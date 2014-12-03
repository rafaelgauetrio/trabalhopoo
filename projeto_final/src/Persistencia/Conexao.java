package Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Negocio.cliente;
import Negocio.cliente_fisico;
import Negocio.cliente_juridico;

public class Conexao {
	public String ContaLogada="";
	public ArrayList<cliente> getClientes(){
		ArrayList<cliente> cli=new ArrayList<cliente>();

		try {
			FileReader arq = new FileReader("clientes.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			while (linha != null) { 
				String dados[]=linha.split(";");
				if(dados[0].equals("f")){
					//tipo(0) conta(1)  nome(2)   renda(3)  endereco(4)  cpf(5) LIMITE(6)   SENHA(7) 
					cli.add(new cliente_fisico(Integer.parseInt(dados[1]),dados[2], Double.parseDouble(dados[3]), dados[4], dados[5], Double.parseDouble(dados[6]), dados[7]));
				}else if(dados[0].equals("j")){
					cli.add(new cliente_juridico(Integer.parseInt(dados[1]),dados[2], Double.parseDouble(dados[3]), dados[4], dados[5], Double.parseDouble(dados[6]), dados[7]));
				}
				linha = lerArq.readLine();
			}
			arq.close();
			return cli;
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<cliente>();
	}

	public boolean logar(String conta, String senha){
		ArrayList<cliente> cli=getClientes();
		for (cliente cliente : cli) {
			if((cliente.getNumero_conta()==Integer.parseInt(conta)) && (cliente.getSenha().equals(senha))){
				return true;
			}
			if(Integer.parseInt(conta)==0)
				return true;
		}

		return false;
	}

	public boolean cadastraCliente(String Nome, String Renda,String Endereco, String Conta, String Senha, String CpfCnpj){
		try{
			ArrayList<cliente> cli= getClientes();
			if(CpfCnpj.length()==14){
				cli.add(new cliente_fisico(Integer.parseInt(Conta),Nome, Double.parseDouble(Renda), Endereco,CpfCnpj, Double.parseDouble(Renda)*0.4, Senha));
			}else{
				cli.add(new cliente_juridico(Integer.parseInt(Conta),Nome, Double.parseDouble(Renda), Endereco,CpfCnpj, Double.parseDouble(Renda)*0.4, Senha));
	
			}
			return SalvaClientes(cli);
		}catch(Exception e){
			return false;
		}
		


	}
	public boolean SalvaClientes(ArrayList<cliente> cli){
		try {
			FileWriter fr = new FileWriter("clientes.txt");
			BufferedWriter arq = new BufferedWriter(fr);
			for (int i=0; i<cli.size(); i++){
				if(cli.get(i) instanceof cliente_fisico){
					arq.write("f"+";"+ ((cliente_fisico)cli.get(i)).getNumero_conta() + ";" + ((cliente_fisico)cli.get(i)).getNome() + ";" + ((cliente_fisico)cli.get(i)).getRenda()+ ";" +
							((cliente_fisico)cli.get(i)).getEndereco() + ";" + ((cliente_fisico)cli.get(i)).getCpf() + ";" + ((cliente_fisico)cli.get(i)).getLimite() + ";" + ((cliente_fisico)cli.get(i)).getSenha() + "\n");
				}else{
					arq.write("j"+";"+ ((cliente_juridico)cli.get(i)).getNumero_conta() + ";" + ((cliente_juridico)cli.get(i)).getNome() + ";" + ((cliente_juridico)cli.get(i)).getRenda()+ ";" +
							((cliente_juridico)cli.get(i)).getEndereco() + ";" + ((cliente_juridico)cli.get(i)).getCnpj() + ";" + ((cliente_juridico)cli.get(i)).getLimite() + ";" + ((cliente_juridico)cli.get(i)).getSenha() + "\n");
				}
			}
			arq.close();
			
			
							//tipo(0)                        conta(1)  nome(2)   renda(3)  endereco(4)  cpf(5)                     LIMITE(6)        SENHA(7) 

			return true;
		}catch(Exception e){
			return false;
							
		}
	}

	public boolean contaExiste(String conta) {
		
		ArrayList<cliente> cli=getClientes();
		for (cliente cliente : cli) {
			if(cliente.getNumero_conta()==Integer.parseInt(conta)){
				return true;
			}
		}
		if(conta.equals("0"))
			return true;
		return false;
	}
}
