import java.util.Scanner;
public class vehiculos{
    private static final double COND1= 10;
    private static final double COND2=500;
    private static final double COND3=300;
    public static void main (String [] args) throws Exception{
        Scanner leer=new Scanner(System.in);
        int acum1=0;
        int acum2=0;
        double total=0;
        
        System.out.println("Ingrese la cantidad de vehículos del día");
        int n=leer.nextInt();

        double[] distancias=new double[n];
        int i=0;

        while(i<n){
            System.out.println("ingrese la distancia recorrida en km del vehículo N."+(i+1));
            distancias[i]=leer.nextDouble();
            if (distancias[i]>COND1 && distancias[i]<=COND2){
                total=total+distancias[i];
                if (distancias[i]<=COND3){
                    acum1++;
                }else{
                    acum2++;
                }
                i++;
            }else{
                System.out.println("distancia fuera del rango (10km - 500km)");
            }
        }
        System.out.println("La cantidad de vehículos que recorrieron entre 10km y 300km es de: "+acum1);
        System.out.println("La cantidad de vehículos que recorrieron más de 300km es de: "+acum2);
        System.out.println("La distancia total recorrida entre todos los vehículos es de:"+total+"km");
        leer.close();
    }
}