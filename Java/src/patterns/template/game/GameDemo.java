package patterns.template.game;

public class GameDemo {
	public static void main(String[] args) {
		Game bb = new Basketball();
		Game fb = new Football();
		
		bb.play();
		
		
		System.out.println();
		
		fb.play();
	}
}
