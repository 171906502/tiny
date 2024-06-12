package com.zch.tiny.help;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class MongoDBToSQLConverter {

    public static String convert(JsonNode jsonNode) {
        StringBuilder sqlWhere = new StringBuilder();
        convertNode(jsonNode, sqlWhere);
        return sqlWhere.toString();
    }

    private static void convertNode(JsonNode node, StringBuilder sqlWhere) {
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
                        convertNode(arrayNode.get(i), sqlWhere);
                    }
                    sqlWhere.append(")");
                } else if (value.isObject()) {
                    value.fields().forEachRemaining(innerEntry -> {
                        String operator = innerEntry.getKey();
                        JsonNode operand = innerEntry.getValue();
                        convertCondition(field, operator, operand, sqlWhere);
                    });
                } else {
                    sqlWhere.append(field).append(" = ").append(formatValue(value)).append(" AND ");
                }
            });

            // Remove trailing " AND " if present
            int length = sqlWhere.length();
            if (length > 5 && sqlWhere.substring(length - 5).equals(" AND ")) {
                sqlWhere.setLength(length - 5);
            }
        }
    }

    private static void convertCondition(String field, String operator, JsonNode operand, StringBuilder sqlWhere) {
        switch (operator) {
            case "$gt":
                sqlWhere.append(field).append(" > ").append(formatValue(operand)).append(" AND ");
                break;
            case "$lt":
                sqlWhere.append(field).append(" < ").append(formatValue(operand)).append(" AND ");
                break;
            case "$eq":
                sqlWhere.append(field).append(" = ").append(formatValue(operand)).append(" AND ");
                break;
            case "$ne":
                sqlWhere.append(field).append(" != ").append(formatValue(operand)).append(" AND ");
                break;
            case "$in":
                sqlWhere.append(field).append(" IN (").append(formatArray(operand)).append(") AND ");
                break;
            case "$nin":
                sqlWhere.append(field).append(" NOT IN (").append(formatArray(operand)).append(") AND ");
                break;
            // Add more operators as needed
            default:
                throw new UnsupportedOperationException("Unsupported operator: " + operator);
        }
    }

    private static String formatValue(JsonNode value) {
        if (value.isTextual()) {
            return "'" + value.asText() + "'";
        } else if (value.isNumber()) {
            return value.toString();
        } else {
            throw new UnsupportedOperationException("Unsupported value type: " + value.getNodeType());
        }
    }

    private static String formatArray(JsonNode arrayNode) {
        if (arrayNode.isArray()) {
            StringBuilder arrayStr = new StringBuilder();
            for (int i = 0; i < arrayNode.size(); i++) {
                if (i > 0) {
                    arrayStr.append(", ");
                }
                arrayStr.append(formatValue(arrayNode.get(i)));
            }
            return arrayStr.toString();
        } else {
            throw new UnsupportedOperationException("Expected array, but got: " + arrayNode.getNodeType());
        }
    }
}
