package Persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Negocio.cliente;
import Negocio.cliente_fisico;
import Negocio.cliente_juridico;

public class Conexao {
	
	public ArrayList<cliente> getClientes(){
		ArrayList<cliente> cli=new ArrayList<cliente>();
		
		try {
			FileReader arq = new FileReader("clientes.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			while (linha != null) { 
				String dados[]=linha.split(";");
				if(dados[0].equals("f")){
					cli.add(new cliente_fisico(Integer.parseInt(dados[1]),dados[2],Double.parseDouble(dados[3]),dados[4],dados[5],Double.parseDouble(dados[6])));
				}else if(dados[0].equals("j")){
					cli.add(new cliente_juridico(Integer.parseInt(dados[1]),dados[2],Double.parseDouble(dados[3]),dados[4],dados[5],Integer.parseInt(dados[6])));
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
}
