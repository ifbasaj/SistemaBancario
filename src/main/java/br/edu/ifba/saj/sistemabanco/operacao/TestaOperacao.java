package br.edu.ifba.saj.sistemabanco.operacao;

public class TestaOperacao {

	public static void main(String[] args) {
		
		Operacao op = new Credito(250);
		
		double saldo = 0;
		
		System.out.println("Credito:" + op.operar());
		saldo+=op.operar();
		
		op = new Debito(150);
		System.out.println("Debito:" + op.operar());
		saldo+=op.operar();
		
		System.out.println("Saldo:" + saldo);
		
		

	}

}
