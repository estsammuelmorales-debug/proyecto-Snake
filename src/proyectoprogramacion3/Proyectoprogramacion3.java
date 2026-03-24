
package proyectoprogramacion3;


public class Proyectoprogramacion3 {

    
    public static void main(String[] args) {
        
        Tablero juego = new Tablero(10, 10);

        iniciarJuego(juego);
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
