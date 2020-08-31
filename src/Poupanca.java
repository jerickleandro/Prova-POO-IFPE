
public class Poupanca extends Conta {
	
	private double juros;


	public Poupanca(int numeroConta, Banco banco, Cliente cliente, double saldo, double juros) {
		super(numeroConta, banco, cliente, saldo);
		this.juros = juros;
	}


	public double getJuros() {
		return juros;
	}


	public void setJuros(double juros) {
		this.juros = juros;
	}


	public void renderJuros() {
		
	}

}
