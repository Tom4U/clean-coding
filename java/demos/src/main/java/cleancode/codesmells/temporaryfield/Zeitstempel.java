package cleancode.codesmells.temporaryfield;

public class Zeitstempel {
    private int jahr;
    private int monat;
    private int tag;
    private String zeitStempelAlsString;

    public Zeitstempel(Integer jahr, Integer monat, Integer tag) {
        this.jahr = jahr;
        this.monat = monat;
        this.tag = tag;

        this.zeitStempelAlsString = String.join(", ",
                jahr.toString(), monat.toString(), tag.toString());
    }

    public void machWasMitJahrUndMonat() {

    }

    public void machWasMitMonatUndTag() {
    }

    public void machWasMitJahrUndTag() {
    }

    @Override
    public String toString() {
        return zeitStempelAlsString;
    }
}
