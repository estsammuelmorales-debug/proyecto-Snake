
package proyectoprogramacion3;


public class Serpiente {
    private int cabezaX;
    private int cabezaY;
    private char direccion;
    private int longitud;

    public Serpiente() {
        cabezaX = 5;
        cabezaY = 5;
        direccion = 'D';
        longitud = 1;
    }

    public void mover() {
        if (direccion == 'D') {
            cabezaX++;
        } else if (direccion == 'I') {
            cabezaX--;
        } else if (direccion == 'U') {
            cabezaY--;
        } else if (direccion == 'A') {
            cabezaY++;
        }
    }

    public void crecer() {
        longitud++;
    }

    public void cambiarDireccion(char nuevaDireccion) {
        direccion = nuevaDireccion;
    }

    public String getPosicion() {
        return "(" + cabezaX + "," + cabezaY + ")";
    }

    public boolean colisionPropia() {
        return false;
    }

    public int getX() {
        return cabezaX;
    }

    public int getY() {
        return cabezaY;
    }
}

