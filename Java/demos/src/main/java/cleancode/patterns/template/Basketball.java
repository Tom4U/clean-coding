package cleancode.patterns.template;

public class Basketball extends Game {
    @Override
    protected void initialize() {
        System.out.println("Basketball game initialized");

    }

    @Override
    protected void startPlay() {
        System.out.println("Basketball game started");

    }

    @Override
    protected void endPlay() {
        System.out.println("Basketball game ended");

    }
}
