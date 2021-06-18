package src.usuarios;

public class Usuario {
    private String nombre;
    private int puntuacion;
    private int partidasGanadas;
    private int partidasPerdidas;

    public Usuario(String nombre,int puntuacion,int partidasGanadas,int partidasPerdidas){
        this.nombre=nombre;
        this.puntuacion=puntuacion;
        this.partidasGanadas=partidasGanadas;
        this.partidasPerdidas=partidasPerdidas;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setPuntuacion(int puntuacion){
        this.puntuacion=puntuacion;
    }
    public void setPartidasGanadas(int partidasGanadas){
        this.partidasGanadas=partidasGanadas;
    }

    public void setPartidasPerdidas(int partidasPerdidas){
        this.partidasPerdidas=partidasPerdidas;
    }

    public String getNombre(){
        return nombre;
    }

    public int getPuntuacion(){
        return puntuacion;
    }

    public int getPartidasGanadas(){
        return partidasGanadas;
    }

    public int getPartidasPerdidas(){
        return partidasPerdidas;
    }

    public String getInformacion(){
        return "Nombre: "+nombre+". Puntuacion: "+puntuacion+". Partidas Ganadas: "+partidasGanadas+". Partidas Perdidas: "+partidasPerdidas;
    }
}
