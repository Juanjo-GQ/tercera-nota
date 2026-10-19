package src;

import java.util.Scanner;

public class Jueguito {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("   BATALLAS MARVEL - DEFIENDE OCAÑA");
        System.out.println("=========================================\n");

        Prota heroe = null;
        int villanoInicial = 0;

        if (Guardar.existePartida()) {
            System.out.println("Se encontro una partida guardada.");
            System.out.println("1. Cargar partida guardada");
            System.out.println("2. Nueva partida");
            System.out.print("Opcion (1 o 2): ");
            int opcCarga = entrada.nextInt();

            if (opcCarga == 1) {
                heroe = Guardar.cargarHeroe();
                villanoInicial = Guardar.cargarIndiceVillano();
                if (heroe != null) {
                    System.out.println("\n --Partida cargada-- Reanudando combate con " + heroe.alias + "...");
                }
            }
        }

        if (heroe == null) {
            System.out.println("\n¿A quien eliges para salvar la ciudad?");
            System.out.println("1. SpiderMan (Ataque: 15, Vel: 20, HP: 100 | 3 Curaciones)");
            System.out.println("2. Deadpool  (Ataque: 13, Vel: 25, HP: 120 | Curaciones Ilimitadas)");
            System.out.print("Elige (1 o 2): ");
            int opcionHeroe = entrada.nextInt();

            if (opcionHeroe == 2) {
                heroe = new Prota("Deadpool", 13, 25, 120);
                System.out.println("\n--- MODO DEADPOOL ACTIVADO ---");
                System.out.println("Relajate -- Yo me encargo de este simulador. Saca las arepas!\n");
            } else {
                heroe = new Prota("SpiderMan", 15, 20, 100);
                System.out.println("\n--- MODO SPIDERMAN ACTIVADO ---");
                System.out.println("Unos villanos estan atacando Ocana... Hora de ir\n");
            }
        }

        Malo[] villanos = {
            new Malo("El Enano Verde", 12, 18, 80),
            new Malo("SadMan", 16, 10, 100),
            new Malo("El Gallinzao", 18, 22, 120)
        };

        for (int i = villanoInicial; i < villanos.length; i++) {
            Malo villanoActual = villanos[i];

            System.out.println("\n-----------------------------------------");
            System.out.println(" PREPARATE. Enemigo actual: " + villanoActual.alias.toUpperCase());
            System.out.println("-----------------------------------------");

            while (heroe.puntosVida > 0 && villanoActual.puntosVida > 0) {
                System.out.println("\n--- ESTADO DE LA BATALLA ---");
                heroe.imprimirEstado();
                villanoActual.imprimirEstado();

                System.out.println("\nES TU TURNO. ¿Que vas a hacer?");
                System.out.println("1. Atacar normal");
                System.out.println("2. Defenderse (Reduce dano 50%)");
                System.out.println("3. Tomar un tintico (+20 HP)");
                System.out.println("4. Ataque Especial");
                System.out.print("Elige una opcion (1-4): ");
                int accion = entrada.nextInt();

                switch (accion) {
                    case 1:
                        heroe.golpear(villanoActual);
                        break;
                    case 2:
                        heroe.cubrirse();
                        break;
                    case 3:
                        heroe.sanarHeridas(20);
                        break;
                    case 4:
                        heroe.ataqueEspecial(villanoActual);
                        break;
                    default:
                        System.out.println("Te equivocaste al teclear. Pierdes el turno.");
                        break;
                }

                if (villanoActual.puntosVida <= 0) {
                    System.out.println("\n HAS DERROTADO A " + villanoActual.alias.toUpperCase());
                    break;
                }

                System.out.println("\n--- TURNO DE " + villanoActual.alias.toUpperCase() + " ---");
                int accionVillano = (int) (Math.random() * 4) + 1;

                if (accionVillano == 1) {
                    villanoActual.golpear(heroe);
                } else if (accionVillano == 2) {
                    villanoActual.movimientoSucio(heroe);
                } else if (accionVillano == 3) {
                    villanoActual.cubrirse();
                } else if (accionVillano == 4) {
                    if (i == 0) {
                        villanoActual.regenerarVida(20);
                    } else if (i == 1) {
                        villanoActual.regenerarVida(35);
                    } else {
                        villanoActual.regenerarVida(50);
                    }
                }

                if (heroe.puntosVida <= 0) {
                    System.out.println("\n GAME OVER. " + heroe.alias + " ha caido. Ocaña pertenece a los villanos.");
                    break;
                }
            }

            if (heroe.puntosVida <= 0) {
                break;
            }

            if (i < villanos.length - 1) {
                System.out.println("\n=========================================");
                System.out.println("¿Que quieres hacer ahora?");
                System.out.println("1. Ir a chismosear el siguiente crimen (Continuar peleando)");
                System.out.println("2. Ir a comer salchipapa (Guardar partida y salir)");
                System.out.print("Elige (1 o 2): ");
                int decision = entrada.nextInt();

                if (decision == 2) {
                    Guardar.guardar(heroe, i + 1);
                    System.out.println("\n " + heroe.alias + " decide tomar un tinto. ¡Hasta la proxima!");
                    break;
                } else {
                    System.out.println("\n Te diriges a la siguiente zona roja (+10 HP de recuperacion)...");
                    heroe.puntosVida += 10;
                    if (heroe.puntosVida > heroe.vidaTope) {
                        heroe.puntosVida = heroe.vidaTope;
                    }
                }
            }
        }

        if (heroe.puntosVida > 0 && villanoInicial == villanos.length - 1 && villanos[villanos.length - 1].puntosVida <= 0) {
            System.out.println("\n=========================================");
            System.out.println(" MISION CUMPLIDA! Has derrotado a todos los villanos.");
            System.out.println(" Nueva York esta a salvo. ¡FIN DEL JUEGO!");
            System.out.println("=========================================");
        }
        if (heroe.puntosVida > 0 && villanos[2].puntosVida <= 0) {
            System.out.println("\n=========================================");
            System.out.println("   ¡¡¡FELICITACIONES, HEROE!!!   ");
            System.out.println(" Has demostrado una estrategia impecable en combate.");
            System.out.println(" Derrotaste a los 3 villanos y salvaste la ciudad.");
            System.out.println(" ¡Gracias por jugar y defender a Ocana! ");
            System.out.println("=========================================");
        }

        entrada.close();
    }
}