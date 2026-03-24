
package proyectoprogramacion3;


public class Serpiente {
    private Cola cuerpo;
    private char direccion;

    public Serpiente() {
        cuerpo = new Cola();
        direccion = 'D';

        // cuerpo inicial (3 segmentos)
        cuerpo.encolar(3, 5);
        cuerpo.encolar(4, 5);
        cuerpo.encolar(5, 5);
    }

    public void mover() {
        Nodo cabeza = cuerpo.getFin();
        int x = cabeza.getX();
        int y = cabeza.getY();

        if (direccion == 'D') x++;
        else if (direccion == 'I') x--;
        else if (direccion == 'U') y--;
        else if (direccion == 'A') y++;

        cuerpo.encolar(x, y);
        cuerpo.desencolar();
    }

    public void crecer() {
        Nodo cabeza = cuerpo.getFin();
        cuerpo.encolar(cabeza.getX(), cabeza.getY());
    }

    public void cambiarDireccion(char d) {
        direccion = d;
    }

    public Nodo getCabeza() {
        return cuerpo.getFin();
    }

    public Cola getCuerpo() {
        return cuerpo;
    }

    public boolean colisionPropia() {
        Nodo cabeza = cuerpo.getFin();
        Nodo actual = cuerpo.getFrente();

        while (actual != null && actual.getSiguiente() != null) {
            if (actual.getX() == cabeza.getX() &&
                actual.getY() == cabeza.getY()) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
        }

