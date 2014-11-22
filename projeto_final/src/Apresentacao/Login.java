package Apresentacao;


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame{
	JLabel rotulo1, rotulo2, rotulo3;
	JButton Logar,Cancelar;
	JTextField txtLogin, txtSenha;
	JLabel lblLogin, lblSenha;
	public Login(){
		super("Entre com seus dados");
		Container tela = getContentPane();
		setLayout(null);
		lblLogin = new JLabel("Login: ");
		lblSenha = new JLabel("Senha: ");
		txtLogin = new JTextField();
		txtSenha = new JPasswordField();
		Logar = new JButton("Logar"); 
		Cancelar = new JButton("Cancelar");
		lblLogin.setBounds(50, 50, 50, 20);
		lblSenha.setBounds(45, 80, 50, 20);
		txtLogin.setBounds(100, 50, 250, 20);
		txtSenha.setBounds(100, 80, 250, 20);

		Logar.setBounds(115,140,90,20);
		Cancelar.setBounds(215,140,90,20);
		Logar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						TelaPrincipal principal = new TelaPrincipal();
						principal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						principal.setVisible(true);
					}
				}
		);
		
		Cancelar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						System.exit(0);
					}
				}
		);
		
		tela.add(txtLogin);
		tela.add(txtSenha);
		tela.add(lblLogin);
		tela.add(lblSenha);
		tela.add(Logar);
		tela.add(Cancelar);
		setSize(425, 250);
		setLocationRelativeTo(null);

		setVisible(true);
	}
	public static void main(String args[]){
		Login app = new Login();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}