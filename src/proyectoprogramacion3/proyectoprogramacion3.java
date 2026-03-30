import java.io.InputStreamReader;
import java.io.BufferedReader;
import proyectoprogramacion3.Tablero;

public class proyectoprogramacion3 {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opcion = 0;

        while (opcion != 6) {

            mostrarMenu();

            try {
                opcion = Integer.parseInt(br.readLine());
            } catch (Exception e) {
                opcion = 0;
            }

            ejecutarOpcion(opcion);
        }
    }

    public static void mostrarMenu() {
        System.out.println("===== GAME SNAKE =====");
        System.out.println("1. Nueva partida");
        System.out.println("2. Cargar partida");
        System.out.println("3. Top 10");
        System.out.println("4. Partidas jugadas");
        System.out.println("5. Jugadores");
        System.out.println("6. Terminar");
        System.out.print("Su opción [1-6]: ");
    }

    public static void ejecutarOpcion(int opcion) {

        switch (opcion) {

            case 1:
                Tablero juego = new Tablero(10, 10);
                iniciarJuego(juego);
                break;

            case 6:
                System.out.println("Saliendo...");
                break;

            default:
                System.out.println("No implementado aún");
        }
    }

    public static void iniciarJuego(Tablero juego) {

        int pasos = 0;
        boolean jugando = true;

        while (jugando) {

            actualizarDireccion(juego, pasos);

            juego.actualizar();

            limpiarPantalla();

            mostrarJuego(juego, pasos);

            if (juego.getEstado().equals("Perdiste")) {
                System.out.println("GAME OVER");
                jugando = false;
            }

            pasos++;

            pausar(300);
        }
    }

    public static void actualizarDireccion(Tablero juego, int pasos) {

        if (pasos == 5) juego.getSerpiente().cambiarDireccion('A');
        if (pasos == 10) juego.getSerpiente().cambiarDireccion('I');
        if (pasos == 15) juego.getSerpiente().cambiarDireccion('U');
        if (pasos == 20) juego.getSerpiente().cambiarDireccion('D');
    }

    public static void mostrarJuego(Tablero juego, int pasos) {
        System.out.println("Paso: " + pasos);
        System.out.println(juego.dibujar());
        System.out.println("-------------------------");
    }

    public static void pausar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (Exception e) {}
    }

    public static void limpiarPantalla() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}