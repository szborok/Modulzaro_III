package be03.borok_szabolcs.Model;

import be03.borok_szabolcs.Interfaces.IMammal;

public class Mammal extends Animal implements IMammal {
    public Integer timeOfPregnancy;
    
    public Mammal(String species, String name, Integer age, Integer timeOfPregnancy) {
        super(species, name, age);
        this.timeOfPregnancy = timeOfPregnancy;
    }
    
    @Override
    public void sound() {
    
    }
    
    @Override
    public void nurse() {
    
    }
    
    @Override
    public String toString() {
        //Faj: faj1 Név: nev1 Kor: kor1 Saját adatok....
        String returnString =
                "Faj: " + this.species + " Név: " + this.name + " Kor: " + this.age
                        + " Vemhességi idõ: " + this.timeOfPregnancy + ".";
        return returnString;
    }
}
