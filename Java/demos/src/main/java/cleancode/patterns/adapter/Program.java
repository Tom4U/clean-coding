package cleancode.patterns.adapter;

import cleancode.patterns.adapter.vendor.ModemUser;

public class Program {
    public static void main(String[] args) {
        DataModem dataModem = new DataModemImpl();
        ModemUser modemUser = new ModemUser(new ModemAdapter(dataModem));

        modemUser.begin("08912345");
    }
}
