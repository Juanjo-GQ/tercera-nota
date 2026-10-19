package src;
public class EntiCombate {
    String alias;
    int poderAtaque;
    int agilidad;
    int puntosVida;
    int vidaTope; 
    boolean enGuardia;
    
    int botiquinesDisponibles; 
    int bonoAtaque;            

    public EntiCombate(String alias, int poderAtaque, int agilidad, int puntosVida) {
        this.alias = alias;
        this.poderAtaque = poderAtaque;
        this.agilidad = agilidad;
        this.puntosVida = puntosVida;
        this.vidaTope = puntosVida;
        this.enGuardia = false;
        this.botiquinesDisponibles = 3; 
        this.bonoAtaque = 0;            
    }

    public void golpear(EntiCombate rival) {
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