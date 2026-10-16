/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuentabancaria;


public class Main {
    public static void main(String[] args) {

   
        
        System.out.println("=====================prueba 1======================");
        CuentaBancaria miCuenta = new CuentaBancaria("bac.01", "dan murilo", 5000.0);
        
      
        System.out.println(" No se puede modificar 'saldo' directamente.");
//esto genra un error porque el saldo es una caracteristica que no se tiene acceso al ser privada


        System.out.println("prueba ===========================2================================");
        System.out.println("Titular (acceso directo): " + miCuenta.titular);
        System.out.println("Numero de Cuenta (acceso directo): " + miCuenta.numeroCuenta);
        
        System.out.println("======================prueba 3=====================");
        CuentaAhorro cuentaAhorro = new CuentaAhorro("bac.67", "juan almera", 3000.0, 5.0);
        
       //retiro
        cuentaAhorro.retirarConComision(200.0);
        cuentaAhorro.retirarConComision(200.0);
        cuentaAhorro.retirarConComision(200.0);
        // Retiro de comicion
        System.out.println("cuarto retiro esta sujeto a comicion");
        cuentaAhorro.retirarConComision(200.0);

        
        System.out.println("================prueba 4======================");
        // Invocar aplicarInteresMensual() y verificar cómo incrementa el saldo mediante getSaldo()
        System.out.printf("Saldo antes del interes: L. %.2f%n", cuentaAhorro.getSaldo());
        cuentaAhorro.aplicarInteresMensual();
        System.out.printf("Saldo despues de aplicar interes mensual: L. %.2f%n", cuentaAhorro.getSaldo());

        
        System.out.println("==================prueba 5===================");

        CuentaCorriente cuentaCorriente = new CuentaCorriente("bac.8", "daniel rodrigo", 1000.0, "Mateo", 5000.0);
        
        System.out.printf("Saldo inicial: L. %.2f | Limite de Sobregiro: L. %.2f%n", cuentaCorriente.getSaldo(), cuentaCorriente.getLimiteSobregiro());
        System.out.println("-> Intentando retirar L. 3,500 (usará L. 1,000 de saldo y L. 2,500 de sobregiro + 3% de recargo):");
        
        cuentaCorriente.retirarConSobregiro(3500.0);
        System.out.printf("Saldo actual en cuenta: L. %.2f%n", cuentaCorriente.getSaldo());
        System.out.printf("Sobregiro utilizado actual: L. %.2f%n", cuentaCorriente.getSobregiroUtilizado());

        
        System.out.println("=================prueba 6==================");
        System.out.println("-> Abonando L. 1,500 para pagar parte del sobregiro:");
        cuentaCorriente.pagarSobregiro(1500.0);
        
        System.out.println("\n--- Estado Final de la Cuenta Corriente ---");
        cuentaCorriente.mostrarDatos();
        System.out.printf("Sobregiro utilizado pendiente: L. %.2f%n", cuentaCorriente.getSobregiroUtilizado());
    }
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
     
        
        
        /*
                System.out.println("intentoi");
        CuentaAhorro cuentaDan = new CuentaAhorro("n-1", "DAN MURILLO", 1000.0, 5.0);
        cuentaDan.depositar(500.0);
        cuentaDan.retirar(200.0);
        cuentaDan.mostrarDatos();
  }
}*/