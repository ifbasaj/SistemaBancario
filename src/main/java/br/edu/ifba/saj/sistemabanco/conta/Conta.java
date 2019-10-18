package br.edu.ifba.saj.sistemabanco.conta;

import  br.edu.ifba.saj.sistemabanco.cliente.Cliente;
import  br.edu.ifba.saj.sistemabanco.servico.Extrato;

public class Conta {
	private static int qtdContas;
	private int numero;
	private Cliente cliente;
	private double saldo;	
	private Extrato extrato;

	public Conta() {
		qtdContas++;
		setNumero(qtdContas);
		extrato = new Extrato(50);
	}

	public Conta(int numero) {
		setNumero(numero);
		extrato = new Extrato(50);
	}

	public int getNumero() {
		return numero;
	}

	private void setNumero(int numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	protected Extrato getExtrato() {
		return extrato;
	}

	public void deposita(double valor) {
		saldo = saldo + valor;
		extrato.registrar(valor);
	}
	
	public boolean saca(double valor) {
		if (valor <= saldo) {
			saldo = saldo - valor;
			extrato.registrar(-valor);
			return true;
		}
		return false;
	}

	public boolean transfere(Conta destino, double valorTransferencia) {
		if (saca(valorTransferencia)) {
			destino.deposita(valorTransferencia);
			return true;
		}
		return false;
	}
	
	public String exibirExtrato(){
		return extrato.exibirExtrato(5);
	}
	
	public String exibirExtrato(int quantidade){
		return extrato.exibirExtrato(quantidade);
	}

  public boolean equals(Object obj){
    Conta outraConta = (Conta)obj;
    return this.getNumero() == outraConta.getNumero();
  }

  public String toString() {
    return "Conta numero: "+getNumero() +"\n Saldo: "+getSaldo()+"\n Cliente: "+getCliente().getNome();
  }
  
}