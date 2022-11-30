package cleancode.codesmells.switchcase.falsch;

import java.util.List;

public class Sortierer {
    public List<String> sortiereDaten(String sortierTyp, List<String> daten) {
        List<String> sortierteDaten = null;

        switch (sortierTyp) {
            case "SortierTypEins":
                SortierTypEins sortierTypEins = new SortierTypEins();
                sortierteDaten = sortierTypEins.sortiereDaten(daten);
                break;
            case "SortierTypZwei":
                SortierTypZwei sortierTypZwei = new SortierTypZwei();
                sortierteDaten = sortierTypZwei.sortiereDaten(daten);
                break;
            default:
                break;
        }

        return sortierteDaten;
    }
}
