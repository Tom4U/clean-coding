package cleancode.codesmells.messagechain;

public class Aufruf {
    public static void main(String[] args) {
        Mitglied mitglied = new Mitglied("Martin", new Verein(new Mitglied("Fred")));

        System.out.println("Der Vorsitzende ist " + mitglied.getVerein().getVorsitzender().getName());
    }
}
