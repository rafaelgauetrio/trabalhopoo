package Apresentacao;


import javax.swing.*;

import Negocio.Cliente;
import Persistencia.Conexao;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
public class Tranferencia extends JFrame{
	JButton Confirma,Cancelar;
	JTextField txtValor,txtConta, txtSenha;
	JLabel lblValor,lblConta, lblSenha;
	Conexao conexao;
	public Tranferencia(final String conta){
		super("Operação de tranferência");
		conexao = new Conexao();
		Container tela = getContentPane();
		setLayout(null);


		txtValor = new JTextField();
		txtConta = new JTextField();
		txtSenha = new JPasswordField();

		lblSenha = new JLabel("Senha: ");
		lblValor = new JLabel("Valor: ");
		lblConta = new JLabel("Conta: ");

		Confirma = new JButton("Confirmar"); 
		Cancelar = new JButton("Cancelar");


		lblValor.setBounds(45, 30, 100, 20);
		lblConta.setBounds(45, 60, 100, 20);
		lblSenha.setBounds(45, 90, 100, 20);


		txtValor.setBounds(120, 30, 150, 20);
		txtConta.setBounds(120, 60, 150, 20);
		txtSenha.setBounds(120, 90, 150, 20);

		Confirma.setBounds(80,120,100,20);
		Cancelar.setBounds(220,120,100,20);

		Confirma.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						try{
							ArrayList<Cliente> clientes = conexao.getClientes();
							Cliente cli = conexao.getConta(conta);
							Cliente cli2 = conexao.getConta(txtConta.getText());
							if (!cli2.equals(null)) {

								if (txtSenha.getText().equals(cli.getSenha())) {
									if(cli.getSaldo()+cli.getLimite()>Double.parseDouble(txtValor.getText())){
										double saldo=cli.saque(Double.parseDouble(txtValor.getText()));
										cli2.deposito(Double.parseDouble(txtValor.getText()));
										JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso. Saldo atual: R$ "+saldo);
									}else {
										JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
									}
									for (int i = 0; i < clientes.size(); i++) {
										if(clientes.get(i).getNumero_conta()==cli.getNumero_conta())
											clientes.set(i, cli);
										if(clientes.get(i).getNumero_conta()==cli2.getNumero_conta())
											clientes.set(i, cli2);
									}
									conexao.SalvaClientes(clientes);
								}else{
									JOptionPane.showMessageDialog(null, "Senha não confere!");

								}
							}
						}catch(Exception e2 ){
							JOptionPane.showMessageDialog(null, "Erro ao fazer operação");

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

		tela.add(txtValor);
		tela.add(txtConta);
		tela.add(txtSenha);

		tela.add(lblSenha);
		tela.add(lblConta);
		tela.add(lblValor);


		tela.add(Confirma);
		tela.add(Cancelar);

		setSize(400, 210);
		setLocationRelativeTo(null);

		setVisible(true);
	}

}