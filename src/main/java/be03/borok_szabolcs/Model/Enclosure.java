package be03.borok_szabolcs.Model;

import java.util.List;

public class Enclosure {
    public String name;
    public List<Animal> animals;
    
    public Enclosure(String name, List<Animal> animals) {
        this.name = name;
        this.animals = animals;
    }
    
    public void printEnclosureAnimals() {
        System.out.println(this.name);
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i).toString());
        }
    }
    
}

