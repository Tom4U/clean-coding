package cleancode.patterns.adapter;

public class DataModemImpl implements DataModem {
    @Override
    public void beginConnection(String pno) {
    }

    @Override
    public void endConnection() {
    }

    @Override
    public void sendSingleChar(char c) {
    }

    @Override
    public char getSingleChar() {
        return 0;
    }
}
