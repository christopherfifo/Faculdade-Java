package telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculadora2  extends JFrame{
	
	private static final long serialVersionUID = 1L;

	private JTextField display = new JTextField();
	
	private JButton[] buttons = new JButton[20];	
	private String[] labels = {"AC","M1", "M2", "+/-","7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", ".", "0", "=", "/"};
	private Font fonte1 = new Font("Arial", Font.BOLD, 26);
	private Font fonte2 = new Font("Arial", Font.BOLD, 11);
	
	private String operador = "";
	private String valorAcumulado = ""; 
	private boolean apagaDisplay = false;
	
	private Double M1 = 0.0;
	private Double M2 = 0.0;
	
	public Calculadora2() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Calculadora");
		this.setBounds(500, 500, 225, 370);
		this.setLayout(null);
		
		this.display.setBounds   (  5, 5, 215, 40 );
		this.display.setFont(fonte1);
		
		int i = 0;
		for (int linha = 55; linha <= 275; linha+=55) {
			for (int coluna = 5; coluna <=170; coluna+=55) {
				this.buttons[i] = new JButton(this.labels[i]);
				this.buttons[i].setBounds   ( coluna, linha, 50, 50);
				this.buttons[i].setFont((this.buttons[i].getText() == "+/-") ||
						(this.buttons[i].getText() == "AC") ||
						(this.buttons[i].getText() == "M1") ||
						(this.buttons[i].getText() == "M2")
						?fonte2:fonte1);	
				this.buttons[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						digito(((JButton) e.getSource()).getText());
					}
				});
				this.add(this.buttons[i]);
				i++;
			}
		}	
		this.add(display);
		this.setVisible(true);
	}


	public void igual() {
		if (( display.getText() != "") && (operador != "") && (valorAcumulado != "")) {
			switch  (operador) {
				case "+": {
					display.setText(( Double.parseDouble(valorAcumulado) + Double.parseDouble(display.getText()))+"");
				} break;
				case "-": { 
					display.setText(( Double.parseDouble(valorAcumulado)-Double.parseDouble(display.getText()) )+"");
						
				} break;
				case "*": { 
					display.setText(( Double.parseDouble(valorAcumulado) * Double.parseDouble(display.getText()))+"");
					
				} break;
				case "/": { 
					display.setText(( Double.parseDouble(valorAcumulado) / Double.parseDouble(display.getText()))+"");
				} break;
			}
			valorAcumulado = "";
			operador = "";
		} else {
			
		}
	}
	
	public void execOperador(String identificador) {
		if (( valorAcumulado == "") && (operador == ""))	{
			operador = identificador;
			valorAcumulado = display.getText();
			apagaDisplay = true;
		} else {
			if((valorAcumulado != "") && (operador != "")) 
			{
				igual();
				operador = identificador;
				valorAcumulado = display.getText();
				apagaDisplay = true;
			}

		}
	}
	
	public void memori1() {
		if( ( display.getText() != "") && (operador == "") && (valorAcumulado == "") && (M1 == 0.0)) {
			M1 = Double.parseDouble(display.getText());
			apagaDisplay = true;
		}else { if( ( display.getText() != "") && (operador != "") && (valorAcumulado != "") && (M1 != 0.0) ) {
			display.setText((display.getText() + M1.toString()));
			M1 = 0.0;
		} else {
			display.setText( M1.toString());
			M1 = 0.0;
		}
		}
	}
	
	public void clear() {
		display.setText("");
		valorAcumulado = "";
		operador = "";
	}
	
	public String digito( String identificador ) {
		switch (identificador) {
			case "+": { execOperador(identificador); } break;
			case "-": { execOperador(identificador); } break;
			case "*": { execOperador(identificador); } break;
			case "/": { execOperador(identificador); } break;
			case "=": {  igual();  } break;
			case ".": { 
				if( ! display.getText().contains(".")) {
					display.setText(display.getText() + identificador);
				}
			} break;
			case "AC": {clear(); } break;
			case "M1": {memori1();} break;
			default: {
				if(apagaDisplay) {
					display.setText("");
					apagaDisplay = false;
				}
				display.setText(display.getText() + identificador);
			}
		}
		
		
		return "";
	}
}