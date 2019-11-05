package patterns.adapter.demo1;

public class DataModemImpl implements DataModem {
	protected Modem adapted = new ModemImpl();

	@Override
	public void beginConnection(String pno) {
		this.adapted.dial(pno);
		
	}

	@Override
	public void endConnection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendSingleChar(char c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public char getSingleChar() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}