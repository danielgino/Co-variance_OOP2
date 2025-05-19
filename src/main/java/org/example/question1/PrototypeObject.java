package org.example.question1;

import java.util.HashMap;
import java.util.Map;

public class PrototypeObject {
    public  String category;
    public  String name;
    public Map<String, Feature> features = new HashMap<>();

    public PrototypeObject(String category, String name) {
        this.category = category;
        this.name = name;
    }

    public double distance(PrototypeObject ideal) {
        double total = 0;
        for (String key : ideal.features.keySet()) {
            Feature fIdeal = ideal.features.get(key);
            Feature fObj = this.features.getOrDefault(
                    key,
                    new Feature(key, fIdeal.getWeight(), 0.0)
            );

            double diff = fObj.distance(fIdeal);
            total += Math.pow(diff * fIdeal.getWeight(), 2);
        }
        return Math.sqrt(total);
    }

    public void addFeature(String name, Feature f) {
        features.put(name, f);
    }
    public double closenessScore(PrototypeObject ideal) {
        double d = distance(ideal);
        double assumedMax = 1.3;

        double normalized = Math.pow(d / assumedMax, 1.2);
        return Math.min(1 + normalized * 6, 7.0);
    }


}
