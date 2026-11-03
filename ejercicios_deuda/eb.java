public class eb{
    public static void main (String [] args){
        int menor = encontrarmen(10, 20, 5);
        System.out.println("El número mayor es: " + menor);
    }

    public static int encontrarmen(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}