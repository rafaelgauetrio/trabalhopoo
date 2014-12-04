package Apresentacao;

import javax.swing.*;

import Negocio.Cliente;
import Negocio.Historico;
import Persistencia.Conexao;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
public class Extrato extends JFrame{
	JTextArea txtExtrato;
	Conexao conexao;
	public Extrato(final String conta){
		super("Operação de saque");
		conexao = new Conexao();
		Container tela = getContentPane();
		setLayout(null);


		txtExtrato = new JTextArea(10,30);
		txtExtrato.setBounds(10, 10, 380, 160);
		txtExtrato.setEditable(false);
		tela.add(txtExtrato);
	

		ArrayList<Historico> his = conexao.getHistorico();
		for (int i = 0; i < his.size(); i++) {
			if(his.get(i).getConta()==Integer.parseInt(conta)){
				txtExtrato.append(his.get(i).toString()+"\n");
			}
		}
		setSize(400, 180);
		setLocationRelativeTo(null);

		setVisible(true);
	}
	

}
/*
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Extrato extends JFrame {

	JTextArea jtAreaOutput;
	String newline = "\n";
	public Extrato() {
		createGui();
	}
	public void createGui() {
		jtAreaOutput = new JTextArea(5, 20);
		jtAreaOutput.setCaretPosition(jtAreaOutput.getDocument()
				.getLength());
		jtAreaOutput.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(jtAreaOutput,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		GridBagLayout gridBag = new GridBagLayout();
		Container contentPane = getContentPane();
		contentPane.setLayout(gridBag);
		GridBagConstraints gridCons1 = new GridBagConstraints();
		gridCons1.gridwidth = GridBagConstraints.REMAINDER;
		gridCons1.fill = GridBagConstraints.HORIZONTAL;

		GridBagConstraints gridCons2 = new GridBagConstraints();
		gridCons2.weightx = 1.0;
		gridCons2.weighty = 1.0;
		contentPane.add(scrollPane, gridCons2);
		jtAreaOutput.append("teste" + newline);

	}
	
	public static void main(String[] args) {
		Extrato jtfTfDemo = new Extrato();
		jtfTfDemo.pack();
		jtfTfDemo.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		jtfTfDemo.setVisible(true);
	}
}*/