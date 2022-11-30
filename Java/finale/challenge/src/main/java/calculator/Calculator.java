/* INFORMATIE/OMSCHRIJVING:
 * ------------------------
 * Wanneer er eerst een teken ingegeven wordt (+, *, /), krijgt de gebruiker een foutmelding
 * met een error-geluid. Enkel een '.' ingeven, wordt ook gezien als foutief.
 * Bij het eerst ingeven van een '-', wordt het getal negatief.
 * Na een punt ingegeven te hebben, wordt deze knop op 'disabled' gezet. Wanneer vervolgens
 * op '<' geklikt wordt en de gebruiker zijn punt wordt verwijderd, wordt deze knop weer actief.
 * Na op 'bereken' geklikt te hebben, moet de gebruiker op 'reset' klikken om verder te kunnen.
 *
 * Bij de uitkomst wordt gekeken of dit een decimaal getal is of niet. Naargelijk als dit zo is
 * wordt de uitkomst getoond als double, anders wordt deze getoond als een int.
 *
 * Wanneer vele voorloopnullen ingegeven worden, worden deze verwijderd. Er blijft wel nog een nul
 * staan als deze volgt door een punt.
 *
 * In de testklasse (Calculator_Main.java) is op regel 11 een code in commentaar gezet. Als deze
 * code gebruikt wordt, worden ALLE swing-componenten op het uiterlijk van de gebruiker zijn besturings-
 * systeem gezet. LET OP: wanneer deze code gebruikt wordt, zijn de buttons met witte tekst niet goed
 * leesbaar. Met deze code moeten alle buttons met witte tekst weer zwart gemaakt worden. Om deze code
 * te gebruiken, moet er een try-catch geplaatst worden. Dit is ook de reden waarom deze in de
 * main-klasse staat.
 *
 * Om ervoor de zorgen dat de knoppen niet te ver uitgerokken kunnen worden, is de JFrame op
 * 'setResizable(false)' gezet. Hierdoor kan de gebruiker zijn venster niet verkleinen of vergroten.
 *
 * Deze rekenmachine is gemaakt door Steven Verheyen (2TinA) en is vanaf 0 gemaakt. Hier en daar zijn
 * kleine opzoekwerken gedaan voor o.a. het krijgen van een error-geluid (regel 380), de look-and-feel
 * van swing-componenten (regel 11 Calculator_Main.java) en hoe een JFrame in het midden van de gebruiker
 * zijn scherm komt te staan bij het uitvoeren (regel 25 Calculator_Main.java) en hoe een ArrayList leeg-
 * gemaakt moet worden (regel 369). De rest is zelf gemaakt zonder opzoekwerk.
 * Dit is gemaakt na het leren van  hoofstuk 11 (Exceptions) en hoofstuk 14 (GUI) en is enkel gemaakt om
 * de leerstof te leren op basis van iets wat in het dagelijks leven gebruikt wordt.
 */

package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {
    private static JButton btnPlus, btnMin, btnMaal, btnDeling, btnBereken, btnKomma, btnEenTerug, btnReset;
    private static JButton btnNul, btnEen, btnTwee, btnDrie, btnVier, btnVijf, btnZes, btnZeven, btnAcht, btnNegen;
    // Reden van aanmaken al deze buttons: later moeten deze op 'disabled' gezet
    // kunnen worden. (anders for-lus gebruiken bij aanmaken)
    private JTextField txtIngave;
    private static JTextField txtTotaleBerekening;
    private JPanel pnlNoord, pnlCenter, pnlZuid, pnlOost;
    private double uitkomst = 0.0;
    static ArrayList<String> ingave = new ArrayList<String>();

    public Calculator() {
        // Panelen aanmaken
        // ----------------
        pnlNoord = new JPanel(new BorderLayout());
        pnlOost = new JPanel(new GridLayout(4, 1));
        pnlCenter = new JPanel(new GridLayout(4, 3));
        pnlZuid = new JPanel(new BorderLayout());

        // Innerklasse gebruiken om events te doen
        // ---------------------------------------
        GetActionCommandHandler handlerEvents = new GetActionCommandHandler();

        // Bewerkingsknoppen
        // -----------------
        btnPlus = new JButton("+");
        btnMaal = new JButton("x");
        btnMin = new JButton("-");
        btnDeling = new JButton("/");
        btnPlus.addActionListener(handlerEvents);
        btnMaal.addActionListener(handlerEvents);
        btnMin.addActionListener(handlerEvents);
        btnDeling.addActionListener(handlerEvents);

        btnPlus.setBackground(Color.DARK_GRAY);
        btnMaal.setBackground(Color.DARK_GRAY);
        btnMin.setBackground(Color.DARK_GRAY);
        btnDeling.setBackground(Color.DARK_GRAY);

        btnPlus.setForeground(Color.WHITE);
        btnMaal.setForeground(Color.WHITE);
        btnMin.setForeground(Color.WHITE);
        btnDeling.setForeground(Color.WHITE);

        btnPlus.setFont(new Font("", Font.PLAIN, 18));
        btnMin.setFont(new Font("", Font.PLAIN, 18));
        btnMaal.setFont(new Font("", Font.PLAIN, 18));
        btnDeling.setFont(new Font("", Font.PLAIN, 18));

        pnlOost.add(btnPlus);
        pnlOost.add(btnMin);
        pnlOost.add(btnMaal);
        pnlOost.add(btnDeling);

        // Cijferknoppen
        // -------------
        btnNul = new JButton("0");
        btnNul.setBackground(Color.LIGHT_GRAY);
        btnNul.addActionListener(handlerEvents);

        btnEen = new JButton("1");
        btnEen.setBackground(Color.LIGHT_GRAY);
        btnEen.addActionListener(handlerEvents);

        btnTwee = new JButton("2");
        btnTwee.setBackground(Color.LIGHT_GRAY);
        btnTwee.addActionListener(handlerEvents);

        btnDrie = new JButton("3");
        btnDrie.setBackground(Color.LIGHT_GRAY);
        btnDrie.addActionListener(handlerEvents);

        btnVier = new JButton("4");
        btnVier.setBackground(Color.LIGHT_GRAY);
        btnVier.addActionListener(handlerEvents);

        btnVijf = new JButton("5");
        btnVijf.setBackground(Color.LIGHT_GRAY);
        btnVijf.addActionListener(handlerEvents);

        btnZes = new JButton("6");
        btnZes.setBackground(Color.LIGHT_GRAY);
        btnZes.addActionListener(handlerEvents);

        btnZeven = new JButton("7");
        btnZeven.setBackground(Color.LIGHT_GRAY);
        btnZeven.addActionListener(handlerEvents);

        btnAcht = new JButton("8");
        btnAcht.setBackground(Color.LIGHT_GRAY);
        btnAcht.addActionListener(handlerEvents);

        pnlCenter.add(btnNul);
        pnlCenter.add(btnEen);
        pnlCenter.add(btnTwee);
        pnlCenter.add(btnDrie);
        pnlCenter.add(btnVier);
        pnlCenter.add(btnVijf);
        pnlCenter.add(btnZes);
        pnlCenter.add(btnZeven);
        pnlCenter.add(btnAcht);

        btnEenTerug = new JButton("<");
        btnEenTerug.setToolTipText("Verwijdert laatste cijfer van een getal");
        btnEenTerug.setBackground(Color.LIGHT_GRAY);
        btnEenTerug.addActionListener(handlerEvents);
        btnNegen = new JButton("9");
        btnNegen.setBackground(Color.LIGHT_GRAY);
        btnNegen.addActionListener(handlerEvents);
        btnKomma = new JButton(".");
        btnKomma.setBackground(Color.LIGHT_GRAY);
        btnKomma.addActionListener(handlerEvents);
        pnlCenter.add(btnEenTerug);
        pnlCenter.add(btnNegen);
        pnlCenter.add(btnKomma);

        txtTotaleBerekening = new JTextField();
        txtTotaleBerekening.setHorizontalAlignment(JTextField.RIGHT);
        txtTotaleBerekening.setFont(new Font("", Font.PLAIN, 15));
        txtTotaleBerekening.setEditable(false);
        txtTotaleBerekening.setToolTipText("Totale berekening voluit");
        pnlNoord.add(txtTotaleBerekening, BorderLayout.NORTH);

        txtIngave = new JTextField();
        txtIngave.setHorizontalAlignment(JTextField.RIGHT);
        txtIngave.setEditable(false);
        txtIngave.setToolTipText("Waarde die ingegeven wordt");
        pnlNoord.add(txtIngave, BorderLayout.SOUTH);

        btnReset = new JButton("Reset");
        btnReset.setBackground(Color.DARK_GRAY);
        btnReset.setForeground(Color.WHITE);
        btnReset.setToolTipText("Reset uw berekeningen");
        btnReset.addActionListener(handlerEvents);
        pnlZuid.add(btnReset, BorderLayout.WEST);

        btnBereken = new JButton("=");
        btnBereken.setBackground(Color.BLACK);
        btnBereken.setForeground(Color.WHITE);
        btnBereken.setFont(new Font("", Font.PLAIN, 18));
        btnBereken.setToolTipText("Berekent de uitkomst");
        btnBereken.addActionListener(handlerEvents);
        pnlZuid.add(btnBereken, BorderLayout.CENTER);

        // pnlPaneel toevoegen aan JFrame
        // ------------------------------
        add(pnlNoord, BorderLayout.NORTH);
        add(pnlOost, BorderLayout.EAST);
        add(pnlCenter, BorderLayout.CENTER);
        add(pnlZuid, BorderLayout.SOUTH);
    }

    // Een 'inner-class' om de events op te vangen
    private class GetActionCommandHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getActionCommand().equals("0")) {
                    txtIngave.setText(txtIngave.getText() + "0");
                } else if (e.getActionCommand().equals("1")) {
                    txtIngave.setText(txtIngave.getText() + "1");
                } else if (e.getActionCommand().equals("2")) {
                    txtIngave.setText(txtIngave.getText() + "2");
                } else if (e.getActionCommand().equals("3")) {
                    txtIngave.setText(txtIngave.getText() + "3");
                } else if (e.getActionCommand().equals("4")) {
                    txtIngave.setText(txtIngave.getText() + "4");
                } else if (e.getActionCommand().equals("5")) {
                    txtIngave.setText(txtIngave.getText() + "5");
                } else if (e.getActionCommand().equals("6")) {
                    txtIngave.setText(txtIngave.getText() + "6");
                } else if (e.getActionCommand().equals("7")) {
                    txtIngave.setText(txtIngave.getText() + "7");
                } else if (e.getActionCommand().equals("8")) {
                    txtIngave.setText(txtIngave.getText() + "8");
                } else if (e.getActionCommand().equals("9")) {
                    txtIngave.setText(txtIngave.getText() + "9");
                } else if (e.getActionCommand().equals(".")) {
                    txtIngave.setText(txtIngave.getText() + ".");
                    btnKomma.setEnabled(false);
                } else if (e.getActionCommand().equals("=")) {
                    if (!(txtIngave.getText().equals("") || txtIngave.getText().equals(".")
                            || txtIngave.getText().equals("-") || txtIngave.getText().equals("-."))) {
                        ingave.add(getInvoerZonderNul(txtIngave.getText())); // Laatst ingegeven getal nog in de
                                                                             // ArrayList plaatsen
                        setTotaleBerekening();
                        uitkomst = Double.parseDouble(ingave.get(0)); // Zorgen dat ook met het 1ste getal gerekend
                                                                      // wordt
                        for (int i = 0; i < ingave.size(); i++) {
                            if (ingave.get(i).equals("+")) {
                                double conversieHulp = Double.parseDouble(ingave.get(i + 1));
                                uitkomst += conversieHulp;
                            } else if (ingave.get(i).equals("-")) {
                                double conversieHulp = Double.parseDouble(ingave.get(i + 1));
                                uitkomst -= conversieHulp;
                            } else if (ingave.get(i).equals("*")) {
                                double conversieHulp = Double.parseDouble(ingave.get(i + 1));
                                uitkomst = uitkomst * conversieHulp;
                            } else if (ingave.get(i).equals("/")) {
                                double conversieHulp = Double.parseDouble(ingave.get(i + 1));
                                uitkomst = uitkomst / conversieHulp;
                            }
                        }
                        setDisabled();
                        txtIngave.setForeground(Color.RED);
                        if (((int) uitkomst == uitkomst)) // Kijken of uitkomst een kommagetal is of niet
                        {
                            txtIngave.setText((int) uitkomst + ""); // Drukt getal zonder komma (lees punt)
                        } else {
                            txtIngave.setText(uitkomst + ""); // Drukt getal met komma (lees punt)
                        }
                    } else
                        throw new NumberFormatException();
                } else if (e.getActionCommand().equals("<")) {
                    int lengte = txtIngave.getText().length();
                    ArrayList<Character> characters = new ArrayList<Character>();
                    for (int i = 0; i < lengte - 1; i++) // Lengte met 1 verminderen om 1 cijfer te kunnen verwijderen
                    {
                        characters.add(txtIngave.getText().charAt(i));
                    }
                    Iterator<Character> iter = characters.iterator();
                    String nieuwWaarde = "";
                    while (iter.hasNext()) {
                        nieuwWaarde = nieuwWaarde + iter.next();
                    }
                    char laatsteChar = txtIngave.getText().charAt(lengte - 1);
                    if (laatsteChar == '.') // char is een primitive datatype -> == gebruiken + ENKELE QUOTES!!!
                    {
                        btnKomma.setEnabled(true);
                    }
                    txtIngave.setText(nieuwWaarde);
                } else if (e.getActionCommand().equals("+")) {
                    if (!(txtIngave.getText().equals("") || txtIngave.getText().equals(".")
                            || txtIngave.getText().equals("-") || txtIngave.getText().equals("-."))) // Enkel een '.'
                                                                                                     // wordt gezien als
                                                                                                     // fout
                    {
                        ingave.add(getInvoerZonderNul(txtIngave.getText()));
                        ingave.add("+");
                        txtIngave.setText("");
                        setTotaleBerekening();
                        setKommaTrue();
                    } else
                        throw new NumberFormatException();
                } else if (e.getActionCommand().equals("-")) {
                    if (txtIngave.getText().equals("")) {
                        txtIngave.setText("-");
                    } else {
                        if (!(txtIngave.getText().equals("-") || txtIngave.getText().equals(".")
                                || txtIngave.getText().equals("-") || txtIngave.getText().equals("-."))) {
                            ingave.add(getInvoerZonderNul(txtIngave.getText()));
                            ingave.add("-");
                            txtIngave.setText("");
                            setTotaleBerekening();
                            setKommaTrue();
                        } else
                            throw new NumberFormatException();
                    }
                } else if (e.getActionCommand().equals("x")) {
                    if (!(txtIngave.getText().equals("") || txtIngave.getText().equals(".")
                            || txtIngave.getText().equals("-") || txtIngave.getText().equals("-."))) {
                        ingave.add(getInvoerZonderNul(txtIngave.getText()));
                        ingave.add("*");
                        txtIngave.setText("");
                        setTotaleBerekening();
                        setKommaTrue();
                    } else
                        throw new NumberFormatException();
                } else if (e.getActionCommand().equals("/")) {
                    if (!(txtIngave.getText().equals("") || txtIngave.getText().equals(".")
                            || txtIngave.getText().equals("-") || txtIngave.getText().equals("-."))) {
                        ingave.add(getInvoerZonderNul(txtIngave.getText()));
                        ingave.add("/");
                        txtIngave.setText("");
                        setTotaleBerekening();
                        setKommaTrue();
                    } else
                        throw new NumberFormatException();
                } else if (e.getActionCommand().equals("Reset")) {
                    txtIngave.setText("");
                    txtIngave.setForeground(Color.BLACK);
                    txtTotaleBerekening.setText("");
                    uitkomst = 0.0;
                    ingave.clear(); // ArrayList leegmaken
                    setEnabled();
                }
            } catch (NumberFormatException NFE) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(Calculator.this, "Gelieve eerst een getal in te geven!", "Geen getal", 0);
            } catch (StringIndexOutOfBoundsException SIOOBE) // Wanneer op '<' geklikt wordt en geen getal ingegeven is
            {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(Calculator.this, "Gelieve eerst een getal in te geven!", "Geen getal", 0);
            }
        }
    }

    public static void setKommaTrue() {
        btnKomma.setEnabled(true);
    }

    public static void setEnabled() {
        btnKomma.setEnabled(true);
        btnBereken.setEnabled(true);
        btnDeling.setEnabled(true);
        btnKomma.setEnabled(true);
        btnPlus.setEnabled(true);
        btnMin.setEnabled(true);
        btnMaal.setEnabled(true);
        btnNul.setEnabled(true);
        btnEen.setEnabled(true);
        btnTwee.setEnabled(true);
        btnDrie.setEnabled(true);
        btnVier.setEnabled(true);
        btnVijf.setEnabled(true);
        btnZes.setEnabled(true);
        btnZeven.setEnabled(true);
        btnAcht.setEnabled(true);
        btnNegen.setEnabled(true);
        btnEenTerug.setEnabled(true);
    }

    public static void setDisabled() {
        btnBereken.setEnabled(false);
        btnDeling.setEnabled(false);
        btnKomma.setEnabled(false);
        btnPlus.setEnabled(false);
        btnMin.setEnabled(false);
        btnMaal.setEnabled(false);
        btnNul.setEnabled(false);
        btnEen.setEnabled(false);
        btnTwee.setEnabled(false);
        btnDrie.setEnabled(false);
        btnVier.setEnabled(false);
        btnVijf.setEnabled(false);
        btnZes.setEnabled(false);
        btnZeven.setEnabled(false);
        btnAcht.setEnabled(false);
        btnNegen.setEnabled(false);
        btnEenTerug.setEnabled(false);
    }

    public static void setTotaleBerekening() {
        txtTotaleBerekening.setText("");
        for (int i = 0; i < ingave.size(); i++) {
            txtTotaleBerekening.setText(txtTotaleBerekening.getText() + " " + ingave.get(i));
        }
    }

    public static String getInvoerZonderNul(String tekst) {
        String invoerWaarde = tekst;
        int lengte = invoerWaarde.length();
        boolean controleNull = true;
        while (controleNull) {
            // Reden lengte>1:
            // De gebruiker kan bijv. 12*0 doen. Als deze controle niet gedaan wordt, kan 0
            // niet ingevoerd worden (Geeft een foutmelding)
            if (lengte > 1 && invoerWaarde.substring(0, 1).equals("0") && !invoerWaarde.substring(1, 2).equals(".")) {
                invoerWaarde = invoerWaarde.substring(1); // zorgen voor geen voorloopnullen (indien het 2de char een
                                                          // punt is)
                lengte = invoerWaarde.length();
            } else if (invoerWaarde.substring(0, 1).equals(".")) // Zorgen voor een voorloopnul bij een decimaal getal
            {
                invoerWaarde = "0" + invoerWaarde;
                lengte = invoerWaarde.length();
            } else if (invoerWaarde.substring(lengte - 1, lengte).equals(".")) // Zorgen voor een 0 na een punt wanneer
                                                                               // het punt de laatste char is
            {
                invoerWaarde = invoerWaarde + "0";
                lengte = invoerWaarde.length();
            } else if (invoerWaarde.substring(0, 1).equals("-") && invoerWaarde.substring(1, 2).equals(".")) {
                invoerWaarde = "-0." + invoerWaarde.substring(2);
            } else {
                controleNull = false;
            }
        }
        return invoerWaarde;
    }
}
