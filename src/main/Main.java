package src.main;
import src.tablero.*;

public class Main {

    public static void main(String[] args){
        Tablero tablero=new Tablero();
        tablero.llenarTablero();
        Ficha ficha=new Ficha(tablero);
        ficha.colocarSimboloEnTablero();
        
    }
}
