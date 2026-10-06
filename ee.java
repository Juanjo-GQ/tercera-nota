import java.util.Scanner;
public class ee{
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int numero;
        do {
            System.out.println("Ingrese el número final a mostrar (0 - 20):");
            numero = leer.nextInt();
            if (numero < 0 || numero > 20) {
                System.out.println("Número fuera de rango, intente nuevamente");
            }
        } while (numero < 0 || numero > 20);
        for (int i = 0; i <= numero; i++) {
            System.out.println(i);
        }
        leer.close();
    }
}