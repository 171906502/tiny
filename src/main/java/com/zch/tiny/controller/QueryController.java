package com.zch.tiny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zch.tiny.help.MongoDBToSQLConverter;
import com.zch.tiny.help.SQLQuery;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class QueryController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/convert")
    public SQLQuery convertQuery(@RequestBody JsonNode jsonBody) throws Exception {
        JsonNode filterNode = jsonBody.get("filter");
        List<String> selectFields = objectMapper.convertValue(jsonBody.get("select"), List.class);
        return MongoDBToSQLConverter.convert(filterNode, selectFields);
    }

    @PostMapping("/query")
    public List<Map<String, Object>> executeQuery(@RequestBody JsonNode jsonBody) throws Exception {
        JsonNode filterNode = jsonBody.get("filter");
        List<String> selectFields = objectMapper.convertValue(jsonBody.get("select"), List.class);
        SQLQuery sqlQuery = MongoDBToSQLConverter.convert(filterNode, selectFields);
        return jdbcTemplate.queryForList(sqlQuery.getSql(), sqlQuery.getParameters().toArray());
    }
}
