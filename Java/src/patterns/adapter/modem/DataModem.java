package patterns.adapter.modem;

public interface DataModem {
	public void beginConnection(String pno);
	public void endConnection();
	public void sendSingleChar(char c);
	public char getSingleChar();
}