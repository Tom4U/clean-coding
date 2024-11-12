package cleancode.codesmells.parallelinheritance;

public class FeinMechaniker extends Mechaniker {

    @Override
    String taetigkeit() {
        return new FeinmechanikerTaetigkeit().get();
    }
    
}
