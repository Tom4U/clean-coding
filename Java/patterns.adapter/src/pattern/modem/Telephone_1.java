package pattern.modem;

public class Telephone_1 extends Modem {

	@Override
	protected void dial(String pno) {
		System.out.println(pno);
		
	}

	@Override
	protected void hangUp() {
		System.out.println("hanged up");
		
	}

	@Override
	protected void send(char c) {
		System.out.println(c);
		
	}

	@Override
	protected char recv() {
		return 'c';
	}

}
