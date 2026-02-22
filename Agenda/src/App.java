import java.util.Scanner;

public class App {

    static Scanner SC = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Agenda agenda = new Agenda("Argie", 926504629);
        Contacto contacto_1 = new Contacto("Nico", "Di Maria", "nico@DM.arg", 758457510);
        agenda.anadirContacto(contacto_1);
        boolean seguir = true;
        while (seguir) {
            System.out.println("+-------------------------------+");
            System.out.println("|             AGENDA            |");
            System.out.println("+-------------------------------+");
            System.out.println("|  1.- Añadir contacto          |");
            System.out.println("|  2.- Ver contactos ordenados  |"); // por nombre, y en caso de ser iguales por apellido
            System.out.println("|  3.- Buscar contacto          |"); // me pide un nombre y me muestra los contactos con ese nombre
            System.out.println("|  4.- Borrar contacto          |");
            System.out.println("|  5.- Ver mis datos            |"); // Mostrara mi nombre, mi numero y la cantidad de contactos guardados
            System.out.println("|  _ Salir                      |");
            System.out.println("+-------------------------------+");
            int opcion = SC.nextInt();
            SC.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Nombre: ");
                    String nom = SC.nextLine();
                    System.out.println("Apellido: ");
                    String ap = SC.nextLine();
                    System.out.println("Correo electrónico: ");
                    String email = SC.nextLine();
                    System.out.println("Número de teléfono: ");
                    long num = SC.nextLong();
                    SC.nextLine();
                    Contacto c_nuevo = new Contacto(nom, ap, email, num);
                    agenda.anadirContacto(c_nuevo);
                    break;
                case 2:
                    agenda.verContactos();
                    break;
                case 3:
                    System.out.println("Se va a buscar un contacto.");
                    System.out.println("Indica el nombre: ");
                    String nombreBuscar = SC.nextLine();
                    agenda.buscarContacto(nombreBuscar);
                break;
                case 4:
                    System.out.println("Se va a borrar un contacto.");
                    System.out.println("Indica el nombre: ");
                    String nombreBorrar = SC.nextLine();
                    System.out.println("Indica el apellido: ");
                    String apellidoBorrar = SC.nextLine();
                    agenda.borrarContacto(nombreBorrar, apellidoBorrar);
                break;
                case 5:
                    System.out.println(agenda);
                break;
                default: seguir = false;
                    break; 
            }
        }
    }
}
