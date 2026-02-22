public class Jugador {
    int posicion_x, posicion_y;
    public Jugador(int posicion_x, int posicion_y) {
        this.posicion_x = posicion_x;
        this.posicion_y = posicion_y;
    }
    public int getPosicion_x() {
        return posicion_x;
    }
    public int getPosicion_y() {
        return posicion_y;
    }
    public void setPosicion_x(int posicion_x) {
        this.posicion_x = posicion_x;
    }
    public void setPosicion_y(int posicion_y) {
        this.posicion_y = posicion_y;
    }
    public void irDerecha(){
        this.posicion_x=posicion_x+1;
    }
    public void irIzquierda(){
        this.posicion_x=posicion_x-1;
    }
    public void irArriba(){
        this.posicion_y=posicion_y-1;
    }
    public void irAbajo(){
        this.posicion_y=posicion_y+1;
    }
}
