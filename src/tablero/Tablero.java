package src.tablero;

public class Tablero {

    protected String[][] tablero;
    private static String espacio;
    private String ficha1 = " O ";
    private String ficha2 = " X ";
    private String colorBlanco; 
    private String colorNegro;
    private String colorDefault;
    private String colorLetraDefault;
   
    public Tablero(){
        this.tablero=new String[9][9];
        espacio = "   ";
        tablero[0][0]="   ";
        colorBlanco = "\u001B[47m";
        colorNegro= "\u001B[40m";
        colorDefault= "\u001B[10m";
        colorLetraDefault="\u001B[0m";
    }

    public static String getEspacio(){
        return espacio;
    }

    public String[][] getTablero() {
        return tablero;
    }

    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }

    public void imprimirTablero() {
        for(int i=1;i<9;i++){
            System.out.print(" "+tablero[0][i]);
        }
        System.out.println("");
        for (int i = 1; i < 9; i++) {
            System.out.print(tablero[i][0]+" ");
            for (int j = 1; j < 9; j++) {
                if ((i + j) % 2 == 0) {
                    
                    System.out.print(colorBlanco+tablero[i][j]+colorDefault+colorLetraDefault); 
                } else {
                    
                    System.out.print(colorNegro+tablero[i][j]+colorDefault+colorLetraDefault);   
                }
            }
            System.out.println(""+colorDefault);
        }
        
    }
    
    public void llenarTablero(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                tablero[j][0]=""+j;
                tablero[0][i]=" "+i;
                tablero[i][j]=espacio;
            }
        }
        imprimirTablero();
    }
}
