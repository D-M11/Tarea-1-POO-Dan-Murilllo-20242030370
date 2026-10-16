/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuentabancaria;

public class CuentaBancaria {
    
    public String numeroCuenta;
    public String titular;
    
    // Atributos Privados (Encapsulados)
    private double saldo;
    private int totalTransacciones;
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
            if (saldoInicial < 0) {this.saldo = 0.0;
        } else {this.saldo = saldoInicial;
        }
        this.totalTransacciones = 0;
    }
    public double getSaldo() {
        return this.saldo;
    }
    public int getTotalTransacciones() {
        return this.totalTransacciones;
    }
    
   
    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            this.totalTransacciones++;
            System.out.println("Deposito exitoso.");
        } else {
            System.out.println("Error: El monto a depositar debe ser mayor a 0.");
        }
    }
    public boolean retirar(double monto) {
        if (monto > 0 && this.saldo >= monto) {
            this.saldo -= monto;
            this.totalTransacciones++;
            System.out.println("Retiro exitoso.");
            return true;
        } else {
            System.out.println("Error: Saldo insuficiente o monto de retiro inbalido.");
            return false;
        }
    }
    
  
    public void mostrarDatos() {
        System.out.println("===DATOS DE LA CUENTA===");
        System.out.println("Titular: " + this.titular);
        System.out.println("Nmro de Cuenta: " + this.numeroCuenta);
        System.out.printf("Saldo Actual: %.2f%n", this.saldo);
        System.out.println("Total de Transacciones: " + this.totalTransacciones);
    }
}