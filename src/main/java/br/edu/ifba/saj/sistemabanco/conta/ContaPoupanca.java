package br.edu.ifba.saj.sistemabanco.conta;

public class ContaPoupanca extends Conta {
	private int diaRendimento;

	@Override
	public double getSaldoTotal() {
		return getSaldo();
	}

}
