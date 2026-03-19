public class Item {
    private String nombre;
    private Tipo tipo;
    private int def, atk, precio, hp;
    public Item(String nombre, Tipo tipo, int def, int hp, int atk, int precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.def = def;
        this.hp = hp;
        this.atk = atk;
        this.precio = precio;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getDef() {
        return def;
    }
    public void setDef(int def) {
        this.def = def;
    }
    public int getAtk() {
        return atk;
    }
    public void setAtk(int atk) {
        this.atk = atk;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    @Override
    public boolean equals(Object obj) {
        Item item2 = (Item)obj;
        if (this.nombre.equals(item2.getNombre())) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "== ITEM =="+"\nNombre: "+this.getNombre()+"\nATK: "+this.getAtk()+"\nDEF: "+this.getDef()+"\nHP: "+this.getHp()+"\nPrecio: "+this.getPrecio();
    }
}
