/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuentabancaria;

public class CuentaAhorro extends CuentaBancaria {
    
  
    public double tasaInteresAnual;
    
  
    private int retirosRealizadosMes;
    private double comisionPorExceso = 20.0;

  
    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, double tasaInteresAnual) {
        super(numeroCuenta, titular, saldoInicial);
        this.tasaInteresAnual = tasaInteresAnual;
        this.retirosRealizadosMes = 0;
    }

  
    public void retirarConComision(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto debe ser mayor a 0.");
            return;
        }

        if (this.retirosRealizadosMes >= 3) {
            double montoTotal = monto + this.comisionPorExceso;
            System.out.printf("Ha superado los 3 retiros mensuales. Se aplicra una comision de %.2f%n", this.comisionPorExceso);
            
            if (super.retirar(montoTotal)) {
                this.retirosRealizadosMes++;
                System.out.println("Retiro con comision realizado con exito.");
            }
        } else {
            if (super.retirar(monto)) {
                this.retirosRealizadosMes++; }
        } }
    public void aplicarInteresMensual() {
        double interes = (getSaldo() *(this.tasaInteresAnual / 100)) / 12;
        if (interes > 0) { super.depositar(interes);
            System.out.printf("Interes mensual aplicado a la cuenta de ahorros: %.2f%n", interes);
        } else {
            System.out.println("No hay sado suficiente para aplicar intereses.");
        }
    }

    public int getRetirosRealizadosMes() {
        return this.retirosRealizadosMes;
    }
}