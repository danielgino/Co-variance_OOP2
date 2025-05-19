package org.example;

import org.example.question1.fileloaders.FeatureLoader;
import org.example.question1.fileloaders.ObjectLoader;
import org.example.question1.PrototypeObject;
import org.example.question1.Feature;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Map<String, Feature>> featureWeights =
                FeatureLoader.loadFeatures("src/main/java/org/example/question1/data/features.csv");

        List<PrototypeObject> objects =
                ObjectLoader.loadObjects("src/main/java/org/example/question1/data/objects.csv", featureWeights);

        Map<String, PrototypeObject> idealByCategory = new HashMap<>();
        for (String category : featureWeights.keySet()) {
            PrototypeObject ideal = new PrototypeObject(category, "אידאלי");
            for (Map.Entry<String, Feature> entry : featureWeights.get(category).entrySet()) {
                Feature f = entry.getValue();
                ideal.addFeature(entry.getKey(), new Feature(entry.getKey(), f.getWeight(), f.getValue()));
            }
            idealByCategory.put(category, ideal);
        }
        printRoschScale();
        for (String category : idealByCategory.keySet()) {
            PrototypeObject ideal = idealByCategory.get(category);
            List<PrototypeObject> categoryObjects = objects.stream()
                    .filter(o -> o.category.equals(category))
                    .toList();

            System.out.println("=== קטגוריה: " + category + " ===");

            for (PrototypeObject obj : categoryObjects) {
                double score = obj.closenessScore(ideal);
                System.out.println(obj.name + " => ציון טיפוסיות: " + String.format("%.2f", score) + " (" + roschLabel(score) + ")");
            }
        }
    }

    public static String roschLabel(double score) {
        if (score <= 1.5) return "טיפוסי מאוד";
        if (score <= 2.5) return "טיפוסי";
        if (score <= 3.5) return "די טיפוסי";
        if (score <= 4.5) return "בינוני";
        if (score <= 5.5) return "לא כל כך טיפוסי";
        if (score <= 6.5) return "כמעט לא טיפוסי";
        return "לא טיפוסי בכלל";
    }
    public static void printRoschScale() {
        System.out.println("========= סקאלת טיפוסיות (1 = טיפוסי מאוד, 7 = לא טיפוסי בכלל) =========");
        System.out.println("ציון | פירוש");
        System.out.println("---------------");
        System.out.println("1 =טיפוסי מאוד");
        System.out.println("2 = טיפוסי");
        System.out.println(" 3= די טיפוסי");
        System.out.println("4 = בינוני");
        System.out.println("5 = לא כל כך טיפוסי");
        System.out.println(" 6 = כמעט לא טיפוסי");
        System.out.println("7 = לא טיפוסי בכלל");
        System.out.println("==============================================================\n");
    }
}
