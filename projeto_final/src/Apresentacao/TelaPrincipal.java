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
		super("Terminal banc�rio RGCS");
		Container tela = getContentPane();
		setLayout(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		barra = new JMenuBar();
		setJMenuBar(barra);

		operacoes = new JMenu("Opera��es");
		relatorios = new JMenu("Relat�rios");
		sair=new JMenu("Sair");
		saque = new JMenuItem("Saque");
		deposito = new JMenuItem("Dep�sito");
		transferencia = new JMenuItem("Tranfer�ncia");
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