package Negocio;

public class conta {
	private int numero;
	private double saldo;

	public double getSaldo() {
		return saldo;
	}

	public void deposito(double dep) {
		saldo = saldo + dep;
	}
	public void saque(double saq) {
		saldo = saldo - saq;
	}

	public int getNumero() {
		return numero;
	}

	
}

