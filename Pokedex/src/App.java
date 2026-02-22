import java.util.Scanner;

public class App {
    final static Scanner SC = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Pokemon [] listaPokemons = new Pokemon[5];
        Pokemon pokemon1 = new Pokemon("Bulbasour", 1, "Planta/Veneno", false);
        Pokemon pokemon2 = new Pokemon("Charizar", 2, "Fuego/Volador", false);
        Pokemon pokemon3 = new Pokemon("Mewtow", 3, "Psíquico", false);
        Pokemon pokemon4 = new Pokemon("Eevee", 4, "Normal", false);
        Pokemon pokemon5 = new Pokemon("Greeninja", 5, "Agua/Siniestro", false);
        listaPokemons [0]=pokemon1;
        listaPokemons [1]=pokemon2;
        listaPokemons [2]=pokemon3;
        listaPokemons [3]=pokemon4;
        listaPokemons [4]=pokemon5;
        Pokedex pokedex = new Pokedex(5);
        boolean continuar = true;
        while (continuar==true) {
            System.out.println("+=================================+");
            System.out.println("|          POKEMON JAVA           |");
            System.out.println("+=================================+");
            System.out.println("|  1.- Ver pokedex                |");
            System.out.println("|  2.- Atrapar pokemon            |");
            System.out.println("|  3.- Salir                      |");
            System.out.println("+=================================+");
            int decision = SC.nextInt();
            switch (decision) {
                case 1:
                    pokedex.imprimirPokedex();
                    break;
                case 2:
                    int idPokemon=(int)(Math.random()*listaPokemons.length);
                    int pokebola=(int)(Math.random()*2+1);
                    System.out.println("Ha aparecido un "+listaPokemons[idPokemon].getNombre()+ " salvaje.");
                    if (pokedex.tengoTodos()==true) {
                        System.out.println("Has capturado a todos");
                        pokedex.imprimirPokedex();
                        continuar=false;
                    }
                    if (!listaPokemons[idPokemon].getCapturado()) {
                        System.out.print("Dime un numero (1-2) -> ");
                        int capturar=SC.nextInt();
                        if (pokebola==capturar) {
                            System.out.println("Has capturado un "+listaPokemons[idPokemon].getNombre()+ " salvaje.");
                            pokedex.añadirPokemon(listaPokemons[idPokemon]);
                            listaPokemons[idPokemon].setCapturado(true);
                        }
                        else{
                            System.out.println("El "+listaPokemons[idPokemon].getNombre()+" salvaje a escapado.");
                        }
                    }
                    else{
                        System.out.println("Ya tienes a "+listaPokemons[idPokemon].getNombre()+ " en la pokedex.");
                    }
                    break;
                case 3: continuar=false;
                    System.out.println("Tu progreso NO se ha guardado");
                    break;
            }
        }
    }
}
