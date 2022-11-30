package cleancode.codesmells.primitiveobsession;

public class Person {
    private String id;
    private String vorname;
    private String nachname;
    private String adresse;
    private String plz;
    private String ort;
    private String land;
    
    Person(String id, String vorname, String nachname, String adresse, String plz, String stadt, String land) {
        // ... Initialisierung ...
    }

    void adresseAendern(String adresse, String plz, String stadt, String land) {
        // ... Logik ...
    }
}
