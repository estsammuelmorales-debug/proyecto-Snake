package proyectoprogramacion3;

public class Serpiente {
    private Cola cuerpo;
    private char direccion;

    public Serpiente() {
        cuerpo = new Cola();
        direccion = 'D';
        
        cuerpo.encolar(3, 5);
        cuerpo.encolar(4, 5);
        cuerpo.encolar(5, 5);
    }

    public void mover(boolean comio) {
        Nodo cabeza = cuerpo.getFin();
        int x = cabeza.getX();
        int y = cabeza.getY();

        if (direccion == 'D') x++;
        else if (direccion == 'A') x--;
        else if (direccion == 'W') y--;
        else if (direccion == 'S') y++;

        cuerpo.encolar(x, y);

        if (!comio) {
        cuerpo.desencolar();
        }
    }

    public void cambiarDireccion(char nuevaDir) {
        if (nuevaDir == 'W' && direccion != 'S') direccion = 'W';
        else if (nuevaDir == 'S' && direccion != 'W') direccion = 'S';
        else if (nuevaDir == 'A' && direccion != 'D') direccion = 'A';
        else if (nuevaDir == 'D' && direccion != 'A') direccion = 'D';
    }

    public void crecer() {
        Nodo cabeza = cuerpo.getFin();
        cuerpo.encolar(cabeza.getX(), cabeza.getY());
    }

    public Cola getCuerpo() { return cuerpo; }
    public Nodo getCabeza() { return cuerpo.getFin(); }
    
    public boolean colisionPropia() {
        Nodo cabeza = cuerpo.getFin();
        Nodo actual = cuerpo.getFrente();
        
        while (actual != null && actual != cabeza) {
            if (actual.getX() == cabeza.getX() && actual.getY() == cabeza.getY()) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
}

