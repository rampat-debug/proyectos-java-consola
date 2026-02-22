import java.util.Scanner;

public class App {
    final static Scanner SC = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Tablero tablero=new Tablero(7, 8, 10);
        tablero.crearTablero();
        boolean ganar=false;
        while (ganar==false) {
            tablero.mostrarTablero();
            System.out.println("Movimientos disponibles");
            if (tablero.getJugador().getPosicion_y()-1 >= 0 && !tablero.getTablero()[tablero.getJugador().getPosicion_y()-1][tablero.getJugador().getPosicion_x()].isMuro()) {
                System.out.println("─ W");
            }
            if (tablero.getJugador().getPosicion_y()+1 < tablero.getFilas() && !tablero.getTablero()[tablero.getJugador().getPosicion_y()+1][tablero.getJugador().getPosicion_x()].isMuro()) {
                System.out.println("─ S");
            }
            if (tablero.getJugador().getPosicion_x()-1 >= 0 && !tablero.getTablero()[tablero.getJugador().getPosicion_y()][tablero.getJugador().getPosicion_x()-1].isMuro()) {
                System.out.println("─ A");
            }
            if (tablero.getJugador().getPosicion_x()+1 < tablero.getColumnas() && !tablero.getTablero()[tablero.getJugador().getPosicion_y()][tablero.getJugador().getPosicion_x()+1].isMuro()) {
                System.out.println("─ D");
            }
            String movimiento=SC.nextLine();
            switch (movimiento) {
                case "w":
                    if (tablero.getJugador().getPosicion_y()-1 >= 0 && !tablero.getTablero()[tablero.getJugador().getPosicion_y()-1][tablero.getJugador().getPosicion_x()].isMuro()) {
                        tablero.getJugador().irArriba();
                    }
                    break;
                case "s":
                    if (tablero.getJugador().getPosicion_y()+1 < tablero.getFilas() && !tablero.getTablero()[tablero.getJugador().getPosicion_y()+1][tablero.getJugador().getPosicion_x()].isMuro()) {
                        tablero.getJugador().irAbajo();
                    }
                    break;
                case "a":
                    if (tablero.getJugador().getPosicion_x()-1 >= 0 && !tablero.getTablero()[tablero.getJugador().getPosicion_y()][tablero.getJugador().getPosicion_x()-1].isMuro()) {
                        tablero.getJugador().irIzquierda();
                    }
                    break;
                case "d":
                    if (tablero.getJugador().getPosicion_x()+1 < tablero.getColumnas() && !tablero.getTablero()[tablero.getJugador().getPosicion_y()][tablero.getJugador().getPosicion_x()+1].isMuro()) {
                        tablero.getJugador().irDerecha();
                    }
                    break;
                default:
                    break;
            }
            if (tablero.getJugador().getPosicion_x()==tablero.getColumnas()-1 && tablero.getJugador().getPosicion_y()==tablero.getFilas()-1) {
                ganar=true;
                tablero.mostrarTablero();
            }
        }
    }
}
