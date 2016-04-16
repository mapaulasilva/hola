package uniandes.cupi2.ligaBolos.test;

import junit.framework.TestCase;
import uniandes.cupi2.ligaBolos.mundo.Jugador;

/**
 * Clase que verifica la correcta implementaci�n de la clase Jugador.
 */
public class JugadorTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------
    /**
     * Instancia de la clase Jugador sobre la que se har�n las pruebas
     */
    private Jugador jugador;

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------
    /**
     * Escenario 1. Construye un nuevo jugador.
     */
    public void setupEscenario1( )
    {
        String nombreEquipo = "Malaysia's Team";
        String nombreJugador = "Shalin Zulkifli";
        int partidasJugadas = 3;
        int totalPuntos = 505;
        boolean profesional = true;
        String rutaImagen = "data/imagenes/Shalin_Zulkifli.jpg";
        jugador = new Jugador( nombreEquipo, nombreJugador, partidasJugadas, totalPuntos, profesional, rutaImagen );
    }

    /**
     * Prueba 1: Prueba el m�todo constructor <br>
     * <b>M�todos a probar: </b> <br>
     * Jugador <br>
     * darNombreEquipo <br>
     * darNombreJugador <br>
     * darPartidasJugadas <br>
     * darTotalPuntos <br>
     * darRutaImagen <br>
     * esProfesional <br>
     * <b>Casos de prueba : </b> <br>
     * 1. El jugador se crea correctamente
     */
    public void testJugador( )
    {
        // Caso de prueba 1.
        setupEscenario1( );
        assertEquals( "No se inicializ� correctamente el nombre del equipo.", "Malaysia's Team", jugador.darNombreEquipo( ) );
        assertEquals( "No se inicializ� correctamente el nombre del jugador.", "Shalin Zulkifli", jugador.darNombreJugador( ) );
        assertEquals( "No se inicializ� correctamente la cantidad de partidas jugadas.", 3, jugador.darCantidadPartidasJugadas( ) );
        assertEquals( "No se inicializ� correctamente la cantidad de puntos totales.", 505, jugador.darTotalPuntos( ) );
        assertEquals( "No se inicializ� correctamente la ruta de la im.", "data/imagenes/Shalin_Zulkifli.jpg", jugador.darRutaImagen( ) );
        assertEquals( "No se inicializ� correctamente el nombre del jugador.", true, jugador.esProfesional( ) );

    }

    /**
     * Prueba 2: Prueba el m�todo agregarNuevoPuntaje <br>
     * <b>M�todos a probar: </b> <br>
     * agregarNuevoPuntaje <br>
     * darTotalPuntos <br>
     * darPartidasJugadas <br>
     * <b>Casos de prueba : </b> <br>
     * 1. Se agregan nuevos puntajes al jugador.
     */
    public void testAgregarNuevoPuntaje( )
    {
        // Caso de prueba 1.
        setupEscenario1( );
        jugador.agregarNuevoPuntaje( 250 );
        assertEquals( "No se modific� correctamente la cantidad total de puntos.", 755, jugador.darTotalPuntos( ) );
        assertEquals( "No se modific� correctamente la cantidad de partidas jugadas.", 4, jugador.darCantidadPartidasJugadas( ) );
    
        jugador.agregarNuevoPuntaje( 180 );
        jugador.agregarNuevoPuntaje( 200 );
        assertEquals( "No se modific� correctamente la cantidad total de puntos.", 1135, jugador.darTotalPuntos( ) );
        assertEquals( "No se modific� correctamente la cantidad de partidas jugadas.", 6, jugador.darCantidadPartidasJugadas( ) );
    }

    /**
     * Prueba 3: Prueba el m�todo darPromedioPuntos <br>
     * <b>M�todos a probar: </b> <br>
     * agregarNuevoPuntaje <br>
     * darPromedioPuntos <br>
     * darPartidasJugadas <br>
     * <b>Casos de prueba : </b> <br>
     * 1. El jugador tiene el puntaje inicial.
     * 2. Se agrega un nuevo puntaje al jugador
     */
    public void testDarPromedioPuntos( )
    {
        // Caso de prueba 1.
        setupEscenario1( );
        assertEquals( "No se calcul� correctamente el promedio inicial de puntos.", 168.0, jugador.darPromedioPuntos( ) );
        assertEquals( "No se modific� correctamente la cantidad inicial de partidas jugadas. se modific� correctamente la cantidad de partidas jugadas.", 3, jugador.darCantidadPartidasJugadas( ) );
       
        //Caso de prueba 2.
        jugador.agregarNuevoPuntaje( 250 );
        assertEquals( "No se calcul� correctamente el nuevo promedio de puntos.", 188.0, jugador.darPromedioPuntos( ) );
        assertEquals( "No se modific� correctamente la cantidad de partidas jugadas.", 4, jugador.darCantidadPartidasJugadas( ) );
        
        jugador.agregarNuevoPuntaje( 180 );
        jugador.agregarNuevoPuntaje( 200 );
        assertEquals( "No se calcul� correctamente el nuevo promedio de puntos.", 189.0, jugador.darPromedioPuntos( ) );
        assertEquals( "No se modific� correctamente la cantidad de partidas jugadas.", 6, jugador.darCantidadPartidasJugadas( ) );
    }

}
