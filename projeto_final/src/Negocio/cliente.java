package Negocio;

public class cliente {
	private int numero_conta;
	private conta conta_banco=new conta();
	private String nome;
	private double renda;
	private String endereco;
	private String senha;
	public double saque(double s){
		this.conta_banco.saque(s);
		return conta_banco.getSaldo(); 
	}
	public double deposito(double d){
		conta_banco.deposito(d);
		return conta_banco.getSaldo(); 
	}
	public void transferencia(cliente cli,double valor){
		if(valor>conta_banco.getSaldo()){
			valor=conta_banco.getSaldo();
		}
		conta_banco.saque(valor);
		cli.deposito(valor);
	}
	public double getSaldo(){
		return conta_banco.getSaldo();
	}
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
	
	public cliente(int id,String nome, double renda, String endereco, String senha) {
		this.nome = nome;
		this.renda = renda;
		this.endereco = endereco;
		this.senha = senha;
	}
	
	public String toString() {
		return "cliente [numero_conta=" + numero_conta + ", nome=" + nome
				+ ", renda=" + renda + ", endereco=" + endereco + ", senha="+senha+"]";
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
