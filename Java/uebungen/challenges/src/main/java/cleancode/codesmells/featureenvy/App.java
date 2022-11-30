package cleancode.codesmells.featureenvy;

public class App {
    public static void main(String[] args) {
        Login login = new Login(new Auth());

        login.anmelden("user", "pass");
        
        if (login.istAngemeldet()) login.loginButtonUmschalten();

        login.abmelden();
        login.loginButtonUmschalten();
    }
}
