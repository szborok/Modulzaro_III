package be03.borok_szabolcs.Engine;

import be03.borok_szabolcs.Model.Animal;
import be03.borok_szabolcs.Model.Bird;
import be03.borok_szabolcs.Model.Mammal;
import be03.borok_szabolcs.Model.Reptile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Factory {

    public static void readFile(String input, AnimalType animalType, List<Animal> output) {
        try {
            File myFile = new File(input);
            Scanner myScanner = new Scanner(myFile);
            
            while (myScanner.hasNextLine()) {
                String line = myScanner.nextLine();
                switch (animalType) {
                    case Reptile:
                        output.add(reptileFromLine(line));
                        break;
                    case Bird:
                        output.add(birdFromLine(line));
                        break;
                    case Mammal:
                        output.add(mammalFromLine(line));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + animalType);
                }
            }
            
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static Mammal mammalFromLine(String line) {
        //species, name, age, time of pregnancy
        //Phascolarctos cinereus Eukaliptusz 4 35 nap
        //0             1           2       3   4   5
        //Phascolarctos cinereus
        
        
        String[] splitted = line.split(" ");
        int l = splitted.length;
        
        String species = "";
        String name = null;
        Integer age = null;
        Integer timeOfPregnancy = null;
        
        if (splitted[l-1].equals("nap")) {
            timeOfPregnancy = Integer.parseInt(splitted[l-2]);
        } else if (splitted[l-1].equals("hónap")) {
            timeOfPregnancy = Integer.parseInt(splitted[l-2]) * 30;
        } else if (splitted[l-1].equals("hét")) {
            timeOfPregnancy = Integer.parseInt(splitted[l-2]) * 7;
        }
        splitted[l-1] = null;
        splitted[l-2] = null;
        
        age = Integer.parseInt(splitted[l-3]);
        splitted[l-3] = null;
        
        name = splitted[l-4];
        splitted[l-4] = null;
        
        for (int i = 0; i < l; i++) {
            if (splitted[i] != null) {
                if (i > 0) {
                    species += " ";
                }
                species += splitted[i];
            }
        }
        return new Mammal(species,name,age,timeOfPregnancy);
    }
    
    public static Bird birdFromLine(String line) {
        //species, name, age, color of feather
        //Serinus canaria Csivike 5 Sárga
        //Phasianidae Fanni 8 Színes barna, fekete)
        
        String[] splitted = line.split(" ");
        int l = splitted.length;
        int border = -1;
        
        String species = "";
        String name = null;
        Integer age = null;
        List<String> colorOfFeather = new ArrayList<>();
        
        for (int i = 0; i < l; i++) {
            try {
                int tmp = Integer.parseInt(splitted[i]);
                border = i;
            } catch (NumberFormatException ignored) {
                //do nothing, skip
            }
        }
        name = splitted[border-1];
        splitted[border-1] = null;
        age = Integer.parseInt(splitted[border]);
        splitted[border] = null;
        
        for (int i = 0; i < border; i++) {
            if (splitted[i] != null) {
                if (i > 0) {
                    species += " ";
                }
                species += splitted[i];
            }
        }
        
        for (int i = border + 1; i < l; i++) {
            String word = splitted[i].replaceAll("[^a-zA-Z]", "");
            colorOfFeather.add(word);
        }
        return new Bird(species,name,age,colorOfFeather);
    }
    
    public static Reptile reptileFromLine(String line) {
        //species, name, age, min temp, max temp
        //Serpentes Szisz 5 25 35
        
        String[] splitted = line.split(" ");
        int l = splitted.length;
        
        String species = "";
        String name = null;
        Integer age = null;
        Integer minTemp = null;
        Integer maxTemp = null;
        
        maxTemp = Math.max(Integer.parseInt(splitted[l - 1]), Integer.parseInt(splitted[l - 2]));
        minTemp = Math.min(Integer.parseInt(splitted[l - 1]), Integer.parseInt(splitted[l - 2]));
        splitted[l - 1] = null;
        splitted[l - 2] = null;
        age = Integer.parseInt(splitted[l - 3]);
        splitted[l - 3] = null;
        name = splitted[l - 4];
        splitted[l-4] = null;
        
        for (int i = 0; i < l; i++) {
            if (splitted[i] != null) {
                if (i > 0) {
                    species += " ";
                }
                species += splitted[i];
            }
        }
        return new Reptile(species, name, age, minTemp, maxTemp);
    }
    
    
    
    
    
    
    
}
