package ar.edu.unlam.figuritas;

public class Figurita implements Comparable<Figurita>{

    private String codigo;
    private String grupo;
    private String seleccion;
    private String jugador;
    private Double valorJugador;


    public Figurita() {

    }


    //getters n' setters


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(String seleccion) {
        this.seleccion = seleccion;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public Double getValorJugador() {
        return valorJugador;
    }

    public void setValorJugador(Double valorJugador) {
        this.valorJugador = valorJugador;
    }


    //Constructor


    public Figurita(String codigo, String grupo, String seleccion, String jugador, Double valorJugador) {
        this.codigo = codigo;
        this.grupo = grupo;
        this.seleccion = seleccion;
        this.jugador = jugador;
        this.valorJugador = valorJugador;

    }

    @Override
    public boolean equals(Object obj) {
        Figurita figu = null;
        if(obj instanceof Figurita){
             figu = (Figurita)obj;
        }

        return this.getCodigo().equals(figu.getCodigo());
    }


    @Override
    public int compareTo(Figurita o) {
        return this.getCodigo().compareTo(o.getCodigo());
    }

    @Override
    public String toString() {
        return "codigo='" + codigo + '\'' +
                ", grupo='" + grupo + '\'' +
                ", seleccion='" + seleccion + '\'' +
                ", jugador='" + jugador + '\'' +
                ", valorJugador=" + valorJugador ;
    }
}
