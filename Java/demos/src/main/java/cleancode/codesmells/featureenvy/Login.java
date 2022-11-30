package cleancode.codesmells.featureenvy;

public class Login {
    private Boolean loginButtonAnzeigen = false;
    private Auth auth;

    Login(Auth auth) {
        this.auth = auth;
    }

    void abmelden() {
        auth.abmelden();
    }

    void anmelden(String benutzer, String passwort) {
        auth.anmelden(benutzer, passwort);
    }

    Boolean istAngemeldet() {
        return auth.istAngemeldet();
    }

    void loginButtonUmschalten() {
        loginButtonAnzeigen = !loginButtonAnzeigen;
    }
}
