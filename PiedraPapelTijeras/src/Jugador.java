public class Jugador {
    private Jugada mano;
    private String nombre;
    private int victorias;
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.victorias=0;
        this.mano=null;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getVictorias() {
        return victorias;
    }
    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }
    public void setMano(Jugada mano) {
        this.mano = mano;
    }
    public Jugada getMano() {
        return mano;
    }
    public void randomHand(){
        //Jugada [] arrayJugadas=Play.values();
        int n_jugadas=Jugada.values().length; //int n_jugadas=arrayJugadas.length;
        int random =  (int)(Math.random()*n_jugadas);
        Jugada jugada = Jugada.values()[random]; //Jugada jugadas=arrayJugadas[random];
        setMano(jugada); //this.hand=jugada;
    }
}
