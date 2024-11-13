package cleancode.adapter.shape;

public class Program {

    public static void main(String[] args) {
        Object[] shapes = { new Line(), new Rectangle() };
        int x1 = 10, y1 = 20;
        int x2 = 30, y2 = 60;
        int width = 20, height = 40;
        for (Object shape : shapes) {
            if (shape.getClass().getSimpleName().equals("Line")) {
                ((Line) shape).draw(x1, y1, x2, y2);
            } else if (shape.getClass().getSimpleName().equals("Rectangle")) {
                ((Rectangle) shape).draw(x2, y2, width, height);
            }
        }
    }

}
