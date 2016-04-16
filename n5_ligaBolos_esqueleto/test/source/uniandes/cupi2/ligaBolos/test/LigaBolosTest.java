package uniandes.cupi2.ligaBolos.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import uniandes.cupi2.ligaBolos.mundo.Jugador;
import uniandes.cupi2.ligaBolos.mundo.LigaBolos;
import junit.framework.TestCase;

/**
 * Clase utilizada para verificar la correcta implementación de la clase LigaBolos
 */
public class LigaBolosTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Liga de Bolos sobre la que se realizarán las pruebas.
     */
    private LigaBolos ligaBolos;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Escenario 1. Construye una nueva liga de bolos con la información contenida en un archivo de propiedades.
     */
    public void setupEscenario1( )
    {
        try
        {
            ligaBolos = new LigaBolos( );
        }
        catch( Exception e )
        {
            fail( "no deberia presentarse ninguna excepción" );
        }
    }

    /**
     * Prueba 1: Prueba el método constructor <br>
     * <b>Métodos a probar: </b> <br>
     * ligaBolos <br>
     * darCantidadJugadores <br>
     * darNombreEquipo <br>
     * darNombreJugador <br>
     * darPartidasJugadas <br>
     * darTotalPuntos <br>
     * darRutaImagen <br>
     * esProfesional <br>
     * <b>Casos de prueba : </b> <br>
     * 1. Se crea la liga de bolos correctamente.
     */
    public void testLigaBolos( )
    {
        setupEscenario1( );
        assertEquals( "El número de jugadores no es correcto.", 6, ligaBolos.darCantidadJugadores( ) );

        try
        {
            Jugador actual = ligaBolos.darJugadorActual( );
            Properties persistencia = new Properties( );
            FileInputStream fis = null;
            fis = new FileInputStream( new File( "data/ligaBolos.data" ) );
            persistencia.load( fis );
            fis.close( );

            for( int i = 1; i < 7; i++ )
            {
                String prefijo = "liga.jugador" + i + ".";
                assertNotNull( "El jugador no deberia ser nulo", actual );
                assertEquals( "El nombre del equipo del jugador " + i + " es correcto.", persistencia.getProperty( prefijo + "nombreEquipo" ), actual.darNombreEquipo( ) );
                assertEquals( "El nombre del jugador " + i + " no es correcto.", persistencia.getProperty( prefijo + "nombreJugador" ), actual.darNombreJugador( ) );
                assertEquals( "La cantidad de partidas jugadas por el jugador " + i + " no corresponde a la correcta.", Integer.parseInt( persistencia.getProperty( prefijo + "partidas" ) ), actual.darCantidadPartidasJugadas( ) );
                assertEquals( "La cantidad de puntos totales del jugador " + i + " no es correcta.", Integer.parseInt( persistencia.getProperty( prefijo + "totalPuntos" ) ), actual.darTotalPuntos( ) );
                assertEquals( "El atributo que indica si el jugador " + i + " es profesional no es correcto.", Boolean.parseBoolean( persistencia.getProperty( prefijo + "profesional" ) ), actual.esProfesional( ) );
                assertEquals( "La ruta de la imagen del jugador " + i + " no es correcta.", persistencia.getProperty( prefijo + "imagen" ), actual.darRutaImagen( ) );

                if( i != 6 )
                {
                    actual = ligaBolos.darSiguienteJugador( );
                }
            }
        }
        catch( Exception e )
        {
            fail( "No se debería generar el error: " + e.getMessage( ) + "." );
        }

    }

    /**
     * Prueba 2: Prueba el método darJugadorActual<br>
     * <b>Métodos a probar: </b> <br>
     * darJugadorActual <br>
     * darCantidadJugadores <br>
     * darNombreEquipo <br>
     * darNombreJugador <br>
     * darPartidasJugadas <br>
     * darTotalPuntos <br>
     * darRutaImagen <br>
     * esProfesional <br>
     * <b>Casos de prueba : </b> <br>
     * 1. El jugador actual es el primer jugador<br>
     * 2. El jugador actual es el cuarto jugador<br>
     * */
    public void testDarJugadorActual( )
    {
        setupEscenario1( );

        try
        {
            // Caso de prueba 1.
            Jugador actual = ligaBolos.darJugadorActual( );

            assertEquals( "El nombre de equipo del jugador actual no es correcto", "USBC Masters", actual.darNombreEquipo( ) );
            assertEquals( "El nombre del jugador actual no es correcto.", "Carolier Lanes", actual.darNombreJugador( ) );
            assertEquals( "La cantidad de partidas del jugador actual no es correcta.", 2, actual.darCantidadPartidasJugadas( ) );
            assertEquals( "La cantidad total de puntos del jugador actual no es correcta", 200, actual.darTotalPuntos( ) );
            assertEquals( "El indicador 'profesional' no es correcto para el jugador actual", false, actual.esProfesional( ) );
            assertEquals( "La ruta de la imagen del jugador actual no es correcta", "data/imagenes/Carolier_Lanes.jpg", actual.darRutaImagen( ) );

            // Caso de prueba 2.
            actual = ligaBolos.darSiguienteJugador( );
            actual = ligaBolos.darSiguienteJugador( );
            actual = ligaBolos.darSiguienteJugador( );

            assertEquals( "El nombre de equipo del jugador actual no es correcto", "Australia Team", actual.darNombreEquipo( ) );
            assertEquals( "El nombre del jugador actual no es correcto.", "Jason Belmonte", actual.darNombreJugador( ) );
            assertEquals( "La cantidad de partidas del jugador actual no es correcta.", 10, actual.darCantidadPartidasJugadas( ) );
            assertEquals( "La cantidad total de puntos del jugador actual no es correcta", 1250, actual.darTotalPuntos( ) );
            assertEquals( "El indicador 'profesional' no es correcto para el jugador actual", false, actual.esProfesional( ) );
            assertEquals( "La ruta de la imagen del jugador actual no es correcta", "data/imagenes/Jason_Belmonte.jpg", actual.darRutaImagen( ) );
        }
        catch( Exception e )
        {
            fail( "No se debería generar el error: " + e.getMessage( ) + "." );
        }

    }

    /**
     * Prueba 3: Prueba el método darSiguienteJugador<br>
     * <b>Métodos a probar: </b> <br>
     * darSiguienteJugador <br>
     * darCantidadJugadores <br>
     * darNombreEquipo <br>
     * darNombreJugador <br>
     * darPartidasJugadas <br>
     * darTotalPuntos <br>
     * darRutaImagen <br>
     * esProfesional <br>
     * <b>Casos de prueba : </b> <br>
     * 1. El jugador actual no es el último jugador. <br>
     * 2. El jugador actual es el último jugador.
     */
    public void testDarSiguienteJugador( )
    {
        // Caso de prueba 1.
        setupEscenario1( );
        try
        {
            Jugador actual = ligaBolos.darSiguienteJugador( );

            assertEquals( "El nombre de equipo del jugador no es correcto.", "Team USA", actual.darNombreEquipo( ) );
            assertEquals( "El nombre del jugador no es correcto.", "Mike Fagan", actual.darNombreJugador( ) );
            assertEquals( "La cantidad de partidas del jugador no es correcta.", 5, actual.darCantidadPartidasJugadas( ) );
            assertEquals( "La cantidad total de puntos del jugador no es correcta.", 890, actual.darTotalPuntos( ) );
            assertEquals( "El jugador debería ser profesional.", true, actual.esProfesional( ) );
            assertEquals( "La ruta de la imagen del jugador  no es correcta", "data/imagenes/Mike_Fagan.jpg", actual.darRutaImagen( ) );
            assertEquals( "No se actualizó el jugador actual.", "Mike Fagan", ligaBolos.darJugadorActual( ).darNombreJugador( ) );

            actual = ligaBolos.darSiguienteJugador( );
            actual = ligaBolos.darSiguienteJugador( );

            assertEquals( "El nombre de equipo del jugador no es correcto.", "Australia Team", actual.darNombreEquipo( ) );
            assertEquals( "El nombre del jugador no es correcto.", "Jason Belmonte", actual.darNombreJugador( ) );
            assertEquals( "La cantidad de partidas del jugador no es correcta.", 10, actual.darCantidadPartidasJugadas( ) );
            assertEquals( "La cantidad total de puntos del jugador no es correcta.", 1250, actual.darTotalPuntos( ) );
            assertEquals( "Eljugador no debería ser profesional.", false, actual.esProfesional( ) );
            assertEquals( "La ruta de la imagen del jugador actual no es correcta.", "data/imagenes/Jason_Belmonte.jpg", actual.darRutaImagen( ) );
            assertEquals( "No se actualizó el jugador actual.", "Jason Belmonte", ligaBolos.darJugadorActual( ).darNombreJugador( ) );
        }
        catch( Exception e )
        {
            fail( "No se debería generar el error: " + e.getMessage( ) + "." );
        }

        // Caso de prueba 2.
        setupEscenario1( );
        try
        {
            ligaBolos.darUltimoJugador( );
            ligaBolos.darSiguienteJugador( );
            fail( "Debería generar excepción. Ya se encuentra en el último jugador" );

        }
        catch( Exception e )
        {

            // Debe pasar por aquí
        }
    }

    /**
     * Prueba 4: Prueba el método darAnteriorJugador<br>
     * <b>Métodos a probar: </b> <br>
     * darAnteriorJugador <br>
     * darCantidadJugadores <br>
     * darNombreEquipo <br>
     * darNombreJugador <br>
     * darPartidasJugadas <br>
     * darTotalPuntos <br>
     * darRutaImagen <br>
     * esProfesional <br>
     * <b>Casos de prueba : </b> <br>
     * 1. El jugador actual no es el primer jugador.<br>
     * 2. El jugador actual es el primer jugador.<br>
     */
    public void testDarAnteriorJugador( )
    {
        // Caso de prueba 1.
        setupEscenario1( );
        try
        {
            Jugador actual = ligaBolos.darUltimoJugador( );

            actual = ligaBolos.darAnteriorJugador( );
            assertEquals( "El nombre de equipo del jugador no es correcto.", "Malaysia's Team", actual.darNombreEquipo( ) );
            assertEquals( "El nombre del jugador no es correcto.", "Sin Li", actual.darNombreJugador( ) );
            assertEquals( "La cantidad de partidas del jugador no es correcta.", 6, actual.darCantidadPartidasJugadas( ) );
            assertEquals( "La cantidad total de puntos del jugador no es correcta.", 2300, actual.darTotalPuntos( ) );
            assertEquals( "El jugador debería ser profesional.", true, actual.esProfesional( ) );
            assertEquals( "La ruta de la imagen del jugador no es correcta.", "data/imagenes/Sin_Li.jpg", actual.darRutaImagen( ) );
            assertEquals( "No se actualizó el jugador actual.", "Sin Li", ligaBolos.darJugadorActual( ).darNombreJugador( ) );

            actual = ligaBolos.darAnteriorJugador( );
            actual = ligaBolos.darAnteriorJugador( );
            actual = ligaBolos.darAnteriorJugador( );

            assertEquals( "El nombre de equipo del jugador no es correcto.", "Team USA", actual.darNombreEquipo( ) );
            assertEquals( "El nombre del jugador no es correcto.", "Mike Fagan", actual.darNombreJugador( ) );
            assertEquals( "La cantidad de partidas del jugador no es correcta.", 5, actual.darCantidadPartidasJugadas( ) );
            assertEquals( "La cantidad total de puntos del jugador no es correcta.", 890, actual.darTotalPuntos( ) );
            assertEquals( "El jugador debería ser profesional.", true, actual.esProfesional( ) );
            assertEquals( "La ruta de la imagen del jugador no es correcta.", "data/imagenes/Mike_Fagan.jpg", actual.darRutaImagen( ) );
            assertEquals( "No se actualizó el jugador actual", "Mike Fagan", ligaBolos.darJugadorActual( ).darNombreJugador( ) );

        }
        catch( Exception e )
        {
            fail( "No se debería generar el error: " + e.getMessage( ) + "." );
        }

        // Caso de prueba 2.
        setupEscenario1( );
        try
        {
            ligaBolos.darPrimerJugador( );
            ligaBolos.darAnteriorJugador( );
            fail( "Debería generar excepción. Ya se encuentra en el primer jugador" );

        }
        catch( Exception e )
        {
            // Debe pasar por este punto
        }
    }

    /**
     * Prueba 5: Prueba el método darPrimerJugador<br>
     * <b>Métodos a probar: </b> <br>
     * darPrimerJugador <br>
     * darCantidadJugadores <br>
     * darNombreEquipo <br>
     * darNombreJugador <br>
     * darPartidasJugadas <br>
     * darTotalPuntos <br>
     * darRutaImagen <br>
     * esProfesional <br>
     * <b>Casos de prueba : </b> <br>
     * 1. El jugador actual no es el primer jugador.<br>
     * 2. El jugador actual es el primer jugador.
     */
    public void testDarPrimerJugador( )
    {
        // Caso de prueba 1.
        setupEscenario1( );
        try
        {
            ligaBolos.darUltimoJugador( );
            Jugador actual = ligaBolos.darPrimerJugador( );

            assertEquals( "El nombre de equipo del jugador no es correcto.", "USBC Masters", actual.darNombreEquipo( ) );
            assertEquals( "El nombre del jugador no es correcto.", "Carolier Lanes", actual.darNombreJugador( ) );
            assertEquals( "La cantidad de partidas del jugador no es correcta.", 2, actual.darCantidadPartidasJugadas( ) );
            assertEquals( "La cantidad total de puntos del jugador no es correcta.", 200, actual.darTotalPuntos( ) );
            assertEquals( "El jugador no debería ser profesional.", false, actual.esProfesional( ) );
            assertEquals( "La ruta de la imagen del jugador actual no es correcta.", "data/imagenes/Carolier_Lanes.jpg", actual.darRutaImagen( ) );
            assertEquals( "No se actualizó el jugador actual.", "Carolier Lanes", ligaBolos.darJugadorActual( ).darNombreJugador( ) );
        }
        catch( Exception e )
        {
            fail( "No se debería generar el error: " + e.getMessage( ) + "." );
        }

        // Caso de prueba 2.
        setupEscenario1( );
        try
        {
            // ligaBolos.darPrimerJugador( );
            ligaBolos.darPrimerJugador( );
            fail( "Debería generar excepción. Ya se encuentra en el primer jugador." );

        }
        catch( Exception e )
        {
            // Debe pasar por este punto
        }
    }

    /**
     * Prueba 6: Prueba el método darUltimoJugador<br>
     * <b>Métodos a probar: </b> <br>
     * darUltimoJugador <br>
     * darCantidadJugadores <br>
     * darNombreEquipo <br>
     * darNombreJugador <br>
     * darPartidasJugadas <br>
     * darTotalPuntos <br>
     * darRutaImagen <br>
     * esProfesional <br>
     * <b>Casos de prueba : </b> <br>
     * 1. El jugador actual no es el último jugador<br>
     * 2. El jugador actual es el último jugador.
     */
    public void testDarUltimoJugador( )
    {
        // Caso de prueba 1.
        setupEscenario1( );
        try
        {
            Jugador actual = ligaBolos.darUltimoJugador( );

            assertEquals( "El nombre de equipo del jugador no es correcto", "Team USA", actual.darNombreEquipo( ) );
            assertEquals( "El nombre del jugador no es correcto.", "Shannon Pluhowsky", actual.darNombreJugador( ) );
            assertEquals( "La cantidad de partidas del jugador no es correcta.", 8, actual.darCantidadPartidasJugadas( ) );
            assertEquals( "La cantidad total de puntos del jugador no es correcta", 1000, actual.darTotalPuntos( ) );
            assertEquals( "El jugador no debería ser profesional.", false, actual.esProfesional( ) );
            assertEquals( "La ruta de la imagen del jugador no es correcta.", "data/imagenes/Shannon_Pluhowsky.jpg", actual.darRutaImagen( ) );
            assertEquals( "No se actualizó el jugador actual.", "Shannon Pluhowsky", ligaBolos.darJugadorActual( ).darNombreJugador( ) );

        }
        catch( Exception e )
        {
            fail( "No se debería generar el error: " + e.getMessage( ) + "." );
        }

        // Caso de prueba 2.
        setupEscenario1( );
        try
        {
            ligaBolos.darUltimoJugador( );
            ligaBolos.darUltimoJugador( );
            fail( "Debería generar excepción. Ya se encuentra en el último jugador." );

        }
        catch( Exception e )
        {
            // Debe pasar por este punto
        }
    }

    /**
     * Prueba 7: Prueba el método buscarJugadorPorNombre<br>
     * <b>Métodos a probar: </b> <br>
     * buscarJugadorPorNombre <br>
     * darCantidadJugadores <br>
     * darNombreEquipo <br>
     * darNombreJugador <br>
     * darPartidasJugadas <br>
     * darTotalPuntos <br>
     * darRutaImagen <br>
     * esProfesional <br>
     * <b>Casos de prueba : </b> <br>
     * 1. El jugador buscado existe. <br>
     * 2. El jugador buscado no existe.
     */
    public void testbuscarJugadorPorNombre( )
    {
        // Caso de prueba 1.
        setupEscenario1( );
        try
        {
            Jugador actual = ligaBolos.buscarJugadorPorNombre( "Sin Li" );

            assertEquals( "El nombre de equipo del jugador actual no es correcto", "Malaysia's Team", actual.darNombreEquipo( ) );
            assertEquals( "El nombre del jugador actual no es correcto.", "Sin Li", actual.darNombreJugador( ) );
            assertEquals( "La cantidad de partidas del jugador actual no es correcta.", 6, actual.darCantidadPartidasJugadas( ) );
            assertEquals( "La cantidad total de puntos del jugador actual no es correcta", 2300, actual.darTotalPuntos( ) );
            assertEquals( "El indicador 'profesional' no es correcto para el jugador actual", true, actual.esProfesional( ) );
            assertEquals( "La ruta de la imagen del jugador actual no es correcta", "data/imagenes/Sin_Li.jpg", actual.darRutaImagen( ) );
            assertEquals( "No se actualizó el jugador actual", "Sin Li", ligaBolos.darJugadorActual( ).darNombreJugador( ) );

            actual = ligaBolos.buscarJugadorPorNombre( "Carolier Lanes" );
            assertEquals( "El nombre de equipo del jugador actual no es correcto", "USBC Masters", actual.darNombreEquipo( ) );
            assertEquals( "El nombre del jugador actual no es correcto.", "Carolier Lanes", actual.darNombreJugador( ) );
            assertEquals( "La cantidad de partidas del jugador actual no es correcta.", 2, actual.darCantidadPartidasJugadas( ) );
            assertEquals( "La cantidad total de puntos del jugador actual no es correcta", 200, actual.darTotalPuntos( ) );
            assertEquals( "El indicador 'profesional' no es correcto para el jugador actual", false, actual.esProfesional( ) );
            assertEquals( "La ruta de la imagen del jugador actual no es correcta", "data/imagenes/Carolier_Lanes.jpg", actual.darRutaImagen( ) );
            assertEquals( "No se actualizó el jugador actual", "Carolier Lanes", ligaBolos.darJugadorActual( ).darNombreJugador( ) );

        }
        catch( Exception e )
        {
            fail( "No se debería generar el error: " + e.getMessage( ) + "." );
        }

        // Caso de prueba 2.
        setupEscenario1( );
        try
        {
            ligaBolos.buscarJugadorPorNombre( "Juan" );
            fail( "Deberia generar excepcion. No existe ningun jugador con este nombre." );

        }
        catch( Exception e )
        {
            // Debe pasar por este punto
        }
    }

    /**
     * Prueba 8: Prueba el método darJugadorMejorPromedio<br>
     * <b>Métodos a probar: </b> <br>
     * darJugadorMejorPromedio <br>
     * darCantidadJugadores <br>
     * darNombreEquipo <br>
     * darNombreJugador <br>
     * darPartidasJugadas <br>
     * darTotalPuntos <br>
     * darRutaImagen <br>
     * esProfesional <br>
     * <b>Casos de prueba : </b> <br>
     * 1. Los puntajes de los jugadores son los puntajes iniciales. <br>
     * 2. Los puntajes de los jugadores no son los iniciales.
     */
    public void testDarJugadorMejorPromedio( )
    {
        setupEscenario1( );
        try
        {
            // Caso de prueba 1.
            Jugador actual = ligaBolos.darJugadorMejorPromedio( );

            assertEquals( "El nombre de equipo del jugador no es correcto", "Malaysia's Team", actual.darNombreEquipo( ) );
            assertEquals( "El nombre del jugador no es correcto.", "Sin Li", actual.darNombreJugador( ) );
            assertEquals( "La cantidad de partidas del jugador no es correcta.", 6, actual.darCantidadPartidasJugadas( ) );
            assertEquals( "La cantidad total de puntos del jugador no es correcta", 2300, actual.darTotalPuntos( ) );
            assertEquals( "El jugador debería ser profesional", true, actual.esProfesional( ) );
            assertEquals( "La ruta de la imagen del jugador no es correcta", "data/imagenes/Sin_Li.jpg", actual.darRutaImagen( ) );
            assertEquals( "No se actualizó el jugador actual", "Sin Li", ligaBolos.darJugadorActual( ).darNombreJugador( ) );

            // Caso de prueba 2.
            actual = ligaBolos.darSiguienteJugador( );
            actual.agregarNuevoPuntaje( 100000 );
            ligaBolos.darAnteriorJugador( );
            actual = ligaBolos.darJugadorMejorPromedio( );
            assertEquals( "El nombre del jugador no es el correcto", "Shannon Pluhowsky", actual.darNombreJugador( ) );
            assertEquals( "No se actualizó el jugador actual", "Shannon Pluhowsky", ligaBolos.darJugadorActual( ).darNombreJugador( ) );

        }
        catch( Exception e )
        {
            fail( "No debería generar excepción: " + e.getMessage( ) );
        }
    }

    /**
     * Prueba 12: Prueba el método agregarPuntaje<br>
     * <b>Métodos a probar: </b> <br>
     * agregarPuntaje <br>
     * darPartidasJugadas <br>
     * darTotalPuntos <br>
     * darPromedioPuntos <br>
     * <b>Casos de prueba : </b> <br>
     * 1. Se agregan puntajes a los jugadores.
     */
    public void testAgregarPuntaje( )
    {
        setupEscenario1( );

        try
        {
            Jugador actual = ligaBolos.darJugadorActual( );

            assertEquals( "La cantidad de partidas del jugador es incorrecta.", 2, actual.darCantidadPartidasJugadas( ) );
            assertEquals( "La cantidad total de puntos del jugador no es correcta.", 200, actual.darTotalPuntos( ) );
            assertEquals( "El promedio de puntos calculado para el jugador no es correcto.", 100.0, actual.darPromedioPuntos( ) );

            ligaBolos.agregarPuntaje( 200 );

            assertEquals( "La cantidad de partidas del jugador es incorrecta.", 3, actual.darCantidadPartidasJugadas( ) );
            assertEquals( "La cantidad total de puntos del jugador no es correcta.", 400, actual.darTotalPuntos( ) );
            assertEquals( "El promedio de puntos calculado para el jugador no es correcto.", 133.0, actual.darPromedioPuntos( ) );

            ligaBolos.agregarPuntaje( 150 );
            ligaBolos.agregarPuntaje( 300 );

            assertEquals( "La cantidad de partidas del jugador es incorrecta.", 5, actual.darCantidadPartidasJugadas( ) );
            assertEquals( "La cantidad total de puntos del jugador no es correcta.", 850, actual.darTotalPuntos( ) );
            assertEquals( "El promedio de puntos calculado para el actual no es correcto.", 170.0, actual.darPromedioPuntos( ) );

        }
        catch( Exception e )
        {
            e.printStackTrace( );
            fail( "No se debería generar el error: " + e.getMessage( ) + "." );
        }
    }

}
