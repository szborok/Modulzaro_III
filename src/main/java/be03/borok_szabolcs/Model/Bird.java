package be03.borok_szabolcs.Model;

import be03.borok_szabolcs.Interfaces.IBird;

import java.util.List;

public class Bird extends Animal implements IBird {
    List<String> colorOfFeather;
    
    public Bird(String species, String name, Integer age, List<String> colorOfFeather) {
        super(species, name, age);
        this.colorOfFeather = colorOfFeather;
    }
    
    @Override
    public void sound() {
    
    }
    
    @Override
    public void fly() {
    
    }
    @Override
    public String toString() {
        //Faj: faj1 Név: nev1 Kor: kor1 Saját adatok....
        String returnString =
                "Faj: " + this.species + " Név: " + this.name + " Kor: " + this.age + " Toll szine/szinei: ";
        
        for (String oneColor:this.colorOfFeather) {
            returnString += oneColor;
            returnString += " ";
        }
        
        return returnString;
    }
}
