package ar.edu.unlam.figuritas;

public abstract class Usuario {

    private String codigo;

    public Usuario(String codigo) {
        this.codigo=codigo;
    }



    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public abstract void agregarFiguritas(Figurita figus, BaseDeDatos baseDeDatos) throws FiguritaExistenteException;
}
