package com.zch.tiny.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@Component
public class LoggingRequestInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger("REQUEST_LOGGER");


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 包装请求
        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);

        String uri = wrappedRequest.getRequestURI();
        String method = wrappedRequest.getMethod();
        
        // 过滤文件上传请求
        if (isMultipartContent(wrappedRequest)) {
            return true;
        }

        StringBuilder params = new StringBuilder();
        if ("POST".equalsIgnoreCase(method) || "PUT".equalsIgnoreCase(method)) {
            String contentType = wrappedRequest.getContentType();
            if (contentType != null && contentType.contains("application/json")) {
                String requestBody = new String(wrappedRequest.getContentAsByteArray(), wrappedRequest.getCharacterEncoding());
                params.append(requestBody);
            } else {
                Map<String, String[]> parameterMap = wrappedRequest.getParameterMap();
                for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                    params.append(entry.getKey()).append("=");
                    for (String value : entry.getValue()) {
                        params.append(value).append(",");
                    }
                    params.deleteCharAt(params.length() - 1).append("&");
                }
                if (params.length() > 0) {
                    params.deleteCharAt(params.length() - 1);
                }
            }
        } else {
            Enumeration<String> parameterNames = wrappedRequest.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String paramName = parameterNames.nextElement();
                String paramValue = wrappedRequest.getParameter(paramName);
                params.append(paramName).append("=").append(paramValue).append("&");
            }
            if (params.length() > 0) {
                params.deleteCharAt(params.length() - 1);
            }
        }

        logRequest(uri, method, params.toString());
        request = wrappedRequest;
        return true;
    }

    private void logRequest(String uri, String method, String params) {
        logger.info("URI: " + uri + "\nMethod: " + method + "\nParameters: " + params + "\n-------------------------------");
    }

    private boolean isMultipartContent(HttpServletRequest request) {
        String contentType = request.getContentType();
        return contentType != null && contentType.toLowerCase().startsWith("multipart/");
    }
}
