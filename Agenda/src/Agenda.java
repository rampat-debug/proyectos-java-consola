import java.util.Arrays;

public class Agenda {
    private Contacto [] lista_telefonica;
    private String mi_nombre;
    private long mi_numero;
    public Agenda(String nombre, long numero){
        this.mi_nombre = nombre;
        this.mi_numero = numero;
        this.lista_telefonica = new Contacto[0];
    }
    public void anadirContacto(Contacto contacto){
        Contacto [] lista_aux = new Contacto[this.lista_telefonica.length + 1];
        for (int i = 0; i < this.lista_telefonica.length; i++){
            lista_aux[i] = this.lista_telefonica[i];
        }
        lista_aux[this.lista_telefonica.length] = contacto;
        this.lista_telefonica = lista_aux;
    }
    public void verContactos(){  
        Arrays.sort(this.lista_telefonica);
        for (int i = 0; i < this.lista_telefonica.length; i++){
            System.out.println("Contacto : " + this.lista_telefonica[i]);
        }
    }
    @Override
    public String toString() {
        return "Nombre : "+this.mi_nombre+"\nNumero : "+this.mi_numero+"\nTotal de "+this.lista_telefonica.length +" contactos";
    }
    public void borrarContacto(String nombre, String apellido){
        Contacto [] nueva_lista = new Contacto[this.lista_telefonica.length - 1];
        boolean encontrado = false;
        for (int i = 0; i < this.lista_telefonica.length; i++){
            if(this.lista_telefonica[i].getNombre().equals(nombre)
            && this.lista_telefonica[i].getApellido().equals(apellido)
            ){
                encontrado = true;
            }
            else{
                if (encontrado == false){
                    nueva_lista[i] = this.lista_telefonica[i];
                }
                else{
                    nueva_lista[i-1] = this.lista_telefonica[i];
                }
            }
        }

    }
    public void buscarContacto(String nombre){ 
        for (int i = 0; i < this.lista_telefonica.length; i++){
            if(this.lista_telefonica[i].getNombre().equals(nombre)){
                System.out.println(this.lista_telefonica[i]);
            }
        }
    }
}