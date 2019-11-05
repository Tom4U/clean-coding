package pattern.modem;

public abstract class Modem {
	
	protected abstract void dial(String pno);
	protected abstract void hangUp();
	protected abstract void send(char c);
	protected abstract char recv(); 
	
	public final void useModem(String pno, char c) {
		dial(pno);
		send(c);
		System.out.println(recv());	
		hangUp();
	}

}
