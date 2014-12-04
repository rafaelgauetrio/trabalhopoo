package Negocio;

public class Historico {

	private int conta;
	private String operacao;
	private double valor;
	private double saldo;
	public Historico(int conta, String operacao, double valor, double saldo){
		this.conta = conta;
		this.operacao = operacao;
		this.valor = valor;
		this.saldo = saldo;
	}
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
