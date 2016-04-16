/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Jugador.java,v 1.6   Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_LigaBolos.
 * Autor:  Equipo Cupi2 2016.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.ligaBolos.mundo;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

/**
 * Clase principal del mundo.
 */
public class LigaBolos
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de jugadores pertenecientes a la liga de Bolos.
     */
    private Jugador[] jugadores;

    /**
     * Posición del jugador actual.
     */
    private int jugadorActual;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
    /**
     * Crea una nueva liga de bolos a partir de un archivo de propiedades. <br>
     * <b>post: </b> Se inicializó la lista de jugadores. El jugador actual se inicializó en 0. Se cargó la información contenida en el archivo.<br>
     * @throws Exception Si hubo algún error cargando el archivo.
     */
    public LigaBolos( ) throws Exception
    {
        // Carga la información de los jugadores desde un archivo de propiedades.

        Properties persistencia = new Properties( );
        FileInputStream fis = null;

        fis = new FileInputStream( new File( "data/ligaBolos.data" ) );

        persistencia.load( fis );
        fis.close( );

        // Inicializa la cantidad de jugadores.

        int cantidadJugadores = Integer.parseInt( persistencia.getProperty( "liga.cantidadJugadores" ) );

        jugadores = new Jugador[cantidadJugadores];

        // Recorre la información del archivo de propiedades.
        Jugador jugador;
        for( int i = 0; i <= cantidadJugadores - 1; i++ )
        {
            // Lee los datos contenidos en el archivo de propiedades.
            String prefijo = "liga.jugador" + ( i + 1 );
            String nombreEquipo = persistencia.getProperty( prefijo + ".nombreEquipo" );
            String nombreJugador = persistencia.getProperty( prefijo + ".nombreJugador" );
            int cantidadPartidasJugadas = Integer.parseInt( persistencia.getProperty( prefijo + ".partidas" ) );
            int totalPuntos = Integer.parseInt( persistencia.getProperty( prefijo + ".totalPuntos" ) );
            boolean profesional = Boolean.parseBoolean( persistencia.getProperty( prefijo + ".profesional" ) );
            String rutaImagen = persistencia.getProperty( prefijo + ".imagen" );
            jugador = new Jugador( nombreEquipo, nombreJugador, cantidadPartidasJugadas, totalPuntos, profesional, rutaImagen );
            jugadores[ i ] = jugador;

        }

        jugadorActual = 0;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de jugadores que pertenecen a la liga. <br>
     * <b>pre:</b> El arreglo de jugadores se encuentra inicializado. <br>
     * @return Cantidad de jugadores en la liga.
     */
    public int darCantidadJugadores( )
    {
        return jugadores.length;
    }

    /**
     * Retorna el primer jugador de la liga de bolos. <br>
     * <b> pre: </b> El arreglo de jugadores se encuentra inicializado. <br>
     * <b> post: </b> El atributo jugadorActual se actualizó a la primera posición. <br>
     * @return Primer jugador ingresado en la liga de bolos.
     * @throws Exception Si ya se encuentra en la primera posición de la lista de jugadores.
     */
    public Jugador darPrimerJugador( ) throws Exception
    {
        Jugador jugador = null;
        if( jugadorActual == 0 )
        {
            throw new Exception( "Se encuentra en el primer jugador actualmente." );
        }
        jugadorActual = 0;
        jugador = jugadores[ jugadorActual ];
        return jugador;
    }

    /**
     * Retorna el último jugador de la liga de bolos. <br>
     * <b> pre: </b> El arreglo de jugadores se encuentra inicializado. <br>
     * <b> post: </b> El atributo jugadorActual se actualizó a la última posición. <br>
     * @return Ultimo jugador ingresado en la liga de bolos.
     * @throws Exception Si ya se encuentra en la última posición de la lista de jugadores.
     */
    public Jugador darUltimoJugador( ) throws Exception
    {
        Jugador jugador = null;
        if( jugadorActual == jugadores.length - 1 )
        {
            throw new Exception( "Se encuentra en el último jugador actualmente." );
        }
        jugadorActual = jugadores.length - 1;
        jugador = jugadores[ jugadorActual ];
        return jugador;
    }

    /**
     * Retorna el siguiente jugador de la liga de bolos. <br>
     * <b> pre: </b> El arreglo de jugadores se encuentra inicializado. <br>
     * <b> post: </b> El atributo jugadorActual se actualizó a la siguiente posición. <br>
     * @return Siguiente jugador al actual.
     * @throws Exception Si se encuentra en el último jugador.
     */
    public Jugador darSiguienteJugador( ) throws Exception
    {
        Jugador jugador = null;
        if( jugadorActual == jugadores.length - 1 )
        {
            throw new Exception( "Se encuentra en el último jugador." );
        }
        jugadorActual++;
        jugador = jugadores[ jugadorActual ];
        return jugador;
    }

    /**
     * Retorna el anterior jugador de la liga de bolos. <br>
     * <b> pre: </b> El arreglo de jugadores se encuentra inicializado. <br>
     * <b> post: </b> El atributo jugadorActual se actualizó a la anterior posición. <br>
     * @return Anterior jugador al actual.
     * @throws Exception Si se encuentra en el primer jugador.
     */
    public Jugador darAnteriorJugador( ) throws Exception
    {
        Jugador jugador = null;
        if( jugadorActual == 0 )
        {
            throw new Exception( "Se encuentra en el primer jugador." );
        }
        jugadorActual--;
        jugador = jugadores[ jugadorActual ];
        return jugador;
    }

    /**
     * Retorna el jugador actual de la liga de bolos. <br>
     * <b> pre: </b> El arreglo de jugadores se encuentra inicializado. <br>
     * @return Jugador en la posición actual.
     * @throws Exception Si no existe un jugador en la posición actual.
     */
    public Jugador darJugadorActual( ) throws Exception
    {
        Jugador jugador = jugadores[ jugadorActual ];
        if( jugador == null )
        {
            throw new Exception( "No existe ningún jugador en la posición actual." );

        }
        return jugador;
    }

    /**
     * Retorna un jugador dado su nombre. <br>
     * <b> pre: </b> El arreglo de jugadores se encuentra inicializado. <br>
     * <b> post: </b> El atributo jugadorActual se actualizó a la posición del jugador buscado. <br>
     * @param pNombre Nombre del jugador que se desea buscar. pNombre != null && pNombre != "".
     * @return Jugador con el nombre dado.
     * @throws Exception Si no existe ningún jugador con el nombre especificado.
     */
    public Jugador buscarJugadorPorNombre( String pNombre ) throws Exception
    {
        Jugador jugador = null;
        boolean nombreCorrecto = false;
        for( int i = 0; i < jugadores.length && !nombreCorrecto; i++ )
        {
            if( jugadores[ i ].darNombreJugador( ).equals( pNombre ) )
            {
                jugadorActual = i;
                nombreCorrecto = true;
            }
        }
        if( !nombreCorrecto )
        {
            throw new Exception( "No existe ningún jugador con el nombre especificado." );
        }

        return jugadores[ jugadorActual ];

    }

    /**
     * Retorna el jugador con mejor promedio. Si dos o más jugadores tienen el mejor promedio se retorna el primero de estos.<br>
     * <b> pre: </b> El arreglo de jugadores se encuentra inicializado y no está vacío. <br>
     * <b> post: </b> El atributo jugadorActual se actualizó a la posición del jugador buscado. <br>
     * @return Jugador con mejor promedio de puntos.
     */
    public Jugador darJugadorMejorPromedio( )
    {
        Jugador jugador = jugadores[ 0 ];
        for( int i = 1; i < jugadores.length; i++ )
        {
            if( jugadores[ i ].darPromedioPuntos( ) > jugador.darPromedioPuntos( ) )
            {
                jugadorActual = i;
                jugador = jugadores[ jugadorActual ];
            }
        }
        return jugador;
    }

    /**
     * Agrega un nuevo puntaje al puntaje acumulado del jugador actual.
     * @param pPuntaje Valor que se agrega al acumulado de puntajes. pPuntaje >= 0. <b> pre: </b> El arreglo de jugadores se encuentra inicializado y no está vacío. <br>
     * <b> post: </b> Jugador con puntaje agregado. <br>
     */
    public void agregarPuntaje( int pPuntaje )
    {
        jugadores[ jugadorActual ].agregarNuevoPuntaje( pPuntaje );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión 2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}