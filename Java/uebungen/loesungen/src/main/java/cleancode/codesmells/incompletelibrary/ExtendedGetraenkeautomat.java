package cleancode.codesmells.incompletelibrary;

import java.util.ArrayList;

import cleancode.codesmells.incompletelibrary.vendor.Getraenk;
import cleancode.codesmells.incompletelibrary.vendor.Getraenkeautomat;

public class ExtendedGetraenkeautomat extends Getraenkeautomat{
    public ArrayList<Getraenk> getHeissgetraenke() {
        ArrayList<Getraenk> alleGetraenke = getGetraenke();
        ArrayList<Getraenk> heissGetraenke = new ArrayList<>();

        for (Getraenk getraenk : alleGetraenke) {
            if (getraenk.getKategorie() == "Heißgetränke") {
                heissGetraenke.add(getraenk);
            }
        }

        return heissGetraenke;
    }
}
