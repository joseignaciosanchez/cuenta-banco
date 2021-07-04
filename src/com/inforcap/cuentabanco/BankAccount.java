package com.inforcap.cuentabanco;

public class BankAccount {
	private String numeroCuenta;
	private double saldoCtaCte;
	private double saldoCtaAhorros;
	
	private static int numCtaCreadas = 0;
	private static double cantCashAlmacenado = 0;
	
	public static final Integer CUENTA_CORRIENTE = 0;
	public static final Integer CUENTA_AHORRO = 1;
	
	public BankAccount() {
		crearCuenta();
		numCtaCreadas++;			
	}

	public static Integer getCuentaCorriente() {
		return CUENTA_CORRIENTE;
	}

	public static Integer getCuentaAhorro() {
		return CUENTA_AHORRO;
	}

	private String crearCuenta() {
		String cuenta = "";
		
		for (int i = 0; i < 10; i++) {
			int numero = (int)(Math.random()*9+1);		
			cuenta += String.valueOf(numero);			
		}
		numeroCuenta = cuenta;				
		return numeroCuenta;
	}
	
	public void depositarDinero(int dinero, Integer tipoCuenta) {
		if (tipoCuenta.equals(CUENTA_CORRIENTE)) {
			saldoCtaCte += dinero;			
			System.out.println("Se ha depositado $"+dinero+" en su cuenta corriente");
		}else if (tipoCuenta.equals(CUENTA_AHORRO)){
			saldoCtaAhorros += dinero;
			System.out.println("Se ha depositado $"+dinero+" en su cuenta de ahorros");
		}		
		cantCashAlmacenado += dinero;
	}
	
	public void saldoCuenta(Integer tipoCuenta) {
		if (tipoCuenta.equals(CUENTA_CORRIENTE)) {
			System.out.println("El saldo de su cuenta corriente es: $"+this.saldoCtaCte);
		}else if (tipoCuenta.equals(CUENTA_AHORRO)){
			System.out.println("El saldo de su cuenta de ahorro es: $"+this.saldoCtaAhorros);
		}
	}
	
	public void retirarDinero(Integer tipoCuenta, int dinero) {
		if (tipoCuenta.equals(CUENTA_CORRIENTE) && this.saldoCtaCte > 0 && dinero <= this.saldoCtaCte) {
			System.out.println("Se ha retirado con exito por un monto $"+dinero+" de su cuenta");
			this.saldoCtaCte -= dinero;
			cantCashAlmacenado -= dinero;
			saldoCuenta(CUENTA_CORRIENTE);
		}else if(tipoCuenta.equals(CUENTA_CORRIENTE) && this.saldoCtaCte > 0 && dinero >= this.saldoCtaCte){
			System.out.println("No tiene saldo suficiente para retirar $"+dinero);
			saldoCuenta(CUENTA_CORRIENTE);
		}else if(tipoCuenta.equals(CUENTA_CORRIENTE) && this.saldoCtaCte == 0) {
			System.out.println("No tiene saldo suficiente para retirar $"+dinero);
			saldoCuenta(CUENTA_CORRIENTE);
		}
		if (tipoCuenta.equals(CUENTA_AHORRO) && this.saldoCtaAhorros > 0 && dinero <= this.saldoCtaAhorros) {
			System.out.println("Se ha retirado con exito por un monto $"+dinero+" de su cuenta");
			this.saldoCtaAhorros -= dinero;
			cantCashAlmacenado -= dinero;
			saldoCuenta(CUENTA_AHORRO);
		}else if(tipoCuenta.equals(CUENTA_AHORRO) && this.saldoCtaAhorros > 0 && dinero >= this.saldoCtaAhorros){
			System.out.println("No tiene saldo suficiente para retirar $"+dinero);
			saldoCuenta(CUENTA_AHORRO);
		}else if(tipoCuenta.equals(CUENTA_AHORRO) && this.saldoCtaAhorros == 0) {
			System.out.println("No tiene saldo suficiente para retirar $"+dinero);
			saldoCuenta(CUENTA_AHORRO);
		}		
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getSaldoCtaCte() {
		return saldoCtaCte;
	}

	public void setSaldoCtaCte(double saldoCtaCte) {
		this.saldoCtaCte = saldoCtaCte;
	}

	public double getSaldoCtaAhorros() {
		return saldoCtaAhorros;
	}

	public void setSaldoCtaAhorros(double saldoCtaAhorros) {
		this.saldoCtaAhorros = saldoCtaAhorros;
	}

	public static int getNumCtaCreadas() {
		return numCtaCreadas;
	}

	public static void setNumCtaCreadas(int numCtaCreadas) {
		BankAccount.numCtaCreadas = numCtaCreadas;
	}

	public static double getCantCashAlmacenado() {
		return cantCashAlmacenado;
	}

	public static void setCantCashAlmacenado(double cantCashAlmacenado) {
		BankAccount.cantCashAlmacenado = cantCashAlmacenado;
	}
	
	
}
