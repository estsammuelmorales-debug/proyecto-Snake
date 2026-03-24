
package proyectoprogramacion3;


public class Nodo {
    
    private int x;
    private int y;
    private Nodo siguiente;

    public Nodo(int x, int y) {
        this.x = x;
        this.y = y;
        this.siguiente = null;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public Nodo getSiguiente() { return siguiente; }
    public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; 
    }
}
