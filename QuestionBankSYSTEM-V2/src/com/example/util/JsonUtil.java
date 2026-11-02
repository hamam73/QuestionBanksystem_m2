package com.example.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonUtil {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // Save any object to a JSON file
    public static <T> void save(T obj, String path) throws IOException {
        MAPPER.writerWithDefaultPrettyPrinter().writeValue(new File(path), obj);
    }

    // Load a List of objects from a JSON file
    public static <T> List<T> loadList(String path, Class<T> clazz) throws IOException {
        File file = new File(path);
        if (!file.exists()) return new ArrayList<>();
        return MAPPER.readValue(file, MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
    }

    // Load a Map of objects from a JSON file
    public static <T> Map<String, T> loadMap(String path, Class<T> clazz) throws IOException {
        File file = new File(path);
        if (!file.exists()) return null;
        return MAPPER.readValue(file, MAPPER.getTypeFactory().constructMapType(Map.class, String.class, clazz));
    }
}