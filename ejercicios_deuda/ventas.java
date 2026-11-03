import java.util.Scanner;
public class ventas {
    private static final double COND1=50;
    private static final double COND2=1000;
    private static final double COND3=500;
    public static void main ( String [] args) throws Exception{
        Scanner leer = new Scanner(System.in);
        int n;
        int acum1=0;
        int acum2=0;
        double acum3=0;
        int i=0;

        System.out.println("Ingrese la cantidad de vendedores del día");
        n=leer.nextInt();
        double[] ventas=new double[n];

        while(i<n){
            System.out.println("ingrese la venta del vendedor N." + (i+1));
            ventas[i]=leer.nextDouble();
            if( ventas[i]>=COND1 && ventas[i]<=COND2){
                acum3=acum3+ventas[i];
                if (ventas[i]<=COND3 && ventas[i]>=COND1){
                    acum1++;
                }else{
                    acum2++;
                }
                i++;
            }else{
                System.out.println("valor no adecuado");
            }

        }
        System.out.println("la cantidad de ventas entre 50 y 500 es de: "+ acum1);
        System.out.println("la cantidad de ventas superiores a 500 es de: "+ acum2);
        System.out.println("El acumulado entre todas las ventas es un total de: "+ acum3);
        leer.close();

    }
}