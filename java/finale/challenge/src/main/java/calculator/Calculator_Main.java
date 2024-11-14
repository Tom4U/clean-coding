package calculator;

import javax.swing.JFrame;

public class Calculator_Main {
    public static void main(String[] args) {
        try {
            // Bij gebruik van onderstaande code: verander de tekstkleur van de knoppen!
            // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            // Site meer info:
            // http://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
            Calculator rekenmachine = new Calculator();
            rekenmachine.setTitle("Rekenmachine");
            rekenmachine.setResizable(false);
            rekenmachine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            rekenmachine.setSize(245, 360);
            rekenmachine.setLocationRelativeTo(null); // Ervoor zorgen dat de JFrame in het midden van de scherm komt te
                                                      // staan
            rekenmachine.setVisible(true);
        } catch (Exception e) {
            System.out.println("Fout bij het uitvoeren!\nBoodschap: " + e.getMessage());
        }
    }
}
