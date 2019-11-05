package pattern.modem.demo;

import pattern.modem.Modem;
import pattern.modem.Telephone_1;

public class ModemDemo {
	public static void main(String[] args) {
		Modem m_1 = new Telephone_1();
		m_1.useModem("110", 'c');
	}

}
