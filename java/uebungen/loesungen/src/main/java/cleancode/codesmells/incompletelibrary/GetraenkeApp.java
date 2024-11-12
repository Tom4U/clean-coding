package cleancode.codesmells.incompletelibrary;

import cleancode.codesmells.incompletelibrary.vendor.Getraenk;

public class GetraenkeApp {
    private static ExtendedGetraenkeautomat getraenkeAutomat = new ExtendedGetraenkeautomat();

    public static void main(String[] args) {
        for (Getraenk getraenk : getraenkeAutomat.getHeissgetraenke()) {
            System.out.println(getraenk.getName());
        }
    }
}
