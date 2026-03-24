
package proyectoprogramacion3;


public class Tablero {
    private int ancho;
    private int alto;
    private Serpiente serpiente;
    private Comida comida;
    private String estado;

    public Tablero(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        serpiente = new Serpiente();
        comida = new Comida();
        estado = "Jugando";
    }

    public void actualizar() {
        serpiente.mover();

        if (verificarComida()) {
            serpiente.crecer();
            comida.generar(ancho, alto);
        }

        if (verificarColision()) {
            estado = "Perdiste";
        }
    }

    public boolean verificarComida() {
        Nodo cabeza = serpiente.getCabeza();
        return cabeza.getX() == comida.getX() &&
               cabeza.getY() == comida.getY();
    }

    public boolean verificarColision() {
        Nodo cabeza = serpiente.getCabeza();

        if (cabeza.getX() < 0 || cabeza.getX() >= ancho ||
            cabeza.getY() < 0 || cabeza.getY() >= alto) {
            return true;
        }

        return serpiente.colisionPropia();
    }

    public String dibujar() {
        String texto = "";

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {

                boolean esCuerpo = false;
                Nodo actual = serpiente.getCuerpo().getFrente();

                while (actual != null) {
                    if (actual.getX() == j && actual.getY() == i) {
                        texto += "S ";
                        esCuerpo = true;
                        break;
                    }
                    actual = actual.getSiguiente();
                }

                if (!esCuerpo) {
                    if (j == comida.getX() && i == comida.getY()) {
                        texto += "C ";
                    } else {
                        texto += ". ";
                    }
                }
            }
            texto += "\n";
        }

        texto += "Estado: " + estado;
        return texto;
    }

    public String getEstado() {
        return estado;
    }

    public Serpiente getSerpiente() {
        return serpiente;
    }
}
