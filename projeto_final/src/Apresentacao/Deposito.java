package Apresentacao;


import javax.swing.*;

import Negocio.Cliente;
import Negocio.Historico;
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
		super("Opera��o de dep�sito");
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
						try{

							ArrayList<Cliente> clientes = conexao.getClientes();
							Cliente cli = conexao.getConta(conta);
							ArrayList<Historico> historicos = conexao.getHistorico();
							Historico historico = null;
							double saldo=cli.deposito(Double.parseDouble(txtValor.getText()));
							JOptionPane.showMessageDialog(null, "Deposito feito com sucesso. Novo Saldo: R$ "+saldo);
							historico= new Historico(Integer.parseInt(conta), "E", Double.parseDouble(txtValor.getText()), saldo);

							for (int i = 0; i < clientes.size(); i++) {
								if(clientes.get(i).getNumero_conta()==cli.getNumero_conta())
									clientes.set(i, cli);
							}
							if (!historico.equals(null))
								historicos.add(historico);
							conexao.SalvaHistoricos(historicos);
							conexao.SalvaClientes(clientes);

						}catch(Exception e2 ){
							JOptionPane.showMessageDialog(null, "Erro ao fazer opera��o");

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

		tela.add(lblValor);


		tela.add(Confirma);
		tela.add(Cancelar);

		setSize(400, 180);
		setLocationRelativeTo(null);

		setVisible(true);
	}

}