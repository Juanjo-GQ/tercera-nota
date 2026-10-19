package src;

public class Prota extends Entidades {
    public Prota(String alias, int poderAtaque, int agilidad, int puntosVida) {
        super(alias, poderAtaque, agilidad, puntosVida);
    }
    public void ataqueEspecial(Entidades rival) {
        System.out.println(this.alias + " intenta ejecutar un ATAQUE ESPECIAL contra " + rival.alias + "...");

        if (Math.random() < 0.5) {
            int danoEspecial = this.poderAtaque + 15;

            if (rival.enGuardia) {
                danoEspecial = danoEspecial / 2;
                rival.enGuardia = false;
                System.out.println(" ¡" + rival.alias + " bloqueo parte del ataque especial!");
            }
            rival.puntosVida -= danoEspecial;
            if (rival.puntosVida < 0) {
                rival.puntosVida = 0;
            }
            System.out.println(" ¡EXITO! Causa " + danoEspecial + " puntos de dano devastador!");
        } else {
            System.out.println(" ¡FALLO! " + esteAlias() + " se resbalo al atacar y perdio el turno.");
        }
    }
    private String esteAlias() {
        return this.alias;
    }
}