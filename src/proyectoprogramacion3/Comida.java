
package proyectoprogramacion3;


public class Comida {
    private int x;
    private int y;

    public Comida() {
        generar(10, 10);
    }

    public void generar(int ancho, int alto) {
        x = (int)(Math.random() * ancho);
        y = (int)(Math.random() * alto);
    }

    public int getX() { 
        return x; 
    }
    public int getY() { 
        return y; 
    }
}
