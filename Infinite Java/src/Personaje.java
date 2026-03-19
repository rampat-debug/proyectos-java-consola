public class Personaje implements Comparable<Personaje>{
    private String nombre;
    private int atk, def, hp;
    public Personaje(String nombre, int atk, int def, int hp) {
        this.nombre = nombre;
        this.atk = atk;
        this.def = def;
        this.hp = hp;
    }
    public Personaje(Personaje otroPersonaje) {
        this.nombre = otroPersonaje.nombre;
        this.atk = otroPersonaje.atk;
        this.def = otroPersonaje.def;
        this.hp = otroPersonaje.hp;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getAtk() {
        return atk;
    }
    public void setAtk(int atk) {
        this.atk = atk;
    }
    public int getDef() {
        return def;
    }
    public void setDef(int def) {
        this.def = def;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    @Override
    public boolean equals(Object obj) {
        Personaje p2 = (Personaje)obj;
        if (this.nombre.equals(p2.getNombre())) {
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public int compareTo(Personaje o) {
        return this.nombre.compareTo(o.getNombre());
    }
    @Override
    public String toString() {
        return "== PERSONAJE =="+"\nNombre: "+this.getNombre()+"\nATK: "+this.getAtk()+"\nDEF: "+this.getDef()+"\nHP: "+this.getHp();
    }
}
