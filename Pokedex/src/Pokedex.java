public class Pokedex {
    private Pokemon [] lista;

    public Pokedex(int n){
        this.lista = new Pokemon[n];
    }
    public Pokemon[] getLista() {
        return lista;
    }
    public void imprimirPokedex(){
        for(int i=0; i<this.lista.length;i++){
            if (this.lista[i]!=null) {
                System.out.println(this.lista[i]);
            }
            else{
                System.out.println("#"+(i+1)+" - ???");
            }
        }
    }
    public void añadirPokemon(Pokemon pokemon){
        int numero = pokemon.getNumero();
        if (numero>this.lista.length) {
            System.out.println("El número de Pokémon es inválido");
        }
        else{
            this.lista[(numero-1)]=pokemon;
        }
    }
    public boolean tengoTodos(){
        for(int i=0; i<this.lista.length;i++){
            if (this.lista[i]==null) {
                return false;
            }
        }
        return true;
    }
}
