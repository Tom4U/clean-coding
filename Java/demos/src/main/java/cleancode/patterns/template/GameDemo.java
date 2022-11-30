package cleancode.patterns.template;

public class GameDemo {
    public static void main(String[] args) {
        Game basketball = new Basketball();
        Game football = new Football();

        basketball.play();

        System.out.println();

        football.play();
    }
}
