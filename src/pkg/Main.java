package pkg;

import java.util.regex.Pattern;

// Implementujte třídu Kostka, v této třídě vytvořte jeji instanci, zavolejte metodu hodKostkou a zavolejte metodu toString()
// Trida Kostka bude obsahovat:
// atributy
// int pocetSten
// konstruktor
// bude přijímat jako parametr pocetSten a ukladat si ho jako atribut
// funkce
//double hodKostkou() - bude vracet výsledek hodu kostkou (využijte random)
//String toString() - Vypíše informace o kostkce - pocetSten
class Kostka {

    private int pocetSten;

    public Kostka(int pocetSten) {
        this.pocetSten = pocetSten;
    }

    public int hodKostkou() {
        return (int) Math.floor(Math.random() * this.pocetSten) + 1;
    }

    @Override
    public String toString() {
        return "Pocet sten: " + this.pocetSten;
    }
}

// Implementujte třídu ValidatorTextu, v této třídě vytvořte jeji instanci, zavolejte metodu validuj a zavolejte metodu toString()
// Vytvořte minimálně validator pro jméno, příjmení (tzn. zkontrolovat, zda řetězec obsahuje  2 slova začínající velkým písmenem)
// Zkuste experimentovat
// Trida ValidatorTextu bude obsahovat:
// atributy
// String vzor (regex pattern)
// konstruktor
// bude přijímat jako parametr vzor a ukladat si ho jako atribut
// funkce
//boolean validuj(String hodnota) - pomocí hodnoty uložené v atributu vzor, bude validovan parametr hodnota (použí metodu matches)
//String toString() - Vypíše informace o ValidatorTextu - vzor
class ValidatorTextu {

    private String vzor;

    public ValidatorTextu(String vzor) {
        this.vzor = vzor;
    }

    public boolean validuj(String text) {
        return Pattern.matches(this.vzor, text);
    }

    @Override
    public String toString() {
        return "Vzor: " + this.vzor;
    }
}

public class Main {

    private Main() {
        Kostka obj1 = new Kostka(6);
        System.out.println("Hozene cislo: " + obj1.hodKostkou());
        System.out.println(obj1);

        ValidatorTextu obj2 = new ValidatorTextu("^[A-Z][a-z]+ [A-Z][a-z]+$");
        System.out.println("Jmeno Prijmeni: " + obj2.validuj("Jmeno Prijmeni")); //true
        System.out.println("jmenoprijmeni: " + obj2.validuj("jmenoprijmeni"));  //false
        System.out.println("Jmeno prijmeni: " + obj2.validuj("Jmeno prijmeni")); //false
        System.out.println(obj2);
    }

    public static void main(String[] args) {
	    new Main();
    }
}
