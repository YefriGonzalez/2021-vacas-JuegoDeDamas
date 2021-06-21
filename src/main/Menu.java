package src.main;
import java.util.Scanner;
import src.tablero.*;
import src.usuarios.PiedraPapelTijera;
import src.usuarios.VectorUsuarios;

public class Menu {
    VectorUsuarios vector1 = new VectorUsuarios();
    Tablero tablero = new Tablero();
    Scanner scanner=new Scanner(System.in);
    Ficha ficha = new Ficha(tablero);
    PiedraPapelTijera turno=new PiedraPapelTijera(ficha);

    public Menu() {

    }

    public void menuPrincipal() {
        tablero.llenarTablero();
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("------------Mini Damas------------------");
            System.out.println("1.Crear Usuario");
            System.out.println("2.Jugar");
            System.out.println("3.Ver Usuarios");
            System.out.println("4.Salir");
            System.out.print("Ingrese la opcion: ");
            opcion=scanner.nextInt();
            scanner.nextLine();
            if(opcion==1){
                vector1.ingresarUsuarios();
            } else if(opcion==2){
                int id1;
                int id2;
                if(VectorUsuarios.getUsuario()[0]!=null && VectorUsuarios.getUsuario()[1]!=null){
                    tablero.llenarTablero();
                    vector1.ordenarmientoUsuarios();
                    System.out.println("");
                    System.out.print("Ingrese Id del Primer jugador: ");
                    id1=scanner.nextInt();
                    System.out.print("Ingrese Id del Segundo jugador: ");
                    id2=scanner.nextInt();
                    turno.turnoJugador(id1, id2);
                } else {
                    System.out.println("\nNo hay usuarios Registrados para poder jugar\n");
                }
            } else if(opcion==3){
                vector1.ordenarmientoUsuarios();
            } else if(opcion==4){
                System.out.println("\n-------Adios--------");
            }

        }
    }
}