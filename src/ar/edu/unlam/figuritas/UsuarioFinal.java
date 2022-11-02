package ar.edu.unlam.figuritas;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UsuarioFinal extends Usuario{

    private List<Figurita> stock;
    private Set<Figurita> pegadas;

    public UsuarioFinal(String codigo) {
        super(codigo);
        this.stock = new ArrayList<Figurita>();
        this.pegadas = new TreeSet<Figurita>();
    }

    @Override
    public void agregarFiguritas(Figurita figus, BaseDeDatos baseDeDatos) {
        Figurita figu = baseDeDatos.buscarFigurita(figus.getCodigo());
        stockAgregar(figu);
    }

    private void stockAgregar(Figurita figu) {
        this.stock.add(figu);
    }

    public void intercambiarFiguritas(String codigo, UsuarioFinal persona) throws FiguritaNoDisponibleException {
        Figurita fEncontrada = stockBuscar(codigo);
        if(fEncontrada==null){
            throw new FiguritaNoDisponibleException("No cuenta con esta figurita para intercambiar");
        }
        if(figuritaPegada(codigo)){
            throw new FiguritaNoDisponibleException("Esta figurita ya fue pegada");
        }
        persona.stockAgregar(fEncontrada);
        this.stock.remove(fEncontrada);
    }

    public void pegarFigurita(String figu) throws FiguritaNoDisponibleException, FiguritaRepetidaException {
        Figurita figuEncontrada = stockBuscar(figu);
        if(figuEncontrada==null){
            throw new FiguritaNoDisponibleException("No tiene esta figurita para ser pegada");
        }
        if(figuritaPegada(figu)){
            throw new FiguritaRepetidaException("Esta figurita ya fue pegada");
        }
        this.pegadas.add(figuEncontrada);

    }

    public Boolean stockVacio(){
        return this.stock.isEmpty();
    }

    public int stockTamaño(){
        return this.stock.size();
    }

    public Figurita stockBuscar(String codigo){
        for (Figurita figu:this.stock
             ) {
            if(figu.getCodigo().equals(codigo)){
                return figu;
            }
        }
        return null;
    }

    public boolean figuritaPegada(String codigo){
        for (Figurita figu:this.pegadas
             ) {
            if(figu.getCodigo().equals(codigo)){
                return true;
            }
        }
        return false;
    }
}
