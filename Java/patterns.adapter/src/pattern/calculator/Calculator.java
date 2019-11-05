package pattern.calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame
{
	private static JButton btnPlus, btnMin, btnMaal, btnDeling, btnBereken;
	static JButton btnKomma;
	private static JButton btnEenTerug;
	private static JButton btnReset;
	private static JButton btnNul, btnEen, btnTwee, btnDrie, btnVier, btnVijf, btnZes, btnZeven, btnAcht, btnNegen;
	//Reden van aanmaken al deze buttons: later moeten deze op 'disabled' gezet kunnen worden. (anders for-lus gebruiken bij aanmaken)
	JTextField txtIngave;
	static JTextField txtTotaleBerekening;
	private JPanel pnlNoord, pnlCenter, pnlZuid, pnlOost;
	double uitkomst = 0.0;
	static ArrayList<String> ingave = new ArrayList<String>();
	
	public Calculator()
	{
		//Panelen aanmaken
		//----------------
		pnlNoord = new JPanel(new BorderLayout());
		pnlOost = new JPanel(new GridLayout(4,1));
		pnlCenter = new JPanel(new GridLayout(4,3));
		pnlZuid = new JPanel(new BorderLayout());
		
		//Innerklasse gebruiken om events te doen
		//---------------------------------------
		ActionCommandHandler handlerEvents = new ActionCommandHandler(this);
		
		//Bewerkingsknoppen
		//-----------------
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
		
		btnPlus.setFont(new Font("",Font.PLAIN,18));
		btnMin.setFont(new Font("",Font.PLAIN,18));
		btnMaal.setFont(new Font("",Font.PLAIN,18));
		btnDeling.setFont(new Font("",Font.PLAIN,18));
			
		pnlOost.add(btnPlus);
		pnlOost.add(btnMin);
		pnlOost.add(btnMaal);
		pnlOost.add(btnDeling);
			
				
		//Cijferknoppen
		//-------------
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
		
		//pnlPaneel toevoegen aan JFrame
		//------------------------------
		add(pnlNoord, BorderLayout.NORTH);
		add(pnlOost, BorderLayout.EAST);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlZuid, BorderLayout.SOUTH);
	}
	
	public static void setKommaTrue()
	{
		btnKomma.setEnabled(true);
	}
	public static void setEnabled()
	{
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
	public static void setDisabled()
	{
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
	public static void setTotaleBerekening()
	{
		txtTotaleBerekening.setText("");
		for(int i=0; i<ingave.size(); i++)
		{			
			txtTotaleBerekening.setText(txtTotaleBerekening.getText()+" "+ingave.get(i));
		}
	}
	public static String getInvoerZonderNul(String tekst)
	{
		String invoerWaarde = tekst;
		int lengte = invoerWaarde.length();
		boolean controleNull = true;
		while(controleNull)
		{
			//Reden lengte>1:
			//De gebruiker kan bijv. 12*0 doen. Als deze controle niet gedaan wordt, kan 0 niet ingevoerd worden (Geeft een foutmelding)
			if(lengte > 1 && invoerWaarde.substring(0,1).equals("0") && !invoerWaarde.substring(1,2).equals("."))
			{
				invoerWaarde = invoerWaarde.substring(1);			//zorgen voor geen voorloopnullen (indien het 2de char een punt is)
				lengte = invoerWaarde.length();
			}
			else if(invoerWaarde.substring(0,1).equals("."))		//Zorgen voor een voorloopnul bij een decimaal getal
			{
				invoerWaarde = "0"+invoerWaarde;
				lengte = invoerWaarde.length();
			}
			else if(invoerWaarde.substring(lengte-1, lengte).equals("."))	//Zorgen voor een 0 na een punt wanneer het punt de laatste char is
			{
				invoerWaarde = invoerWaarde+"0";
				lengte = invoerWaarde.length();
			}
			else if(invoerWaarde.substring(0,1).equals("-") && invoerWaarde.substring(1,2).equals("."))
			{
				invoerWaarde = "-0."+invoerWaarde.substring(2);
			}
			else
			{
				controleNull = false;
			}
		}
		return invoerWaarde;
	}
}
