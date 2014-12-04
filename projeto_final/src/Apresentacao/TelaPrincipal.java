package Apresentacao;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class TelaPrincipal extends JFrame{
	
	
	JMenuBar barra;
	JMenu  operacoes,relatorios, sair;
	JMenuItem saque, deposito, transferencia,extrato,saldo;
	JPanel panel;
	public TelaPrincipal(){
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
		
		
		
	}
	
}