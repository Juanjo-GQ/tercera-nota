import java.util.Scanner;
public class parqueaderos{
    private static final double COND1=2000;
    private static final double COND2=50000;
    private static final double COND3=20000;
    public static void main (String [] args)throws Exception{
        Scanner leer = new Scanner(System.in);
        int acum1=0;
        int acum2=0;
        double total=0;
        System.out.println("Ingrese el total de vehículos");
        int n =leer.nextInt();

        double[] pagos=new double[n];
        int i=0;
        while (i<n){
            System.out.println("ingrese lo pagado por el vehículo N."+(i+1));
            pagos[i]=leer.nextDouble();
            if (pagos[i]<=COND2 && pagos[i]>=COND1){
                total=total+pagos[i];
                if (pagos[i]<=COND3){
                    acum1++;

                }else{
                    acum2++;
                }
                i++;
            }else{
                System.out.println("Pago no válido");
            }
        }
        System.out.println("El total de vehículos que pagaron entr 2.000 y 20.000 es de: "+ acum1);
        System.out.println("El total de vehículos que pagaron más de 20.000 es de:"+acum2);
        System.out.println("El total de dinero recaudado es de: "+ total);
    }
}