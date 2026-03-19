import java.util.ArrayList;

public class Protagonista {
    private Personaje personaje;
    private int oro;
    private ArrayList<Item> bolsa = new ArrayList<>();
    private Item armadura;
    public Protagonista(Personaje personaje, Item armadura) {
        this.personaje = personaje;
        this.armadura = armadura;
        this.oro=0;
    }
    public ArrayList<Item> getBolsa() {
        return bolsa;
    }
    public void setBolsa(ArrayList<Item> bolsa) {
        this.bolsa = bolsa;
    }
    public Personaje getPersonaje() {
        return personaje;
    }
    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }
    public int getOro() {
        return oro;
    }
    public void setOro(int oro) {
        this.oro = oro;
    }
    public Item getArmadura() {
        return armadura;
    }
    public void setArmadura(Item armadura) {
        this.armadura = armadura;
    }
    public void añadirItem (Item item){
        if (this.bolsa.contains(item)) {
            System.out.println("Ese item ya esta en tu bolsa");
        }
        else{
            this.bolsa.add(item);
        }
    }
    public void ponerEquipo(Item item){
        setArmadura(item);
        this.personaje.setAtk(this.personaje.getAtk()+item.getAtk());
        this.personaje.setDef(this.personaje.getDef()+item.getDef());
        this.personaje.setHp(this.personaje.getHp()+item.getHp());
    }
    @Override
    public String toString() {
        return "== PROTAGONISTA =="+"\nNombre: "+this.personaje.getNombre()+"\nATK: "+this.personaje.getAtk()+"\nDEF: "+this.personaje.getDef()+"\nHP: "+this.personaje.getHp();
    }
}
