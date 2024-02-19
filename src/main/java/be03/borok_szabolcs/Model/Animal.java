package be03.borok_szabolcs.Model;

import be03.borok_szabolcs.Interfaces.IAnimal;

public abstract class Animal implements IAnimal {
    
    public String species;
    public String name;
    public Integer age;
    
    public Animal(String species, String name, Integer age) {
        this.species = species;
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return this.species + " " + this.name + " " + this.age;
    }
}
