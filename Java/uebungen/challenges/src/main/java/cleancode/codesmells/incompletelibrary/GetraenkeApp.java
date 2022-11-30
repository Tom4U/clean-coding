package cleancode.codesmells.incompletelibrary;

import java.util.ArrayList;

import cleancode.codesmells.incompletelibrary.vendor.Getraenk;
import cleancode.codesmells.incompletelibrary.vendor.Getraenkeautomat;

public class GetraenkeApp {
    private static Getraenkeautomat getraenkeAutomat = new Getraenkeautomat();
    
    public static void main(String[] args) {
        for (Getraenk getraenk : getHeissgetraenke()) {
            System.out.println(getraenk.getName());
        }
    }
    
    public static ArrayList<Getraenk> getHeissgetraenke() {
        ArrayList<Getraenk> alleGetraenke = getraenkeAutomat.getGetraenke();
        ArrayList<Getraenk> heissGetraenke = new ArrayList<>();

        for (Getraenk getraenk : alleGetraenke) {
            if (getraenk.getKategorie() == "Heißgetränke") {
                heissGetraenke.add(getraenk);
            }
        }

        return heissGetraenke;
    }
}