package question2;

import question2.model.Animal;
import question2.model.Dog;

import java.util.List;
import java.util.Objects;

public class Methods {
    public static void printAnimalsNames (List<? extends Animal> animalsNames){
        for (Animal animal: animalsNames){
            System.out.println(animal.getName());
        }
    }

    public static void addAnimalToList(List<? super Dog> newDogList,String newDog){
        newDogList.add(new Dog(newDog));
    }


    public static void printObjects(List<Object> objects){
        for (Object o : objects){
            System.out.println(o);
        }
    }
}
