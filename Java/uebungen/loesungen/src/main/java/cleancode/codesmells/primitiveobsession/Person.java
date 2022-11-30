package cleancode.codesmells.primitiveobsession;

public class Person {
    private PersonId id;
    private Name name;
    private Adresse adresse;

    Person(PersonId id, Name name, Adresse adresse) {
        // ... Initialisierung ...
    }

    void adresseAendern(Adresse adresse) {
        // ... Logik ...
    }

    class Name {
        String vorname;
        String nachname;

        Name(String vorname, String nachname) {
            this.vorname = vorname;
            this.nachname = nachname;
        }
    }

    class Adresse {
        private String adresse;
        private String plz;
        private String ort;
        private String land;

        Adresse(String adresse, String plz, String stadt, String land) {
            // ... Initialisierung ...
        }
    }

    class PersonId implements Comparable {
        private String id;

        PersonId(String id) {
            // ... Initialisierung ...
        }

        @Override
        public int compareTo(Object personId) {
            // TODO Auto-generated method stub
            return 0;
        }
    }
}
