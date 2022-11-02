package ar.edu.unlam.figuritas;

import com.sun.org.apache.bcel.internal.generic.ATHROW;

public class UsuarioAdministrador extends Usuario{



    public UsuarioAdministrador(String codigo) {
        super(codigo);
    }


    @Override
    public void agregarFiguritas(Figurita figus, BaseDeDatos baseDeDatos) throws FiguritaExistenteException {
        if(baseDeDatos==null){
            baseDeDatos = new BaseDeDatos();
        }
        if(!baseDeDatos.yaExiste(figus)){
            baseDeDatos.agregarFiguritas(figus);
        }else{
            throw new FiguritaExistenteException("la figurita ya existe");
        }

    }


}
