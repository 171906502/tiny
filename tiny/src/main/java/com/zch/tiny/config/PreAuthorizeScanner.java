package com.zch.tiny.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PreAuthorizeScanner {

    private Map<String, Object> globalMemory = new HashMap<>();

    @PostConstruct
    public void init() throws Exception {
        scanControllers();
    }

    public void scanControllers() throws Exception {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Controller.class));

        List<Map<String, String>> resultList = new ArrayList<>();
        
        for (var beanDefinition : scanner.findCandidateComponents("com.zch.tiny")) {
            Class<?> clazz = Class.forName(beanDefinition.getBeanClassName());

            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(PreAuthorize.class)) {
                    PreAuthorize preAuthorize = method.getAnnotation(PreAuthorize.class);
                    Map<String, String> methodInfo = new HashMap<>();
                    methodInfo.put("controller", clazz.getSimpleName());
                    methodInfo.put("method", method.getName());
                    methodInfo.put("preAuthorize", preAuthorize.value());
                    resultList.add(methodInfo);
                }
            }
        }

        // ObjectMapper objectMapper = new ObjectMapper();
        // String json = objectMapper.writeValueAsString(resultList);

        globalMemory.put("preAuthorizeData", resultList);
        // System.out.println("PreAuthorize data stored in global memory: " + json);
    }

    public Map<String, Object> getGlobalMemory() {
        return globalMemory;
    }
}
