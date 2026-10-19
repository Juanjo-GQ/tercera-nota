package src;
import java.util.Scanner;

public class Jueguito {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("=========================================================================");
        System.out.println("  MARVEL BATTLES: DEFENDERS OF NEW YORK ⚔️");
        System.out.println("=========================================================================\n");
        
        String opcionElegida = "";
        while (!opcionElegida.equals("1") && !opcionElegida.equals("2")) {
            System.out.println("¿A quién elegirás para salvar la ciudad?");
            System.out.println("1. Spider-Man (Equilibrado: 15 Fuerza, 20 Vel, 100 HP)");
            System.out.println("2. Deadpool    (Inmortal: 13 Fuerza, 25 Vel, 160 HP)");
            System.out.print(" Elige (1 o 2): ");
            opcionElegida = entrada.next();
        }

        Prota heroe;
        if (opcionElegida.equals("2")) {
            heroe = new Prota("Deadpool", 13, 25, 160);
            System.out.println("\n--- MODO DEADPOOL ACTIVADO ---");
            System.out.println("Ah, ¿estás leyendo esto? Sí, tú, el estudiante de sistemas que me está");
            System.out.println("ejecutando en la consola. ¡Relájate, yo me encargo de salvar este simulador");
            System.out.println("barato! ¿Qué? ¿Que el profe no nos dio presupuesto para animaciones 3D?");
            System.out.println("Bueno, a leer letras y números se ha dicho. ¡Saca las chimichangas!");
            System.out.println("Unos villanos están atacando el banco, vamos a patear traseros virtuales...\n");
        } else {
            heroe = new Prota("Spider-Man", 15, 20, 100);
            System.out.println("\n--- MODO SPIDER-MAN ACTIVADO ---");
            System.out.println("Era una tarde tranquila en Nueva York. Mientras Spider-Man se balanceaba");
            System.out.println("tranquilamente entre los rascacielos de Manhattan, una fuerte explosión");
            System.out.println("sacudió el centro de la ciudad. Al acercarse, vio que el Banco Nacional");
            System.out.println("estaba siendo atacado... ¡Era el Duende Verde robando la bóveda principal!");
            System.out.println("'¿No podías simplemente abrir una cuenta de ahorros, Norman?', dice nuestro héroe.\n");
        }

        Malo[] listaVillanos = {
            new Malo("El Duende Verde", 12, 18, 100),
            new Malo("Sandman (El Hombre de Arena)", 16, 10, 140),
            new Malo("El Buitre", 20, 25, 160)
        };

        for (int i = 0; i < listaVillanos.length; i++) {
            Malo villanoActual = listaVillanos[i];
            System.out.println(" PREPÁRATE. Enemigo actual: " + villanoActual.alias + " \n");

            while (heroe.puntosVida > 0 && villanoActual.puntosVida > 0) {
                System.out.println("--------------------------------------------------");
                heroe.imprimirEstado();
                villanoActual.imprimirEstado();
                System.out.println("--------------------------------------------------");
                
                boolean heroeMasVeloz = heroe.agilidad >= villanoActual.agilidad;

                if (heroeMasVeloz) {
                    procesarTurnoProtagonista(heroe, villanoActual, entrada);
                    if (villanoActual.puntosVida > 0) procesarTurnoAntagonista(villanoActual, heroe, entrada);
                } else {
                    System.out.println(" ¡" + villanoActual.alias + " es más rápido y toma la iniciativa en esta ronda!");
                    procesarTurnoAntagonista(villanoActual, heroe, entrada);
                    if (heroe.puntosVida > 0) procesarTurnoProtagonista(heroe, villanoActual, entrada);
                }
            }

            if (heroe.puntosVida <= 0) {
                System.out.println("\n GAME OVER. " + heroe.alias + " ha caído. La ciudad pertenece a los villanos.");
                break; 
            } else {
                System.out.println("\n ¡HAS DERROTADO A " + villanoActual.alias.toUpperCase() + "!");
                heroe.acumularExperiencia(55); 

                if (i < listaVillanos.length - 1) {
                    String seguir = "";
                    while (!seguir.equals("1") && !seguir.equals("2")) {
                        System.out.println("\n¿Qué deseas hacer?");
                        System.out.println("1. Ir a investigar el siguiente crimen (Continuar jugando)");
                        System.out.println("2. Ir a comer chimichangas/pizza (Retirarse y acabar el juego)");
                        System.out.print(" Elige (1 o 2): ");
                        seguir = entrada.next();
                    }

                    if (seguir.equals("2")) {
                        System.out.println("\n " + heroe.alias + " decide ir a comer. ¡Buen trabajo hoy!");
                        break;
                    } else {
                        System.out.println("\n Te diriges rápidamente hacia la siguiente zona de peligro...");
                        heroe.puntosVida += 15; 
                    }
                } else {
                    System.out.println("\n ¡Misión cumplida! Has encerrado a todos los villanos.");
                    System.out.println("Nueva York puede dormir tranquila esta noche. ¡FIN DEL JUEGO!");
                }
            }
        }
        entrada.close();
    }

    public static void procesarTurnoProtagonista(Prota heroe, Malo villanoActual, Scanner entrada) {
        System.out.println("\nES TU TURNO. ¿Qué deseas hacer?");
        System.out.println("1. Atacar Normal");
        System.out.println("2. Defender (Reduce daño 50% el prox turno)");
        
        if (heroe.alias.equals("Deadpool")) {
            System.out.println("3. Curación Mutante (+35 HP, Usos Ilimitados)");
        } else {
            System.out.println("3. Tomar un respiro (+35 HP, " + heroe.botiquinesDisponibles + " usos restantes)");
        }
        
        System.out.println("4. Ataque Especial (Ataque devastador - 50% de éxito)");
        System.out.println("5. Postura de Combate (+10 Daño para tu próximo ataque)");
        System.out.print(" Elige una opción: ");
        
        String opcion = entrada.next();
        System.out.println();

        switch (opcion) {
            case "1": heroe.golpear(villanoActual); break;
            case "2": heroe.cubrirse(); break;
            case "3": heroe.sanarHeridas(35); break;
            case "4": heroe.golpeDefinitivo(villanoActual); break;
            case "5": heroe.concentracionFeroz(); break;
            default: System.out.println(" Te enredaste al teclear. Pierdes el turno.");
        }
    }

    public static void procesarTurnoAntagonista(Malo villanoActual, Prota heroe, Scanner entrada) {
        System.out.println("\n--- TURNO DE " + villanoActual.alias.toUpperCase() + " ---");
        int accionVillano = (int) (Math.random() * 3) + 1; 
        
        if (accionVillano == 1) villanoActual.golpear(heroe);
        else if (accionVillano == 2) villanoActual.movimientoSucio(heroe);
        else if (accionVillano == 3) villanoActual.cubrirse();
        
        System.out.println("\n(Presiona ENTER para continuar...)");
        entrada.nextLine(); 
        entrada.nextLine(); 
    }
}