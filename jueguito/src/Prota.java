package src;
public class Prota extends EntiCombate {
    int rango;
    int puntosExp;

    public Prota(String alias, int poderAtaque, int agilidad, int puntosVida) {
        super(alias, poderAtaque, agilidad, puntosVida);
        this.rango = 1;
        this.puntosExp = 0;
    }

    public void golpeDefinitivo(EntiCombate rival) {
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