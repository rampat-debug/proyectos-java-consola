public class Contacto implements Comparable<Contacto> {
    private String nombre, apellido, email;
    private long numero;
    public Contacto (String nombre, String apellido, String email, long numero){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.numero = numero;
    }
    public String getApellido() {
        return apellido;
    }
    public String getEmail() {
        return email;
    }
    public String getNombre() {
        return nombre;
    }
    public long getNumero() {
        return numero;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setNumero(long numero) {
        this.numero = numero;
    }
    @Override
    public String toString() {
        return this.nombre + " " + this.apellido + "\n" + this.numero + "\n" + this.email;
    }
    @Override
    public int compareTo(Contacto contacto2) {
        if (this.nombre.compareTo(contacto2.getNombre()) < 0){
            return -1;
        }
        else if (this.nombre.compareTo(contacto2.getNombre()) > 0){
            return +1;
        }
        else{
            return this.apellido.compareTo(contacto2.apellido);
        }
    }
}