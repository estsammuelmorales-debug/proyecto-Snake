package proyectoprogramacion3;

public class Tablero {
    private int ancho, alto, puntaje;
    private Serpiente serpiente;
    private Comida comida;
    private String estado;

    public Tablero(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.serpiente = new Serpiente();
        this.comida = new Comida();
        this.comida.generar(ancho, alto, serpiente);
        this.estado = "Jugando";
        this.puntaje = 0;
    }

    public void actualizar() {
        boolean comio = verificarComida();
        serpiente.mover(comio);
        if (comio) {
            puntaje += 10;
            comida.generar(ancho, alto, serpiente);
        }
        if (verificarColision()) estado = "Perdiste";
    }

    public boolean verificarComida() {
        Nodo cabeza = serpiente.getCabeza();
        return cabeza.getX() == comida.getX() && cabeza.getY() == comida.getY();
    }

    public boolean verificarColision() {
        Nodo cabeza = serpiente.getCabeza();
        if (cabeza.getX() < 0 || cabeza.getX() >= ancho || cabeza.getY() < 0 || cabeza.getY() >= alto) return true;
        return serpiente.colisionPropia();
    }

    public String dibujar() {
        String mapa = "";
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                boolean serp = false;
                Nodo act = serpiente.getCuerpo().getFrente();
                while (act != null) {
                    if (act.getX() == j && act.getY() == i) {
                        mapa += "O ";
                        serp = true;
                        break;
                    }
                    act = act.getSiguiente();
                }
                if (!serp) {
                    if (comida.getX() == j && comida.getY() == i) mapa += "C ";
                    else mapa += ". ";
                }
            }
            mapa += "\n";
        }
        return mapa;
    }

    public int getPuntaje() { return puntaje; }
    public String getEstado() { return estado; }
    public Serpiente getSerpiente() { return serpiente; }
}
