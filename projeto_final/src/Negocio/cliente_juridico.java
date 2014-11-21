package Negocio;

public class cliente_juridico extends cliente{
	private String cnpj;
	private double limite;
	

	public cliente_juridico(int id, String nome, double renda, String endereco,
			String cnpj, double limite) {
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


	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "cliente_juridico [cnpj=" + cnpj + ", limite=" + limite
				+ ", getNome()=" + getNome() + ", getRenda()=" + getRenda()
				+ ", getNumero_conta()=" + getNumero_conta() + "]";
	}


	
	
	
}
