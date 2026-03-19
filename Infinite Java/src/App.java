import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App  {
    final static Scanner SC = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Personaje npc1 = new Personaje("Guts", 35, 30, 300);
        Personaje npc2 = new Personaje("Kratos", 30, 28, 295);
        Personaje npc3 = new Personaje("Simon the Digger", 20, 50, 160);
        Personaje npc4 = new Personaje("Cafe", 22, 18, 270);
        Personaje npc5 = new Personaje("Bob el constructor", 50, 25, 200);
        Protagonista p1 = new Protagonista(npc1, null);
        Protagonista p2 = new Protagonista(npc2, null);
        Protagonista p3 = new Protagonista(npc3, null);
        Protagonista p4 = new Protagonista(npc4, null);
        Protagonista p5 = new Protagonista(npc5, null);
        ArrayList<Protagonista> protagonistas = new ArrayList<>();
        protagonistas.add(p1);
        protagonistas.add(p2);
        protagonistas.add(p3);
        protagonistas.add(p4);
        protagonistas.add(p5);
        Personaje npc6  = new Personaje("Bandido del Bosque", 14, 6, 80);
        Personaje npc7  = new Personaje("Guerrero Oscuro", 18, 10, 120);
        Personaje npc8  = new Personaje("Espectro de las catacumbas", 22, 14, 160);
        Personaje npc9  = new Personaje("Bestia de las montañas", 26, 18, 200);
        Personaje npc10 = new Personaje("Mago Corrupto", 28, 12, 180);
        Enemigo e1 = new Enemigo(npc6, 40);
        Enemigo e2 = new Enemigo(npc7, 80);
        Enemigo e3 = new Enemigo(npc8, 150);
        Enemigo e4 = new Enemigo(npc9, 200);
        Enemigo e5 = new Enemigo(npc10, 300);
        ArrayList<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(e1);
        enemigos.add(e2);
        enemigos.add(e3);
        enemigos.add(e4);
        enemigos.add(e5);
        ArrayList<Personaje> npc = new ArrayList<>();
        npc.add(npc1);
        npc.add(npc2);
        npc.add(npc3);
        npc.add(npc4);
        npc.add(npc5);
        npc.add(npc6);
        npc.add(npc7);
        npc.add(npc8);
        npc.add(npc9);
        npc.add(npc10);
        ArrayList<Item> items = new ArrayList<>();
        Item item1 = new Item("Poción de Vida Menor", Tipo.CURATIVO, 0, 25, 0, 10);
        Item item2 = new Item("Elixir de Eärendil", Tipo.CURATIVO, 0, 100, 0, 50);
        Item item3 = new Item("Botas de Mithril", Tipo.ARMADURA, 5, 0, 0, 100);
        Item item4 = new Item("Yelmo de Hierro", Tipo.ARMADURA, 10, 0, 0, 80);
        Item item5 = new Item("Andúril (Espada)", Tipo.ARMADURA, 2, 0, 20, 500);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        boolean seguir=true;
        while (seguir==true) {
            int decision = excepcionesInt("+------------------------------+\n|         Infinite Java        |\n+------------------------------+\n|  1. Editar lista personajes  |\n|  2. Editar lista items       |\n|  3. Crear perosnaje          |\n|  4. Crear item               |\n|  5. Jugar                    |\n|  6. Salir                    |\n+------------------------------+\nOpcion: ", 6, 1);
            switch (decision) {
                case 1:
                    editarPersonajes(npc);
                    break;
                case 2:
                    editarItem(items);
                    break;
                case 3:
                    crearPersonaje(protagonistas, npc, enemigos);
                    break;
                case 4:
                    crearItem(items);
                    break;
                case 5:
                    Protagonista protagonista;
                    for(int i=0;i<protagonistas.size();i++){
                        System.out.println((i+1)+". "+protagonistas.get(i));
                        System.out.println();
                    }
                    int elgir_protagonista=excepcionesInt("Opcion: ", 999999999, 1);
                    if (elgir_protagonista>protagonistas.size()) {
                        protagonista=protagonistas.get((int)(Math.random()*protagonistas.size()));
                    }
                    else{
                        protagonista=protagonistas.get(elgir_protagonista-1);
                    }
                    dificultad(protagonista, items);
                    boolean vivo=true;
                    int rondas=1;
                    while (vivo) {
                        System.out.println("== RONDA: "+rondas+" ==");
                        ArrayList<Enemigo> cantidad_enemigos = generarEnemigosEscalados(enemigos, rondas);
                        int cantidad = (int)(Math.random()*3+1);
                        for(int i=0;i<cantidad;i++){
                            int enemigo_aleatorio = (int)(Math.random()*enemigos.size());
                            Enemigo modelo=enemigos.get(enemigo_aleatorio);
                            Personaje copiaEnemigo=new Personaje(modelo.getPersonaje());
                            Enemigo enemmigoCombate = new Enemigo(copiaEnemigo, modelo.getRecompensa());
                            cantidad_enemigos.add(enemmigoCombate);
                        }
                        boolean combate=true;
                        while (combate) {
                            for(int i=0;i<cantidad_enemigos.size();i++){
                                System.out.println((i+1)+". "+cantidad_enemigos.get(i));
                                System.out.println();
                            }
                            System.out.println("== COMBATE ==");
                            System.out.println("Tu vida: "+protagonista.getPersonaje().getHp());
                            int menu_combate=excepcionesInt("1. Atacar\t2. Bolsa\t3, Huir\nOpcion: ", 3, 1);
                            switch (menu_combate) {
                                case 1:
                                    int elegir_enemigo = excepcionesInt("Que enemigo quieres atacar: ", cantidad_enemigos.size(), 1);
                                    if (cantidad_enemigos.get(elegir_enemigo-1).getPersonaje().getHp()>0) {
                                        quitarVida(protagonista, cantidad_enemigos, elegir_enemigo);
                                        if (cantidad_enemigos.get(elegir_enemigo-1).getPersonaje().getHp()<=0) {
                                            cantidad_enemigos.get(elegir_enemigo-1).getPersonaje().setHp(0);
                                        }
                                        enemigoAtacar(protagonista, cantidad_enemigos);
                                    }
                                    else{
                                        System.out.println("¿Quieres atacar un cadaver?");
                                    }
                                    break;
                                case 2:
                                    usarObjeto(protagonista);
                                    if (protagonista.getBolsa().size()>0) {
                                        enemigoAtacar(protagonista, cantidad_enemigos);
                                    }
                                    break;
                                case 3:
                                    if (protagonista.getOro()>0) {
                                        System.out.println("Mientras huias, se te cayeron la mitad de tus monedas");
                                        protagonista.setOro(protagonista.getOro()/2);
                                        combate=false;
                                    }
                                    else{
                                        System.out.println("No puedes huir");
                                        enemigoAtacar(protagonista, cantidad_enemigos);
                                    }
                                    break;
                            }
                            boolean todosMuertos = true;
                            for (int i = 0; i < cantidad_enemigos.size(); i++) {
                                if (cantidad_enemigos.get(i).getPersonaje().getHp() > 0) {
                                    todosMuertos = false;
                                    break;
                                }
                            }
                            if (todosMuertos) {
                                for(int i=0;i<cantidad_enemigos.size();i++){
                                    protagonista.setOro(protagonista.getOro()+cantidad_enemigos.get(i).getRecompensa());
                                }
                                combate = false;
                            }
                            if (protagonista.getPersonaje().getHp() <= 0) {
                                System.out.println("Has caido");
                                combate = false;
                                vivo = false;
                                seguir = false;
                            }
                        }
                        if (protagonista.getPersonaje().getHp()>0) {
                            subirStatsJugador(protagonista, rondas);
                            ArrayList<Item> curativos = new ArrayList<>();
                            ArrayList<Item> armadura = new ArrayList<>();
                            for(int i=0;i<items.size();i++){
                                if (items.get(i).getTipo()==Tipo.CURATIVO) {
                                    curativos.add(items.get(i));
                                }
                                else{
                                    armadura.add(items.get(i));
                                }
                            }
                            Item objeto1 = curativos.get((int)(Math.random()*curativos.size()));
                            Item objeto2 = curativos.get((int)(Math.random()*curativos.size()));
                            Item objeto3 = armadura.get((int)(Math.random()*armadura.size()));
                            boolean comprar=true;
                            while (comprar) {
                                int tienda=excepcionesInt("+--------------------------+\n|   Buffer de suministros  |\n+--------------------------+\n   1. "+objeto1+"\n   2. "+objeto2+"\n   3."+objeto3+"\n   4. Salir\n+--------------------------+\nTu oro: "+protagonista.getOro()+"\nOpcion: ", 4, 1);
                                switch (tienda) {
                                    case 1:
                                        if (protagonista.getOro()>=objeto1.getPrecio()) {
                                            protagonista.añadirItem(objeto1);
                                            protagonista.setOro(protagonista.getOro()-objeto1.getPrecio());
                                        }
                                        else{
                                            System.out.println("No tienes hora suficiente");
                                        }
                                        break;
                                    case 2:
                                        if (protagonista.getOro()>=objeto2.getPrecio()) {
                                            protagonista.añadirItem(objeto2);
                                            protagonista.setOro(protagonista.getOro()-objeto2.getPrecio());
                                        }
                                        else{
                                            System.out.println("No tienes hora suficiente");
                                        }
                                        break;
                                    case 3:
                                        if (protagonista.getOro()>=objeto3.getPrecio()) {
                                            protagonista.ponerEquipo(objeto3);
                                            protagonista.setOro(protagonista.getOro()-objeto3.getPrecio());
                                        }
                                        else{
                                            System.out.println("No tienes hora suficiente");
                                        }
                                        break;
                                    case 4:
                                        comprar=false;
                                        break;
                                }
                            }
                        }
                        rondas++;
                    }
                    break;
                case 6:
                    seguir=false;
                    break;
            }
        }
    }
    private static ArrayList<Enemigo> generarEnemigosEscalados(ArrayList<Enemigo> enemigos, int ronda) {
    ArrayList<Enemigo> encuentro = new ArrayList<>();
    int num = (int)(Math.random() * 3) + 1;
    double escala = 1 + (ronda - 1) * 0.08; 
    for (int i = 0; i < num; i++) {
        Enemigo modelo = enemigos.get((int)(Math.random() * enemigos.size()));
        Personaje pEscalado = new Personaje(modelo.getPersonaje());
        pEscalado.setAtk((int)(pEscalado.getAtk() * (1 + (ronda-1) * 0.05)));
        pEscalado.setHp((int)(pEscalado.getHp() * (1 + (ronda-1) * 0.10)));
        pEscalado.setDef((int)(pEscalado.getDef() * escala));
        int recompensaEscalada = (int)(modelo.getRecompensa() * escala);
        encuentro.add(new Enemigo(pEscalado, recompensaEscalada));
    }
    return encuentro;
    }
    private static void subirStatsJugador(Protagonista protagonista, int ronda) {
        System.out.println("¡Subes de nivel! +50 HP recuperado, +5 ATK, +3 DEF");
        protagonista.getPersonaje().setHp(protagonista.getPersonaje().getHp() + 50);
        protagonista.getPersonaje().setAtk(protagonista.getPersonaje().getAtk() + 5);
        protagonista.getPersonaje().setDef(protagonista.getPersonaje().getDef() + 3);
    }
    public static void quitarVida(Protagonista protagonista, ArrayList<Enemigo> enemigos, int elegir_enemigo){
        int probabilidadCritico = (int)(Math.random()*100);
        int variacionDaño = (int)(Math.random()*5);
        int daño=protagonista.getPersonaje().getAtk()-enemigos.get(elegir_enemigo-1).getPersonaje().getDef();
        if (daño<0) {
            daño=0;
        }
        int dañoTotal=daño+variacionDaño;
        if (probabilidadCritico<75) {
            enemigos.get(elegir_enemigo-1).getPersonaje().setHp(enemigos.get(elegir_enemigo-1).getPersonaje().getHp()-dañoTotal);
            System.out.println("Has inflingido "+daño+" de daño a "+enemigos.get(elegir_enemigo-1).getPersonaje().getNombre());
        }
        else{
            enemigos.get(elegir_enemigo-1).getPersonaje().setHp(enemigos.get(elegir_enemigo-1).getPersonaje().getHp()-dañoTotal*2);
            System.out.println("Has inflingido un golpe critico y has hecho "+daño*2+" de daño a "+enemigos.get(elegir_enemigo-1).getPersonaje().getNombre());
        }
    }
    public static void enemigoAtacar (Protagonista protagonista, ArrayList<Enemigo> enemigos){
        for(int i=0;i<enemigos.size();i++){
            if (enemigos.get(i).getPersonaje().getHp()>0) {
                int daño=enemigos.get(i).getPersonaje().getAtk()-protagonista.getPersonaje().getDef();
                if (daño<0) {
                    daño=0;
                }
                protagonista.getPersonaje().setHp(protagonista.getPersonaje().getHp()-daño);
                System.out.println(enemigos.get(i).getPersonaje().getNombre()+" te ha hecho "+daño+" de daño");
            }
        }
    }
    public static Protagonista usarObjeto (Protagonista protagonista){
        if (protagonista.getBolsa().size()==0) {
            System.out.println("No tienes ningun objeto en la bolsa");
        }
        else{
            for(int i=0;i<protagonista.getBolsa().size();i++){
                System.out.println((i+1)+". "+protagonista.getBolsa().get(i));
            }
            System.out.println("Que objeto quieres usar: ");
            int decision=excepcionesInt("Que objeto quieres usar: ", protagonista.getBolsa().size(), 1);
            protagonista.getPersonaje().setHp(protagonista.getPersonaje().getHp()+protagonista.getBolsa().get(decision-1).getHp());
            protagonista.getBolsa().remove(decision-1);
        }
        return protagonista;
    }
    public static ArrayList<Personaje> editarPersonajes(ArrayList<Personaje> personajes){
        int opcion=excepcionesInt("Quieres eliminar o modificar\n1. Eliminar\n2. Modificar\nOpcion: ", 2, 1);
        switch (opcion) {
            case 1:
                if (personajes.size()>0) {
                    for(int i=0;i<personajes.size();i++){
                        System.out.println((i+1)+". "+personajes.get(i));
                    }
                    int eliminar=excepcionesInt("Que personaje quieres eliminar: ", personajes.size(), 1);
                    personajes.remove(eliminar-1);
                }
                else {
                    System.out.println("No tienes ningun personaje creado");
                }
                break;
            case 2:
                for(int i=0;i<personajes.size();i++){
                    System.out.println((i+1)+". "+personajes.get(i));
                }
                if (personajes.size()>0) {
                    int decision=excepcionesInt("Que personaje quieres modificar: ", personajes.size(), 1);
                    SC.nextLine();
                    Personaje modificarPersonaje=personajes.get(decision-1);
                    System.out.println("Nombre: ");
                    String nombre=SC.nextLine();
                    int atk=excepcionesInt("Ataque: ", 999999999, 1);
                    int def=excepcionesInt("Defensa: ", 999999999, 1);
                    int hp=excepcionesInt("Vida: ", 999999999, 1);
                    modificarPersonaje.setNombre(nombre);
                    modificarPersonaje.setAtk(atk);
                    modificarPersonaje.setDef(def);
                    modificarPersonaje.setHp(hp);
                }
                else {
                    System.out.println("No tienes ningun personaje creado");
                }
                break;
        }
        return personajes;
    }
    public static int excepcionesInt(String mensaje, int maximo, int minimo){
        int numero=-1;
        boolean seguir=true;
        while (seguir) {
            try {
                System.out.println(mensaje);
                numero=SC.nextInt();
                if (numero<=maximo && numero>=minimo) {
                    seguir=false;
                }
            } catch (InputMismatchException e) {
                SC.nextLine();
            }
        }
        return numero;
    }
    public static ArrayList<Item> editarItem(ArrayList<Item> items){
        int opcion=excepcionesInt("Quieres eliminar o modificar\n1. Eliminar\n2. Modificar\nOpcion: ", 2, 1);
        switch (opcion) {
            case 1:
                int curativos=0;
                int armaduras=0;
                if (items.size()>0) {
                    for(int i=0;i<items.size();i++){
                        System.out.println((i+1)+". "+items.get(i));
                        System.out.println();
                        if (items.get(i).getTipo()==Tipo.CURATIVO) {
                            curativos++;
                        }
                        else{
                            armaduras++;
                        }
                    }
                    System.out.println("Que objeto quieres eliminar: ");
                    int eliminar=excepcionesInt("Que objeto quieres eliminar: ", items.size(), 1);
                    if ((items.get(eliminar-1).getTipo()==Tipo.CURATIVO && curativos>=2) || (items.get(eliminar-1).getTipo()==Tipo.ARMADURA && armaduras>=2)) {
                        items.remove(eliminar-1);
                    }
                }
                else {
                    System.out.println("No tienes ningun item creado");
                }
                break;
            case 2:
                if (items.size()>0) {
                    for(int i=0;i<items.size();i++){
                        System.out.println((i+1)+". "+items.get(i));
                        System.out.println();
                    }
                    int decision=excepcionesInt("Que objeto quieres modificar: ", items.size(), 1);
                    SC.nextLine();
                    System.out.println("Nombre: ");
                    String nombre=SC.nextLine();
                    int atk=excepcionesInt("Ataque: ", 999999999, 1);
                    int def=excepcionesInt("Defensa: ", 999999999, 1);
                    int hp=excepcionesInt("Vida: ", 999999999, 1);
                    Item modificarObjeto=items.get(decision-1);
                    modificarObjeto.setNombre(nombre);
                    modificarObjeto.setAtk(atk);
                    modificarObjeto.setDef(def);
                    modificarObjeto.setHp(hp);
                }
                else {
                    System.out.println("No tienes ningun item creado");
                }
                break;
        }
        return items;
    }
    public static void crearPersonaje(ArrayList<Protagonista> protagonistas, ArrayList<Personaje> personajes, ArrayList<Enemigo> enemigos){
        SC.nextLine();
        System.out.println("Nombre: ");
        String nombre=SC.nextLine();
        int atk=excepcionesInt("Ataque: ", 999999999, 1);
        int def=excepcionesInt("Defensa: ", 999999999, 1);
        int hp=excepcionesInt("Vida: ", 999999999, 1);
        Personaje nuevo_personaje = new Personaje(nombre, atk, def, hp);
        if (personajes.contains(nuevo_personaje)==true) {
            System.out.println("Ese personaje ya esta en el rooster");
        }
        else{
            personajes.add(nuevo_personaje);
            int decision=excepcionesInt("El personaje va a ser protagonista o enemigo\n1. Protagonista\n2. Enemigo\nOpcion: ", 2, 1);
            switch (decision) {
                case 1:
                    Protagonista nuevo_protagonista = new Protagonista(nuevo_personaje, null);
                    protagonistas.add(nuevo_protagonista);
                    System.out.println("Se ha creado el nuevo protagonista");
                    break;
                case 2:
                    System.out.println("Cuanto oro dara el enemigo: ");
                    int oro=excepcionesInt("Cuanto oro dara el enemigo\nCantidad: ", 999999999, 1);
                    Enemigo nuevo_enemigo = new Enemigo(nuevo_personaje, oro);
                    enemigos.add(nuevo_enemigo);
                    System.out.println("Se ha creado el nuevo enemigo");
                    break;
            }
        }
        
    }
    public static void crearItem(ArrayList<Item> items){
        SC.nextLine();
        System.out.println("Nombre: ");
        String nombre=SC.nextLine();
        int atk=excepcionesInt("Ataque: ", 999999999, 1);
        int def=excepcionesInt("Defensa: ", 999999999, 1);
        int hp=excepcionesInt("Vida: ", 999999999, 1);
        Item nuevo_item = new Item(nombre, null, def, hp, atk, hp);
        if (items.contains(nuevo_item)==true) {
            System.out.println("Ese item ya esta en el rooster");
        }
        else{
            int decision=excepcionesInt("El item va a ser un item curativo o equipable\n1. Curativo\n2. Equipable\nOpcion: ", 2, 1);
            switch (decision) {
                case 1:
                    nuevo_item.setTipo(Tipo.CURATIVO);
                    items.add(nuevo_item);
                    System.out.println("Se ha creado el nuevo item curativo");
                    break;
                case 2:
                    nuevo_item.setTipo(Tipo.ARMADURA);
                    items.add(nuevo_item);
                    System.out.println("Se ha creado el nuevo item equipable");
                    break;
            }
        }
    }
    public static Protagonista dificultad(Protagonista protagonista, ArrayList<Item> items){
        int decision = excepcionesInt("Elige la dificultad\n1. Facil\n2. Dificil\nOpcion: ", 2, 1);
        switch (decision) {
            case 1:
                int equipable_random=(int)(Math.random()*items.size());
                while (items.get(equipable_random).getTipo()!=Tipo.ARMADURA) {
                    equipable_random=(int)(Math.random()*items.size());
                    if (items.get(equipable_random).getTipo()==Tipo.ARMADURA) {
                        protagonista.setArmadura(items.get(equipable_random));
                        protagonista.ponerEquipo(items.get(equipable_random));
                    }
                }
                protagonista.setOro(20);
                System.out.println("Buena suerte, la vas a necesitar");
                break;
            case 2:
                System.out.println("Buena suerte, la vas a necesitar");
                break;
        }
        return protagonista;
    }
}
