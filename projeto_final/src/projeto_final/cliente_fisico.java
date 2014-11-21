package projeto_final;

public class cliente_fisico extends cliente{
	private long cpf;
	private double limite;
	
	public cliente_fisico(int id, String nome, double renda, String endereco,
			long cpf, double limite) {
		super(id, nome, renda, endereco);
		this.cpf = cpf;
		this.limite = limite;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	@Override
	public String toString() {
		return "cliente_fisico [cpf=" + cpf + ", limite=" + limite
				+ ", getNome()=" + getNome() + ", getRenda()=" + getRenda()
				+ ", getEndereco()=" + getEndereco() + ", getNumero_conta()="
				+ getNumero_conta() + "]";
	}
	
	
	
	
}
