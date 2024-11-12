package cleancode.codesmells.incompletelibrary.vendor;

import java.math.BigDecimal;

public class Getraenk {
    private String name;
    private String kategorie;
    private BigDecimal preis;

    public Getraenk(String name, String kategorie, BigDecimal preis) {
        this.name = name;
        this.kategorie = kategorie;
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPreis() {
        return preis;
    }

    public String getKategorie() {
        return kategorie;
    }
}
