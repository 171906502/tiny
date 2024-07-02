package com.zch.tiny.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class CodeGenerator {

    private static final String TEMPLATE_PATH = "tiny/src/main/resources/templates";
    private static final String JAVA_PATH = "tiny/src/main/java/com/zch/tiny";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/tiny?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "123456";

    public static void main(String[] args) throws IOException, TemplateException, SQLException {
        // 初始化 FreeMarker 配置
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
        cfg.setDefaultEncoding("UTF-8");

        boolean clean = false;

        if (clean) {
            List<String> packages = Arrays
                    .asList(new String[] { "model", "dto", "service", "mapper", "controller", "repository" });
            packages.stream().forEach(p -> {
                deleteDirectory(new File(JAVA_PATH + "/" + p));
                createDirectory(JAVA_PATH + "/" + p);
            });

        }

        // 获取数据库连接
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
            DatabaseMetaData metaData = connection.getMetaData();
            try (ResultSet tables = metaData.getTables("tiny", null, "%", new String[] { "TABLE" })) {
                while (tables.next()) {
                    if (tables.getString(1).equals("tiny")) {
                        String tableName = tables.getString("TABLE_NAME");
                        generateCodeForTable(cfg, metaData, tableName);
                    }
                }
            }
        }
    }

    private static void generateCodeForTable(Configuration cfg, DatabaseMetaData metaData, String tableName)
            throws SQLException, IOException, TemplateException {
        // 查询表结构
        try (ResultSet columns = metaData.getColumns("tiny", null, tableName, "%")) {
            Map<String, Object> data = new HashMap<>();
            String className = toCamelCase(tableName, true);
            data.put("className", className);
            data.put("table", tableName);
            boolean overWrite = false;
            String basePackageName = "com.zch.tiny.";
            data.put("packageName", basePackageName + "model");
            StringBuilder fieldsBuilder = new StringBuilder();

            ResultSet primaryKeys = metaData.getPrimaryKeys(null, null, tableName);

            System.out.println("Table: " + tableName);
            String primaryKeyColumn = "";
            while (primaryKeys.next()) {
                primaryKeyColumn = primaryKeys.getString("COLUMN_NAME");
            }
            primaryKeys.close();

            while (columns.next()) {
                // if(!columns.getString(1).equals("tiny")){
                // System.out.println("skip not tiny database");
                // continue;
                // }
                String columnName = columns.getString("COLUMN_NAME");
                String javaType = sqlTypeToJavaType(columns.getString("TYPE_NAME"));
                if (javaType.equals("BigDecimal")) {
                    data.put("bigDecimal", 1);
                }

                if (javaType.contains("LocalDate")) {
                    data.put("localDate", 1);
                }

                fieldsBuilder.append(columnName).append(":").append(javaType);
                if (columnName.equals(primaryKeyColumn)) {
                    fieldsBuilder.append(":PrimaryKey");
                } else {
                    fieldsBuilder.append(":Normal");
                }
                fieldsBuilder.append(":").append(toCamelCase(columnName, false));
                fieldsBuilder.append(",");
            }
            data.put("fields", fieldsBuilder.toString().split(","));

            // 生成实体类
            String entityFilePath = JAVA_PATH + "/model/" + className + ".java";
            if (overWrite || !new File(entityFilePath).exists()) {
                generateFile(cfg, data, "Entity.ftl", entityFilePath);
            }

            // 生成仓库接口
            data.put("packageName", basePackageName + "repository");
            String repositoryFilePath = JAVA_PATH + "/repository/" + className + "Repository.java";
            if (overWrite || !new File(repositoryFilePath).exists()) {
                generateFile(cfg, data, "Repository.ftl", repositoryFilePath);
            }

            // 生成服务类
            data.put("packageName", basePackageName + "service");

            String serviceFilePath = JAVA_PATH + "/service/" + className + "Service.java";
            if (overWrite || !new File(serviceFilePath).exists()) {
                generateFile(cfg, data, "Service.ftl", serviceFilePath);
            }

            // 生成控制器类
            data.put("packageName", basePackageName + "controller");

            String controllerFilePath = JAVA_PATH + "/controller/" + className + "Controller.java";
            if (overWrite || !new File(controllerFilePath).exists()) {
                generateFile(cfg, data, "Controller.ftl", controllerFilePath);
            }

            // 生成 DTO 类
            data.put("packageName", basePackageName + "dto");

            String dtoFilePath = JAVA_PATH + "/dto/" + className + "Dto.java";
            if (overWrite || !new File(dtoFilePath).exists()) {
                generateFile(cfg, data, "Dto.ftl", dtoFilePath);
            }

            // 生成 Mapper 类
            data.put("packageName", basePackageName + "mapper");

            String mapperFilePath = JAVA_PATH + "/mapper/" + className + "Mapper.java";
            if (overWrite || !new File(mapperFilePath).exists()) {
                generateFile(cfg, data, "Mapper.ftl", mapperFilePath);
            }
        }
    }

    private static void generateFile(Configuration cfg, Map<String, Object> data, String templateName,
            String outputFilePath) throws IOException, TemplateException {
        Template template = cfg.getTemplate(templateName);
        try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath)))) {
            template.process(data, out);
        }
    }

    private static String toCamelCase(String s, boolean capitalizeFirst) {
        StringBuilder sb = new StringBuilder();
        boolean capitalizeNext = capitalizeFirst;
        for (char c : s.toCharArray()) {
            if (c == '_') {
                capitalizeNext = true;
            } else {
                if (capitalizeNext) {
                    sb.append(Character.toUpperCase(c));
                    capitalizeNext = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        return sb.toString();
    }

    private static String sqlTypeToJavaType(String sqlType) {
        switch (sqlType.toLowerCase()) {
            case "int":
            case "integer":
                return "Integer";
            case "bigint":
                return "Long";
            case "varchar":
            case "char":
            case "text":
                return "String";
            case "timestamp":
            case "datetime":
                return "LocalDateTime";
            case "date":
                return "LocalDate";
            case "decimal":
                return "BigDecimal";
            case "boolean":
                return "Boolean";
            default:
                return "String";
        }
    }

    public static void deleteDirectory(File directory) {
        if (!directory.exists()) {
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 递归删除子目录
                    deleteDirectory(file);
                } else {
                    // 删除文件
                    file.delete();
                }
            }
        }

        // 删除空目录或文件
        directory.delete();
    }

    public static String camelToSnake(String camelCase) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < camelCase.length(); i++) {
            char currentChar = camelCase.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                if (i > 0) {
                    result.append('_');
                }
                result.append(Character.toLowerCase(currentChar));
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    public static String snakeToCamel(String snakeCase) {
        StringBuilder result = new StringBuilder();
        boolean nextUpperCase = false;
        for (int i = 0; i < snakeCase.length(); i++) {
            char currentChar = snakeCase.charAt(i);
            if (currentChar == '_') {
                nextUpperCase = true;
            } else {
                if (nextUpperCase) {
                    result.append(Character.toUpperCase(currentChar));
                    nextUpperCase = false;
                } else {
                    result.append(currentChar);
                }
            }
        }
        return result.toString();
    }

    public static boolean createDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        // 如果目录已存在，则返回true
        if (directory.exists()) {
            System.out.println("目录已存在。");
            return true;
        }

        // 尝试创建目录
        if (directory.mkdirs()) {
            System.out.println("目录已成功创建。");
            return true;
        } else {
            System.out.println("无法创建目录。");
            return false;
        }
    }
}
