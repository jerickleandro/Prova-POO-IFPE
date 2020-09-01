import java.util.ArrayList;
import java.util.Scanner;

public class Teste {

	static int numeroConta = 0;
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ArrayList<Conta> contas = new ArrayList<Conta>();
		
		boolean flag = true;
		int op, op2;
		do {
		System.out.println("********************************************");	
		System.out.println("***Escolha uma das op��es abaixo:          *");
		System.out.println("***1 - Cadastrar conta                     *");
		System.out.println("***2 - Realizar deposito                   *");
		System.out.println("***3 - Render juros                        *");
		System.out.println("***4 - Consultar n�mero e nome da agencia  *");
		System.out.println("***5 - Alterar o n�mero e nome da agencia  *");
		System.out.println("***0 - Sair                                *");
		System.out.println("********************************************");
		op = scan.nextInt();
		scan.nextLine();
		switch (op) {
		case 1:
			if(contas.size()<10) {
				double saldo = 0.0;
				numeroConta++;
				System.out.println("Digite o nome do cliente:");
				String nome = scan.nextLine();
				System.out.println("Digite o CPF (Somente n�meros):");
				String CPF = scan.nextLine();
				Cliente cliente = new Cliente(nome,CPF);
				System.out.println("Digite o n�mero da ag�ncia:");
				int numeroAgencia = scan.nextInt();
				scan.nextLine();
				System.out.println("Digite o nome da ag�ncia:");
				String nomeAgencia = scan.nextLine();
				Banco banco = new Banco(numeroAgencia, nomeAgencia);
				System.out.println("Deseja depositar um valor inicial? \n1-Sim\n2-N�o");
				op2 = scan.nextInt();
				scan.nextLine();
				if(op2 == 1) {
					System.out.println("Digite o quanto deseja depositar:");
					saldo = scan.nextDouble();
				}
				System.out.println("Deseja transfomar essa conta em uma conta poupan�a? \n1-Sim\n2-N�o");
				op2 = scan.nextInt();
				scan.nextLine();
				if(op2 == 1) {
					System.out.println("Digite a porcentagem que a conta ir� render de juros:");
					double juros = scan.nextDouble();
					
					Conta poupanca = new Poupanca(numeroConta, banco, cliente, saldo, juros);
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
			if(contas.size() > 0) {
				System.out.println("Digite o numero do CPF (somente n�meros):");
				String CPF = scan.nextLine();
				Conta c = buscarConta(CPF, contas);
				if(c != null) {
					System.out.println("Nome: " + c.getCliente().getNome());
					System.out.println("Conta: " + c.getNumeroConta());
					System.out.println("Quanto deseja depositar?");
					double valor = scan.nextDouble();
					c.setSaldo((c.getSaldo()+valor));
					System.out.println("Novo saldo: "+ c.getSaldo());
					
				}else {
					System.out.println("N�o existe conta cadastrada para esse CPF!");
				}
			}else {
				System.out.println("Nenhuma conta criada at� o momento!");
			}
			
			break;
		case 3:
			if(contas.size() > 0) {
				System.out.println("Digite o numero do CPF (somente n�meros):");
				String CPF = scan.nextLine();
				Conta c = buscarConta(CPF, contas);
				if(c != null && (c instanceof Poupanca)) {
					System.out.println("Nome: " + c.getCliente().getNome());
					System.out.println("Conta: " + c.getNumeroConta());
					((Poupanca) c).renderJuros();
					System.out.println("Novo saldo: "+ c.getSaldo());
					
				}else {
					System.out.println("N�o existe conta cadastrada para esse CPF ou n�o � uma poupan�a!");
				}
			}else {
				System.out.println("Nenhuma conta criada at� o momento!");
			}
	
			break;
		case 4:
			if(contas.size() > 0) {
				for(Conta c : contas) {
					System.out.println("Numero da ag�ncia: " + c.getBanco().getNumeroAgencia());
					System.out.println("Ag�ncia: " + c.getBanco().getNomeAgencia());
					System.out.println("CPF do cliente: " + c.getCliente().getCPF());
					System.out.println("Nome do cliente: " + c.getCliente().getNome());
				}
			}else {
				System.out.println("Nenhuma conta criada at� o momento!");
			}
	
			break;
		case 5:
			if(contas.size() > 0) {
				System.out.println("Digite o numero do CPF (somente n�meros):");
				String CPF = scan.nextLine();
				Conta c = buscarConta(CPF, contas);
				if(c != null) {
					System.out.println("Nome: " + c.getCliente().getNome());
					System.out.println("Numero: " + c.getBanco().getNumeroAgencia());
					System.out.println("Nome da ag�ncia: " + c.getBanco().getNomeAgencia());
					System.out.println("Digite o novo numero da conta");
					int numConta = scan.nextInt();
					System.out.println("Digite o novo nome da conta");
					String nomeConta = scan.nextLine();
					c.getBanco().setNumeroAgencia(numConta);
					c.getBanco().setNomeAgencia(nomeConta);

					System.out.println("Novo Numero: " + c.getBanco().getNumeroAgencia());
					System.out.println("Novo nome da ag�ncia: " + c.getBanco().getNomeAgencia());
					
				}else {
					System.out.println("N�o existe conta cadastrada para esse CPF!");
				}
			}else {
				System.out.println("Nenhuma conta criada at� o momento!");
			}
			break;
		case 0:
			flag = false;
			break;

		default:
			System.out.println("Essa op��o n�o � valida");
			flag = false;
			break;
		}
		
		}while(flag);
		
	}
	
	public static Conta buscarConta(String CPF, ArrayList<Conta> contas) {
			for(Conta c : contas) {
				if(c.getCliente().getCPF().equals(CPF)) {
				return c;
				}
			}
		return null;
	}

}
