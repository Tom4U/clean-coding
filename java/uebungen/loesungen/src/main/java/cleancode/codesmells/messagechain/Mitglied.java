package cleancode.codesmells.messagechain;

public class Mitglied {
    private Verein verein;

    private final String name;

    Mitglied(String name) {
        this.name = name;
    }

    Mitglied(String name, Verein verein) {
        this.name = name;
        this.verein = verein;
    }

    String getName() {
        return name;
    }

    String getNameVonVorsitzendem() {
        return verein.getVorsitzender().getName();
    }
}
