package proyectoprogramacion3;

import java.io.*;

public class proyectoprogramacion3 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int opcion = 0;
        while (opcion != 4) {
            mostrarMenu();
            System.out.print("Eleccion: ");
            try {
                String linea = br.readLine();
                if (linea == null || linea.isEmpty()) continue;
                opcion = Integer.parseInt(linea);
                ejecutarOpcion(opcion);
            } catch (Exception e) {
                opcion = 0;
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("\n--- MENU SNAKE ---");
        System.out.println("1. Nueva Partida");
        System.out.println("2. Ver Records");
        System.out.println("3. Historial Jugadores");
        System.out.println("4. Salir");
    }

    public static void ejecutarOpcion(int opcion) throws Exception {
        switch (opcion) {
            case 1:
                System.out.print("Nombre del Jugador: ");
                String nombre = br.readLine();
                if (nombre.isEmpty()) nombre = "Anonimo";
                Tablero juego = new Tablero(10, 10);
                iniciarJuego(juego, nombre);
                break;
            case 2:
                mostrarArchivo("puntajes.txt", "TOP RECORDS");
                break;
            case 3:
                mostrarArchivo("jugadores.txt", "HISTORIAL");
                break;
        }
    }

    public static void iniciarJuego(Tablero tablero, String jugador) throws Exception {
        while (tablero.getEstado().equals("Jugando")) {
            System.out.println("\n" + tablero.dibujar());
            System.out.println("JUGADOR: " + jugador + " | PUNTOS: " + tablero.getPuntaje());
            System.out.print("Mover (W/A/S/D) | 'M' Menu: ");
            
            String entrada = br.readLine();
            if (entrada != null && !entrada.isEmpty()) {
                char tecla = entrada.toUpperCase().charAt(0);
                if (tecla == 'M') break;
                tablero.getSerpiente().cambiarDireccion(tecla);
            }
            tablero.actualizar();
        }

        if (tablero.getEstado().equals("Perdiste")) {
            System.out.println(tablero.dibujar());
            System.out.println("--- GAME OVER ---");
            guardarFinJuego(jugador, tablero.getPuntaje());
        }
    }
    

    public static void guardarFinJuego(String nombre, int puntos) {
        try {
            PrintWriter pw1 = new PrintWriter(new FileWriter("puntajes.txt", true));
            pw1.println(nombre + " - " + puntos + " pts");
            pw1.close();
            PrintWriter pw2 = new PrintWriter(new FileWriter("jugadores.txt", true));
            pw2.println(nombre);
            pw2.close();
        } catch (Exception e) { }
    }

    public static void mostrarArchivo(String archivo, String titulo) {
        System.out.println("\n--- " + titulo + " ---");
        try (BufferedReader r = new BufferedReader(new FileReader(archivo))) {
            String l;
            while ((l = r.readLine()) != null) System.out.println(l);
        } catch (Exception e) { System.out.println("Sin datos."); }
    }
}
