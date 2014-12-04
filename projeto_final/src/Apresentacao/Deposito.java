package Apresentacao;


import javax.swing.*;

import Negocio.Cliente;
import Persistencia.Conexao;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
public class Deposito extends JFrame{
	JButton Confirma,Cancelar;
	JTextField txtValor;
	JLabel lblValor;
	Conexao conexao;
	public Deposito(final String conta){
		super("Operação de depósito");
		conexao = new Conexao();
		Container tela = getContentPane();
		setLayout(null);


		txtValor = new JTextField();

		lblValor = new JLabel("Valor: ");

		Confirma = new JButton("Confirmar"); 
		Cancelar = new JButton("Cancelar");


		lblValor.setBounds(45, 30, 100, 20);


		txtValor.setBounds(120, 30, 150, 20);

		Confirma.setBounds(80,90,100,20);
		Cancelar.setBounds(220,90,100,20);

		Confirma.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){

						ArrayList<Cliente> clientes = conexao.getClientes();
						Cliente cli = conexao.getConta(conta);
						double saldo=cli.deposito(Double.parseDouble(txtValor.getText()));
						JOptionPane.showMessageDialog(null, "Deposito feito com sucesso. Novo Saldo: R$ "+saldo);
						for (int i = 0; i < clientes.size(); i++) {
							if(clientes.get(i).getNumero_conta()==cli.getNumero_conta())
								clientes.set(i, cli);
						}
						conexao.SalvaClientes(clientes);

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

		tela.add(lblValor);


		tela.add(Confirma);
		tela.add(Cancelar);

		setSize(400, 180);
		setLocationRelativeTo(null);

		setVisible(true);
	}
	public static void main(String[] args) {
		Deposito saque = new Deposito("1357");
		saque.setDefaultCloseOperation(EXIT_ON_CLOSE);
		saque.setVisible(true);
	}
}