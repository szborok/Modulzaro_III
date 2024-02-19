package be03.borok_szabolcs;

import be03.borok_szabolcs.Engine.AnimalType;
import be03.borok_szabolcs.Engine.Factory;
import be03.borok_szabolcs.Engine.Logic;
import be03.borok_szabolcs.Engine.PrintTest;
import be03.borok_szabolcs.Model.Animal;
import be03.borok_szabolcs.Model.Zoo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        List<Animal> animalList = new ArrayList<>();
        
        Factory.readFile("output.txt", AnimalType.Mammal, animalList);
        Factory.readFile("output2.txt", AnimalType.Reptile, animalList);
        Factory.readFile("output3.txt", AnimalType.Bird, animalList);
        
        PrintTest.dataProcessTest(animalList);
        System.out.println("---");
        Logic.animalTypeQuantity(animalList);                    //does not require print test, cause the method does it.
        System.out.println("---");
        PrintTest.createCage("testCage", animalList);
        System.out.println("---");
        PrintTest.createZoo(3,3,animalList);
        System.out.println("---");
        List<Zoo> zooList = Logic.createZoo(3,3,animalList);
        zooList.get(1).printZooAnimals();
        System.out.println("---");
        PrintTest.oldestAnimal(zooList.get(1));
        System.out.println("---");
        PrintTest.birthDate(zooList.get(1));
        System.out.println("---");
        PrintTest.averageAge(zooList.get(1));
        System.out.println("---");
        PrintTest.youngestAnimal(zooList.get(1));
        System.out.println("---");
        PrintTest.averageAgeWithTwoNewborn(zooList.get(1));
        System.out.println("---");
        PrintTest.zooVisitDuration(zooList.get(1));
        System.out.println("---");
        Logic.oddsOfMammalInZoo();                              //does not require print test, cause the method does it.
        System.out.println("---");
        Logic.writeZooDataToFile("zoo1",animalList);    //Nem lehet ugyan az a nev, mint ami mar letezik.
        
        
        
        
        
        
        
        
        
        
        
        
    }
}