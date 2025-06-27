#  Prototype-Based Object Classification – OOP Assignment 2
##  Question 1 – Prototype Theory by Rosch (1975)

This project implements a model inspired by **Eleanor Rosch's Prototype Theory**, using object-oriented programming. It evaluates how well real-world objects match an **ideal prototype** within a given category based on a set of weighted features.

---

##  Theoretical Background

According to Rosch (1975), categories like "birds" or "furniture" are structured around **central prototypes**, not rigid definitions. Some members are more **typical** than others.

### Example:

| Category: Birds        | Typicality Score |
|------------------------|------------------|
| Sparrow (דרור)         | 1.18             |
| Penguin (פינגווין)     | 4.53             |
| Bat (עטלף)             | 6.15             |

The lower the score, the more typical the item is perceived.

---

##  System Overview

The system loads:
- ✅ **Features per category** with weights and ideal values (`features.csv`)
- ✅ **Objects** with actual feature values (`objects.csv`)
- ✅ It calculates a **closeness score** between each object and its category’s prototype.

---

##  Object-Oriented Design

### Key Classes:
| Class              | Description                                               |
|--------------------|-----------------------------------------------------------|
| `PrototypeObject`  | Represents an object with a name, category, and features. |
| `Feature`          | Encapsulates name, value, and weight of a feature.        |
| `FeatureLoader`    | Loads features from CSV per category.                     |
| `ObjectLoader`     | Loads real objects and their feature values.              |

---
# Levels:
```
========= סקאלת טיפוסיות =========
1 = טיפוסי מאוד
2 = טיפוסי
3 = די טיפוסי
4 = בינוני
5 = לא כל כך טיפוסי
6 = כמעט לא טיפוסי
7 = לא טיפוסי בכלל
=== קטגוריה: ציפורים ===
דרור => ציון טיפוסיות: 1.20 (טיפוסי מאוד)
פינגווין => ציון טיפוסיות: 4.53 (בינוני)
עטלף => ציון טיפוסיות: 6.15 (כמעט לא טיפוסי)

=== קטגוריה: רהיטים ===
טלפון => ציון טיפוסיות: 6.68 (לא טיפוסי בכלל)
מראה => ציון טיפוסיות: 4.39 (בינוני)
כיסא => ציון טיפוסיות: 1.04 (טיפוסי מאוד)
```

# Example Run 

```

========= סקאלת טיפוסיות (1 = טיפוסי מאוד, 7 = לא טיפוסי בכלל) =========
ציון | פירוש
---------------
1 =טיפוסי מאוד
2 = טיפוסי
 3= די טיפוסי
4 = בינוני
5 = לא כל כך טיפוסי
 6 = כמעט לא טיפוסי
7 = לא טיפוסי בכלל
==============================================================

=== קטגוריה: ציפורים ===
דרור => ציון טיפוסיות: 1.04 (טיפוסי מאוד)
ינשוף => ציון טיפוסיות: 2.69 (די טיפוסי)
עטלף => ציון טיפוסיות: 5.88 (כמעט לא טיפוסי)
פינגווין => ציון טיפוסיות: 4.93 (לא כל כך טיפוסי)
=== קטגוריה: רהיטים ===
כסא => ציון טיפוסיות: 1.24 (טיפוסי מאוד)
שולחן => ציון טיפוסיות: 1.24 (טיפוסי מאוד)
מראה => ציון טיפוסיות: 6.11 (כמעט לא טיפוסי)
טלפון => ציון טיפוסיות: 7.00 (לא טיפוסי בכלל)
=== קטגוריה: משקאות ===
מים => ציון טיפוסיות: 1.02 (טיפוסי מאוד)
קולה => ציון טיפוסיות: 1.00 (טיפוסי מאוד)
שמן => ציון טיפוסיות: 5.41 (לא כל כך טיפוסי)
חומץ => ציון טיפוסיות: 5.41 (לא כל כך טיפוסי)

```


# Question 2- Java Generics – Covariance & Contravariance

## Object-Oriented Programming Assignment

This project demonstrates the use of **covariance** and **contravariance** in Java generics through practical examples using `List<T>`, inheritance, and bounded wildcards.

---

### Goal:
To understand and apply covariance (`? extends T`) and contravariance (`? super T`) in Java using class hierarchies and generic lists.

---

## Class Structure

### `Animal` (Base Class)
```java
public class Animal {
    protected String name;
    public Animal(String name) { this.name = name; }
    public String getName() { return name; }
}

Dog (Subclass of Animal)
public class Dog extends Animal {
    public Dog(String name) { super(name); }
}
```
##  Implemented Methods
```
public static void printAnimalsNames(List<? extends Animal> animals) {
    for (Animal animal : animals) {
        System.out.println(animal.getName());
    }
}
public static void printObjects(List<Object> objects) {
    for (Object o : objects) {
        System.out.println(o);
    }
}

```

# Input Code

```
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
```

# Output

```
Section A= Print All dogs name List<? extends Animal>
Rocky
Toy
Rex
Bobi
Sky
Section B= Add a New Dog to List<? super Dog>
Rocky
Toy
Rex
Bobi
Sky
Zoey
Section C= Testing with Object 2 functions
Using Print Function to random animals
Giraffe
Zebra
Adding dogs to Objects+Print
Scooby
Pincher
Adding dogs to Animals+Print
Giraffe
Zebra
Coco
Podel
```

