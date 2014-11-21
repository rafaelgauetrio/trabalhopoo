package projeto_final;

public class cliente_juridico extends cliente{
	private long cnpj;
	private double limite;
	

	public cliente_juridico(int id, String nome, double renda, String endereco,
			long cnpj, double limite) {
		super(id, nome, renda, endereco);
		this.cnpj = cnpj;
		this.limite = limite;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}


	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "cliente_juridico [cnpj=" + cnpj + ", limite=" + limite
				+ ", getNome()=" + getNome() + ", getRenda()=" + getRenda()
				+ ", getNumero_conta()=" + getNumero_conta() + "]";
	}


	
	
	
}
