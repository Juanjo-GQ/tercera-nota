import java.util.Scanner;

public class EjercicioPreguntas{
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Condición a comprobar: primer número mayor que el segundo número y menor que el tercer número");
        System.out.println();
        System.out.println("Ingrese su primer número");
        int primerN= entrada.nextInt();
        System.out.println();
        System.out.println("Ingrese su segundo número");
        int segundoN= entrada.nextInt();
        System.out.println();
        System.out.println("Ingrese su tercer número");
        int tercerN= entrada.nextInt();
        System.out.println();

        boolean comparacion = (primerN>segundoN) && (primerN<tercerN);
        System.out.println("COMPROBACIÓN--DE--LA--CONDICIÓN");
        System.out.println("¿Es "+primerN+" mayor a "+segundoN+", y menor a "+tercerN+" ?");
        System.out.println();
        if (comparacion){
            System.out.println("Sí se cumple la condición con los valores ingresados");
        } else {
                System.out.println("No se cumple la condición con los valores ingresados");
        }
    }
}