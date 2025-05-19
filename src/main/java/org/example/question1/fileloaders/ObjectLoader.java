package org.example.question1.fileloaders;
import org.example.question1.Feature;
import org.example.question1.PrototypeObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ObjectLoader {

    public static List<PrototypeObject> loadObjects(String path, Map<String, Map<String, Feature>> featureDefinitions) throws IOException {
        Map<String, PrototypeObject> objects = new LinkedHashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length < 4) continue;

            String category = parts[0].trim();
            String name = parts[1].trim();
            String featureName = parts[2].trim();
            String rawValue = parts[3].trim();
            Object value = FeatureLoader.parseValue(rawValue);
            double weight = 0.5;
            if (featureDefinitions.containsKey(category) && featureDefinitions.get(category).containsKey(featureName)) {
                weight = featureDefinitions.get(category).get(featureName).getWeight();
            }
            String objectKey = category + "-" + name;
            objects.putIfAbsent(objectKey, new PrototypeObject(category, name));
            objects.get(objectKey).addFeature(featureName, new Feature(featureName, weight, value));
        }

        reader.close();
        return new ArrayList<>(objects.values());
    }
}
