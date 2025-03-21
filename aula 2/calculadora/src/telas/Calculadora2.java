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
	
	private JButton[] buttons = new JButton[16];	
	private String[] labels = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", ".", "0", "=", "/"};
	private Font fonte1 = new Font("Arial", Font.BOLD, 26);
	private Font fonte2 = new Font("Arial", Font.BOLD, 10);
	
	private String operador = "";
	private String valorAcumulado = ""; 
	
	public Calculadora2() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Calculadora");
		this.setBounds(500, 500, 225, 310);
		this.setLayout(null);
		
		this.display.setBounds   (  5, 5, 215, 40 );
		this.display.setFont(fonte1);
		
		int i = 0;
		for (int linha = 55; linha <= 220; linha+=55) {
			for (int coluna = 5; coluna <=170; coluna+=55) {
				this.buttons[i] = new JButton(this.labels[i]);
				this.buttons[i].setBounds   ( coluna, linha, 50, 50);
				this.buttons[i].setFont((this.buttons[i].getText() == "+/-")?fonte2:fonte1);	
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

	public void calcular () {
		if (( display.getText() != "") && (operador != "") && (valorAcumulado != "")) {
			
		}
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
	
	public void calcular(String identificador) {
		if (( valorAcumulado == "") && (operador == ""))	{
			operador = identificador;
			valorAcumulado = display.getText();
			display.setText("");
		}
	}
	
	public String digito( String identificador ) {
		switch (identificador) {
			case "+": { calcular(identificador); } break;
			case "-": { calcular(identificador); } break;
			case "*": { calcular(identificador); } break;
			case "/": { calcular(identificador); } break;
			case "=": {  igual();  } break;
			case ".": { 
				if( ! display.getText().contains(".")) {
					display.setText(display.getText() + identificador);
				}
			} break;
			default: {
				display.setText(display.getText() + identificador);
			}
		}
		
		
		return "";
	}
}
