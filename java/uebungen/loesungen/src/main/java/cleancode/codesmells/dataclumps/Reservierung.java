package cleancode.codesmells.dataclumps;

import java.util.Date;

public class Reservierung {
    private int reservierungsNr;
    private int zimmerNr;
    private Zeitraum zeitraum;

    public Reservierung(int reservierungsNr, int zimmerNr, Zeitraum zeitraum)
    {
        this.reservierungsNr = reservierungsNr;
        this.zimmerNr = zimmerNr;
        this.zeitraum = zeitraum;
    }

    class Zeitraum {
        private Date ankunft;
        private Date abreise;

        Zeitraum(Date ankunft, Date abreise) {
            this.ankunft = ankunft;
            this.abreise = abreise;
        }
    }
}
