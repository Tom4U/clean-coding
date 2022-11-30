package cleancode.solid.srp;

public interface Modem {
    public void dial(String pno);

    public void hangup();

    public void send(char c);

    public char recv();
}
