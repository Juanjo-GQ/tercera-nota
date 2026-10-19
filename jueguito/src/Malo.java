package src;
public class Malo extends EntiCombate {
    public Malo(String alias, int poderAtaque, int agilidad, int puntosVida) {
        super(alias, poderAtaque, agilidad, puntosVida);
    }

    public void movimientoSucio(EntiCombate rival) {
        int danoTrampa = this.poderAtaque * 2;
        if (rival.enGuardia) {
            danoTrampa = danoTrampa / 2;
            rival.enGuardia = false;
        }
        rival.puntosVida -= danoTrampa;
        System.out.println(" ¡TRAMPA! " + this.alias + " juega sucio y causa " + danoTrampa + " de daño.");
    }
}
