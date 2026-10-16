/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuentabancaria;

public class CuentaCorriente extends CuentaBancaria {
    
    public String nombreEmpresa;
    
    private double limiteSobregiro;
    private double sobregiroUtilizado;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial, String nombreEmpresa, double limiteSobregiro) {
        super(numeroCuenta, titular, saldoInicial);
        this.nombreEmpresa = nombreEmpresa;
        this.limiteSobregiro = limiteSobregiro;
        this.sobregiroUtilizado = 0.0;
    }

    public double getLimiteSobregiro() {
        return this.limiteSobregiro;
    }

    public double getSobregiroUtilizado() {
        return this.sobregiroUtilizado;
    }

    public void retirarConSobregiro(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto de retiro debe ser mayor a 0.");
            return;
        }

        double sobregiroDisponible = this.limiteSobregiro - this.sobregiroUtilizado;
        double totalDisponible = getSaldo() + sobregiroDisponible;

        if (getSaldo() >= monto) {
            super.retirar(monto);
        } else if (monto <= totalDisponible) {
            double saldoActual = getSaldo();
            double creditoUsado = monto - saldoActual;
            
            super.retirar(saldoActual);

            double recargo = creditoUsado * 0.03;
            double totalDeudaNueva = creditoUsado + recargo;
            this.sobregiroUtilizado += totalDeudaNueva;

            System.out.printf("Retiro con sobregiro exitoso. Se uso credito por %.2f con un recargo del 3%% (%.2f). Sobregiro total acumulado: %.2f%n", 
                    creditoUsado, recargo, this.sobregiroUtilizado);
        } else {
            System.out.println("Error: Operacion rechazada. El monto excede el saldo y el cupo de sobregiro autorizado.");
        }
    }

    public void pagarSobregiro(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto de abono debe ser mayor a 0.");
            return;
        }
if (this.sobregiroUtilizado > 0) {
            if (monto >= this.sobregiroUtilizado) {double sobrante = monto - this.sobregiroUtilizado;
                this.sobregiroUtilizado = 0.0;
                System.out.println("Se ha pagado la totalidad de la deuda por sobregiro.");
                
                if (sobrante > 0) {super.depositar(sobrante);
                    System.out.printf("El excedente de %.2f ha sido abonado al saldo de la cuenta.%n", sobrante);
                }
            } else {
                this.sobregiroUtilizado -= monto;
                System.out.printf("Abono de %.2f aplicado al sobregiro. Sobregiro pendiente: %.2f%n", monto, this.sobregiroUtilizado);
            }
        } else {
            super.depositar(monto);
            System.out.println("No hay deuda de sobregiro pendiente. El monto fue depositado al saldo de la cuenta.");
        }
    }
}