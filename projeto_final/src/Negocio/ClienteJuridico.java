package Negocio;

public class ClienteJuridico extends Cliente{
	private String cnpj;
	

	public ClienteJuridico(int conta, String nome, double renda, String endereco,
			String cnpj, double limite, String senha, double saldo) {
		super( conta, nome, renda, endereco, senha,limite,saldo);
		this.cnpj = cnpj;
	}


	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "cliente_juridico [cnpj=" + cnpj + ", getLimite()=" + getLimite()
				+ ", getNome()=" + getNome() + ", getRenda()=" + getRenda()
				+ ", getNumero_conta()=" + getNumero_conta() + "]";
	}


	
	
	
}
