import java.util.Scanner;
public class sueldos {
    private static final int COND1=100;
    private static final int COND2=500;
    private static final int COND3=300;
    public static void main (String [] args) throws Exception{
        int n;
        int acum1=0;
        int acum2=0;
        double acum3=0;

        int i =0;
        //acum para cada acumulador, 1. entre 100 y 300 - 2.+ de 300 - 3.Total a pagar por la empresa
        Scanner leer=new Scanner(System.in);
        System.out.println("Ingrese la cantidad de empleados de la empresa");
        n = leer.nextInt();
        double[] sueldos = new double[n];

       while (i < n){
            System.out.println("ingrese el sueldo del empleado N."+ (i+1));
            sueldos[i]=leer.nextDouble();
            if (sueldos[i]<=COND2 && sueldos[i]>=COND1){
                acum3=acum3+sueldos[i];
                if (sueldos[i]<=COND3){
                    acum1++;
                }else{
                    acum2++;
                }
                i++;
            }else{
                System.out.println("dato inválido");
            }
        }
        System.out.println("Número de empleados que cobran entre 100 y 300: "+ acum1);
        System.out.println("Número de empleados que cobran más de 300: " + acum2);
        System.out.println("Cantidad a pagar por parte de la empresa: " + acum3);

        leer.close();
    }
}
