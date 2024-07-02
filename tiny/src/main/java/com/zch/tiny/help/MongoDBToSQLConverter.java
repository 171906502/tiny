package com.zch.tiny.help;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;
import java.util.List;

public class MongoDBToSQLConverter {

    public static SQLQuery convert(JsonNode jsonNode, List<String> selectFields) {
        StringBuilder sqlWhere = new StringBuilder();
        List<Object> parameters = new ArrayList<>();
        convertNode(jsonNode, sqlWhere, parameters);

        // Building the SELECT part of the SQL query
        StringBuilder sqlSelect = new StringBuilder("SELECT ");
        if (selectFields == null || selectFields.isEmpty()) {
            sqlSelect.append("*");
        } else {
            sqlSelect.append(String.join(", ", selectFields));
        }
        sqlSelect.append(" FROM user"); // Assuming the table name is 'users'

        // Combining SELECT and WHERE parts
        String sql = sqlSelect.toString();
        if (sqlWhere.length() > 0) {
            sql += " WHERE " + sqlWhere.toString();
        }

        // Remove trailing " AND " if present
        int length = sql.length();
        if (length > 5 && sql.substring(length - 5).equals(" AND ")) {
            sql = sql.substring(0, length - 5);
        }

        return new SQLQuery(sql, parameters);
    }

    private static void convertNode(JsonNode node, StringBuilder sqlWhere, List<Object> parameters) {
        if (node.isObject()) {
            node.fields().forEachRemaining(entry -> {
                String field = entry.getKey();
                JsonNode value = entry.getValue();
                if (field.equals("$and") || field.equals("$or")) {
                    sqlWhere.append("(");
                    ArrayNode arrayNode = (ArrayNode) value;
                    for (int i = 0; i < arrayNode.size(); i++) {
                        if (i > 0) {
                            sqlWhere.append(field.equals("$and") ? " AND " : " OR ");
                        }
                        convertNode(arrayNode.get(i), sqlWhere, parameters);
                    }
                    sqlWhere.append(")");
                } else if (value.isObject()) {
                    value.fields().forEachRemaining(innerEntry -> {
                        String operator = innerEntry.getKey();
                        JsonNode operand = innerEntry.getValue();
                        convertCondition(field, operator, operand, sqlWhere, parameters);
                    });
                } else {
                    sqlWhere.append(field).append(" = ? AND ");
                    parameters.add(formatValue(value));
                }
            });

            // Remove trailing " AND " if present
            int length = sqlWhere.length();
            if (length > 5 && sqlWhere.substring(length - 5).equals(" AND ")) {
                sqlWhere.setLength(length - 5);
            }
        }
    }

    private static void convertCondition(String field, String operator, JsonNode operand, StringBuilder sqlWhere, List<Object> parameters) {
        switch (operator) {
            case "$gt":
                sqlWhere.append(field).append(" > ? AND ");
                parameters.add(formatValue(operand));
                break;
            case "$lt":
                sqlWhere.append(field).append(" < ? AND ");
                parameters.add(formatValue(operand));
                break;
            case "$eq":
                sqlWhere.append(field).append(" = ? AND ");
                parameters.add(formatValue(operand));
                break;
            case "$ne":
                sqlWhere.append(field).append(" != ? AND ");
                parameters.add(formatValue(operand));
                break;
            case "$in":
                sqlWhere.append(field).append(" IN (");
                ArrayNode arrayNode = (ArrayNode) operand;
                for (int i = 0; i < arrayNode.size(); i++) {
                    if (i > 0) {
                        sqlWhere.append(", ");
                    }
                    sqlWhere.append("?");
                    parameters.add(formatValue(arrayNode.get(i)));
                }
                sqlWhere.append(") AND ");
                break;
            case "$nin":
                sqlWhere.append(field).append(" NOT IN (");
                arrayNode = (ArrayNode) operand;
                for (int i = 0; i < arrayNode.size(); i++) {
                    if (i > 0) {
                        sqlWhere.append(", ");
                    }
                    sqlWhere.append("?");
                    parameters.add(formatValue(arrayNode.get(i)));
                }
                sqlWhere.append(") AND ");
                break;
            // Add more operators as needed
            default:
                throw new UnsupportedOperationException("Unsupported operator: " + operator);
        }
    }

    private static Object formatValue(JsonNode value) {
        if (value.isTextual()) {
            return value.asText();
        } else if (value.isNumber()) {
            return value.numberValue();
        } else {
            throw new UnsupportedOperationException("Unsupported value type: " + value.getNodeType());
        }
    }
}
