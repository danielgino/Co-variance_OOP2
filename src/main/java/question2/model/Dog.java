package question2.model;

import question2.model.Animal;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return super.getName();
    }
}
