package cleancode.patterns.adapter;

import cleancode.patterns.adapter.vendor.Modem;

public class ModemAdapter implements Modem {
    private final DataModem dataModem;

    public ModemAdapter(DataModem dataModem) {
        this.dataModem = dataModem;
    }

    @Override
    public void dial(String pno) {
        this.dataModem.beginConnection(pno);
    }

    @Override
    public void hangup() {
        this.dataModem.endConnection();
    }

    @Override
    public void send(char c) {
        this.dataModem.sendSingleChar(c);
    }

    @Override
    public char recv() {
        return this.dataModem.getSingleChar();
    }
}
