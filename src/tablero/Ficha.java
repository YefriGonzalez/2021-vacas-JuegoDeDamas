package src.tablero;


public class Ficha {
    private String simbolo1;
    private String simbolo2;
    private Tablero tablero;
    private String letraBlanca;
    private String colorLetraDefault;
    public Ficha(Tablero tablero){
        simbolo1=" X ";
        simbolo2=" O ";
        letraBlanca = "\u001B[37m";
        colorLetraDefault="\u001B[0m";
        this.tablero=tablero;
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
        System.out.println("\n\n");
        this.tablero.imprimirTablero();
    }
}
