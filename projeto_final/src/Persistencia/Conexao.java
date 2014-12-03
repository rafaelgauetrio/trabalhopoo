package Persistencia;

import java.io.BufferedReader;
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
					cli.add(new cliente_fisico(dados[2], Double.parseDouble(dados[3]), dados[4], dados[5], Double.parseDouble(dados[6]), dados[7]));
				}else if(dados[0].equals("j")){
					cli.add(new cliente_juridico(dados[2], Double.parseDouble(dados[3]), dados[4], dados[5], Double.parseDouble(dados[6]), dados[7]));
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
			if((cliente.getNumero_conta()==Integer.parseInt(conta)) && (cliente.getClass().equals(senha))){
				return true;
			}
			if(Integer.parseInt(conta)==0)
				return true;
		}

		return false;
	}

	public boolean cadastraCliente(String Nome, String Renda,String Endereco, String Conta, String Senha, String CpfCnpj){
		FileWriter arq;
		try {
			arq = new FileWriter("clientes.txt");
			PrintWriter gravarArq = new PrintWriter(arq);
							//tipo(0)                        conta(1)  nome(2)   renda(3)  endereco(4)  cpf(5)                     LIMITE(6)        SENHA(7) 
			gravarArq.write((CpfCnpj.length()==14?"j":"f")+";"+Conta+";"+Nome+";"+Renda+";"+Endereco+";"+CpfCnpj+";"+Double.parseDouble(Renda)*0.4+";"+Senha);

			gravarArq.flush();
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
		if(conta.equals(""))
			return true;
		return false;
	}
}
