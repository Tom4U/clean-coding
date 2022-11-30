package cleancode.codesmells.parallelinheritance;

public abstract class Mechaniker {
    private String name;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    abstract String taetigkeit();
}
