package telas;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora2 {
	
	private JFrame janela = new JFrame();
	private JTextField display = new JTextField();
	
	private String[] labes = {
		"7", "8", "9", "+",
		"4","5","6","-",
		"1", "2", "3", "*",
		".", "0", "+/-", "="
	};
	
	private JButton[] buttons = new JButton[16];
	
	private JPanel keyboardPanel = new JPanel();
	
	
	private Font fonte = new Font("Arial", Font.BOLD, 26);
	private Font fonte2 = new Font("Arial", Font.BOLD, 10);
	
	public Calculadora2() {
		this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.janela.setTitle("Calculadora");
		this.janela.setBounds(500, 500, 225, 310);
		this.janela.setLayout(null);
		
		this.display.setBounds   (  5, 5, 215, 40 );
		this.display.setFont(fonte);
		
		this.keyboardPanel.setBounds(5, 55, 215, 255);
		this.keyboardPanel.setLayout(new GridLayout(4,4));
		
		for(int i =0; i < this.buttons.length; i++) {
			
llçç~çç~ççççlkkkkkkkkkkkkkkkkkkkkkk;		} 
		
		this.janela.setVisible(true);
	}

}