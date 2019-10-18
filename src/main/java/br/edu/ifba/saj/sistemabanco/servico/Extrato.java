package br.edu.ifba.saj.sistemabanco.servico;

public class Extrato {
	
	private double[] registroOperacao;
	private int indexRegistroOperacao;
	
	public Extrato(int quantidade) {
		registroOperacao = new double[quantidade];
	}
	
	public void registrar(double valor) {
		registroOperacao[indexRegistroOperacao++] = valor;
	}

	public String exibirExtrato(int quantidade) {
		String extrato = "";
		int limite;
		
		if(indexRegistroOperacao<quantidade) {
			limite = indexRegistroOperacao;
		}else {
			limite = quantidade;
		}
		
		for (int i = 0; i < limite; i++) {
			extrato += String.format("*  %8.2f \n",registroOperacao[i]);
		}
		
		return extrato;
	}


}
