package uebungen.adapter.shape.solution;

public class Rectangle implements Shape {
	public void draw(int x, int y, int width, int height) {
		System.out.println("Rectangle with coordinate left-down point (" + x + ";" + y + "), width: " + width
				+ ", height: " + height);
	}
}
