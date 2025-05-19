package question2;

import question2.model.Animal;
import question2.model.Dog;

import java.util.ArrayList;
import java.util.List;

import static question2.Methods.*;

public class Main {
    public static void main(String[] args) {
   Dog rocky=new Dog("Rocky");
   Dog toy=new Dog("Toy");
   Dog rex=new Dog("Rex");
   Dog bobi=new Dog("Bobi");
   Dog sky=new Dog("Sky");
   List<Dog> dogList = new ArrayList<>(List.of(rocky, toy, rex, bobi, sky));
    System.out.println("Section A= Print All dogs name List<? extends Animal>");
    printAnimalsNames(dogList);
    System.out.println("Section B= Add a New Dog to List<? super Dog>");
    addAnimalToList(dogList,"Zoey");
    printAnimalsNames(dogList);
    System.out.println("Section C= Testing with Object 2 functions");
    System.out.println("Using Print Function to random animals");
    List <Animal> animals=new ArrayList<>();
    animals.add(new Animal("Giraffe"));
    animals.add(new Animal("Zebra"));
    printAnimalsNames(animals);
    System.out.println("Adding dogs to Objects+Print");
    List<Object> randomObject=new ArrayList<>();
    randomObject.add(new Dog("Scooby"));
    randomObject.add(new Dog("Pincher"));
   printObjects(randomObject);
    System.out.println("Adding dogs to Animals+Print");
     animals.add(new Dog("Coco"));
     animals.add(new Dog("Podel"));
     printAnimalsNames(animals);
    }


}
