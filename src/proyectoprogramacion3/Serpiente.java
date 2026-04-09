package proyectoprogramacion3;

public class Serpiente {
    private String jugador;
    private int puntaje;

    public Serpiente() {
        jugador = "Anonimo";
        puntaje = 0;
    }

    public void iniciarJuego() {
        puntaje = (int)(Math.random() * 100);
    }

    public int getPuntaje() {
        return puntaje;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public String toString() {
        return "Jugador: " + jugador + " | Puntaje: " + puntaje;
    }
}
