import java.util.Scanner;
public class fabrica{
    private static final int COND1=10;
    private static final int COND2=200;
    private static final int COND3=100;

    public static void main (String [] args)throws Exception{
        Scanner leer=new Scanner(System.in);    
        int i =0;
        int acum1=0;
        int acum2=0;
        int acum3=0;
        System.out.println("Ingrese la cantidad de operarios");
        int n=leer.nextInt();
        int[] unidades=new int[n];
        while (i<n){
            System.out.println("Ingrese la cantidad de unidades producidas por el operario N."+(i+1));
            unidades[i]=leer.nextInt();
            if (unidades[i]>=COND1 && unidades[i]<=COND2){
                acum3=acum3+unidades[i];
                if (unidades[i]<=COND3){
                    acum1++;
                }else{
                    acum2++;
                }
                i++;
            }else{
                System.out.println("cantidad no válida");
            }
        }
        System.out.println("La cantidad de operarios que produjeron entre 10 y 100 unidades es de: "+acum1);
        System.out.println("La cantidad de operarios que produjeron más de 100 unidades es de: "+ acum2);
        System.out.println("La cantidad total de unidades producidas en la fábrica es de: "+ acum3);
        leer.close();
    }
}