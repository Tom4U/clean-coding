package patterns.template.demo;

import patterns.template.Basketball;
import patterns.template.Football;
import patterns.template.Game;

public class GameDemo {
	public static void main(String[] args) {
		Game basketball = new Basketball();
		Game football = new Football();
		
		basketball.play();
		
		System.out.println();
		
		football.play();
	}
}
