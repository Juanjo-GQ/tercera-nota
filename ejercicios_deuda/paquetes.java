import java.util.Scanner;
public class paquetes{
    private static final int COND1=1;
    private static final int COND2=50;
    private static final int COND3=20;
    
    public static void main (String [] args)throws Exception{
        Scanner leer = new Scanner(System.in);
        int i=0;
        int acum1=0;
        int acum2=0;
        double acum3=0;

        System.out.println("ingrese la cantidad de paquetes a registrar");
        int n=leer.nextInt();

        double[] pesos=new double[n];

        while(i<n){
            System.out.println("ingrese el peso del paquete N."+(i+1));
            pesos[i]=leer.nextDouble();
            if (pesos[i]>=COND1 && pesos[i]<=COND2){
                acum3=acum3+pesos[i];
                if (pesos[i]<=COND3){
                    acum1++;
                }else{
                    acum2++;
                }
            i++;
            }else{
                System.out.println("Peso no válido");
            }
        }
        System.out.println("La cantidad de paquetes entre 1kg y 20kg es de: "+acum1);
        System.out.println("La cantidad de paquetes con un peso mayor a 20kg es de: "+acum2);
        System.out.println("La carga total llevada es de: "+acum3+"kg");
        leer.close();
    }
}