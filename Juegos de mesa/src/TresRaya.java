import java.util.Scanner;
public class TresRaya{
    static int turnos = 8;
    final static char vacio = '_';
    final static char fichaX = 'X';
    final static char fichaO = 'O';
    static Scanner SC = new Scanner(System.in);
    static char [][] tablero = { {vacio, vacio, vacio},
                                 {vacio, vacio, vacio},
                                 {vacio, vacio, vacio} };
    public static void main(String[] args) {
        System.out.println("----- Empieza el juego -----");
        imprimirTablero();
        boolean ganar = false;
        while (turnos > 0 && ganar == false){
            if(turnos % 2 == 0){
                System.out.println("Turno del jugador : "+fichaX);
                ponerFicha(fichaX);
                imprimirTablero();
                ganar=comprobarGanar(fichaX);
            }
            else{
                System.out.println("Turno del jugador : "+fichaO);
                ponerFicha(fichaO);
                imprimirTablero();
                ganar=comprobarGanar(fichaO);
            }
            turnos--;
        }
    }
    private static void imprimirTablero(){
        for (int i=0;i<tablero.length; i++){
            for (int j=0;j<tablero[0].length; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void ponerFicha(char ficha){
        // pone la ficha en la posicion del tablero
        // si la fila no existe, se vuelve a pedir.
        // si la columna no existe, se vuelve a pedir
        // SI la posicion esta ocupada, te lo dice, y se vuelve a pedir.
        boolean ocupada = false;
        while (ocupada == false){
            System.out.print("Introduce la fila: ");
            int fila = SC.nextInt();
            while (fila > 3 || fila < 1){
                System.out.print("Fila incorrecta, por favor introduce una fila: ");
                fila = SC.nextInt();
            }
            System.out.print("Introduce la columna : ");
            int columna = SC.nextInt();
            while (columna > 3 || columna < 1){
                System.out.print("Columna incorrecta, por favor introduce una fila: ");
                columna = SC.nextInt();
            }
            if (tablero[fila-1][columna-1] == vacio){
                tablero[fila-1][columna-1] = ficha;
                ocupada = true;
            }
            else{
                System.out.println("Ya hay una ficha ahí");
            }   
        }
    }
    private static boolean comprobarGanar(char ficha){
        for(int i = 0; i < 3; i++){
            if(tablero[i][0] == ficha &&
            tablero[i][1] == ficha &&
            tablero[i][2] == ficha){
                return true;
            }
        }
        for(int j = 0; j < 3; j++){
            if(tablero[0][j] == ficha &&
            tablero[1][j] == ficha &&
            tablero[2][j] == ficha){
                return true;
            }
        }
        if(tablero[0][0] == ficha &&
        tablero[1][1] == ficha &&
        tablero[2][2] == ficha){
            return true;
        }
        if(tablero[0][2] == ficha &&
        tablero[1][1] == ficha &&
        tablero[2][0] == ficha){
            return true;
        }
        return false;
    }
}