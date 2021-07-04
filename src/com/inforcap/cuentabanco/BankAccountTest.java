package com.inforcap.cuentabanco;

public class BankAccountTest {

	public static void main(String[] args) {
		
		BankAccount cliente = new BankAccount();
		//BankAccount cliente2 = new BankAccount();	
		cliente.depositarDinero(1000,BankAccount.CUENTA_CORRIENTE);
		cliente.depositarDinero(1000,BankAccount.CUENTA_CORRIENTE);
		cliente.depositarDinero(1500,BankAccount.CUENTA_AHORRO);
		cliente.depositarDinero(1500,BankAccount.CUENTA_AHORRO);
		cliente.depositarDinero(1500,BankAccount.CUENTA_AHORRO);
		
		cliente.saldoCuenta(BankAccount.CUENTA_AHORRO);
		cliente.saldoCuenta(BankAccount.CUENTA_CORRIENTE);
		
		cliente.retirarDinero(BankAccount.CUENTA_CORRIENTE,15000);
		cliente.retirarDinero(BankAccount.CUENTA_AHORRO,15000);
		
		System.out.println("La cantidad de dinero almacenado en el banco es de $"+BankAccount.getCantCashAlmacenado());
		System.out.println("Hasta el momento se han creado "+BankAccount.getNumCtaCreadas()+" cuentas");
	}
}
