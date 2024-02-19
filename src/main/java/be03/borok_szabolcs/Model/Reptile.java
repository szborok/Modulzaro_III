package be03.borok_szabolcs.Model;

import be03.borok_szabolcs.Interfaces.IReptile;

public class Reptile extends Animal implements IReptile {
    Integer minBodyTemp;
    Integer maxBodyTemp;
    
    public Reptile(String species, String name, Integer age, Integer minBodyTemp, Integer maxBodyTemp) {
        super(species, name, age);
        this.minBodyTemp = minBodyTemp;
        this.maxBodyTemp = maxBodyTemp;
    }
    
    @Override
    public void sound() {
    
    }
    
    @Override
    public void amplitudeOfBodyTemp() {
    
    }
    @Override
    public String toString() {
        //Faj: faj1 Név: nev1 Kor: kor1 Saját adatok....
        String returnString =
                "Faj: " + this.species + " Név: " + this.name + " Kor: " + this.age
                        + " Minimum testho: " + this.maxBodyTemp + " Maximum testho: " + this.maxBodyTemp + ".";
        return returnString;
    }
}
