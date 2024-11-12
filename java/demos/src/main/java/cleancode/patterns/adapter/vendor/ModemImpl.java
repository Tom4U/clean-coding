package cleancode.patterns.adapter.vendor;

public class ModemImpl implements Modem {
    @Override
    public void dial(String pno) {
    }

    @Override
    public void hangup() {
    }

    @Override
    public void send(char c) {
    }

    @Override
    public char recv() {
        return 0;
    }
}
