package com.zch.tiny.help;

import java.util.List;

public class SQLQuery {
    private String sql;
    private List<Object> parameters;

    public SQLQuery(String sql, List<Object> parameters) {
        this.sql = sql;
        this.parameters = parameters;
    }

    public String getSql() {
        return sql;
    }

    public List<Object> getParameters() {
        return parameters;
    }
}
