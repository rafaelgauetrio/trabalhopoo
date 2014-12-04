package Negocio;

public class Cliente {
	private int numero_conta;
	private String nome;
	private double renda;
	private String endereco;
	private String senha;
	private double limite; 
	private double saldo;
	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite){
		this.limite = limite;
	}

	public double saque(double s){
		this.saldo-=s;
		return saldo; 
	}
	public double deposito(double d){
		this.saldo+=d;
		return saldo; 
	}
	public void transferencia(Cliente cli,double valor){
		this.saque(valor);
		cli.deposito(valor);
	}
	public double getSaldo(){
		return saldo;
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
	
	public Cliente(int conta, String nome, double renda, String endereco, String senha, double limite, double saldo) {
		this.nome = nome;
		this.renda = renda;
		this.endereco = endereco;
		this.senha = senha;
		this.numero_conta = conta;
		this.limite = limite;
		this.saldo = saldo;
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

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
