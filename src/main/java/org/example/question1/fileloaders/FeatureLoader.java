package org.example.question1.fileloaders;
import org.example.question1.Feature;
import java.io.*;
import java.util.*;

public class FeatureLoader {

    public static Map<String, Map<String, Feature>> loadFeatures(String path) throws IOException {
        Map<String, Map<String, Feature>> featureMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine(); //
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 3) continue;

                String category = parts[0].trim();
                String featureName = parts[1].trim();
                Object value = parseValue(parts[2].trim());

                double weight;
                if (value instanceof Number) {
                    weight = ((Number) value).doubleValue();
                } else {
                    weight = 1.0;
                }

                Feature feature = new Feature(featureName, weight, value);
                featureMap.putIfAbsent(category, new HashMap<>());
                featureMap.get(category).put(featureName, feature);
            }
        }
        return featureMap;
    }


    public static Object parseValue(String raw) {
        if (raw == null || raw.isBlank()) return null;
        raw = raw.trim();

        if (raw.equalsIgnoreCase("true") || raw.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(raw);
        }

        try {
            return Double.parseDouble(raw);
        } catch (NumberFormatException ignored) {}

        return raw;
    }
}
