package cleancode.codesmells.featureenvy;

public class App {
    public static void main(String[] args) {
        Login login = new Login();
        Auth auth = new Auth();

        auth.anmelden("user", "pass");

        if (auth.istAngemeldet())
            login.loginButtonUmschalten();

        auth.abmelden();
        login.loginButtonUmschalten();
    }
}
