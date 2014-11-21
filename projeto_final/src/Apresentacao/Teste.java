package Apresentacao;

import Negocio.cliente;
import Negocio.cliente_fisico;

public class Teste {
	public static void main(String[] args) {
		cliente cli=new cliente_fisico(0, "rafael", 20000, "caravelas", "03209165025", 20000);
		cli.getEndereco();
	}

}
