public class cuentabancaria {
    public static void main(String[] args) {
        double saldoInicial = 1000.0;
        double retiroSemanal = 200.0;
        int semanasEnMes = 4;
                double totalRetirado = retiroSemanal * semanasEnMes;
                double saldoFinal = saldoInicial - totalRetirado;
        System.out.println(" Cálculo de Retiros Bancarios ");
        System.out.println("Saldo inicial: " + saldoInicial);
        System.out.println("Retiro por semana: " + retiroSemanal);
        System.out.println("Semanas transcurridas: " + semanasEnMes);
        System.out.println("Total retirado en el mes: " + totalRetirado);
        System.out.println("Dinero restante al final del mes: " + saldoFinal);
    }
}