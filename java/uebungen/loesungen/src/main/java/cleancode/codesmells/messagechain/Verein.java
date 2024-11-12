package cleancode.codesmells.messagechain;

public class Verein {
    private final Mitglied vorsitzender;

    Verein(Mitglied vorsitzender) {
        this.vorsitzender = vorsitzender;
    }

    public Mitglied getVorsitzender() {
        return vorsitzender;
    }
}
