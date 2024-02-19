package be03.borok_szabolcs.Engine;

import be03.borok_szabolcs.Model.Animal;
import be03.borok_szabolcs.Model.Enclosure;
import be03.borok_szabolcs.Model.Zoo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrintTest {
    
    public static void dataProcessTest(List<Animal> animalList) {
        int cnt = 0;
        for (Animal oneAnimal:animalList) {
            cnt++;
            System.out.println(oneAnimal.toString());
        }
        System.out.println(cnt + " animal we have.");
    }
    
    public static void createCage(String name, List<Animal> animalList) {
        Enclosure test = Logic.createCage(name, animalList);
        int cnt = 1;
        test.printEnclosureAnimals();
    }
    
    public static void createZoo(int numberOfZoo, int numberOfEnclosure, List<Animal> animalList) {
        List<Zoo> zoos = Logic.createZoo(numberOfZoo,numberOfEnclosure,animalList);
        
        for (int i = 0; i < zoos.size(); i++) {
            Zoo currentZoo = zoos.get(i);
            currentZoo.printZooAnimals();
            System.out.println("-");
        }
    }
    
    public static void oldestAnimal(Zoo zoo) {
        Animal a = Logic.oldestAnimal(zoo);
        System.out.println(a.name + " is the oldest animal, age " + a.age + ".");
    }
    
    public static void birthDate(Zoo zoo) {
        LocalDate l = Logic.birthDate(zoo);
        
        if (l == LocalDate.of(2099,1,1)) {
            System.out.println("There is no animal in the zoo what have information about the time of pregnancy. (NO MAMMAL)");
        }
        
        System.out.println("The next random animal will give birth in " + l + ".");
    }
    
    public static void averageAge(Zoo zoo) {
        List<Animal> a = zoo.getAllZooAnimal();
        Double avg = Logic.averageAge(a);
        System.out.println("The average age of the animals is " + avg + ".");
    }
    
    public static void youngestAnimal(Zoo zoo) {
        Animal a = Logic.youngestAnimal(zoo);
        System.out.println("The youngest animal is a " + a.species + " and it's name is " + a.name + " with the age of " + a.age + ".");
    }
    
    public static void averageAgeWithTwoNewborn(Zoo zoo) {
        Double d = Logic.averageAgeDiffWithTwoNewborn(zoo);
        System.out.println("The average age difference is " + d + ".");
    }
    
    public static void zooVisitDuration(Zoo zoo) {
        int time = Logic.zooVisitDuration(zoo);
        System.out.println("It would take " + time + " minutes to walk around the zoo.");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
