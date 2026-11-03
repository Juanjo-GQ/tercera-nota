import java.util.Scanner;
public class edades{
    private static final int COND1=18;
    private static final int COND2=30;
    public static void main (String [] args) throws Exception{
        Scanner leer = new Scanner(System.in);
       int n;
        int acum1=0;
        int acum2=0;
        int acum3=0;
        int i=0;
        System.out.println("ingrese la cantidad de personas");
        n=leer.nextInt();
        int[] edades=new int[n];
        while (i<n){
            System.out.println("ingrese la edad de la persona N." + (i+1));
            edades[i]=leer.nextInt();
            if (edades[i]>=0){
                acum3=acum3+edades[i];
                    if(edades[i]>=COND1 && edades[i]<=COND2){
                    acum1++;
                        if(edades[i]<18){
                            //limpiamos los menores de 18 para el contador de mayores a 30
                         }else{
                        acum2++;
                         }
                }
            }
            i++;
        }
        System.out.println("el número de personas con una edad entre 18 y 30 años es de: " + acum1);
        System.out.println("el número de personas mayores a 30 años es de: " + acum2);
        System.out.println("la suma de todas las edades da un total de :" + acum3);


        leer.close();

    }
}