package cleancode.patterns.adapter.vendor;

public class ModemUser {
    private Modem modem;

    public ModemUser(Modem modem) {
    }

    public void begin(String phoneNumber) {
        modem.dial(phoneNumber);
    }
}
