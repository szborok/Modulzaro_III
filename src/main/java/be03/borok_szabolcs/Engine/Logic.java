package be03.borok_szabolcs.Engine;

import be03.borok_szabolcs.Model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Logic {
    
    //Írassa ki, hogy hány emlős, hány hüllő és hány madár van összesen.
    public static void animalTypeQuantity(List<Animal> animalList) {
        int mammal = 0;
        int bird = 0;
        int reptile = 0;
        
        for (Animal oneAnimal:animalList) {
            if (oneAnimal instanceof Mammal) {
                mammal += 1;
            } else if (oneAnimal instanceof Bird){
                bird += 1;
            } else if (oneAnimal instanceof Reptile) {
                reptile += 1;
            }
        }
        System.out.println("There is " + mammal + " mammal.");
        System.out.println("There is " + bird + " bird.");
        System.out.println("There is " + reptile + " reptile.");
    }
    
    
    //A ketrec feltöltéséhez véletlenszerűen válasszon ki az adott csoportból 10 állatot, az
    //állatok ne ismátlődjenek. A ketrecek nevei: enclosure1, enclosure2... legyen
    
    public static Enclosure createCage(String name, List<Animal> animalList) {
        Enclosure cage = new Enclosure(name, new ArrayList<>());
        int animalLimit = 10;
        int animalCnt = 0;
        List<Animal> cloned = new ArrayList<>(animalList);
        
        Random rnd = new Random();
        
        Animal randomAnimal = cloned.get(rnd.nextInt(cloned.size()-1));
        cage.animals.add(randomAnimal);
        cloned.remove(randomAnimal);
        animalCnt++;
        
        while (animalCnt < animalLimit) {
            Animal randomAnimal2 = cloned.get(rnd.nextInt(cloned.size()-1));
            if (randomAnimal.getClass() == randomAnimal2.getClass()) {
                cage.animals.add(randomAnimal2);
                cloned.remove(randomAnimal2);
                animalCnt++;
            }
        }
        return cage;
    }
    
    //Hozzon létre 3 állatkertet. Mindegyik állatkertben 3 ketrec legyen. Az előző feladatot
    //egészítse ki, ha szükséges. Állatkertek nevei: zoo1, zoo2,...
    
    public static List<Zoo> createZoo(int numberOfZoo, int numberOfEnclosure, List<Animal> animalList) {
        List<Zoo> returnList = new ArrayList<>();
        int zooCounter = 1;
        int enclosureCounter = 1;
        
        while (zooCounter < numberOfZoo + 1) {
            Zoo oneZoo = new Zoo("zoo" + zooCounter, new ArrayList<>());
            while (enclosureCounter < numberOfEnclosure + 1) {
                oneZoo.enclosures.add(Logic.createCage("enclosure" + enclosureCounter, animalList));
                enclosureCounter++;
            }
            returnList.add(oneZoo);
            
            enclosureCounter = 1;
            zooCounter++;
        }
        return returnList;
    }
    
    //Listázza ki a kettes állatkert összes állatát. A későbbiekben ezzel dolgozzon.
    //Melyik a legidősebb állat.
    public static Animal oldestAnimal(Zoo zoo) {
        List<Animal> animalList = zoo.getAllZooAnimal();
        Animal returnAnimal = null;
        int age = -1;
        
        for (Animal oneAnimal:animalList) {
            if (oneAnimal.age > age) {
                returnAnimal = oneAnimal;
                age = oneAnimal.age;
            }
        }
        return returnAnimal;
    }
    
    //Listázza ki a kettes állatkert összes állatát. A későbbiekben ezzel dolgozzon.
    //Amennyiben a mai napon egy random állat megfogan, mikorra várható a kicsi születése? Dátumot adjon vissza.
    public static LocalDate birthDate(Zoo zoo) {
        List<Animal> animalList = zoo.getAllZooAnimal();
        List<Mammal> mammal = new ArrayList<>();
        Random rnd = new Random();
        
        for (Animal oneAnimal:animalList) {
            if (oneAnimal instanceof Mammal) {
                mammal.add((Mammal) oneAnimal);
            }
        }
        
        if (mammal.size() == 0) {
            //System.out.println("There is no mammal what could be pregnant.");
            return LocalDate.of(2099,1,1);
        }
        
        Mammal randomMammal = mammal.get(rnd.nextInt(0,mammal.size() - 1));
        return LocalDate.now().plusDays(randomMammal.timeOfPregnancy);
    }
    
    //Listázza ki a kettes állatkert összes állatát. A későbbiekben ezzel dolgozzon.
    //Mennyi az állatok átlagos életkora
    public static Double averageAge(List<Animal> animalList) {
        //List<Animal> animalList = zoo.getAllZooAnimal();
        Double counter = 0.0;
        Double sum = 0.0;
        
        for (Animal oneAnimal:animalList) {
            sum += oneAnimal.age;
            counter++;
        }
        return (double) (sum / counter);
    }
    
    //Listázza ki a kettes állatkert összes állatát. A későbbiekben ezzel dolgozzon.
    //Melyik a legfiatalabb állat.
    public static Animal youngestAnimal(Zoo zoo) {
        List<Animal> animalList = zoo.getAllZooAnimal();
        Animal returnAnimal = null;
        int age = Integer.MAX_VALUE;
        
        for (Animal oneAnimal:animalList) {
            if (oneAnimal.age < age) {
                age = oneAnimal.age;
                returnAnimal = oneAnimal;
            }
        }
        return returnAnimal;
    }
    
    //Listázza ki a kettes állatkert összes állatát. A későbbiekben ezzel dolgozzon.
    //Mennyivel változna az állatok életkora, ha a 2. feladatban kiválasztott állatt 2 utódot hozna világra a mai napon?
    // Addig nem születik állat és nem is lesznek idősebbek az állatok.
    
    public static Double averageAgeDiffWithTwoNewborn(Zoo zoo) {
        List<Animal> before = zoo.getAllZooAnimal();
        Double ageBefore = Logic.averageAge(before);
        
        Animal newBorn1 = new Mammal("Elephant", "Eli", 0,660);
        Animal newBorn2 = new Reptile("Cameleon", "LazyFart",0,20,40);
        
        List<Animal> after = zoo.getAllZooAnimal();
        after.add(newBorn1);
        after.add(newBorn2);
        Double ageAfter = Logic.averageAge(after);
        
        return ageBefore - ageAfter;
    }
    
    //Listázza ki a kettes állatkert összes állatát. A későbbiekben ezzel dolgozzon.
    //Mennyi idő alatt lehetne végigjárni az állatkertet az alábbi szempontokat figyelembe véve:
    //▪ Minden állatot meg akarunk nézni. Állattól függően:
    //• Emlősöknél 10p-et, hüllőknél 5p-et, madaraknál 15p-et töltünk el.
    
    public static int zooVisitDuration(Zoo zoo) {
        List<Animal> animalList = zoo.getAllZooAnimal();
        
        int mammalTime = 10;
        int reptileTime = 5;
        int birdTime = 15;
        
        int mammal = 0;
        int reptile = 0;
        int bird = 0;
        
        for (Animal oneAnimal:animalList) {
            String[] fullName = oneAnimal.getClass().getName().split("\\.");
            String name = fullName[fullName.length - 1];
            
            switch (name) {
                case "Reptile":
                    reptile++;
                    break;
                case "Bird":
                    bird++;
                    break;
                case "Mammal":
                    mammal++;
                    break;
            }
        }
        return mammal * mammalTime + bird * birdTime + reptile * reptileTime;
    }
    
    public static void oddsOfMammalInZoo() {
        //enclosures:   3   x   3   x   3       - all cages are bird type
        //
        //animals       10  x   10  x   10      - each animal in a cage
        //We don't have to multiply with the amount of animals in cage cause all is the same type.
        
        System.out.println("1 to " + 3*3*3 + " is the chance Pistike will see a mammal first.");
    }
    
    public static void writeZooDataToFile(String fileName, List<Animal> animalList) {
        String path = "/Users/sovi/Library/Mobile Documents/com~apple~CloudDocs/Data/personal_Fun/Coding/Java/Soterline/Modulzaro-3/Modulzaro-III/";
        
        try {
            File myObj = new File(path + fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Something went wrong.");
        }
        
        try {
            FileWriter myWriter = new FileWriter(path + fileName);
            for (Animal oneAnimal:animalList) {
                myWriter.write("\n" + oneAnimal.toString());
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
