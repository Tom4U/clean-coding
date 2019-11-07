package uebungen.calculator.solution.unfinished;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

class ActionCommandHandler implements ActionListener
{
	private final Calculator calculator;
	
	private ArrayList<String> availableActionCommands;

	private void setAvailableNumberCommands() {
		availableActionCommands = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) {
			availableActionCommands.add(Integer.toString(i));
		}
		
		setAvailableSymbolCommands();
	}

	private void setAvailableSymbolCommands() {
		availableActionCommands.add(".");
		availableActionCommands.add("=");
		availableActionCommands.add("+");
		availableActionCommands.add("-");
		availableActionCommands.add("x");
		availableActionCommands.add("/");
		availableActionCommands.add("<");
		availableActionCommands.add("Reset");
	}

	ActionCommandHandler(Calculator calculator) {
		this.calculator = calculator;
		setAvailableNumberCommands();
		setAvailableSymbolCommands();
	}
	
	public void actionPerformed(ActionEvent actionEvent)
	{
		try {
			checkActionCommandForActionEvent(actionEvent);
		}
		catch(NumberFormatException NFE) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(this.calculator, "Gelieve eerst een getal in te geven!", "Geen getal", 0);
		}
		catch(StringIndexOutOfBoundsException SIOOBE) {	//Wanneer op '<' geklikt wordt en geen getal ingegeven is
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(this.calculator, "Gelieve eerst een getal in te geven!", "Geen getal", 0);
		}
	}

	public void checkActionCommandForActionEvent(ActionEvent actionEvent) {
		try {
			String actionEventCommand = actionEvent.getActionCommand();			
			checkActionCommandType(actionEventCommand);
		} catch (Exception ex) {}
	}

	private boolean isNumberCommand(String command) {
		try {
			Integer.parseInt(command);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	private void checkActionCommandType(String actionEventCommand) {
		if (isNumberCommand(actionEventCommand)) {
			addNewInputToCurrentTextInputField(actionEventCommand);
		}
		else {
			setSymbolForTextInputField(actionEventCommand);
		}
	}
	
	private void setSymbolForTextInputField(String actionEventCommand) {
		switch (actionEventCommand) {
		case ".":
			setDotSymbolActionEventCommand();
			break;
		case "=":
			setEqualSymbolActionEventCommand();
			break;
		case "+":
			setPlusSymbolActionEventCommand();
			break;
		case "-":
			setMinusSymbolActionEventCommand();
			break;
		case "x":
			setTimesSymbolActionEventCommand();
			break;
		case "/":
			setDividerSymbolActionEventCommand();
			break;
		case "<":
			setLowerThanSymbolActionEventCommand();
		case "Reset":
			resetTextInputField();
		default:
			break;
		}
	}

	private void resetTextInputField() {
		this.calculator.getTxtIngave().setText("");
		this.calculator.getTxtIngave().setForeground(Color.BLACK);
		Calculator.txtTotaleBerekening.setText("");
		this.calculator.uitkomst = 0.0;
		Calculator.ingave.clear();		//ArrayList leegmaken
		Calculator.setEnabled();
	}

	private void setLowerThanSymbolActionEventCommand() {
		int lengte = this.calculator.getTxtIngave().getText().length();
		ArrayList<Character> characters = new ArrayList<Character>();
		for(int i=0; i<lengte-1; i++)	//Lengte met 1 verminderen om 1 cijfer te kunnen verwijderen
		{
			characters.add(this.calculator.getTxtIngave().getText().charAt(i));
		}
		Iterator<Character> iter = characters.iterator();
		String nieuwWaarde="";
		while (iter.hasNext())
		{
		    nieuwWaarde = nieuwWaarde+iter.next();
		}
		char laatsteChar = this.calculator.getTxtIngave().getText().charAt(lengte-1);
		if(laatsteChar == '.')		//char is een primitive datatype -> == gebruiken + ENKELE QUOTES!!!
		{
			Calculator.getBtnKomma().setEnabled(true);
		}
		this.calculator.getTxtIngave().setText(nieuwWaarde);
	}

	private void setDividerSymbolActionEventCommand() {
		if(!(this.calculator.getTxtIngave().getText().equals("") || this.calculator.getTxtIngave().getText().equals(".") || this.calculator.getTxtIngave().getText().equals("-") || this.calculator.getTxtIngave().getText().equals("-.")))
		{
			Calculator.ingave.add(Calculator.getInvoerZonderNul(this.calculator.getTxtIngave().getText()));
			Calculator.ingave.add("/");
			this.calculator.getTxtIngave().setText("");
			Calculator.setTotaleBerekening();
			Calculator.setKommaTrue();
		}
		else throw new NumberFormatException();
	}

	private void setTimesSymbolActionEventCommand() {
		if(!(this.calculator.getTxtIngave().getText().equals("") || this.calculator.getTxtIngave().getText().equals(".") || this.calculator.getTxtIngave().getText().equals("-") || this.calculator.getTxtIngave().getText().equals("-.")))
		{
			Calculator.ingave.add(Calculator.getInvoerZonderNul(this.calculator.getTxtIngave().getText()));
			Calculator.ingave.add("*");
			this.calculator.getTxtIngave().setText("");
			Calculator.setTotaleBerekening();
			Calculator.setKommaTrue();
		}
		else throw new NumberFormatException();
	}

	private void setMinusSymbolActionEventCommand() {
		if(this.calculator.getTxtIngave().getText().equals(""))
		{
			this.calculator.getTxtIngave().setText("-");
		}
		else
		{
			if(!(this.calculator.getTxtIngave().getText().equals("-") || this.calculator.getTxtIngave().getText().equals(".") || this.calculator.getTxtIngave().getText().equals("-") || this.calculator.getTxtIngave().getText().equals("-.")))
			{
				Calculator.ingave.add(Calculator.getInvoerZonderNul(this.calculator.getTxtIngave().getText()));
				Calculator.ingave.add("-");
				this.calculator.getTxtIngave().setText("");
				Calculator.setTotaleBerekening();
				Calculator.setKommaTrue();
			}
			else throw new NumberFormatException();
		}
	}

	private void setPlusSymbolActionEventCommand() {
		if(!(this.calculator.getTxtIngave().getText().equals("") || this.calculator.getTxtIngave().getText().equals(".") || this.calculator.getTxtIngave().getText().equals("-") || this.calculator.getTxtIngave().getText().equals("-.")))	//Enkel een '.' wordt gezien als fout
		{
			Calculator.ingave.add(Calculator.getInvoerZonderNul(this.calculator.getTxtIngave().getText()));
			Calculator.ingave.add("+");
			this.calculator.getTxtIngave().setText("");
			Calculator.setTotaleBerekening();
			Calculator.setKommaTrue();
		}
		else throw new NumberFormatException();
	}

	private void setEqualSymbolActionEventCommand() {
		if(!(this.calculator.getTxtIngave().getText().equals("") || this.calculator.getTxtIngave().getText().equals(".") || this.calculator.getTxtIngave().getText().equals("-") || this.calculator.getTxtIngave().getText().equals("-.")))
		{
			Calculator.ingave.add(Calculator.getInvoerZonderNul(this.calculator.getTxtIngave().getText()));				//Laatst ingegeven getal nog in de ArrayList plaatsen
			Calculator.setTotaleBerekening();
			this.calculator.uitkomst = Double.parseDouble(Calculator.ingave.get(0));	//Zorgen dat ook met het 1ste getal gerekend wordt
			for(int i=0; i<Calculator.ingave.size(); i++)
			{
				if(Calculator.ingave.get(i).equals("+"))
				{
					double conversieHulp = Double.parseDouble(Calculator.ingave.get(i+1));
					this.calculator.uitkomst += conversieHulp;
				}
				else if(Calculator.ingave.get(i).equals("-"))
				{
					double conversieHulp = Double.parseDouble(Calculator.ingave.get(i+1));
					this.calculator.uitkomst -= conversieHulp;
				}
				else if(Calculator.ingave.get(i).equals("*"))
				{
					double conversieHulp = Double.parseDouble(Calculator.ingave.get(i+1));
					this.calculator.uitkomst = this.calculator.uitkomst*conversieHulp;
				}
				else if(Calculator.ingave.get(i).equals("/"))
				{
					double conversieHulp = Double.parseDouble(Calculator.ingave.get(i+1));
					this.calculator.uitkomst = this.calculator.uitkomst/conversieHulp;
				}
			}
			Calculator.setDisabled();
			this.calculator.getTxtIngave().setForeground(Color.RED);
			if(((int)this.calculator.uitkomst == this.calculator.uitkomst))		//Kijken of uitkomst een kommagetal is of niet
			{
				this.calculator.getTxtIngave().setText((int)this.calculator.uitkomst+"");		//Drukt getal zonder komma (lees punt)
			}
			else
			{
				this.calculator.getTxtIngave().setText(this.calculator.uitkomst+"");				//Drukt getal met komma (lees punt)
			}
		}
		else throw new NumberFormatException();
	}

	private void setDotSymbolActionEventCommand() {
		addNewInputToCurrentTextInputField(".");
		Calculator.getBtnKomma().setEnabled(false);
	}

	private void addNewInputToCurrentTextInputField(String inputCharacter) {
		String fullInputTextWithNewInputCharacter = getOldTextInputFieldValueWithNewInputAdded(inputCharacter);
		this.calculator.getTxtIngave().setText(fullInputTextWithNewInputCharacter);
	}
	
	private String getOldTextInputFieldValueWithNewInputAdded(String newInputCharacter) {
		String currentFieldValue = this.calculator.getTxtIngave().getText();
		String result = currentFieldValue + newInputCharacter;
		
		return result;
	}
}
