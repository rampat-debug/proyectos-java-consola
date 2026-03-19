public class Enemigo {
    private Personaje personaje;
    private int derrotas, recompensa;
    public Enemigo(Personaje personaje, int recompensa) {
        this.personaje = personaje;
        this.derrotas = 0;
        this.recompensa = recompensa;
    }
    public Personaje getPersonaje() {
        return personaje;
    }
    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }
    public int getDerrotas() {
        return derrotas;
    }
    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }
    public int getRecompensa() {
        return recompensa;
    }
    public void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }
    @Override
    public String toString() {
        return "== ENEMIGO =="+"\nNombre: "+this.personaje.getNombre()+"\nATK: "+this.personaje.getAtk()+"\nDEF: "+this.personaje.getDef()+"\nHP: "+this.personaje.getHp();
    }
}
