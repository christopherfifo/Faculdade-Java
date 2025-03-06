package telas;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculadora {
	
	private JFrame janela = new JFrame();
	private JTextField display = new JTextField();
	
	private JButton btn7 = new JButton("7");
	private JButton btn8 = new JButton("8");
	private JButton btn9 = new JButton("9");
	private JButton btnSoma = new JButton("+");
	
	private JButton btn4 = new JButton("4");
	private JButton btn5 = new JButton("5");
	private JButton btn6 = new JButton("6");
	private JButton btnSub = new JButton("-");
	
	private JButton btn1 = new JButton("1");
	private JButton btn2 = new JButton("2");
	private JButton btn3 = new JButton("3");
	private JButton btnMult = new JButton("*");
	
	private JButton btnPonto = new JButton(".");
	private JButton btn0 = new JButton("0");
	private JButton btnInvert = new JButton("+/-");
	private JButton btnIgual = new JButton("=");
	
	private Font fonte = new Font("Arial", Font.BOLD, 26);
	private Font fonte2 = new Font("Arial", Font.BOLD, 10);
	
	public Calculadora() {
		this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.janela.setTitle("Calculadora");
		this.janela.setBounds(500, 500, 225, 310);
		this.janela.setLayout(null);
		
		this.display.setBounds   (  5, 5, 215, 40 );
		this.display.setFont(fonte);
		
		this.btn7.setBounds   (  5, 55, 50, 50);
		this.btn7.setFont(fonte);
		
		this.btn7.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				display.setText(display.getText() + "7");
			}
		});
		this.btn8.setBounds   ( 60, 55, 50, 50);
		this.btn8.setFont(fonte);
		this.btn9.setBounds   (115, 55, 50, 50);
		this.btn9.setFont(fonte);
		this.btnSoma.setBounds(170,55, 50, 50);
		this.btnSoma.setFont(fonte);
		
		this.btn4.setBounds   (  5, 110, 50, 50);
		this.btn4.setFont(fonte);
		this.btn5.setBounds   ( 60, 110, 50, 50);
		this.btn5.setFont(fonte);
		this.btn6.setBounds   (115, 110, 50, 50);
		this.btn6.setFont(fonte);
		this.btnSub.setBounds(170, 110, 50, 50);
		this.btnSub.setFont(fonte);
		
		this.btn1.setBounds   (  5, 165, 50, 50);
		this.btn1.setFont(fonte);
		this.btn2.setBounds   ( 60, 165, 50, 50);
		this.btn2.setFont(fonte);
		this.btn3.setBounds   (115, 165, 50, 50);
		this.btn3.setFont(fonte);
		this.btnMult.setBounds(170, 165, 50, 50);
		this.btnSub.setFont(fonte);
		
		this.btn1.setBounds   (  5, 165, 50, 50);
		this.btn1.setFont(fonte);
		this.btn2.setBounds   ( 60, 165, 50, 50);
		this.btn2.setFont(fonte);
		this.btn3.setBounds   (115, 165, 50, 50);
		this.btn3.setFont(fonte);
		this.btnMult.setBounds(170, 165, 50, 50);
		this.btnSub.setFont(fonte);
		
		this.btnPonto.setBounds   	(  5, 220, 50, 50);
		this.btnPonto.setFont(fonte);
		this.btn0.setBounds   		( 60, 220, 50, 50);
		this.btn0.setFont(fonte);
		this.btnInvert.setBounds   	(115, 220, 50, 50);
		this.btnInvert.setFont(fonte2);
		this.btnIgual.setBounds		(170, 220, 50, 50);
		this.btnIgual.setFont(fonte);
		
		this.janela.add(display);
		this.janela.add(btn7);
		this.janela.add(btn8);
		this.janela.add(btn9);
		this.janela.add(btnSoma);
		this.janela.add(btn4);
		this.janela.add(btn5);
		this.janela.add(btn6);
		this.janela.add(btnSub);
		
		this.janela.add(btn1);
		this.janela.add(btn2);
		this.janela.add(btn3);
		this.janela.add(btnMult);
		
		this.janela.add(btnPonto);
		this.janela.add(btn0);
		this.janela.add(btnInvert);
		this.janela.add(btnIgual);
		
		
		this.janela.setVisible(true);
	}

}