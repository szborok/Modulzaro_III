package be03.borok_szabolcs.Model;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    public String name;
    public List<Enclosure> enclosures;
    
    public Zoo(String name, List<Enclosure> enclosures) {
        this.name = name;
        this.enclosures = enclosures;
    }
    
    public void printZooAnimals() {
        System.out.println(this.name);
        for (int i = 0; i < this.enclosures.size(); i++) {
            Enclosure currentEnclosure = this.enclosures.get(i);
            currentEnclosure.printEnclosureAnimals();
            if (i != this.enclosures.size() - 1) {
                System.out.println("");
            }
        }
    }
    
    public List<Animal> getAllZooAnimal() {
        List<Animal> animals = new ArrayList<>();
        
        for (Enclosure oneEnclosure:this.enclosures) {
            animals.addAll(oneEnclosure.animals);
        }
        return animals;
    }
    
    
    
    
    
    
}
