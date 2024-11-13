package cleancode.adapter.shape;

public final class Program {
    private Program() {}

    public static void main(String[] args) {
        Shape[] shapes = {
            new Shape2DAdapter(new Rectangle()), 
            new Line()
        };

        final int x1 = 10;
        final int y1 = 20;
        final int x2 = 30;
        final int y2 = 60;

        for (Shape shape : shapes) {
            shape.draw(x1, y1, x2, y2);
        }
    }
}
