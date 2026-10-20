package src;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Guardar {
    private static final String ARCHIVO = "partida.txt";
    public static void guardar(Prota heroe, int indiceVillano) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO));
            writer.println(heroe.alias);
            writer.println(heroe.poderAtaque);
            writer.println(heroe.agilidad);
            writer.println(heroe.puntosVida);
            writer.println(heroe.vidaTope);
            writer.println(heroe.botiquines);
            writer.println(indiceVillano);
            writer.close();
            System.out.println("\n ¡Partida guardada con éxito en '" + ARCHIVO + "'!");
        } catch (Exception e) {
            System.out.println("\n Error al guardar la partida: " + e.getMessage());
        }
    }
    public static boolean existePartida() {
        File file = new File(ARCHIVO);
        return file.exists();
    }
    public static Prota cargarHeroe() {
        try {
            Scanner lector = new Scanner(new File(ARCHIVO));
            String alias = lector.nextLine();
            int ataque = Integer.parseInt(lector.nextLine());
            int vel = Integer.parseInt(lector.nextLine());
            int hpActual = Integer.parseInt(lector.nextLine());
            int hpMax = Integer.parseInt(lector.nextLine());
            int botiquines = Integer.parseInt(lector.nextLine());
            lector.close();

            Prota heroe = new Prota(alias, ataque, vel, hpMax);
            heroe.puntosVida = hpActual;
            heroe.botiquines = botiquines;
            return heroe;
        } catch (Exception e) {
            System.out.println("\n Error al cargar el héroe.");
            return null;
        }
    }
    public static int cargarIndiceVillano() {
        try {
            Scanner lector = new Scanner(new File(ARCHIVO));
            for (int i = 0; i < 6; i++) {
                lector.nextLine();
            }
            int indice = Integer.parseInt(lector.nextLine());
            lector.close();
            return indice;
        } catch (Exception e) {
            return 0;
        }
    }
}