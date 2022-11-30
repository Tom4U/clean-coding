package cleancode.codesmells.dataclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservierungsApp {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        try {
            Date ankunft = dateFormat.parse("20.07.2022");
            Date abreise = dateFormat.parse("23.07.2022");
            Reservierung reservierung = new Reservierung(ankunft, abreise);

            dauerAnzeigen(reservierung);
        } catch (ParseException parseException) {

        }
    }
    
    public static void dauerAnzeigen(Reservierung reservierung) {
        Long timeDiff = reservierung.getAbreise().getTime() - reservierung.getAnkunft().getTime();
        Long days = (timeDiff / (1000 * 60 * 60 * 24)) % 365;

        System.out.println("Der Gast bleibt " + days + " Tage");
    }
}
