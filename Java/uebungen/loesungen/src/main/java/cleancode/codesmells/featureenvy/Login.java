package cleancode.codesmells.featureenvy;

public class Login {
    private Boolean loginButtonAnzeigen = false;

    void loginButtonUmschalten() {
        loginButtonAnzeigen = !loginButtonAnzeigen;
    }
}
