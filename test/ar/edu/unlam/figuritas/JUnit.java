package ar.edu.unlam.figuritas;

import org.junit.Test;

import static org.junit.Assert.*;

public class JUnit{

    @Test
    public void queSePuedaCrearUnaFigurita(){
        Figurita figus = new Figurita();
        figus.setCodigo("123");
        figus.setGrupo("A");
        figus.setSeleccion("Argentina");
        figus.setValorJugador(1000.2);
        figus.setJugador("Alberto Fernandez");


        assertNotNull(figus);
        assertEquals("123",figus.getCodigo());
        assertEquals("A",figus.getGrupo());
        assertEquals("Argentina",figus.getSeleccion());
        assertEquals(1000.2, figus.getValorJugador(),1);
        assertEquals("Alberto Fernandez", figus.getJugador());


    }

    @Test
    public void queSePuedaCrearUnAdministrador(){

        String codigo = "1234";
        UsuarioAdministrador uA = new UsuarioAdministrador(codigo);

        assertNotNull(uA);
        assertEquals(codigo,uA.getCodigo());
    }

    @Test
    public void queSePuedaCrearUnUsuarioFinal(){
        String codigo = "1234";

        UsuarioFinal jorgeAlberti = new UsuarioFinal(codigo);

        assertNotNull(jorgeAlberti);
        assertEquals(codigo, jorgeAlberti.getCodigo());
    }

    @Test
    public void administradorAgregaFigurita() throws FiguritaExistenteException {

        UsuarioAdministrador uA = new UsuarioAdministrador("1234");

        Figurita figus = new Figurita("123","A","Argentina","Alberto Fernandez",1000.2);

        BaseDeDatos baseDeDatos = new BaseDeDatos();

        uA.agregarFiguritas(figus, baseDeDatos);
        baseDeDatos.estaVacia();
        assertFalse(baseDeDatos.estaVacia());
        }

    @Test
    public void queUnUsuarioFinalPuedaAgregarUnaFigurita() throws FiguritaDuplicadaExcepction, FiguritaExistenteException {
        UsuarioAdministrador uA = new UsuarioAdministrador("1234");

        Figurita figus = new Figurita("123","A","Argentina","Alberto Fernandez",1000.2);

        BaseDeDatos baseDeDatos = new BaseDeDatos();

        UsuarioFinal uF = new UsuarioFinal("12345");

        uA.agregarFiguritas(figus, baseDeDatos);
        uF.agregarFiguritas(figus,baseDeDatos);

        assertFalse(uF.stockVacio());

    }

    @Test
    public void queLasFiguritasAgregadasDeFormaDesordenadaQuedenOrdenadas() throws FiguritaExistenteException {
        UsuarioAdministrador uA = new UsuarioAdministrador("1234");

        Figurita figus = new Figurita("123","A","Argentina","Alberto Fernandez",1000.2);
        Figurita figus2 = new Figurita("122","B","Brasil","Alberto Fernandez",1000.2);
        Figurita figus3 = new Figurita("121","C","Inglaterra","Alberto Fernandez",1000.2);

        BaseDeDatos baseDeDatos = new BaseDeDatos();

        uA.agregarFiguritas(figus, baseDeDatos);
        uA.agregarFiguritas(figus2, baseDeDatos);
        uA.agregarFiguritas(figus3, baseDeDatos);

        baseDeDatos.imprimirBase();
    }

    @Test
    public void queUnAdministradorNoPuedaAgregarUnaFiguritaExistente() throws FiguritaExistenteException {
        UsuarioAdministrador uA = new UsuarioAdministrador("1234");

        Figurita figus = new Figurita("123","A","Argentina","Alberto Fernandez",1000.2);

        BaseDeDatos baseDeDatos = new BaseDeDatos();

        uA.agregarFiguritas(figus, baseDeDatos);
        uA.agregarFiguritas(figus, baseDeDatos);

        assertEquals(1, baseDeDatos.tamañoBase());
    }

    @Test
    public void queUnUsuarioFinalSiPuedaAgregarFiguritasExistentes() throws FiguritaExistenteException {
        UsuarioAdministrador uA = new UsuarioAdministrador("1234");

        Figurita figus = new Figurita("123","A","Argentina","Alberto Fernandez",1000.2);

        BaseDeDatos baseDeDatos = new BaseDeDatos();

        UsuarioFinal uF = new UsuarioFinal("12345");

        uA.agregarFiguritas(figus, baseDeDatos);
        uF.agregarFiguritas(figus,baseDeDatos);
        uF.agregarFiguritas(figus,baseDeDatos);
        uF.agregarFiguritas(figus,baseDeDatos);
        uF.agregarFiguritas(figus,baseDeDatos);

        assertEquals(4, uF.stockTamaño());


    }

    @Test
    public void queUnUsuarioFinalPuedaPegarUnaFigurita() throws FiguritaExistenteException, FiguritaNoDisponibleException, FiguritaRepetidaException {
        UsuarioAdministrador uA = new UsuarioAdministrador("1234");

        Figurita figus = new Figurita("123","A","Argentina","Alberto Fernandez",1000.2);

        BaseDeDatos baseDeDatos = new BaseDeDatos();

        UsuarioFinal uF = new UsuarioFinal("12345");

        uA.agregarFiguritas(figus, baseDeDatos);
        uF.agregarFiguritas(figus,baseDeDatos);
        uF.agregarFiguritas(figus,baseDeDatos);

        uF.pegarFigurita(figus.getCodigo());

        assertTrue(uF.figuritaPegada(figus.getCodigo()));
    }

    @Test
    public void queUnUsuarioFinalNoPuedaPegarUnaFiguritaRepetida() throws FiguritaExistenteException, FiguritaNoDisponibleException, FiguritaRepetidaException {
        UsuarioAdministrador uA = new UsuarioAdministrador("1234");

        Figurita figus = new Figurita("123","A","Argentina","Alberto Fernandez",1000.2);

        BaseDeDatos baseDeDatos = new BaseDeDatos();

        UsuarioFinal uF = new UsuarioFinal("12345");

        uA.agregarFiguritas(figus, baseDeDatos);
        uF.agregarFiguritas(figus,baseDeDatos);
        uF.agregarFiguritas(figus,baseDeDatos);

        uF.pegarFigurita(figus.getCodigo());
        uF.pegarFigurita(figus.getCodigo());

        assertTrue(uF.figuritaPegada(figus.getCodigo()));
    }

    @Test
    public void queSePuedaRealizarElIntercambioDeFiguritasEntreDosUsuariosFinales() throws FiguritaExistenteException, FiguritaNoDisponibleException, FiguritaRepetidaException {
        UsuarioAdministrador uA = new UsuarioAdministrador("1234");

        Figurita figus = new Figurita("123","A","Argentina","Alberto Fernandez",1000.2);

        BaseDeDatos baseDeDatos = new BaseDeDatos();

        UsuarioFinal pedro = new UsuarioFinal("12345");
        UsuarioFinal rodrigo = new UsuarioFinal("2345");

        uA.agregarFiguritas(figus, baseDeDatos);
        pedro.agregarFiguritas(figus,baseDeDatos);

        int pedroSize = pedro.stockTamaño();
        int rodrigoSize = rodrigo.stockTamaño();


        pedro.intercambiarFiguritas(figus.getCodigo(),rodrigo);

        assertEquals(pedroSize-1,pedro.stockTamaño());

        assertEquals(rodrigoSize+1,rodrigo.stockTamaño());


    }

    @Test
    public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueNoLaTenga() throws FiguritaExistenteException, FiguritaNoDisponibleException {
        UsuarioAdministrador uA = new UsuarioAdministrador("1234");

        Figurita figus = new Figurita("123","A","Argentina","Alberto Fernandez",1000.2);

        BaseDeDatos baseDeDatos = new BaseDeDatos();

        UsuarioFinal pedro = new UsuarioFinal("12345");
        UsuarioFinal rodrigo = new UsuarioFinal("2345");

        uA.agregarFiguritas(figus, baseDeDatos);
        pedro.agregarFiguritas(figus,baseDeDatos);

        int pedroSize = pedro.stockTamaño();
        int rodrigoSize = rodrigo.stockTamaño();


        pedro.intercambiarFiguritas(figus.getCodigo(),rodrigo);
        pedro.intercambiarFiguritas(figus.getCodigo(),rodrigo);

    }

    @Test
    public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueYaLaHayaPegado() throws FiguritaNoDisponibleException, FiguritaExistenteException, FiguritaRepetidaException {
        UsuarioAdministrador uA = new UsuarioAdministrador("1234");

        Figurita figus = new Figurita("123","A","Argentina","Alberto Fernandez",1000.2);

        BaseDeDatos baseDeDatos = new BaseDeDatos();

        UsuarioFinal pedro = new UsuarioFinal("12345");
        UsuarioFinal rodrigo = new UsuarioFinal("2345");

        uA.agregarFiguritas(figus, baseDeDatos);
        pedro.agregarFiguritas(figus,baseDeDatos);
        pedro.pegarFigurita(figus.getCodigo());

        pedro.intercambiarFiguritas(figus.getCodigo(),rodrigo);
    }



}
