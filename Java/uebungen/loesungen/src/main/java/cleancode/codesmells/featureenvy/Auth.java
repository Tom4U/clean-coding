package cleancode.codesmells.featureenvy;

public class Auth {
    private Boolean angemeldet = false;

    void abmelden() {
        angemeldet = false;
    }

    void anmelden(String benutzer, String passwort) {
        angemeldet = true;
    }

    Boolean istAngemeldet() {
        return angemeldet;
    }
}
