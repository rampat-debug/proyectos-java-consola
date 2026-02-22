import java.util.Scanner;

public class MasterMind {

    static int [] combinacion_ganadora = new int[4];
    static int intentos;
    static int [][] tabla_intentos;
    static int n_opciones;
    final static Scanner SC = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        System.out.println("¿Cuantas opciones quieres que haya?");
        System.out.print("1 - ");
        n_opciones = SC.nextInt();
        System.out.println("¿Cuantos intentos quieres tener?");
        intentos = SC.nextInt();
        tabla_intentos = new int[intentos][4];
        crearCombinacionGanadora();
        System.out.println();
        int turno = 0;
        boolean ganar = false;
        while (ganar == false && turno < intentos){
            anadirIntento(turno);
            ganar = comprobarTurno(turno);
            mostrarIntentos(turno); 
            turno++;
        }
        if (ganar == false){
            System.out.println("Has perdido");
            revelarCombinacionGanadora();
        }
        else {
            System.out.println("Has ganado");
        }
    }
    private static void crearCombinacionGanadora(){
        for (int i = 0; i < combinacion_ganadora.length; i++){
            combinacion_ganadora[i] = (int)(Math.random()*n_opciones + 1);
        }
    }
    private static void revelarCombinacionGanadora(){  
        System.out.print("La combinación ganadora es : ");
        for (int i = 0; i < combinacion_ganadora.length; i++){
            if (i != combinacion_ganadora.length - 1){
                System.out.print(combinacion_ganadora[i] + " - ");
            }
            else{
                System.out.print(combinacion_ganadora[i]);
            }
        }

    }
    private static void anadirIntento(int turno){
        System.out.println("Turno : " + (turno+1));
        for (int i = 0; i < tabla_intentos[0].length; i++){
            System.out.println("Introduce el valor de la posicion : " + (i+1));
            int v = SC.nextInt();
            while (v < 1 || v > n_opciones){
                System.out.println("Introduce el valor de la posicion : " + (i+1));
                v = SC.nextInt();
            }
            tabla_intentos[turno][i] = v;
        }
    }
    public static void mostrarIntentos(int intentos){
        for (int i = 0; i <= intentos; i++){
            System.out.print((i+1)+ " ---> ");
            for(int j = 0; j < tabla_intentos[0].length; j++){
                if (j != tabla_intentos[0].length - 1){
                    System.out.print(tabla_intentos[i][j] + " - ");
                }
                else{
                    System.out.print(tabla_intentos[i][j]);
                }            
            }
            System.out.println();
        }
    }
    private static boolean comprobarTurno(int turno){
        // devuelvo true si he ganado
        // sino, digo cuantos están bien y devuelvo false
        boolean victoria = false;
        int aciertos = 0;
        int fuera_posicion = 0;
        for (int i = 0; i < tabla_intentos[0].length; i++){
            for (int j = 0; j < combinacion_ganadora.length; j++){
                if (tabla_intentos[turno][i] == combinacion_ganadora[j]){                    
                    if (i == j){
                        aciertos++;
                    }
                    else{
                        fuera_posicion++;
                    }
                    break;
                }
            }
        }
        if (aciertos == 4){
            victoria = true;
        }
        else{
            System.out.println("Has acertado " + aciertos + " posiciones.");
            System.out.println("Hay " + fuera_posicion + " fuera de su posicion.");
        }
        return victoria;
    }
}
