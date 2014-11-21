import java.util.*;
public class Testa_Banco {
	public static void main(String[] args) {
		Scanner e= new Scanner(System.in);
		Vector<Banco> cliente=new Vector<Banco>();
		Vector<Extrato> extrato=new Vector<Extrato>();
		String nome="";
		int nro_conta=0;
		int CPF=0;
		String endereco="";
		double renda=0.0;
		double valor=0.0;
		String tipocliente;
		double maior_saldo=0.0;
		double menor_saldo=0.0;
		int pesquisa=0;
		int nroclientes_f�sicos=0;
		int nroclientes_jur�dicos=0;
		String operacao="";
		System.out.println("Entre com a quantidade de clientes:");
		int quantidade=e.nextInt();
		
		for(int i=0;i<quantidade;i++){
			System.out.println("voc� � cliente jur�dico ou f�sico?");    	 
			System.out.println("escreva:");
			e.nextLine();
			tipocliente=e.nextLine();

			if(tipocliente.equals("fisico")){
				System.out.println("Entre com o nome:");
				nome=e.nextLine();
				System.out.println("n� da conta:");
				nro_conta=e.nextInt();
				System.out.println("CPF:");
				CPF=e.nextInt();
				System.out.println("endere�o:");
				e.nextLine();
				endereco=e.nextLine();
				System.out.println("renda:");
				renda=e.nextDouble();
				nroclientes_f�sicos++;
				cliente.add(new Banco(nome,nro_conta,CPF,endereco,renda));
			}

			if(tipocliente.equals("juridico")){
				System.out.println("Entre com o nome:");
				nome=e.nextLine();
				System.out.println("n� da conta:");
				nro_conta=e.nextInt();
				System.out.println("CPF:");
				CPF=e.nextInt();
				System.out.println("endere�o:");
				e.nextLine();
				endereco=e.nextLine();
				System.out.println("receita:");
				renda=e.nextDouble();
				nroclientes_jur�dicos++;
				cliente.add(new Banco(nome,nro_conta,CPF,endereco,renda));
			}	
		}
		System.out.println("escolha a op��o sobre o que voc� quer fazer agora:");
		System.out.println("Dep�sito");
		System.out.println("Saque");
		System.out.println("Tranfer�ncia");
		System.out.println("Saldo");
		System.out.println("Extrato");
		System.out.println("escreva:");
		e.nextLine();
		operacao=e.nextLine();

		if(operacao.equals("deposito")){
			System.out.println("n� da conta:");
			nro_conta=e.nextInt();
			System.out.println("valor do dep�sito");
			valor=e.nextDouble();
			extrato.add(new Extrato(nro_conta,"c",valor));
			Banco comparacao = new Banco(nro_conta); 
			int index=cliente.indexOf(comparacao);
			cliente.elementAt(index).deposito(nro_conta, valor); 
			System.out.println(cliente.elementAt(index).saldo(nome,nro_conta));
		}
		/*System.out.println("escolha a op��o sobre o que voc� quer fazer agora:");
		System.out.println("Dep�sito");
		System.out.println("Saque");
		System.out.println("Tranfer�ncia");
		System.out.println("Saldo");
		System.out.println("Extrato");
		System.out.println("escreva:");
		e.nextLine();
        operacao =e.nextLine();*/

		if(operacao.equals("saque")){
			System.out.println("n� da conta:");
			nro_conta=e.nextInt();
			System.out.println("valor do saque");
			valor=e.nextDouble();
			extrato.add(new Extrato(nro_conta,"d",valor));
			Banco comparacao = new Banco(nro_conta); 
			int index=cliente.indexOf(comparacao);
			//cliente.elementAt(index).sacar_fisico(nro_conta, valor);
			System.out.println(cliente.elementAt(index).sacar_fisico(nro_conta, valor));
			//System.out.println(cliente.elementAt(index).saldo(nome,nro_conta));
		}
		/*System.out.println("escolha a op��o sobre o que voc� quer fazer agora:");
		System.out.println("Dep�sito");
		System.out.println("Saque");
		System.out.println("Tranfer�ncia");
		System.out.println("Saldo");
		System.out.println("Extrato");
		System.out.println("escreva:");
		e.nextLine();
        operacao =e.nextLine();
*/
		if(operacao.equals("transferencia")){
			System.out.println("n� da conta1:");
			nro_conta=e.nextInt();
			System.out.println("n� da conta2:");
			int nro_conta2=e.nextInt();
			System.out.println("valor da tranfer�ncia");
			valor=e.nextDouble();
			Banco comparacao = new Banco(nro_conta); 
			int index=cliente.indexOf(comparacao);
			cliente.get(index).sacar_fisico(nro_conta, valor);
			extrato.add(new Extrato(nro_conta,"d",valor));
			Banco comparacao2 = new Banco(nro_conta2); 
			int index2=cliente.indexOf(comparacao);
			cliente.get(index2).deposito(nro_conta2, valor);
			extrato.add(new Extrato(nro_conta2,"c",valor));
		}
		/*System.out.println("escolha a op��o sobre o que voc� quer fazer agora:");
		System.out.println("Dep�sito");
		System.out.println("Saque");
		System.out.println("Tranfer�ncia");
		System.out.println("Saldo");
		System.out.println("Extrato");
		System.out.println("Pesquisa");
		System.out.println("Sair");
		System.out.println("escreva:");
		e.nextLine();
        operacao =e.nextLine();*/
		if(operacao.equals("saldo")){
			System.out.println("n� da conta:");
			nro_conta=e.nextInt();
			System.out.println("nome:");
			nome=e.nextLine();
			Banco comparacao = new Banco(nro_conta); 
			int index=cliente.indexOf(comparacao);
			cliente.elementAt(index).saldo(nome,nro_conta);
		}

		if(operacao.equals("pesquisa")){
			System.out.println("1-quantos clientes f�sicos e jur�dicos existem?");
				System.out.println("2-qual � o clientes que tem o maior saldo?");
				System.out.println("3-qual � o clientes que tem o maior d�vida?");
				pesquisa=e.nextInt();
				if(pesquisa==1){
				System.out.println("nro de clientes fisicos:"+nroclientes_f�sicos);
				System.out.println("nro de clientes jur�dicos:"+nroclientes_jur�dicos);
				}
				if(pesquisa==2){
					int indice=0;
					System.out.println("n� da conta:");
					nro_conta=e.nextInt();
					System.out.println("nome:");
					nome=e.nextLine();
					maior_saldo=cliente.elementAt(0).saldo(nome,nro_conta);
					for(int i=0;i<quantidade;i++){
						if(maior_saldo<cliente.elementAt(i).saldo(nome,nro_conta)){
							maior_saldo=cliente.elementAt(i).saldo(nome,nro_conta);
							indice=i;
						}
					}
					System.out.println(" nome:"+cliente.elementAt(indice).getNome());
					System.out.println("nro conta:"+cliente.elementAt(indice).getnumConta());
					System.out.println("CPF:"+cliente.elementAt(indice).getCPF());
					System.out.println("endere�o:"+cliente.elementAt(indice).getEndereco());
				}
			}
		if(pesquisa==3){
			int indice=0;
			System.out.println("n� da conta:");
			nro_conta=e.nextInt();
			System.out.println("nome:");
			nome=e.nextLine();
			menor_saldo=cliente.elementAt(0).saldo(nome,nro_conta);
			for(int i=0;i<quantidade;i++){
				if(maior_saldo>cliente.elementAt(i).saldo(nome,nro_conta)){
					maior_saldo=cliente.elementAt(i).saldo(nome,nro_conta);
					indice=i;
				}
			}
			System.out.println(" nome:"+cliente.elementAt(indice).getNome());
			System.out.println("nro conta:"+cliente.elementAt(indice).getnumConta());
			System.out.println("CPF:"+cliente.elementAt(indice).getCPF());
			System.out.println("endere�o:"+cliente.elementAt(indice).getEndereco());
		}
	
			

			if(operacao.equals("sair")){
				System.out.println("saindo!"); 
		}   

	}
}