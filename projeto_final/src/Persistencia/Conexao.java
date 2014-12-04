package Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Negocio.Cliente;
import Negocio.ClienteFisico;
import Negocio.ClienteJuridico;

public class Conexao {
	public String ContaLogada="";
	public ArrayList<Cliente> getClientes(){
		ArrayList<Cliente> cli=new ArrayList<Cliente>();

		try {
			FileReader arq = new FileReader("clientes.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			while (linha != null) { 
				String dados[]=linha.split(";");
				if(dados[0].equals("f")){
					//tipo(0) conta(1)  nome(2)   renda(3)  endereco(4)  cpf(5) LIMITE(6)   SENHA(7) 
					cli.add(new ClienteFisico(Integer.parseInt(dados[1]),dados[2], Double.parseDouble(dados[3]), dados[4], dados[5], Double.parseDouble(dados[6]), dados[7], Double.parseDouble(dados[8])));
				}else if(dados[0].equals("j")){
					cli.add(new ClienteJuridico(Integer.parseInt(dados[1]),dados[2], Double.parseDouble(dados[3]), dados[4], dados[5], Double.parseDouble(dados[6]), dados[7], Double.parseDouble(dados[8])));
				}
				linha = lerArq.readLine();
			}
			arq.close();
			return cli;
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<Cliente>();
	}

	public boolean logar(String conta, String senha){
		ArrayList<Cliente> cli=getClientes();
		for (Cliente cliente : cli) {
			if((cliente.getNumero_conta()==Integer.parseInt(conta)) && (cliente.getSenha().equals(senha))){
				ContaLogada=String.valueOf(cliente.getNumero_conta());
				return true;
			}
			if(Integer.parseInt(conta)==0)
				return true;
		}

		return false;
	}

	public boolean cadastraCliente(String Nome, String Renda,String Endereco, String Conta, String Senha, String CpfCnpj){
		try{
			ArrayList<Cliente> cli= getClientes();
			if(CpfCnpj.length()==14){
				cli.add(new ClienteFisico(Integer.parseInt(Conta),Nome, Double.parseDouble(Renda), Endereco,CpfCnpj, Double.parseDouble(Renda)*0.4, Senha,0));
			}else{
				cli.add(new ClienteJuridico(Integer.parseInt(Conta),Nome, Double.parseDouble(Renda), Endereco,CpfCnpj, Double.parseDouble(Renda)*0.4, Senha,0));
	
			}
			return SalvaClientes(cli);
		}catch(Exception e){
			return false;
		}
		


	}
	public boolean SalvaClientes(ArrayList<Cliente> cli){
		try {
			FileWriter fr = new FileWriter("clientes.txt");
			BufferedWriter arq = new BufferedWriter(fr);
			for (int i=0; i<cli.size(); i++){
				if(cli.get(i) instanceof ClienteFisico){
					arq.write("f"+";"+ ((ClienteFisico)cli.get(i)).getNumero_conta() + ";" + ((ClienteFisico)cli.get(i)).getNome() + ";" + ((ClienteFisico)cli.get(i)).getRenda()+ ";" +
							((ClienteFisico)cli.get(i)).getEndereco() + ";" + ((ClienteFisico)cli.get(i)).getCpf() + ";" + ((ClienteFisico)cli.get(i)).getLimite() + ";" + ((ClienteFisico)cli.get(i)).getSenha() + ";" + ((ClienteFisico)cli.get(i)).getSaldo()+ "\n");
				}else{
					arq.write("j"+";"+ ((ClienteJuridico)cli.get(i)).getNumero_conta() + ";" + ((ClienteJuridico)cli.get(i)).getNome() + ";" + ((ClienteJuridico)cli.get(i)).getRenda()+ ";" +
							((ClienteJuridico)cli.get(i)).getEndereco() + ";" + ((ClienteJuridico)cli.get(i)).getCnpj() + ";" + ((ClienteJuridico)cli.get(i)).getLimite() + ";" + ((ClienteJuridico)cli.get(i)).getSenha() + ";" + ((ClienteJuridico)cli.get(i)).getSaldo()+ "\n");
				}
			}
			arq.close();
			
			
							//tipo(0)                        conta(1)  nome(2)   renda(3)  endereco(4)  cpf(5)                     LIMITE(6)        SENHA(7) 

			return true;
		}catch(Exception e){
			return false;
							
		}
	}

	public Cliente getConta(String conta) {
		
		ArrayList<Cliente> cli=getClientes();
		for (Cliente cliente : cli) {
			if(cliente.getNumero_conta()==Integer.parseInt(conta)){
				return cliente;
			}
		}
		if(conta.equals("0"))
			return new Cliente(0, "", 0, "", "",0,0);
		return null;
	}
}
