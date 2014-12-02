package Apresentacao;


import javax.swing.*;

import Persistencia.Conexao;

import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame{
	JButton Logar,Cancelar;
	JTextField txtLogin, txtSenha;
	JLabel lblLogin, lblSenha;
	Conexao conexao;
	public Login(){
		super("Entre com seus dados");
		conexao = new Conexao();
		Container tela = getContentPane();
		setLayout(null);
		lblLogin = new JLabel("Conta: ");
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
						if(conexao.logar(lblLogin.getText(), lblSenha.getText())){
							TelaPrincipal principal = new TelaPrincipal();
							principal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							principal.setVisible(true);
						}else{
							int status = JOptionPane.showConfirmDialog(null,"Erro de autenticação. Deseja cadastrar novo cliente?",
									"Autenticação",JOptionPane.YES_NO_OPTION);
							if (status == JOptionPane.YES_OPTION)
							{

							}	
						}
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