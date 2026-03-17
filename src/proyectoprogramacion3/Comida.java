
package proyectoprogramacion3;


public class Comida {
    private int posicionX;
    private int posicionY;

    public Comida() {
        generar(10, 10);
    }

    public void generar(int ancho, int alto) {
        posicionX = (int)(Math.random() * ancho);
        posicionY = (int)(Math.random() * alto);
    }

    public String getPosicion() {
        return "(" + posicionX + "," + posicionY + ")";
    }

    public int getX() {
        return posicionX;
    }

    public int getY() {
        return posicionY;
    }
}
