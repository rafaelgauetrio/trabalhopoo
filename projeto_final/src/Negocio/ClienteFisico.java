package Negocio;

public class ClienteFisico extends Cliente{
	private String cpf;
	
	public ClienteFisico(int conta, String nome, double renda, String endereco,
			String cpf, double limite, String senha, double saldo) {
		super( conta, nome, renda, endereco, senha,limite,saldo);
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "cliente_fisico [cpf=" + cpf + ", getLimite()=" + getLimite()
				+ ", getNome()=" + getNome() + ", getRenda()=" + getRenda()
				+ ", getEndereco()=" + getEndereco() + ", getNumero_conta()="
				+ getNumero_conta() + "]";
	}
	
	
	
	
}
