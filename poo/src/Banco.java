public class Banco {
	private double valor;
	private String nome;
	private int numConta;
	private int CPF;
	private String endereco;
	private double deposito;
	private double saque;
	private double renda;
	private double limitetotal;
	private double limite;

	Banco(String nome, int numConta, int CPF, String endereco, double renda) {
		this.nome = nome;
		this.numConta = numConta;
		this.renda = renda;
		limite = 1000;
	}

	public String getNome() {
		return nome;
	}

	public int getCPF() {
		return CPF;
	}

	public String getEndereco() {
		return endereco;
	}

	public Banco(int numConta) {
		this("", numConta, 0, "", 0);
	}

	public int getnumConta() {
		return numConta;
	}

	void deposito(int numConta, double deposito) {
		this.numConta = numConta;
		this.deposito = deposito;
		valor += deposito;
	}

	public double sacar_fisico(int numConta, double saque) {
		this.numConta = numConta;
		this.saque = saque;
		limitetotal = valor + limite;
		if (limitetotal < saque) {
			System.out.println("Saldo insuficiente!!");
		} else {
			if (saque > valor) {
				saque -= valor;
				valor = saque * -1;
				limite -= saque;
				limite -= limite * 0.05;
			} else {
				valor -= saque;
			}
		}
		System.out.println(limite);
		return valor;
	}

	double saldo(String nome, int numConta) {
		this.numConta = numConta;
		this.nome = nome;
		return (limite + valor);
	}

	public boolean equals(Object obj) {
		if (obj instanceof Banco)
			if ((((Banco) obj).getNome().equals(this.nome))) {

				return true;
			}

		if ((((Banco) obj).getnumConta() == this.numConta)) {

			return true;
		}

		return false;

	}

}
