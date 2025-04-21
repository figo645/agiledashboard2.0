package com.example.dashboard.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class DataService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> T readJsonFile(String path, Class<T> valueType) throws IOException {
        ClassPathResource resource = new ClassPathResource("static/data/" + path);
        try (InputStream inputStream = resource.getInputStream()) {
            return objectMapper.readValue(inputStream, valueType);
        }
    }
} 