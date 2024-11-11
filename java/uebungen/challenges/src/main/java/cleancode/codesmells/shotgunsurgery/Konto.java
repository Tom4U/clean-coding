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
              if (kontostand <= 500) {
                     throw new Exception("Kontostand muss über 500 sein");
              }

              kontostand = kontostand - betrag;
              System.out.println("Kontostand ist " + kontostand);

       }

       public void umbuchen(Konto sender, Konto empfaenger, int betrag) throws Exception {
              if (sender.kontostand <= 500) {
                     throw new Exception("Kontostand muss über 500 sein");
              }

              empfaenger.kontostand = kontostand + betrag;

       }

       public void warnungSenden() {
              if (kontostand <= 500) {
                     System.out.println("Kontostand muss über 500 sein");
              }
       }

}