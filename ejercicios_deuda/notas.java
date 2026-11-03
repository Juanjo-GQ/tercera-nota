import java.util.Scanner;

public class notas{
    private static final double COND1=0;
    private static final double COND2=5;
    private static final double COND3=3;
    private static final double COND4=4;

    public static void main (String [] args) throws Exception{
        Scanner leer=new Scanner(System.in);
        int acum1=0;
        int acum2=0;
        double acum3=0;
        int i=0;


        System.out.println("ingrese la cantidad de estudiantes del curso");
        int n=leer.nextInt();

        double[] notas= new double[n];
        while (i<n){
            System.out.println("Ingrese la nota del estudiante N."+ (i+1));
            notas[i]=leer.nextDouble();
            if (notas[i]>=COND1 && notas[i]<=COND2){
                acum3=acum3+notas[i];
                if (notas[i]>=COND3 && notas[i]<=COND4){
                    acum1++;
                }
                if (notas[i]>COND4){
                        acum2++;
                    }
                i++;
            }else{
                System.out.println("dato no válido");
            }
        }
        System.out.println("La cantidad de estudiantes que aprobaron con notas entre 3 y 4 es de: "+ acum1);
        System.out.println("La cantidad de estudiantes que aprobaron con notas superiores a 4 es de: "+ acum2);
        System.out.println("La suma de todas las notas de los estudiantes es de: "+acum3);
        leer.close();

        
    }
}