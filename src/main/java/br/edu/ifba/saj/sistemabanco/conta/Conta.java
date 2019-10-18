package br.edu.ifba.saj.sistemabanco.conta;

import  br.edu.ifba.saj.sistemabanco.cliente.Cliente;
import br.edu.ifba.saj.sistemabanco.operacao.Credito;
import br.edu.ifba.saj.sistemabanco.operacao.Debito;
import br.edu.ifba.saj.sistemabanco.operacao.Operacao;
import  br.edu.ifba.saj.sistemabanco.servico.Extrato;

public abstract class Conta {
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
	
	
	public boolean executa(Operacao operacao) {
		if(operacao.valida(this)) {
			double valorOperacao = operacao.operar();
			this.saldo+=valorOperacao;
			extrato.registrar(valorOperacao);
			return true;
		}
		return false;
	}

	public boolean transfere(Conta destino, double valorTransferencia) {
		Debito debito = new Debito(valorTransferencia);
		Credito credito = new Credito(valorTransferencia);
		if(this.executa(debito)) {
			destino.executa(credito);			
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

  public abstract double getSaldoTotal(); 
  
}