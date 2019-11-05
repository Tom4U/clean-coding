package patterns.adapter.demo1;
public interface DataModem {
	public void beginConnection(String pno);
	public void endConnection();
	public void sendSingleChar(char c);
	public char getSingleChar();
}