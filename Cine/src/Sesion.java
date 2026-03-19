public class Sesion {
    private Pelicula pelicula;
    private int horaInicio, entradasVendidas, entradasTotales;
    public Sesion(Pelicula pelicula, int horaInicio, int entradasTotales) {
        this.pelicula = pelicula;
        this.horaInicio = horaInicio;
        this.entradasTotales= entradasTotales;
        this.entradasVendidas=0;
    }
    public Pelicula getPelicula() {
        return pelicula;
    }
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
    public int getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }
    public int getEntradasVendidas() {
        return entradasVendidas;
    }
    public void setEntradasVendidas(int entradasVendidas) {
        this.entradasVendidas = entradasVendidas;
    }
    public int getEntradasTotales() {
        return entradasTotales;
    }
    public void setEntradasTotales(int entradasTotales) {
        this.entradasTotales = entradasTotales;
    }
    public void quitarEntrada(){
        if (this.entradasTotales>0) {
            this.entradasVendidas++;
            this.entradasTotales--;
            System.out.println("Has comprado una entrada");
        }
        else{
            System.out.println("No quedan entradas por vender");
        }
    }
    @Override
    public String toString() {
        return "Hora de inicio: "+this.horaInicio+"h\n"
              +"Entradas: "+this.entradasTotales;
    }
}
