package proyectoprogramacion3;

import com.murcia.utils.*;

public class proyectoprogramacion3 {

    private static ColaEnlazada<Serpiente> partidas;

    public static void main(String args[]) {

        final char SALIR = '5';

        String[] opt = {
            "1. Nueva partida",
            "2. Mostrar partidas",
            "3. Mejor puntaje",
            "4. Desencolar partida",
            "5. Salir"
        };

        Menu mnu = new Menu(opt, 'V', " ", "JUEGO SERPIENTE");
        char opc;

        do {
            Consola.clrscr();
            Consola.gotoxy(0, 0);

            opc = mnu.select("Su opción [1-5]: ");

            if (opc == '1') nuevaPartida();
            if (opc == '2') mostrarPartidas();
            if (opc == '3') mejorPuntaje();
            if (opc == '4') desencolarPartida();

        } while (opc != SALIR);
    }

    public static void nuevaPartida() {

        if (partidas == null)
            partidas = new ColaEnlazada<Serpiente>();

        Serpiente s = new Serpiente();
        s.iniciarJuego();

        partidas.encolar(s);

        Consola.println("Partida creada: " + s);
        Consola.pause();
    }

    public static void mostrarPartidas() {

        if (partidas == null || partidas.size() == 0) {
            Consola.println("No hay partidas");
        } else {
            Consola.println("Partidas:");
            Consola.println(partidas.toString());
        }

        Consola.pause();
    }

    public static void mejorPuntaje() {

        if (partidas == null || partidas.size() == 0) {
            Consola.println("No hay partidas");
            Consola.pause();
            return;
        }

        ColaEnlazada<Serpiente> copia = (ColaEnlazada<Serpiente>) partidas.clone();

        Serpiente mejor = copia.desencolar();

        while (copia.size() > 0) {
            Serpiente actual = copia.desencolar();

            if (actual.getPuntaje() > mejor.getPuntaje()) {
                mejor = actual;
            }
        }

        Consola.println("Mejor partida:");
        Consola.println(mejor);

        Consola.pause();
    }

    public static void desencolarPartida() {

        if (partidas == null || partidas.size() == 0) {
            Consola.println("No hay partidas");
        } else {
            Serpiente s = partidas.desencolar();
            Consola.println("Partida eliminada: " + s);
        }

        Consola.pause();
    }
}

