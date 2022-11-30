package cleancode.codesmells.dataclumps;

import java.util.Date;

public class Reservierung {
    private int reservierungsNr;
    private int zimmerNr;
    private Date ankunft;
    private Date abreise;

    public Reservierung(int reservierungsNr, int zimmerNr, Date ankunft, Date abreise)
    {
        this.reservierungsNr = reservierungsNr;
        this.zimmerNr = zimmerNr;
        this.ankunft = ankunft;
        this.abreise = abreise;
    }
}
