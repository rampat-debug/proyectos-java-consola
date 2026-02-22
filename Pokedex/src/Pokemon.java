public class Pokemon {
    private String nombre, descripcion;
    private int numero;
    private boolean capturado;

    public Pokemon (String nombre, int numero, String descripcion, boolean capturado){
    this.nombre=nombre;
    this.numero=numero;
    this.descripcion=descripcion;
    this.capturado=capturado;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getNombre() {
        return nombre;
    }
    public int getNumero() {
        return numero;
    }
    public boolean getCapturado() {
        return capturado;
    }
    public void setCapturado(boolean capturado) {
        this.capturado = capturado;
    }
    @Override
    public String toString() {
        if (capturado==false) {
            return "#"+this.numero+" - ???";
        }
        else{
            return "#"+this.numero+" - "+this.nombre+" | Descrpción: "+this.descripcion;
        }
    }
}