package br.edu.ifba.saj.sistemabanco.conta;

public class ContaCorrente extends Conta{

  private double limite = 100;

	public ContaCorrente() {
		super();
	}

  public ContaCorrente(int numero) {
		super(numero);
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

  public boolean saca(double valor) {
		if (valor <= (getSaldo() + limite)) {
			setSaldo(getSaldo() - valor);
			getExtrato().registrar(-valor);
			return true;
		}
		return false;
	}  
}