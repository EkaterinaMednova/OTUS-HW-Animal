package factory;

import animals.Animal;
import birds.Duck;
import pets.Cat;
import pets.Dog;
import data.AnimalData;

public class AnimalFactory {
    private String name;
    private int age;
    private double weight;
    private String color;

    public AnimalFactory(String name, int age, double weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }


    public Animal created(AnimalData data) {
        switch(data) {
            case CAT: return new Cat(name, age, weight, color);
            case DOG: return new Dog(name, age, weight, color);
            case DUCK: return new Duck(name, age, weight, color);
            default:
                System.out.println("Такой тип животного отсутствует");
        }
        return null;
    }
}

