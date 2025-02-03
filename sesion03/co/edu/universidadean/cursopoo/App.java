package co.edu.universidadean.cursopoo;

public class App {
	public static void main(String[] args) throws Exception {
	
		CuentaBancaria cuenta = new CuentaBancaria();
		cuenta.mostrarDatosCuenta();

		cuenta.numero = "12345";
		cuenta.mostrarDatosCuenta();

		cuenta.abonar(600);
		cuenta.mostrarDatosCuenta();

		CuentaBancaria cuenta2 = new CuentaBancaria();
		cuenta2.transferir(300, cuenta);
		cuenta.mostrarDatosCuenta();
		cuenta2.mostrarDatosCuenta();
		var c = System.console();
		var rta = c.readLine("Te gustó lo que hice? ");
		System.out.println("gracias");
	}
}
