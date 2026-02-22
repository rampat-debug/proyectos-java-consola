public class Tablero {
    private Casilla [][] tablero;
    private int filas, columnas, n_muros;
    private Jugador jugador;
    public Tablero(int filas, int columnas, int n_muros) {
        this.filas = filas;
        this.columnas = columnas;
        this.n_muros = n_muros;
        this.tablero=new Casilla[filas][columnas];
        this.jugador=new Jugador(0, 0);
    }
    public int getFilas() {
        return filas;
    }
    public void setFilas(int filas) {
        this.filas = filas;
    }
    public int getColumnas() {
        return columnas;
    }
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    public Casilla[][] getTablero() {
        return tablero;
    }
    public void setTablero(final Casilla[][] tablero) {
        this.tablero = tablero;
    }
    public int getN_muros() {
        return n_muros;
    }
    public void setN_muros(final int n_muros) {
        this.n_muros = n_muros;
    }
    public Jugador getJugador() {
        return jugador;
    }
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    public void crearTablero(){
        for(int i=0;i<tablero.length;i++){
            for(int j=0;j<tablero[0].length;j++){
                tablero[i][j]=new Casilla(false, false, false);
            }
        }
        tablero[0][0].setInicio(true);
        tablero[this.filas-1][this.columnas-1].setFin(true);
        for(int i=0;i<n_muros;i++){
            int row=(int)(Math.random()*this.filas);
            int col=(int)(Math.random()*this.columnas);
            if (tablero[row][col]!=tablero[0][0] && tablero[row][col]!=tablero[this.filas-1][this.columnas-1]) {
                tablero[row][col].setMuro(true);
            }
        }
    }
    public void mostrarTablero(){
        for(int i=0;i<this.filas;i++){
            for(int j=0;j<this.columnas;j++){
                if (this.jugador.getPosicion_x()==j && this.jugador.getPosicion_y()==i) {
                    System.out.print("#|");
                }
                else{
                    System.out.print(tablero[i][j]+"|");
                }
            }
            System.out.println();
        }
    }
}
