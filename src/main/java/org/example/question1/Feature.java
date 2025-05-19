package org.example.question1;

public class Feature {


    public String name;
    public double weight;

    public Object value;

    public Feature(String name, double weight, Object value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

public double distance(Feature other) {
    if (this.value instanceof Number && other.value instanceof Number) {
        double d1 = ((Number) this.value).doubleValue();
        double d2 = ((Number) other.value).doubleValue();
        return d1 < d2 ? (d2 - d1) : 0;
    }
    if (this.value instanceof Boolean && other.value instanceof Boolean) {
        return this.value.equals(other.value) ? 0 : 1;
    }
    if (this.value instanceof String && other.value instanceof String) {
        return this.value.equals(other.value) ? 0 : 1;
    }
    return 1;
}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
