package cleancode.codesmells.temporaryfield;

public class ZeitstempelLoesung {
    private Integer jahr;
    private Integer monat;
    private Integer tag;

    public ZeitstempelLoesung(Integer jahr, Integer monat, Integer tag) {
        this.jahr = jahr;
        this.monat = monat;
        this.tag = tag;
    }

    public void machWasMitJahrUndMonat() {

    }

    public void machWasMitMonatUndTag() {
    }

    public void machWasMitJahrUndTag() {
    }

    @Override
    public String toString() {
        return String.join(", ",
                this.jahr.toString(), this.monat.toString(), this.tag.toString());
    }
}
