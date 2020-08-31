import java.util.ArrayList;
import java.util.Scanner;

public class Teste {

	static int numeroConta = 0;
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ArrayList<Conta> contas = new ArrayList<Conta>();
		
		boolean flag = true;
		int op, op2;
		do {
		System.out.println("********************************************");	
		System.out.println("***Escolha uma das opções abaixo:***********");
		System.out.println("***1 - Cadastrar conta**********************");
		System.out.println("***2 - Realizar deposito********************");
		System.out.println("***3 - Render juros*************************");
		System.out.println("***4 - Consultar número e nome da agencia***");
		System.out.println("***5 - Alterar o número e nome da agencia***");
		System.out.println("***0 - Sair*********************************");
		System.out.println("********************************************");
		op = scan.nextInt();
		scan.nextLine();
		switch (op) {
		case 1:
			if(clientes.size()<10) {
				double saldo = 0.0;
				numeroConta++;
				System.out.println("Digite o nome do cliente:");
				String nome = scan.nextLine();
				System.out.println("Digite o CPF (Somente números):");
				String CPF = scan.nextLine();
				Cliente cliente = new Cliente(nome,CPF);
				System.out.println("Digite o número da agência:");
				int numeroAgencia = scan.nextInt();
				scan.nextLine();
				System.out.println("Digite o nome da agência:");
				String nomeAgencia = scan.nextLine();
				Banco banco = new Banco(numeroAgencia, nomeAgencia);
				System.out.println("Deseja depositar um valor inicial? \n1-Sim\n2-Não");
				op2 = scan.nextInt();
				scan.nextLine();
				if(op2 == 1) {
					System.out.println("Digite o quanto deseja depositar:");
					saldo = scan.nextDouble();
				}
				System.out.println("Deseja transfomar essa conta em uma conta poupança? \n1-Sim\n2-Não");
				op2 = scan.nextInt();
				scan.nextLine();
				if(op2 == 1) {
					System.out.println("Digite a porcentagem que a conta irá render de juros:");
					double juros = scan.nextDouble();
					
					Poupanca poupanca = new Poupanca(numeroConta, banco, cliente, saldo, juros);
					contas.add(poupanca);
					System.out.println("Conta criada com sucesso");
				}else {
					Conta conta = new Conta(numeroAgencia, banco, cliente, saldo);
					contas.add(conta);
					System.out.println("Conta criada com sucesso");
				}
				
			}else {
				System.out.println("Limite de clientes atendidos excedido (10)");
			}
			break;
		case 2:
			
			break;
		case 3:
	
			break;
		case 4:
	
			break;
		case 5:
	
			break;
		case 0:
	
			break;

		default:
			
			break;
		}
		
		}while(flag);
		
	}

}
