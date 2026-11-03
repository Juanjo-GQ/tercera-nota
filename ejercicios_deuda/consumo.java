import java.util.Scanner;
public class consumo{
    private static final int COND1=1;
    private static final int COND2=100;
    private static final int COND3=50;
    public static void main (String [] args) throws Exception{
        Scanner leer=new Scanner(System.in);
        int i =0;
        int acum1=0;
        int acum2=0;
        double acum3=0;
        System.out.println("Ingrese la cantidad de apartamentos de la unidad");
        int n = leer.nextInt();
        double[] consumidos= new double[n];
        while (i<n){
            System.out.println("ingrese los metros cúbicos de agua consumidos por el apartamento N." + (i+1));
            consumidos[i]=leer.nextDouble();
            if (consumidos[i]>=COND1 && consumidos[i]<=COND2){
                acum3=acum3+consumidos[i];
                if (consumidos[i]<=COND3){
                    acum1++;
                }else{
                    acum2++;
                }
                i++;
            }else{
                System.out.println("Cantidad no válida");
            }

        }
        System.out.println("La cantidad de apartamentos que consumieron menos de 50 metros cúbicos de agua es de: "+acum1);
        System.out.println("La cantidad de apartamentos que consumieron más de 50 metros cpubicos de agua es de: "+ acum2);
        System.out.println("El total de metros cúbicos de agua consumidos es de: "+ acum3);
        leer.close();



    }
}