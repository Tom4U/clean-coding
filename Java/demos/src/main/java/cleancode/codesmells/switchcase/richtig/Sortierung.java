package cleancode.codesmells.switchcase.richtig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sortierung {
    private final Map<String, SortierTyp> sortierStrategien = new HashMap<>();

    public Sortierung() {
        sortierStrategien.put("SortierTypEins", new SortierTypEins());
        sortierStrategien.put("SortierTypZwei", new SortierTypZwei());
    }

    public List<String> sortiere(String sortierTyp, List<String> daten) {
        return sortierStrategien.get(sortierTyp).sortiereDaten(daten);
    }
}
