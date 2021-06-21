package src.tablero;
import java.util.Scanner;

import src.usuarios.*;

public class Ficha {
    Scanner scanner =new Scanner(System.in);
    private static String simbolo1;
    private static String simbolo2;
    private Tablero tablero;
    private String letraBlanca;
    private String colorLetraDefault;
    Ficha[] ficha=new Ficha[24];

    public Ficha(){

    }

    public Ficha(Tablero tablero){
        letraBlanca = "\u001B[37m";
        colorLetraDefault="\u001B[0m";
        simbolo1=letraBlanca+" X "+colorLetraDefault;
        simbolo2=letraBlanca+" O "+colorLetraDefault;
        this.tablero=tablero;
    }

    public static String getSimbolo1(){
        return simbolo1;
    }

    public static String getSimbolo2(){
        return simbolo2;
    }

    public void setTablero(Tablero tablero){
        this.tablero=tablero;
    }

    public Tablero getTablero(){
        return tablero;
    }

    public void colocarSimboloEnTablero(){
        for(int i=1;i<4;i++){
            for(int j=1;j<9;j++){
                if((i%2)!=0 && (j%2)==0){
                    this.tablero.getTablero()[i][j]=simbolo1;
                }
                if((i%2)==0 && (j%2)!=0){
                    this.tablero.getTablero()[i][j]=simbolo1;
                }
            }
        }

        for(int i=6;i<9;i++){
            for(int j=1;j<9;j++){
                if((i%2)==0 && (j%2)!=0){
                    this.tablero.getTablero()[i][j]=simbolo2;
                }
                if((i%2)!=0 && (j%2)==0){
                    this.tablero.getTablero()[i][j]=simbolo2;
                }
            }
        }
        this.tablero.imprimirTablero();
    }

    public void pedirPosicionDeCambio(Usuario jugador1, Usuario jugador2,String simbolo1,String simbolo2,int opcion){
        int contador=0;
        while(contador<3){
            if(opcion==1){
                turnoJugador1(jugador1,simbolo1,simbolo2);
                this.tablero.imprimirTablero();
                turnoJugador2(jugador2,simbolo2,simbolo1);
                this.tablero.imprimirTablero();
                contador++;
            } else if (opcion==2){
                turnoJugador2(jugador2,simbolo2,simbolo1);
                this.tablero.imprimirTablero();
                turnoJugador1(jugador1,simbolo1,simbolo2);
                this.tablero.imprimirTablero();
                contador++;
            }
        }
    }

    public void turnoJugador1(Usuario jugador1,String simbolo1,String simbolo2){
        boolean posicionVacia=true;
        boolean puedeComer=true;
        do{
            System.out.print(jugador1.getNombre()+" Ingrese Posicion inicial en Y: ");
            int posicionInicialY=scanner.nextInt();
            System.out.print(jugador1.getNombre()+" Ingrese Posicion inicial en X: ");
            int posicionInicialX=scanner.nextInt();
            if(this.tablero.getTablero()[posicionInicialY+1][posicionInicialX+1].equals(simbolo2) || this.tablero.getTablero()[posicionInicialY+1][posicionInicialX-1].equals(simbolo2)){
                if(this.tablero.getTablero()[posicionInicialY+2][posicionInicialX+2].equals(Tablero.getEspacio()) || this.tablero.getTablero()[posicionInicialY+2][posicionInicialX-2].equals(Tablero.getEspacio())){
                    puedeComer=true;
                    System.out.println("!!Hay posibilidades que puedas comer una ficha!!!!");
                    System.out.print(jugador1.getNombre()+" Ingrese Posicion final en Y: ");
                    int posicionFinalY=scanner.nextInt();
                    System.out.print(jugador1.getNombre()+" Ingrese Posicion final en X: ");
                    int posicionFinalX=scanner.nextInt();
                    if(posicionFinalY==posicionInicialY+2 && posicionFinalX==posicionInicialX+2 ){
                        this.tablero.getTablero()[posicionFinalY][posicionFinalX]=this.tablero.getTablero()[posicionInicialY][posicionInicialX];
                        this.tablero.getTablero()[posicionInicialY][posicionInicialX]=Tablero.getEspacio();
                        this.tablero.getTablero()[posicionInicialY+1][posicionInicialX+1]=Tablero.getEspacio();
                        posicionVacia=false;
                    } else if(posicionFinalY==posicionInicialY+2 && posicionFinalX==posicionInicialX-2){
                        this.tablero.getTablero()[posicionFinalY][posicionFinalX]=this.tablero.getTablero()[posicionInicialY][posicionInicialX];
                        this.tablero.getTablero()[posicionInicialY][posicionInicialX]=Tablero.getEspacio();
                        this.tablero.getTablero()[posicionInicialY+1][posicionInicialX-1]=Tablero.getEspacio();
                        posicionVacia=false;
                    } else {
                        this.tablero.imprimirTablero();
                    }
                }
            } else {
                puedeComer=false;
            }

            if(this.tablero.getTablero()[posicionInicialY][posicionInicialX].equals(simbolo1) && puedeComer==false){
                if(this.tablero.getTablero()[posicionInicialY][posicionInicialX]!=Tablero.getEspacio()){
                    System.out.print(jugador1.getNombre()+" Ingrese Posicion final en Y: ");
                    int posicionFinalY=scanner.nextInt();
                    System.out.print(jugador1.getNombre()+" Ingrese Posicion final en X: ");
                    int posicionFinalX=scanner.nextInt();
                    if(this.tablero.getTablero()[posicionFinalY][posicionFinalX].equals(Tablero.getEspacio()) && posicionFinalY>posicionInicialY && posicionFinalY<posicionInicialY+2 &&(posicionFinalX<posicionInicialX+2 && posicionFinalX>posicionInicialX-2)){
                        this.tablero.getTablero()[posicionFinalY][posicionFinalX]=this.tablero.getTablero()[posicionInicialY][posicionInicialX];
                        this.tablero.getTablero()[posicionInicialY][posicionInicialX]=Tablero.getEspacio();
                        posicionVacia=false;
                    
                    } else {
                        System.out.println("Movimiento no permitido");
                        this.tablero.imprimirTablero();
                    }
                } else {
                    System.out.println("Coordenas iniciales incorrectas");
                    this.tablero.imprimirTablero();
                }
            } else {
                System.out.println("Esta seleccionando la ficha incorrecta");
                this.tablero.imprimirTablero();
            }
        } while(posicionVacia!=false);
    }

    public void turnoJugador2(Usuario jugador2,String simbolo2,String simbolo1){
        boolean posicionVacia=true;
        boolean puedeComer=true;
        do{
            System.out.print(jugador2.getNombre()+" Ingrese Posicion inicial en X: ");
            int posicionInicialY=scanner.nextInt();
            System.out.print(jugador2.getNombre()+" Ingrese Posicion inicial en Y: ");
            int posicionInicialX=scanner.nextInt();
            if(this.tablero.getTablero()[posicionInicialY-1][posicionInicialX-1].equals(simbolo1) || this.tablero.getTablero()[posicionInicialY-1][posicionInicialX+1].equals(simbolo1)){
                if(this.tablero.getTablero()[posicionInicialY-2][posicionInicialX+2].equals(Tablero.getEspacio()) || this.tablero.getTablero()[posicionInicialY-2][posicionInicialX-2].equals(Tablero.getEspacio())){
                    puedeComer=true;
                    System.out.println("!!Hay posibilidades que puedas comer una ficha!!!!");
                    System.out.print(jugador2.getNombre()+" Ingrese Posicion final en Y: ");
                    int posicionFinalY=scanner.nextInt();
                    System.out.print(jugador2.getNombre()+" Ingrese Posicion final en X: ");
                    int posicionFinalX=scanner.nextInt();
                    if(posicionFinalY==posicionInicialY-2 && posicionFinalX==posicionInicialX+2 ){
                        this.tablero.getTablero()[posicionFinalY][posicionFinalX]=this.tablero.getTablero()[posicionInicialY][posicionInicialX];
                        this.tablero.getTablero()[posicionInicialY][posicionInicialX]=Tablero.getEspacio();
                        this.tablero.getTablero()[posicionInicialY-1][posicionInicialX+1]=Tablero.getEspacio();
                        posicionVacia=false;
                    } else if(posicionFinalY==posicionInicialY-2 && posicionFinalX==posicionInicialX-2){
                        this.tablero.getTablero()[posicionFinalY][posicionFinalX]=this.tablero.getTablero()[posicionInicialY][posicionInicialX];
                        this.tablero.getTablero()[posicionInicialY][posicionInicialX]=Tablero.getEspacio();
                        this.tablero.getTablero()[posicionInicialY-1][posicionInicialX-1]=Tablero.getEspacio();
                        posicionVacia=false;
                    } else {
                        this.tablero.imprimirTablero();
                    }
                }
            } else {
                puedeComer=false;
            }
            if(this.tablero.getTablero()[posicionInicialY][posicionInicialX].equals(simbolo2) && puedeComer==false){
                if(this.tablero.getTablero()[posicionInicialY][posicionInicialX]!=Tablero.getEspacio()){
                    System.out.print(jugador2.getNombre()+" Ingrese Posicion final en Y: ");
                    int posicionFinalY=scanner.nextInt();
                    System.out.print(jugador2.getNombre()+" Ingrese Posicion final en X: ");
                    int posicionFinalX=scanner.nextInt();
                    if(this.tablero.getTablero()[posicionFinalY][posicionFinalX].equals(Tablero.getEspacio())&& posicionFinalY<posicionInicialY && posicionFinalY>posicionInicialY-2 &&(posicionFinalX<posicionInicialX+2 && posicionFinalX>posicionInicialX-2)){
                        this.tablero.getTablero()[posicionFinalY][posicionFinalX]=this.tablero.getTablero()[posicionInicialY][posicionInicialX];
                        this.tablero.getTablero()[posicionInicialY][posicionInicialX]=Tablero.getEspacio();
                        posicionVacia=false;
                    
                    } else {
                        System.out.println("Movimiento no permitido");
                        this.tablero.imprimirTablero();
                    }
                } else {
                    System.out.println("Coordenas iniciales incorrectas");
                    this.tablero.imprimirTablero();
                }
            } else {
                System.out.println("Esta seleccionando la ficha incorrecta");
                this.tablero.imprimirTablero();
            }
        } while(posicionVacia!=false);
    }

    public boolean evaluarJugador1(String simbolo1){
        int contador=0;
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                if(!this.tablero.getTablero()[i][j].equals(simbolo1)){
                    contador++;
                }
            }
        }
        if(contador==16){
            return true;
        } else {
            return false;
        }
    }

    public boolean evaluarJugador2(String simbolo){
        int contador=0;
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                if(!this.tablero.getTablero()[i][j].equals(simbolo)){
                    contador++;
                }
            }
        } 
        if(contador==16){
            return true;
        } else{
            return false;
        }        
    }
}
