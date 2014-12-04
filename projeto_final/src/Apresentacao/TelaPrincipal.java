package Apresentacao;
import javax.swing.*;

import Negocio.Cliente;
import Persistencia.Conexao;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class TelaPrincipal extends JFrame{
	
	
	JMenuBar barra;
	JMenu  operacoes,relatorios, sair;
	JMenuItem saque, deposito, transferencia,extrato,saldo;
	JPanel panel;
	public TelaPrincipal(final String conta){
		super("Terminal bancário RGCS");
		Container tela = getContentPane();
		setLayout(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		barra = new JMenuBar();
		setJMenuBar(barra);

		operacoes = new JMenu("Operações");
		relatorios = new JMenu("Relatórios");
		sair=new JMenu("Sair");
		saque = new JMenuItem("Saque");
		deposito = new JMenuItem("Depósito");
		transferencia = new JMenuItem("Tranferência");
		extrato = new JMenuItem("Extrato");
		saldo = new JMenuItem("Saldo");
		barra.add(operacoes);
		barra.add(relatorios);
		barra.add(sair);
		operacoes.add(saque);
		operacoes.add(deposito);
		operacoes.add(transferencia);
		relatorios.add(extrato);
		relatorios.add(saldo);
		
		saque.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						Saque saque = new Saque(conta);
						saque.setDefaultCloseOperation(EXIT_ON_CLOSE);
						saque.setVisible(true);
					}
				}
				);
		deposito.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						Deposito deposito = new Deposito(conta);
						deposito.setDefaultCloseOperation(EXIT_ON_CLOSE);
						deposito.setVisible(true);
					}
				}
				);
		transferencia.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						Tranferencia tranferencia = new Tranferencia(conta);
						tranferencia.setDefaultCloseOperation(EXIT_ON_CLOSE);
						tranferencia.setVisible(true);
					}
				}
				);
		saldo.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						Conexao con = new Conexao();
						Cliente cli = con.getConta(conta);
						JOptionPane.showMessageDialog(null,"Seu saldo é de R$ " +cli.getSaldo());
					}
				}
				);
		saldo.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						Extrato extrato = new Extrato(conta);
						extrato.setDefaultCloseOperation(EXIT_ON_CLOSE);
						extrato.setVisible(true);
						
					}
				}
				);
		
	}
	
}