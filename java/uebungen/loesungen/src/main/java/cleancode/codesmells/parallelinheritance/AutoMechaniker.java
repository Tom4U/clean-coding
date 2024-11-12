package cleancode.codesmells.parallelinheritance;

public class AutoMechaniker implements Mechaniker, Taetigkeit {
    private String name;

    @Override
    public String taetigkeit(Mechaniker mechaniker) {
        return "Repariert Autos";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
