package com.zch.tiny.controller;

import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zch.tiny.help.MongoDBToSQLConverter;

@RestController
@RequestMapping("/api")
public class QueryController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/convert")
    public String convertQuery(@RequestBody String jsonBody) throws Exception {
        JsonNode jsonNode = objectMapper.readTree(jsonBody);
        String sqlWhere = MongoDBToSQLConverter.convert(jsonNode);
        return sqlWhere;
    }
}
