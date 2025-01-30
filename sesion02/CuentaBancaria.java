/**
* Esta clase representa una cuenta bancaria
*/
public class CuentaBancaria {
	// numero de la cuenta
	String numero;
	// saldo actual de la cuenta
	double saldo = 1000;
	// cuenta corriente o ahorros
	String tipo;


	/*
	muestra el numero y saldo de la cuenta
	*/
	void mostrarDatosCuenta() {
		System.out.println("Cuenta No. " + numero + " tiene un saldo de " + saldo);
	}

	/*
	Permite retirar dinero de la cuenta si hay suficiente saldo
	Retorna el saldo de la cuenta después de haber efectuado el retiro
	*/
	double retirar(double cantidad) {
		if ( cantidad < 0 )
			System.out.println("No puedo retirar cantidades negativas. Use el método abonar");
		else if ( cantidad > saldo )
			System.out.println("Saldo insuficiente");
		else
			saldo -= cantidad;
		return saldo;
	}

	/*
	Permite abonar dinero a la cuenta si el cantidad a abonar es correcta|
	Retorna el saldo de la cuenta después de haber efectuado el abono
	*/
	double abonar(double cantidad) {
		if ( cantidad > 0 ) 
			this.saldo += cantidad;
		else
			System.out.println("No puedo abonar cantidades negativas o en cero. Use el método retirar");
		return saldo;
	}


	/** Transfiere dinero de esta cuenta a una cuenta destino.
	 *  Para esto hace un retiro de la actual y luego un abono en la cuenta destino
	 * @param cantidad monto a transferir
	 * @param cuentaDestino cuenta que recibirá el dinero
	 * @return true si la transferencia fue exitosa
	 */
	boolean transferir(double cantidad, CuentaBancaria cuentaDestino ) {
		double saldoActual = saldo;
		double nuevoSaldo = this.retirar(cantidad);
		if ( saldoActual == nuevoSaldo )
			return false;
		cuentaDestino.abonar(cantidad);
		return true;
	}
}
