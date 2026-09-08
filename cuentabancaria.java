public class cuentabancaria {
    public static void main(String[] args) {
        // Declaración e inicialización de variables
        double saldoInicial = 1000.0;
        double retiroSemanal = 200.0;
        int semanasEnMes = 4;
        
        // Operación aritmética para calcular el total retirado
        double totalRetirado = retiroSemanal * semanasEnMes;
        
        // Operación aritmética para calcular el saldo final
        double saldoFinal = saldoInicial - totalRetirado;
        
        // Mostrar los resultados en la consola
        System.out.println("--- Cálculo de Retiros Bancarios ---");
        System.out.println("Saldo inicial: $" + saldoInicial);
        System.out.println("Retiro por semana: $" + retiroSemanal);
        System.out.println("Semanas transcurridas: " + semanasEnMes);
        System.out.println("Total retirado en el mes: $" + totalRetirado);
        System.out.println("Dinero restante al final del mes: $" + saldoFinal);
    }
}