
package proyectoprogramacion3;

public class Tablero {
    private int ancho;
    private int alto;
    private Serpiente serpiente;
    private Comida comida;
    private String estado;
    private int puntaje;

    public Tablero(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        serpiente = new Serpiente();
        comida = new Comida();
        comida.generar(ancho, alto, serpiente);
        estado = "Jugando";
        puntaje = 0;
    }

    public void actualizar() {

        boolean comio = verificarComida();

        serpiente.mover(comio);

        if (comio) {
            puntaje += 10;
            comida.generar(ancho, alto, serpiente);
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

                        if (actual == serpiente.getCabeza()) {
                            texto += "O ";
                        } else {
                            texto += "S ";
                        }

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
        texto += "\nPuntaje: " + puntaje;

        return texto;
    }

    public String getEstado() {
        return estado;
    }

    public Serpiente getSerpiente() {
        return serpiente;
    }
}
