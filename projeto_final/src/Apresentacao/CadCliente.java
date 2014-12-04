package Apresentacao;


import javax.swing.*;

import Persistencia.Conexao;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class CadCliente extends JFrame{
	JButton Cadastrar,Cancelar;
	JTextField txtNome, txtRenda,txtEndereco, txtSenha;
	JFormattedTextField txtCpfCnpj;
	JLabel lblNome, lblRenda, lblEndereco, lblSenha, lblCpfCnpj;
	Conexao conexao;
	public CadCliente(){
		super("Entre com seus dados");
		conexao = new Conexao();
		Container tela = getContentPane();
		setLayout(null);
		
		txtCpfCnpj = new JFormattedTextField();
		txtSenha = new JPasswordField();
		txtEndereco = new JTextField();
		txtNome = new JTextField();
		txtRenda = new JTextField();
		
		lblSenha = new JLabel("Senha: ");
		lblNome = new JLabel("Nome: ");
		lblRenda = new JLabel("Renda: ");
		lblEndereco = new JLabel("Endereço: ");
		lblCpfCnpj = new JLabel("CPF/CNPJ: ");

		Cadastrar = new JButton("Cadastrar"); 
		Cancelar = new JButton("Cancelar");
		
		lblNome.setBounds(45, 50, 100, 20);
		lblCpfCnpj.setBounds(45, 80, 100, 20);
		lblEndereco.setBounds(45, 110, 100, 20);
		lblRenda.setBounds(45, 140, 100, 20);
		lblSenha.setBounds(45, 170, 100, 20);
		
		txtNome.setBounds(120, 50, 250, 20);
		txtCpfCnpj.setBounds(120, 80, 250, 20);
		txtEndereco.setBounds(120, 110, 250, 20);
		txtRenda.setBounds(120, 140, 250, 20);
		txtSenha.setBounds(120, 170, 250, 20);
		
		Cadastrar.setBounds(120,200,100,20);
		Cancelar.setBounds(270,200,100,20);
		
		Cadastrar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						Random gerador = new Random();
						 
				        gerador.nextInt(10);
				        String conta="0";
				        while(conexao.getConta(conta)!=null)//verifica se conta existe
				        	conta="0"+gerador.nextInt(10)+""+gerador.nextInt(10)+""+gerador.nextInt(10)+""+gerador.nextInt(10);
						if(conexao.cadastraCliente(txtNome.getText(), txtRenda.getText(), txtEndereco.getText(), conta, txtSenha.getText(), txtCpfCnpj.getText())){
							JOptionPane.showMessageDialog(null, "Conta n° "+conta+" criada com sucesso!");
						}else{
							JOptionPane.showMessageDialog(null, "Erro ao Criar a conta!");

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

		tela.add(txtCpfCnpj);
		tela.add(txtSenha);
		tela.add(txtEndereco);
		tela.add(txtNome);
		tela.add(txtRenda);
		
		tela.add(lblSenha);
		tela.add(lblNome);
		tela.add(lblRenda);
		tela.add(lblEndereco);
		tela.add(lblCpfCnpj);
		
		tela.add(Cadastrar);
		tela.add(Cancelar);
		
		setSize(800, 600);
		setLocationRelativeTo(null);

		setVisible(true);
	}
	
}