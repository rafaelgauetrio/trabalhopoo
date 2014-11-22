package Apresentacao;

import java.io.*;
import java.util.*;
import Negocio.*;
public class Teste {
	public static void main(String[] args) {
		ArrayList<cliente> cli=new ArrayList<cliente>();
		Scanner l= new Scanner(System.in);
		int codigo=0;
		String nome="";
		double renda=0.0;
		String endereco="";
		String cpf_cnpj="";
		double limite=0.0;
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
			
		} 
		 catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("clientes adicionados");
		for(int i=0;i<cli.size();i++){
			System.out.println(cli.get(i).getNome());
		}
		
		FileWriter arq;
		try {
			arq = new FileWriter("clientes.txt");
			PrintWriter gravarArq = new PrintWriter(arq);
			int tipo=0;
			System.out.println("1-f\n2-j");
			tipo=l.nextInt();
			
			System.out.println("n° da conta:");
			codigo=l.nextInt();
			System.out.println("nome:");
			nome=l.next();
			System.out.println("renda:");
			renda=l.nextDouble();
			System.out.println("endereço:");
			endereco=l.next();
			l.next();
			System.out.println("cpf/cnpj:");
			cpf_cnpj=l.next();
			l.next();
			System.out.println("limite:");
			limite=l.nextDouble();
			
			if(tipo==1){
				gravarArq.write("f;"+codigo+";"+nome+";"+renda+";"+endereco+";"+cpf_cnpj+";"+limite);
			}else if(tipo==2){
				gravarArq.write("j;"+codigo+";"+nome+";"+renda+";"+endereco+";"+cpf_cnpj+";"+limite);
			}
			gravarArq.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
//		if(cli.get(1).getSaldo()!=200){//if que trata de tranferencias o 200 seria substituido por valor de transferencia
//			System.out.println("como seu saldo foi insuficiente só foi possível fazer a transferência do valor de seu saldo");
//		}
		
	}

}
