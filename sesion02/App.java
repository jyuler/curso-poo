public class App {
	public static void main(String[] args) throws Exception {
	
		CuentaBancaria cuenta = new CuentaBancaria();
		System.out.println("Cuenta No. " + cuenta.numero + " tiene un saldo de " + cuenta.saldo);

		cuenta.numero = "12345";
		System.out.println("Cuenta No. " + cuenta.numero + " tiene un saldo de " + cuenta.saldo);

	}
}
