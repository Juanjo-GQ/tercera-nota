import java.util.Scanner;
public class ed {
    public static void main (String [] args){
        Scanner leer = new Scanner(System.in);
        System.out.println("ingrese el rango (cero a x número) "+ 
        "del que desea extraer los números impares");
        int cant = leer.nextInt();
        System.out.println("=====");

        for (int i = 1; i <= cant; i++) {
    if (i % 2 == 0) {
        continue;
    }
    System.out.println(i);
}
    leer.close();
    }
}
