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
        simbolo1=" X ";
        simbolo2=" O ";
        letraBlanca = "\u001B[37m";
        colorLetraDefault="\u001B[0m";
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
                    this.tablero.getTablero()[i][j]=letraBlanca+simbolo1+colorLetraDefault;
                }
                if((i%2)==0 && (j%2)!=0){
                    this.tablero.getTablero()[i][j]=letraBlanca+simbolo1+colorLetraDefault;
                }
            }
        }

        for(int i=6;i<9;i++){
            for(int j=1;j<9;j++){
                if((i%2)==0 && (j%2)!=0){
                    this.tablero.getTablero()[i][j]=letraBlanca+simbolo2+colorLetraDefault;
                }
                if((i%2)!=0 && (j%2)==0){
                    this.tablero.getTablero()[i][j]=letraBlanca+simbolo2+colorLetraDefault;
                }
            }
        }
        this.tablero.imprimirTablero();
    }

    public void pedirPosicionDeCambio(Usuario jugador1, Usuario jugador2){
        int contador=0;
        while(contador<2){
            turnoJugador1(jugador1);
            this.tablero.imprimirTablero();
            turnoJugador2(jugador2);
            this.tablero.imprimirTablero();
            contador++;
        }
    }

    public void turnoJugador1(Usuario jugador1){
        boolean posicionVacia=true;
        do{
            System.out.println(jugador1.getNombre()+" Ingrese Posicion inicial en X");
            int posicionInicialX=scanner.nextInt();
            System.out.println(jugador1.getNombre()+" Ingrese Posicion inicial en Y:");
            int posicionInicialY=scanner.nextInt();
            if(this.tablero.getTablero()[posicionInicialX][posicionInicialY].equals(letraBlanca+simbolo1+colorLetraDefault)){
                if(this.tablero.getTablero()[posicionInicialX][posicionInicialY]!=Tablero.getEspacio()){
                    System.out.println(jugador1.getNombre()+" Ingrese Posicion final en X");
                    int posicionFinalX=scanner.nextInt();
                    System.out.println(jugador1.getNombre()+" Ingrese Posicion final en Y:");
                    int posicionFinalY=scanner.nextInt();
                    if(this.tablero.getTablero()[posicionFinalX][posicionFinalY].equals(Tablero.getEspacio())){
                        this.tablero.getTablero()[posicionFinalX][posicionFinalY]=this.tablero.getTablero()[posicionInicialX][posicionInicialY];
                        this.tablero.getTablero()[posicionInicialX][posicionInicialY]=Tablero.getEspacio();
                        posicionVacia=false;
                    
                    } else {
                        System.out.println("Coordenadas finales Incorrectas");
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

    public void turnoJugador2(Usuario jugador2){
        boolean posicionVacia=true;
        do{
            System.out.println(jugador2.getNombre()+" Ingrese Posicion inicial en X");
            int posicionInicialX=scanner.nextInt();
            System.out.println(jugador2.getNombre()+" Ingrese Posicion inicial en Y:");
            int posicionInicialY=scanner.nextInt();
            if(this.tablero.getTablero()[posicionInicialX][posicionInicialY].equals(letraBlanca+simbolo2+colorLetraDefault)){
                if(this.tablero.getTablero()[posicionInicialX][posicionInicialY]!=Tablero.getEspacio()){
                    System.out.println(jugador2.getNombre()+" Ingrese Posicion final en X");
                    int posicionFinalX=scanner.nextInt();
                    System.out.println(jugador2.getNombre()+" Ingrese Posicion final en Y:");
                    int posicionFinalY=scanner.nextInt();
                    if(this.tablero.getTablero()[posicionFinalX][posicionFinalY].equals(Tablero.getEspacio())){
                        this.tablero.getTablero()[posicionFinalX][posicionFinalY]=this.tablero.getTablero()[posicionInicialX][posicionInicialY];
                        this.tablero.getTablero()[posicionInicialX][posicionInicialY]=Tablero.getEspacio();
                        posicionVacia=false;
                    
                    } else {
                        System.out.println("Coordenadas finales Incorrectas");
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
}
