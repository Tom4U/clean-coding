package cleancode.codesmells.incompletelibrary.vendor;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Getraenkeautomat {
    private ArrayList<Getraenk> getraenke = new ArrayList<>();

    public Getraenkeautomat() {
        getraenke.add(new Getraenk("Mineralwasser", "Kaltgetränke", new BigDecimal(1.20)));
        getraenke.add(new Getraenk("Tafelwasser", "Kaltgetränke", new BigDecimal(1.00)));
        getraenke.add(new Getraenk("Orangensaft", "Kaltgetränke", new BigDecimal(2.80)));
        getraenke.add(new Getraenk("Kaffee", "Heißgetränke", new BigDecimal(1.30)));
        getraenke.add(new Getraenk("Espresso", "Heißgetränke", new BigDecimal(1.50)));
        getraenke.add(new Getraenk("Tee", "Heißgetränke", new BigDecimal(1.10)));
    }

    public ArrayList<Getraenk> getGetraenke() {
        return getraenke;
    }
}
