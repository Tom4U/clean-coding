package cleancode.codesmells.switchcase.okay;

public class ValueSwitch {
    public void machWasMitEingabe(String eingabe) {
        switch (eingabe) {
            case "Wert1":
                // Mach was mit Wert1
                break;
            case "Wert2":
                // Mach was mit Wert2
            default:
                break;
        }
    }
}
