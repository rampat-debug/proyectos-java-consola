import java.util.Scanner;

public class App {
    final static Scanner SC = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Jugador j1 = new Jugador("YO");
        Jugador j2 = new Jugador("BOT");
        while (j1.getVictorias()<3 && j2.getVictorias()<3) {
            System.out.println("1. Piedra - 2. Papel - 3. Tijera");
            //se puede hacer con Jugada.valueOf("String");
            int jugada=SC.nextInt();
            j1.setMano(Jugada.values()[jugada-1]);
            j2.randomHand();
            Jugada mano1=j1.getMano();
            Jugada mano2=j2.getMano();
            System.out.println(j1.getNombre()+" ha sacado "+j1.getMano());
            System.out.println(j2.getNombre()+" ha sacado "+j2.getMano());
            //hacer logica piedra papel tijera
            if (mano1==mano2) {
                System.out.println("Empate");
            }
            else{
                if (mano1==Jugada.cuarzo) {
                    if (mano2==Jugada.navaja) {
                        j1.setVictorias(j1.getVictorias()+1);
                    }
                    else if (mano2==Jugada.papiro){
                        j2.setVictorias(j2.getVictorias()+1);
                    }
                }
                if (mano1==Jugada.papiro){
                    if (mano2==Jugada.cuarzo) {
                        j1.setVictorias(j1.getVictorias()+1);
                    }
                    else if (mano2==Jugada.navaja){
                        j2.setVictorias(j2.getVictorias()+1);
                    }
                }
                if (mano1==Jugada.navaja){
                    if (mano2==Jugada.papiro) {
                        j1.setVictorias(j1.getVictorias()+1);
                    }
                    else if (mano2==Jugada.cuarzo){
                        j2.setVictorias(j2.getVictorias()+1);
                    }
                }
            }
            System.out.println(j1.getNombre()+" : "+j1.getVictorias());
            System.out.println(j2.getNombre()+" : "+j2.getVictorias());
            if (j1.getVictorias()==3) {
                System.out.println("Has ganado. Felicidades");
            }
            if (j2.getVictorias()==3) {
                System.out.println("¿Como has perdido contra un BOT?");
            }
        }
    }
}
