package src;

public class Malo extends Entidades {
    public Malo(String alias, int poderAtaque, int agilidad, int puntosVida) {
        super(alias, poderAtaque, agilidad, puntosVida);
    }
    public void movimientoSucio(Entidades rival) {
        int danoTrampa = this.poderAtaque * 2;

        System.out.println(this.alias + " HACE TRAMPA y ataca con el doble de fuerza!");

        if (rival.enGuardia) {
            danoTrampa = danoTrampa / 2;
            rival.enGuardia = false;
            System.out.println(" ¡Lograste defenderte parcialmente de la trampa!");
        }
        rival.puntosVida -= danoTrampa;
        if (rival.puntosVida < 0) {
            rival.puntosVida = 0;
        }
        System.out.println("Te inflige " + danoTrampa + " de daño!");
    }
    public void regenerarVida(int porcentaje) {
        if (porcentaje > 25) {
            porcentaje = 25;
        }
        int azar = (int) (Math.random() * 100) + 1;

        if (azar <= porcentaje) {
            int hpRecuperado = (int) (Math.random() * 21) + 10;
            this.puntosVida += hpRecuperado;

            if (this.puntosVida > this.vidaTope) {
                this.puntosVida = this.vidaTope;
            }
            System.out.println(" ¡" + this.alias + " se REGENERA " + hpRecuperado + " HP!");
            System.out.println("   Vida actual de " + this.alias + ": " + this.puntosVida + "/" + this.vidaTope + " HP");
        } else {
            System.out.println(" " + this.alias + " intento curarse pero fallo.");
        }
    }
}