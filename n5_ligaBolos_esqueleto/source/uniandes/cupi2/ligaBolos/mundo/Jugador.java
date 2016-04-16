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

/**
 * Clase que representa a un jugador perteneciente a la liga de bolos.
 */
public class Jugador
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del equipo al que pertenece el jugador.
     */
    private String nombreEquipo;

    /**
     * Nombre del jugador.
     */
    private String nombreJugador;

    /**
     * Cantidad de partidas jugadas por el jugador.
     */
    private int cantidadPartidasJugadas;

    /**
     * Total de puntos obtenidos por el jugador.
     */
    private int totalPuntos;

    /**
     * Valor que indica si el jugador es profesional.
     */
    private boolean profesional;

    /**
     * Ruta donde se guarda la imagen del jugador.
     */
    private String rutaImagen;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo jugador con los datos dados por parámetro.<br>
     * <b>post</b> Se creó el nuevo jugador y se inicializaron los atributos nombreEquipo, nombreJugador, partidasJugadas, totalPuntos, profesional y rutaImagen con los datos
     * dados por parámetro. <br>
     * @param pNombreEquipo Nombre del equipo al que pertenece el jugador. pNombreEquipo != null && pNombreEquipo != "".
     * @param pNombreJugador Nombre del jugador. pNombreEquipo != null && pNombreEquipo != "".
     * @param pCantidadPartidasJugadas Cantidad de partidas jugadas por el jugador al momento de su creación en la liga. pCantidadPartidasJugadas >= 0.
     * @param pTotalPuntos Total de puntos que inicialmente tendrá el jugador. pTotalPuntos >= 0.
     * @param pProfesional Valor que indica si el jugador es profesional. pProfesional != null.
     * @param pRutaImagen ruta de la imagen del jugador. pProfesional != null && pProfesional != "".
     */
    public Jugador( String pNombreEquipo, String pNombreJugador, int pCantidadPartidasJugadas, int pTotalPuntos, boolean pProfesional, String pRutaImagen )
    {
        nombreEquipo = pNombreEquipo;
        nombreJugador = pNombreJugador;
        cantidadPartidasJugadas = pCantidadPartidasJugadas;
        totalPuntos = pTotalPuntos;
        profesional = pProfesional;
        rutaImagen = pRutaImagen;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del equipo al que pertenece el jugador.
     * @return Nombre del equipo.
     */
    public String darNombreEquipo( )
    {
        return nombreEquipo;
    }

    /**
     * Retorna el nombre del jugador.
     * @return Nombre del jugador.
     */
    public String darNombreJugador( )
    {
        return nombreJugador;
    }

    /**
     * Retorna la cantidad de partidas del jugador.
     * @return Cantidad de partidas jugadas.
     */
    public int darCantidadPartidasJugadas( )
    {
        return cantidadPartidasJugadas;
    }

    /**
     * Retorna el total de puntos hechos por el jugador.
     * @return Total de puntos.
     */
    public int darTotalPuntos( )
    {
        return totalPuntos;
    }

    /**
     * Indica si el jugador es o no profesional.
     * @return Indicador profesional.
     */
    public boolean esProfesional( )
    {
        return profesional;
    }

    /**
     * Retorna la ruta donde se guarda la imagen del jugador.
     * @return Ruta de la imagen.
     */
    public String darRutaImagen( )
    {
        return rutaImagen;
    }

    /**
     * Retorna el promedio de puntos del jugador, utilizando el total de puntos y la cantidad de partidas jugadas.
     * @return Promedio de puntos.
     */
    public double darPromedioPuntos( )
    {
        double promedio = 0.0;
        if( cantidadPartidasJugadas > 0 )
        {
            promedio = totalPuntos / cantidadPartidasJugadas;
            promedio = Math.round( promedio * 100.0 ) / 100.0;
        }
        return promedio;
    }

    /**
     * Agrega un nuevo puntaje al jugador. <br>
     * <b>post:</b>La cantidad de partidas jugadas aumentó en uno y el total de puntos aumentó en la cantidad dada por parámetro.
     * @param pPuntaje Puntaje a adicionar. pPuntaje > 0.
     */
    public void agregarNuevoPuntaje( int pPuntaje )
    {
        totalPuntos += pPuntaje;
        cantidadPartidasJugadas++;
    }

}