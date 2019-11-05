package pattern.calculator;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

//Een 'inner-class' om de events op te vangen
class ActionCommandHandler implements ActionListener
{
	/**
	 * 
	 */
	private final Calculator ActionCommandHandler;

	/**
	 * @param calculator
	 */
	ActionCommandHandler(Calculator calculator) {
		ActionCommandHandler = calculator;
	}

	
	public void checkActionCommandForActionEvent(ActionEvent actionEvent) {
		try {
			String actionEventCommand = actionEvent.getActionCommand();
			String value;
			
			switch (actionEventCommand) {
			case value:
				break;
				
			default:
				break;
			}
		} finally {
			
		}
	}
	
	private void setTextFoTextInputField(String inputCharacter) {
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if( e.getActionCommand().equals("0"))
			{
				ActionCommandHandler.txtIngave.setText(ActionCommandHandler.txtIngave.getText()+"0");
			}
			else if( e.getActionCommand().equals("1"))
			{
				ActionCommandHandler.txtIngave.setText(ActionCommandHandler.txtIngave.getText()+"1");
			}
			else if( e.getActionCommand().equals("2"))
			{
				ActionCommandHandler.txtIngave.setText(ActionCommandHandler.txtIngave.getText()+"2");
			}
			else if( e.getActionCommand().equals("3"))
			{
				ActionCommandHandler.txtIngave.setText(ActionCommandHandler.txtIngave.getText()+"3");
			}
			else if( e.getActionCommand().equals("4"))
			{
				ActionCommandHandler.txtIngave.setText(ActionCommandHandler.txtIngave.getText()+"4");
			}
			else if( e.getActionCommand().equals("5"))
			{
				ActionCommandHandler.txtIngave.setText(ActionCommandHandler.txtIngave.getText()+"5");
			}
			else if( e.getActionCommand().equals("6"))
			{
				ActionCommandHandler.txtIngave.setText(ActionCommandHandler.txtIngave.getText()+"6");
			}
			else if( e.getActionCommand().equals("7"))
			{
				ActionCommandHandler.txtIngave.setText(ActionCommandHandler.txtIngave.getText()+"7");
			}
			else if( e.getActionCommand().equals("8"))
			{
				ActionCommandHandler.txtIngave.setText(ActionCommandHandler.txtIngave.getText()+"8");
			}
			else if( e.getActionCommand().equals("9"))
			{
				ActionCommandHandler.txtIngave.setText(ActionCommandHandler.txtIngave.getText()+"9");
			}
			else if( e.getActionCommand().equals("."))
			{
				ActionCommandHandler.txtIngave.setText(ActionCommandHandler.txtIngave.getText()+".");
				Calculator.btnKomma.setEnabled(false);
			}
			else if( e.getActionCommand().equals("="))
			{
				if(!(ActionCommandHandler.txtIngave.getText().equals("") || ActionCommandHandler.txtIngave.getText().equals(".") || ActionCommandHandler.txtIngave.getText().equals("-") || ActionCommandHandler.txtIngave.getText().equals("-.")))
				{
					Calculator.ingave.add(Calculator.getInvoerZonderNul(ActionCommandHandler.txtIngave.getText()));				//Laatst ingegeven getal nog in de ArrayList plaatsen
					Calculator.setTotaleBerekening();
					ActionCommandHandler.uitkomst = Double.parseDouble(Calculator.ingave.get(0));	//Zorgen dat ook met het 1ste getal gerekend wordt
					for(int i=0; i<Calculator.ingave.size(); i++)
					{
						if(Calculator.ingave.get(i).equals("+"))
						{
							double conversieHulp = Double.parseDouble(Calculator.ingave.get(i+1));
							ActionCommandHandler.uitkomst += conversieHulp;
						}
						else if(Calculator.ingave.get(i).equals("-"))
						{
							double conversieHulp = Double.parseDouble(Calculator.ingave.get(i+1));
							ActionCommandHandler.uitkomst -= conversieHulp;
						}
						else if(Calculator.ingave.get(i).equals("*"))
						{
							double conversieHulp = Double.parseDouble(Calculator.ingave.get(i+1));
							ActionCommandHandler.uitkomst = ActionCommandHandler.uitkomst*conversieHulp;
						}
						else if(Calculator.ingave.get(i).equals("/"))
						{
							double conversieHulp = Double.parseDouble(Calculator.ingave.get(i+1));
							ActionCommandHandler.uitkomst = ActionCommandHandler.uitkomst/conversieHulp;
						}
					}
					Calculator.setDisabled();
					ActionCommandHandler.txtIngave.setForeground(Color.RED);
					if(((int)ActionCommandHandler.uitkomst == ActionCommandHandler.uitkomst))		//Kijken of uitkomst een kommagetal is of niet
					{
						ActionCommandHandler.txtIngave.setText((int)ActionCommandHandler.uitkomst+"");		//Drukt getal zonder komma (lees punt)
					}
					else
					{
						ActionCommandHandler.txtIngave.setText(ActionCommandHandler.uitkomst+"");				//Drukt getal met komma (lees punt)
					}
				}
				else throw new NumberFormatException();
			}
			else if(e.getActionCommand().equals("<"))
			{
				int lengte = ActionCommandHandler.txtIngave.getText().length();
				ArrayList<Character> characters = new ArrayList<Character>();
				for(int i=0; i<lengte-1; i++)	//Lengte met 1 verminderen om 1 cijfer te kunnen verwijderen
				{
					characters.add(ActionCommandHandler.txtIngave.getText().charAt(i));
				}
				Iterator<Character> iter = characters.iterator();
				String nieuwWaarde="";
				while (iter.hasNext())
				{
				    nieuwWaarde = nieuwWaarde+iter.next();
				}
				char laatsteChar = ActionCommandHandler.txtIngave.getText().charAt(lengte-1);
				if(laatsteChar == '.')		//char is een primitive datatype -> == gebruiken + ENKELE QUOTES!!!
				{
					Calculator.btnKomma.setEnabled(true);
				}
				ActionCommandHandler.txtIngave.setText(nieuwWaarde);
			}
			else if(e.getActionCommand().equals("+"))
			{
				if(!(ActionCommandHandler.txtIngave.getText().equals("") || ActionCommandHandler.txtIngave.getText().equals(".") || ActionCommandHandler.txtIngave.getText().equals("-") || ActionCommandHandler.txtIngave.getText().equals("-.")))	//Enkel een '.' wordt gezien als fout
				{
					Calculator.ingave.add(Calculator.getInvoerZonderNul(ActionCommandHandler.txtIngave.getText()));
					Calculator.ingave.add("+");
					ActionCommandHandler.txtIngave.setText("");
					Calculator.setTotaleBerekening();
					Calculator.setKommaTrue();
				}
				else throw new NumberFormatException();
			}
			else if(e.getActionCommand().equals("-"))
			{
				if(ActionCommandHandler.txtIngave.getText().equals(""))
				{
					ActionCommandHandler.txtIngave.setText("-");
				}
				else
				{
					if(!(ActionCommandHandler.txtIngave.getText().equals("-") || ActionCommandHandler.txtIngave.getText().equals(".") || ActionCommandHandler.txtIngave.getText().equals("-") || ActionCommandHandler.txtIngave.getText().equals("-.")))
					{
						Calculator.ingave.add(Calculator.getInvoerZonderNul(ActionCommandHandler.txtIngave.getText()));
						Calculator.ingave.add("-");
						ActionCommandHandler.txtIngave.setText("");
						Calculator.setTotaleBerekening();
						Calculator.setKommaTrue();
					}
					else throw new NumberFormatException();
				}
			}
			else if(e.getActionCommand().equals("x"))
			{
				if(!(ActionCommandHandler.txtIngave.getText().equals("") || ActionCommandHandler.txtIngave.getText().equals(".") || ActionCommandHandler.txtIngave.getText().equals("-") || ActionCommandHandler.txtIngave.getText().equals("-.")))
				{
					Calculator.ingave.add(Calculator.getInvoerZonderNul(ActionCommandHandler.txtIngave.getText()));
					Calculator.ingave.add("*");
					ActionCommandHandler.txtIngave.setText("");
					Calculator.setTotaleBerekening();
					Calculator.setKommaTrue();
				}
				else throw new NumberFormatException();
			}
			else if(e.getActionCommand().equals("/"))
			{
				if(!(ActionCommandHandler.txtIngave.getText().equals("") || ActionCommandHandler.txtIngave.getText().equals(".") || ActionCommandHandler.txtIngave.getText().equals("-") || ActionCommandHandler.txtIngave.getText().equals("-.")))
				{
					Calculator.ingave.add(Calculator.getInvoerZonderNul(ActionCommandHandler.txtIngave.getText()));
					Calculator.ingave.add("/");
					ActionCommandHandler.txtIngave.setText("");
					Calculator.setTotaleBerekening();
					Calculator.setKommaTrue();
				}
				else throw new NumberFormatException();
			}
			else if(e.getActionCommand().equals("Reset"))
			{
				ActionCommandHandler.txtIngave.setText("");
				ActionCommandHandler.txtIngave.setForeground(Color.BLACK);
				Calculator.txtTotaleBerekening.setText("");
				ActionCommandHandler.uitkomst = 0.0;
				Calculator.ingave.clear();		//ArrayList leegmaken
				Calculator.setEnabled();
			}
		}
		catch(NumberFormatException NFE)
		{
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(ActionCommandHandler, "Gelieve eerst een getal in te geven!", "Geen getal", 0);
		}
		catch(StringIndexOutOfBoundsException SIOOBE)	//Wanneer op '<' geklikt wordt en geen getal ingegeven is
		{
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(ActionCommandHandler, "Gelieve eerst een getal in te geven!", "Geen getal", 0);
		}
	}
}