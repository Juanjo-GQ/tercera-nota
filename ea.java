public class ea{
    public static void main(String [] args){
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int contadorinpares = 0;  
        for (int numero : numeros) {
            if (numero % 2 != 0) {
                contadorinpares++;  
            }
        }
        System.out.println("Cantidad de números inpares: " + contadorinpares);
    }
}