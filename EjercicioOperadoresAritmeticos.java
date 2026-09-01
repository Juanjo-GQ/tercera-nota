public class EjercicioOperadoresAritmeticos{
    public static void main(String[] args){
        double camisa=25.0;
        double pantalon=30.0;
        double total=camisa+pantalon;
        System.out.println("El total de las 2 prendas sin descuento es de: "+total);

        double camisadescuento=camisa*0.85;
        double pantalondescuento=pantalon*0.85;
        double total_condescuento=camisadescuento+pantalondescuento;
        System.out.println("El total de las 2 prendas con descuento es de: "+ total_condescuento);

        double segundacamisa=camisadescuento*0.95;
        double total_consegundacamisa=total_condescuento+segundacamisa;
        System.out.println("El total ahora de las 3 prendas con descuento es de: "+ total_consegundacamisa);

    }
}