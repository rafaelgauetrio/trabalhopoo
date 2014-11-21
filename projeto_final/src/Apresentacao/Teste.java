package Apresentacao;

import java.util.*;

import Negocio.cliente;
import Negocio.cliente_fisico;

public class Teste {
	public static void main(String[] args) {
		ArrayList<cliente> cli=new ArrayList<cliente>();
		cli.add(new cliente_fisico(0, "rafael", 20000, "caravelas", "03209165025", 20000));
		cli.add(new cliente_fisico(1, "rafael2", 10000, "caravelas", "05209165025", 1000));
		System.out.println(cli.get(0).deposito(100));
		cli.get(0).transferencia(cli.get(1), 200);
		if(cli.get(1).getSaldo()!=200){
			System.out.println("como seu saldo foi insuficiente só foi possível fazer a transferência do valor de seu saldo");
		}
		System.out.println(cli.get(0).getNome()+" "+cli.get(0).getSaldo());
		System.out.println(cli.get(1).getNome()+" "+cli.get(1).getSaldo());
	}

}
