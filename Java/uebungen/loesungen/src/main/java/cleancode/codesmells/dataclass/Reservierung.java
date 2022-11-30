package cleancode.codesmells.dataclass;

import java.util.Date;

public class Reservierung {
    private Date ankunft;
    private Date abreise;

    Reservierung(Date ankunft, Date abreise) {
        this.ankunft = ankunft;
        this.abreise = abreise;
    }

    public void dauerAnzeigen() {
        Long timeDiff = abreise.getTime() - ankunft.getTime();
        Long days = (timeDiff / (1000 * 60 * 60 * 24)) % 365;

        System.out.println("Der Gast bleibt " + days + " Tage");
    }
}
