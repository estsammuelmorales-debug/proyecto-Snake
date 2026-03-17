
package proyectoprogramacion3;


public class Tablero {
    private int ancho;
    private int alto;
    private String estado;
    private Serpiente serpiente;
    private Comida comida;

    public Tablero(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        estado = "Jugando";
        serpiente = new Serpiente();
        comida = new Comida();
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
        return serpiente.getX() == comida.getX() &&
               serpiente.getY() == comida.getY();
    }

    public boolean verificarColision() {
        if (serpiente.getX() < 0 || serpiente.getX() >= ancho ||
            serpiente.getY() < 0 || serpiente.getY() >= alto) {
            return true;
        }
        return false;
    }

    public String dibujar() {
        return "Serpiente: " + serpiente.getPosicion() +
               " Comida: " + comida.getPosicion() +
               " Estado: " + estado;
    }
}
