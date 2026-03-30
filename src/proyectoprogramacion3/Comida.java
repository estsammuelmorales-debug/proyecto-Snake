
package proyectoprogramacion3;

public class Comida {
    private int x;
    private int y;

    public Comida() {
        generar(10, 10, null);
    }

    public void generar(int ancho, int alto, Serpiente serpiente) {

        boolean valido = false;

        while (!valido) {

            x = (int)(Math.random() * ancho);
            y = (int)(Math.random() * alto);

            valido = true;

            if (serpiente != null) {
                Nodo actual = serpiente.getCuerpo().getFrente();

                while (actual != null) {
                    if (actual.getX() == x && actual.getY() == y) {
                        valido = false;
                        break;
                    }
                    actual = actual.getSiguiente();
                }
            }
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }
}
