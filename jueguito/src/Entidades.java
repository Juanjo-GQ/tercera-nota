package src;
public class Entidades {
    String alias;
    int poderAtaque;
    int agilidad;
    int puntosVida;
    int vidaTope;
    boolean enGuardia;
    int botiquines;

    public Entidades(String alias, int poderAtaque, int agilidad, int puntosVida) {
        this.alias = alias;
        this.poderAtaque = poderAtaque;
        this.agilidad = agilidad;
        this.puntosVida = puntosVida;
        this.vidaTope = puntosVida;
        this.enGuardia = false;
        this.botiquines = 3;
    }
    public void golpear(Entidades rival) {
        int dano = this.poderAtaque;

        if (rival.enGuardia) {
            dano = dano / 2;
            rival.enGuardia = false;
            System.out.println(rival.alias + " se protegió y redujo el daño a la mitad (" + dano + " HP).");
        } else {
            System.out.println(this.alias + " ataca y causa " + dano + " de daño a " + rival.alias + ".");
        }

        rival.puntosVida -= dano;
        if (rival.puntosVida < 0) {
            rival.puntosVida = 0;
        }
    }
    public void cubrirse() {
        this.enGuardia = true;
        System.out.println(this.alias + " se pone en guardia. Reducirá el daño en el próximo turno.");
    }
    public void sanarHeridas(int cantidad) {
        boolean esDeadpool = this.alias.equalsIgnoreCase("Deadpool");

        if (esDeadpool || this.botiquines > 0) {
            if (!esDeadpool) {
                this.botiquines--;
            }

            this.puntosVida += cantidad;
            if (this.puntosVida > this.vidaTope) {
                this.puntosVida = this.vidaTope;
            }

            System.out.println(this.alias + " se ha curado (+ " + cantidad + " HP). Vida actual: " + this.puntosVida + "/" + this.vidaTope);

            if (esDeadpool) {
                System.out.println("   (Factor regenerativo mutante: Usos ilimitados)");
            } else {
                System.out.println("   (Le quedan " + this.botiquines + " botiquines restantes)");
            }
        } else {
            System.out.println(this.alias + " ya no tiene más botiquines! Pierde el turno por confiarse.");
        }
    }
    public void imprimirEstado() {
        System.out.println("[" + this.alias + "] -> Vida: " + this.puntosVida + "/" + this.vidaTope + " | Ataque: " + this.poderAtaque + " | Vel: " + this.agilidad);
    }
}