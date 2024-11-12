package cleancode.codesmells.switchcase.richtig;

import java.util.List;

public class Sortierer {
    public List<String> sortiereDaten(String sortierTyp, List<String> daten) {
        Sortierung sortierung = new Sortierung();

        return sortierung.sortiere(sortierTyp, daten);
    }
}
