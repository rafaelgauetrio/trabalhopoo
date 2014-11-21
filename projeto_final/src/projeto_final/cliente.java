package projeto_final;

public class cliente {
	private int numero_conta;
	private String nome;
	private double renda;
	private String endereco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getRenda() {
		return renda;
	}
	public void setRenda(double renda) {
		this.renda = renda;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getNumero_conta() {
		return numero_conta;
	}
	public void setNumero_conta(int numero_conta) {
		this.numero_conta = numero_conta;
	}
	
	public cliente(int id,String nome, double renda, String endereco) {
		this.nome = nome;
		this.renda = renda;
		this.endereco = endereco;
	}
	
	public String toString() {
		return "cliente [numero_conta=" + numero_conta + ", nome=" + nome
				+ ", renda=" + renda + ", endereco=" + endereco + "]";
	}
	
}
