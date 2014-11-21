package Apresentacao;

import java.util.*;

import Negocio.cliente;
import Negocio.cliente_fisico;

public class Teste {
	public static void main(String[] args) {
		ArrayList<cliente> cli=new ArrayList<cliente>();
		cli.add(new cliente_fisico(0, "rafael", 20000, "caravelas", "03209165025", 20000));
		System.out.println(cli.get(0).deposito(100));
	}

}
