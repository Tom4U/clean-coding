package cleancode.patterns.adapter.vendor;

public interface Modem {
    public void dial(String phoneNumber);

    public void hangup();

    public void send(char c);

    public char recv();
}

/*
 * public abstract class Modem {
 * protected abstract void dial(String pno);
 * protected abstract void hangup();
 * protected abstract void send(char c);
 * protected abstract char recv();
 *
 * public final char sendData(String pno, char c) {
 * dial(pno);
 *
 * send(c);
 *
 * char result = recv();
 *
 * hangup();
 *
 * return result;
 * }
 * }
 */
