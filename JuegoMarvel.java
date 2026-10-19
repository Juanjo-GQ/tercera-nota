import java.util.Scanner;

// ==========================================
// 1. CLASE ANTAGONISTA (Villano)
// ==========================================
class Antagonista extends EntidadCombate {
    public Antagonista(String alias, int poderAtaque, int agilidad, int puntosVida) {
        super(alias, poderAtaque, agilidad, puntosVida);
    }

    public void movimientoSucio(EntidadCombate rival) {
        int danoTrampa = this.poderAtaque * 2;
        if (rival.enGuardia) {
            danoTrampa = danoTrampa / 2;
            rival.enGuardia = false;
        }
        rival.puntosVida -= danoTrampa;
        System.out.println(" ¡TRAMPA! " + this.alias + " juega sucio y causa " + danoTrampa + " de daño.");
    }
}

// ==========================================
// 2. CLASE PROTAGONISTA (Superhéroe)
// ==========================================
class Protagonista extends EntidadCombate {
    int rango;
    int puntosExp;

    public Protagonista(String alias, int poderAtaque, int agilidad, int puntosVida) {
        super(alias, poderAtaque, agilidad, puntosVida);
        this.rango = 1;
        this.puntosExp = 0;
    }

    public void golpeDefinitivo(EntidadCombate rival) {
        System.out.println(" " + this.alias + " se arriesga con un Ataque Especial (50% de probabilidad)...");
        int ruleta = (int) (Math.random() * 2); 
        
        if (ruleta == 1) { 
            int danoEspecial = this.poderAtaque + (10 * this.rango) + this.bonoAtaque; 
            this.bonoAtaque = 0; 
            
            if (rival.enGuardia) {
                danoEspecial = danoEspecial / 2;
                rival.enGuardia = false;
            }
            rival.puntosVida -= danoEspecial;
            System.out.println(" ¡ÉXITO! " + this.alias + " conecta un golpe devastador causando " + danoEspecial + " de daño.");
        } else { 
            System.out.println(" ¡FALLÓ! El oponente logró esquivarlo. " + this.alias + " tropieza y pierde su turno.");
        }
    }

    public void acumularExperiencia(int expGanada) {
        this.puntosExp += expGanada;
        System.out.println(" ¡Has ganado " + expGanada + " puntos de experiencia! (EXP: " + this.puntosExp + "/100)");
        if (this.puntosExp >= 100) ascenderNivel();
    }

    private void ascenderNivel() {
        this.rango++;
        this.puntosExp -= 100; 
        this.poderAtaque += 5;           
        this.vidaTope += 30;  
        this.puntosVida = this.vidaTope; 
        this.botiquinesDisponibles = 3; 
        
        System.out.println("\n ¡NIVEL SUPERADO! ");
        System.out.println("¡" + this.alias + " ha subido al Nivel " + this.rango + "!");
        System.out.println(" Tus estadísticas han mejorado y recuperaste tus 3 curaciones.\n");
    }
}

// ==========================================
// 3. CLASE BASE (EntidadCombate)
// ==========================================
class EntidadCombate {
    String alias;
    int poderAtaque;
    int agilidad;
    int puntosVida;
    int vidaTope; 
    boolean enGuardia;
    
    int botiquinesDisponibles; 
    int bonoAtaque;            

    public EntidadCombate(String alias, int poderAtaque, int agilidad, int puntosVida) {
        this.alias = alias;
        this.poderAtaque = poderAtaque;
        this.agilidad = agilidad;
        this.puntosVida = puntosVida;
        this.vidaTope = puntosVida;
        this.enGuardia = false;
        this.botiquinesDisponibles = 3; 
        this.bonoAtaque = 0;           
    }

    public void golpear(EntidadCombate rival) {
        int dano = this.poderAtaque + this.bonoAtaque;
        this.bonoAtaque = 0; 
        
        int suerteCritica = (int) (Math.random() * 100);
        if (suerteCritica < 20) {
            dano = dano * 2;
            System.out.println(" ¡GOLPE CRÍTICO! " + this.alias + " encuentra un punto débil.");
        }

        if (rival.enGuardia) {
            dano = dano / 2;
            rival.enGuardia = false;
            System.out.println(" " + rival.alias + " se protegió! El daño se redujo a " + dano + ".");
        }
        
        rival.puntosVida -= dano;
        System.out.println(" " + this.alias + " ataca causando " + dano + " de daño a " + rival.alias + ".");
    }

    public void cubrirse() {
        this.enGuardia = true;
        System.out.println(" " + this.alias + " adopta una posición defensiva para mitigar daños.");
    }

    public void concentracionFeroz() {
        this.bonoAtaque = 10; 
        System.out.println(" " + this.alias + " adopta una POSTURA DE COMBATE. ¡Su próximo ataque será letal!");
    }

    public void sanarHeridas(int cantidad) {
        boolean esDeadpool = this.alias.equals("Deadpool");

        if (this.botiquinesDisponibles > 0 || esDeadpool) {
            if (!esDeadpool) {
                this.botiquinesDisponibles--; 
            }
            
            this.puntosVida += cantidad;
            if (this.puntosVida > this.vidaTope) {
                this.puntosVida = this.vidaTope; 
            }
            
            System.out.println(" " + this.alias + " toma distancia y toma un respiro (+ " + cantidad + " HP).");
            
            if (esDeadpool) {
                System.out.println("   (Factor regenerativo mutante: Usos ilimitados 🌮).");
            } else {
                System.out.println("   (Le quedan " + this.botiquinesDisponibles + " usos restantes).");
            }
            
        } else {
            System.out.println(" " + this.alias + " intenta tomar un respiro... ¡pero está exhausto! Pierde el turno por confiarse.");
        }
    }

    public void imprimirEstado() {
        System.out.println("[" + this.alias + "] -> Vida: " + this.puntosVida + "/" + this.vidaTope + " | Fuerza: " + this.poderAtaque + " | Velocidad: " + this.agilidad);
    }
}

// ==========================================
// 4. CLASE PRINCIPAL (JuegoMarvel)
// ==========================================
public class JuegoMarvel{
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("=========================================================================");
        System.out.println("  MARVEL BATTLES: DEFENDERS OF NEW YORK ⚔️");
        System.out.println("=========================================================================\n");
        
        String opcionElegida = "";
        while (!opcionElegida.equals("1") && !opcionElegida.equals("2")) {
            System.out.println("¿A quién elegirás para salvar la ciudad?");
            System.out.println("1. Spider-Man (Equilibrado: 15 Fuerza, 20 Vel, 100 HP)");
            System.out.println("2. Deadpool   (Inmortal: 13 Fuerza, 25 Vel, 160 HP)");
            System.out.print(" Elige (1 o 2): ");
            opcionElegida = entrada.next();
        }

        Protagonista heroe;
        if (opcionElegida.equals("2")) {
            heroe = new Protagonista("Deadpool", 13, 25, 160);
            System.out.println("\n--- MODO DEADPOOL ACTIVADO ---");
            System.out.println("Ah, ¿estás leyendo esto? Sí, tú, el estudiante de sistemas que me está");
            System.out.println("ejecutando en la consola. ¡Relájate, yo me encargo de salvar este simulador");
            System.out.println("barato! ¿Qué? ¿Que el profe no nos dio presupuesto para animaciones 3D?");
            System.out.println("Bueno, a leer letras y números se ha dicho. ¡Saca las chimichangas!");
            System.out.println("Unos villanos están atacando el banco, vamos a patear traseros virtuales...\n");
        } else {
            heroe = new Protagonista("Spider-Man", 15, 20, 100);
            System.out.println("\n--- MODO SPIDER-MAN ACTIVADO ---");
            System.out.println("Era una tarde tranquila en Nueva York. Mientras Spider-Man se balanceaba");
            System.out.println("tranquilamente entre los rascacielos de Manhattan, una fuerte explosión");
            System.out.println("sacudió el centro de la ciudad. Al acercarse, vio que el Banco Nacional");
            System.out.println("estaba siendo atacado... ¡Era el Duende Verde robando la bóveda principal!");
            System.out.println("'¿No podías simplemente abrir una cuenta de ahorros, Norman?', dice nuestro héroe.\n");
        }

        Antagonista[] listaVillanos = {
            new Antagonista("El Duende Verde", 12, 18, 100),
            new Antagonista("Sandman (El Hombre de Arena)", 16, 10, 140),
            new Antagonista("El Buitre", 20, 25, 160)
        };

        for (int i = 0; i < listaVillanos.length; i++) {
            Antagonista villanoActual = listaVillanos[i];
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

    public static void procesarTurnoProtagonista(Protagonista heroe, Antagonista villanoActual, Scanner entrada) {
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

    public static void procesarTurnoAntagonista(Antagonista villanoActual, Protagonista heroe, Scanner entrada) {
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