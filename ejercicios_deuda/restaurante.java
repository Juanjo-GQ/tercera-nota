import java.util.Scanner;
public class restaurante{
    private static final double COND1=20000;
    private static final double COND2=200000;
    private static final double COND3=100000;
    public static void main (String [] args) throws Exception{
        Scanner leer=new Scanner (System.in);
        int acum1=0;
        int acum2=0;
        int i=0;
        double total=0;
        System.out.println("ingrese la cantidad de clientes atendido en la jornada");
        int n=leer.nextInt();
        double[] gastos=new double[n];
        while (i<n){
            System.out.println("Ingrese los gastos del cliente N."+(i+1));
            gastos[i]=leer.nextDouble();
            if (gastos[i]>=COND1 && gastos[i]<=COND2){
                total=total + gastos[i];
                if (gastos[i]<=COND3){
                    acum1++;
                }else{
                    acum2++;
                }
                i++;
            }else{
                System.out.println("valor no válido");
            }
        }
        System.out.println("La cantidad de clientes que gastaron entre 20.000 y 100.000 es de: " + acum1 );
        System.out.println("La cantidad de clientes que gastaron ,ás de 100.000 es de: " + acum2);
        System.out.println("El total de dinero recibido es de: " + total);
        leer.close();
        
    }
}