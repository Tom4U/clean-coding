package cleancode.codesmells.messagechain;

public class Mitglied {
    private Verein verein;

    private final String name;

    Mitglied(String name) {
        this.name = name;
    }

    Mitglied(String name, Verein club) {
        this.name = name;
        this.verein = club;
    }

    Verein getVerein() {
        return verein;
    }

    String getName() {
        return name;
    }
}
