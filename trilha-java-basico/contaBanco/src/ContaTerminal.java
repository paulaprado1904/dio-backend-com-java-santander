import java.util.Scanner;

public class ContaTerminal {

    private int numero;
    private String agencia;
    private String nomeCliente;
    private double saldo;

    public ContaTerminal(int numero, String agencia, String nomeCliente, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }


    public static void main(String[] args) {
        int numero;
        String agencia;
        String nomeCliente;
        double saldo;

        Scanner scan = new Scanner(System.in);

        System.out.println("Insira os dados para criar uma conta!");
        System.out.println("Digite o número da Conta --> ");
        numero = scan.nextInt();

        System.out.println("Digite o número da Agência --> ");
        agencia = scan.next();

        System.out.println("Digite o Nome do Cliente --> ");
        nomeCliente = scan.next();

        System.out.println("Digite o Saldo --> ");
        saldo = scan.nextDouble();

        scan.close();

        ContaTerminal conta = new ContaTerminal(numero, agencia, nomeCliente, saldo);

        System.out.println("Olá " + conta.getNomeCliente() + ", obrigado por criar uma conta em nosso banco, sua agência é " 
            + conta.getAgencia() + ", conta " + conta.getNumero() + " e seu saldo de " + conta.getSaldo() + " já está disponível para saque.");
    }
}
