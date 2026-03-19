import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.Scanner;

public class App {
    final static Scanner SC = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        Pelicula p1=new Pelicula("Avatar", "Yo", 237);
        Pelicula p2=new Pelicula("Killer bean", "Yo", 123);
        Pelicula p3=new Pelicula("Your name", "Yo", 93);
        peliculas.add(p3);
        peliculas.add(p2);
        peliculas.add(p1);
        ArrayList<Sesion> sesiones = new ArrayList<>();
        HashMap<String, ArrayList<Sesion>> cartelera = new HashMap<>();
        cartelera.put(p1.getNombre(), new ArrayList<>(sesiones));
        cartelera.put(p2.getNombre(), new ArrayList<>(sesiones));
        cartelera.put(p3.getNombre(), new ArrayList<>(sesiones));
        boolean seguir=true;
        while (seguir) {
            int opcion = excepcionesInt(menuCine(), 5, 1);
            SC.nextLine();
            switch (opcion) {
                case 1:
                    añadirPelicula(peliculas, cartelera);
                    break;
                case 2:
                    añadirSesion(cartelera, sesiones, peliculas);
                    break;
                case 3:
                    verPeliculasDisponibles(cartelera);
                    break;
                case 4:
                    comprarEntrada(cartelera, sesiones, peliculas);
                    break;
                case 5:
                    seguir=false;
                    break;
            }
        }
    }
    public static void verPeliculasDisponibles(HashMap<String, ArrayList<Sesion>> cartelera){
        for (Entry<String, ArrayList<Sesion>> aux : cartelera.entrySet()) {
            if (!aux.getValue().isEmpty()) {
                System.out.println(aux);
            }
        }
    }
    public static void comprarEntrada(HashMap<String, ArrayList<Sesion>> cartelera, ArrayList<Sesion> sesiones, ArrayList<Pelicula> peliculas){
        for(String aux : cartelera.keySet()){
            System.out.println(aux);
        }
        System.out.println("¿Que pelicula quieres ver?");
        String buscar=SC.nextLine();
        ArrayList<Sesion> listaSesiones = cartelera.get(buscar);
        if (listaSesiones!=null) {
            if (cartelera.containsKey(buscar)) {
                for(int i=0;i<listaSesiones.size();i++){
                    System.out.println((i+1)+".\n"+listaSesiones.get(i));
                }
                int decision=excepcionesInt("¿A que hora quieres ver la pelicula?", listaSesiones.size(), 1);
                listaSesiones.get(decision-1).quitarEntrada();
            }
            else{
                System.out.println("Esa sesion no esta registrada");
            }
        }
        else{
            System.out.println("No tenemos esa pelicula o la pelicula no tiene ninguna session");
        }
    }
    public static void añadirSesion(HashMap<String, ArrayList<Sesion>> cartelera, ArrayList<Sesion> sesiones, ArrayList<Pelicula> peliculas){
        for(String aux : cartelera.keySet()){
            System.out.println(aux);
        }
        System.out.println("¿A que pelicula quieres añadirle una sesion?");
        String buscar=SC.nextLine();
        if (cartelera.containsKey(buscar)) {
            Pelicula peliAux = null;
            for(int i=0;i<peliculas.size();i++){
                if (peliculas.get(i).getNombre().equals(buscar)) {
                    peliAux=peliculas.get(i);
                    break;
                }
            }
            int horaInicio=excepcionesInt("Hora de inicio: ", 23, 0);
            int entradasTotales=excepcionesInt("Entradas totales:", 999999999, 0);
            Sesion sesion = new Sesion(peliAux, horaInicio, entradasTotales);
            ArrayList<Sesion> listaSesiones = cartelera.get(buscar);
            boolean repetido=false;
            for(int i=0;i<listaSesiones.size();i++){
                if (listaSesiones.get(i).getHoraInicio() == horaInicio) {
                    repetido=true;
                    break;
                }
            }
            if (repetido==false) {
                listaSesiones.add(sesion);
                cartelera.put(buscar, listaSesiones);
            }
            else{
                System.out.println("Ya hay una sesion a esa hora");
            }
        }
        else{
            System.out.println("No tenemos esa pelicula en el cine");
        }
    }
    public static void añadirPelicula(ArrayList<Pelicula>peliculas, HashMap<String, ArrayList<Sesion>> cartelera){
        System.out.println("Nombre: ");
        String nombre=SC.nextLine();
        System.out.println("Director: ");
        String director=SC.nextLine();
        int duracion=excepcionesInt("Duracion (min): ", 999999999, 1);
        Pelicula peliculaNueva = new Pelicula(nombre, director, duracion);
        peliculas.add(peliculaNueva);
        cartelera.put(peliculaNueva.getNombre(), new ArrayList<>());
    }
    public static int excepcionesInt (String mensaje, int maximo, int minimo){
        int n=-1;
        boolean seguir = true;
        while (seguir) {
            try {
                System.out.println(mensaje);
                n=SC.nextInt();
                if (n<=maximo && n>=minimo) {
                    seguir=false;
                }
            } catch (InputMismatchException e) {
                SC.nextInt();
            }
        }
        return n;
    }
    public static String menuCine(){
        return "+--------------------------------+\n"
              +"|              CINE              |\n"
              +"+--------------------------------+\n"
              +"|  1. Añadir pelicula            |\n"
              +"|  2. Añadir sesion              |\n"
              +"|  3. Ver peliculas disponibles  |\n"
              +"|  4. Comprar entrada            |\n"
              +"|  5. Salir                      |\n"
              +"+--------------------------------+";
    }
}
