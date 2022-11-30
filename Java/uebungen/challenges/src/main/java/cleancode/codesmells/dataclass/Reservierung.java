package cleancode.codesmells.dataclass;

import java.util.Date;

public class Reservierung {
    private Date ankunft;
    private Date abreise;

    Reservierung(Date ankunft, Date abreise) {
        this.ankunft = ankunft;
        this.abreise = abreise;
    }

    public Date getAnkunft() {
        return ankunft;
    }

    public Date getAbreise() {
        return abreise;
    }
}
