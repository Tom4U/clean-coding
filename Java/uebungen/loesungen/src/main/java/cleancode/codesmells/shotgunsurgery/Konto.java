package cleancode.codesmells.shotgunsurgery;

public class Konto {

    private String typ;
    private String kontonummer;
    private int kontostand;

    public Konto(String typ, String kontonummer, int kontostand) {
        this.kontostand = kontostand;
        this.typ = typ;
        this.kontonummer = kontonummer;
    }

    public void abheben(int betrag) throws Exception {
        kontoErfuelltAnforderungen(this, true);

        kontostand = kontostand - betrag;
        System.out.println("Kontostand ist " + kontostand);

    }

    public void umbuchen(Konto sender, Konto empfaenger, int betrag) throws Exception {
        kontoErfuelltAnforderungen(sender, true);

        empfaenger.kontostand = kontostand + betrag;
        sender.kontostand = kontostand - betrag;
    }

    public void warnungSenden() {
        try {
            kontoErfuelltAnforderungen(this, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getKontostand() {
        return kontostand;
    }

    private void kontoErfuelltAnforderungen(Konto konto, Boolean throwException) throws Exception {
        if (konto.getKontostand() <= 500) {
            String message = "Kontostand muss über 500 sein";

            if (throwException) {
                throw new Exception(message);
            } else {
                System.out.println(message);
            }
        }
    }

}
