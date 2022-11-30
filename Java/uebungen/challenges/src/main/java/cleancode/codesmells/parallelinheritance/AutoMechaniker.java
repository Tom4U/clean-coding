package cleancode.codesmells.parallelinheritance;

public class AutoMechaniker extends Mechaniker {

    @Override
    String taetigkeit() {
        return new AutoMechanikerTaetigkeit().get();
    }
    
}
