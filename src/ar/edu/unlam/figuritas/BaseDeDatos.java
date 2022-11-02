package ar.edu.unlam.figuritas;

import java.util.Set;
import java.util.TreeSet;

public class BaseDeDatos {

    private Set<Figurita> base;

    public BaseDeDatos() {
        this.base = new TreeSet<Figurita>();
    }

    public void agregarFiguritas(Figurita figu){
        if(this.base==null){
            this.base = new TreeSet<Figurita>();
        }
        this.base.add(figu);
    }

    public Boolean estaVacia(){
        return this.base.isEmpty();
    }

    public Figurita buscarFigurita(String codigo){

        for (Figurita figu :this.base
             ) {
            if(figu.getCodigo().equals(codigo)){
                return figu;
            }
        }

        return null;
    }

    public void imprimirBase(){
        for (Figurita figu :this.base
        ) {
            System.out.println(figu.toString());

        }
    }

    public Boolean yaExiste(Figurita figu){
        return this.base.contains(figu);
    }

    public int tamañoBase(){
        return this.base.size();
    }
}
