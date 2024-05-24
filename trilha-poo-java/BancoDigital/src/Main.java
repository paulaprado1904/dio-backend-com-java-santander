import java.util.ArrayList;
import java.util.List;
public class Main {

	public static void main(String[] args) {
		//cliente 1
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);

		//cliente 2

		Cliente paula = new Cliente();
		paula.setNome("Paula");
		
		Conta cc_paula = new ContaCorrente(paula);
		Conta poupanca_paula = new ContaPoupanca(paula);

		//cliente 2

		Cliente jorge = new Cliente();
		jorge.setNome("Jorge");
		
		Conta cc_jorge = new ContaCorrente(jorge);
		Conta poupanca_jorge = new ContaPoupanca(jorge);
		
		List<Conta> contas = new ArrayList<>();
		contas.add(cc);
		contas.add(poupanca);
		contas.add(cc_paula);
		contas.add(poupanca_paula);
		contas.add(cc_jorge);
		contas.add(poupanca_jorge);

		String nome_banco = "C6 Bank";

		Banco c6_bank = new Banco(nome_banco, contas);

		cc.depositar(100);
		cc.transferir(100, poupanca);

		cc_paula.depositar(10000);
		cc_paula.transferir(6000, poupanca_paula);

		cc_jorge.depositar(8000);
		cc_jorge.transferir(4500, poupanca_jorge);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

		c6_bank.listarValorGuardadoBanco();
	}

}
