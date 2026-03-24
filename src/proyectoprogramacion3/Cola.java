
package proyectoprogramacion3;


public class Cola {
    private Nodo frente;
    private Nodo fin;

    public Cola() {
        frente = null;
        fin = null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void encolar(int x, int y) {
        Nodo nuevo = new Nodo(x, y);

        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    public void desencolar() {
        if (!estaVacia()) {
            frente = frente.getSiguiente();
        }
    }

    public Nodo getFrente() { return frente; 
    }
    public Nodo getFin() { return fin; 
    }
}
