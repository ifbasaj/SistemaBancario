package br.edu.ifba.saj.sistemabanco;
import br.edu.ifba.saj.sistemabanco.conta.Conta;
import br.edu.ifba.saj.sistemabanco.conta.ContaCorrente;
import br.edu.ifba.saj.sistemabanco.conta.ContaPoupanca;
import br.edu.ifba.saj.sistemabanco.operacao.Credito;
import br.edu.ifba.saj.sistemabanco.operacao.Debito;
import br.edu.ifba.saj.sistemabanco.cliente.Cliente;

public class Main {

	public static void main(String[] args) {
		
		Conta minhaConta;
	    minhaConta = new ContaPoupanca();
	    Cliente cliente1 = new Cliente("Leandro", "11111111111");
	    
	    minhaConta.setCliente(cliente1);
	    

	    System.out.println("Depositando 10 na conta de "+minhaConta.getCliente().getNome() +"("+minhaConta.getNumero()+")" );
	    minhaConta.executa(new Credito(10));
	    System.out.println("Depositando 10 na conta de "+minhaConta.getCliente().getNome() +"("+minhaConta.getNumero()+")");
	    minhaConta.executa(new Credito(10));
	    System.out.println("Sacando 100 na conta de "+minhaConta.getCliente().getNome() +"("+minhaConta.getNumero()+")");
	    minhaConta.executa(new Debito(100));
	    
	    ContaCorrente outraConta;
	    outraConta = new ContaCorrente();

	    Cliente cliente2 = new Cliente("Jose", "22222222222");
	    
	    outraConta.setCliente(cliente2);
	    
	    
	    System.out.println("Depositando 1000 na conta de "+outraConta.getCliente().getNome() +"("+outraConta.getNumero()+")");
	    outraConta.executa(new Credito(1000));
	    System.out.println("Sacando 2000 na conta de "+outraConta.getCliente().getNome() +"("+outraConta.getNumero()+")");
	    boolean saqueRealizado = outraConta.executa(new Debito(2000));
	    
	    if(saqueRealizado==false){
	      System.out.println("Não foi possível realizar o saque na conta do cliente " + outraConta.getCliente().getNome() +"("+outraConta.getNumero()+")"); 
	    }
	    
	    System.out.println("<=====================================");
	    System.out.println("O saldo da conta do cliente "+minhaConta.getCliente().getNome()+" é: "+minhaConta.getSaldo() );    
	    System.out.printf("O saldo da conta do cliente %s é: %.1f \n",outraConta.getCliente().getNome(),outraConta.getSaldo());
	    System.out.println("=====================================>");


	    System.out.println("Trasnferindo 2000");
	    if(!(outraConta.transfere(minhaConta, 2000))){
	      System.out.println("Não foi possível realizar transferencia da conta do cliente " + outraConta.getCliente().getNome() +"("+outraConta.getNumero()+")" + " para a conta do cliente "+ minhaConta.getCliente().getNome() +"("+minhaConta.getNumero()+")"); 
	    }
	    
	    System.out.println("<=====================================");
	    System.out.println("O saldo da conta do cliente "+minhaConta.getCliente().getNome()+" é: "+minhaConta.getSaldo() );    
	    System.out.printf("O saldo da conta do cliente %s é: %.1f \n",outraConta.getCliente().getNome(),outraConta.getSaldo());
	    System.out.println("=====================================>");

	    System.out.println("Trasnferindo 1000");
	    if(!(outraConta.transfere(minhaConta, 1000))){
	      System.out.println("Não foi possível realizar transferencia da conta do cliente " + outraConta.getCliente().getNome() + " para a conta do cliente "+ minhaConta.getCliente().getNome()); 
	    }
	    
	    System.out.println("<=====================================");
	    System.out.println("O saldo da conta do cliente "+minhaConta.getCliente().getNome()+" é: "+minhaConta.getSaldo());    
	    System.out.printf("O saldo da conta do cliente %s é: %.1f \n",outraConta.getCliente().getNome(),outraConta.getSaldo());
	    System.out.println("=====================================>");
    
	    System.out.println("=====================================>");
	    System.out.println(minhaConta.exibirExtrato());
	    System.out.println("=====================================>");
	    System.out.println("=====================================>");
	    System.out.println(outraConta.exibirExtrato(15));


	}
  

  /*
	public static void main(String[] args) {
    Cliente cliente = new Cliente("Leandro", "01234567891");

		ContaCorrente c1 = new ContaCorrente();
    c1.setCliente(cliente);
    ContaCorrente c2 = new ContaCorrente(c1.getNumero());
    c2.setCliente(cliente);

    System.out.println("=====================================>");
	  System.out.println(c1==c2);    
    System.out.println("=====================================>");
    System.out.println(c1);
    System.out.println(c2);
	  System.out.println("=============equals==================>");
	  System.out.println(c1.equals(c2));
	}
  */
}
