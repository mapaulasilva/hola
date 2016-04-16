package uniandes.cupi2.ligaBolos.Interfaz;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import sun.java2d.Disposer;
import uniandes.cupi2.ligaBolos.mundo.Jugador;
import uniandes.cupi2.ligaBolos.mundo.LigaBolos;

public class IntefazLigaBolos extends JFrame {

private PanelInformacion panel1;

private PanelNavegacion panel2;

private PanelOpciones panel3;


// asociacion con la clase pprincipall del mundo
private LigaBolos  mundo;


// constructor


public IntefazLigaBolos ()
{
	setLayout (new BorderLayout());

	setSize( 700, 600 );
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	setLocationRelativeTo( null );
	setTitle( "Liga Bolos" );

	JLabel imagen = new JLabel();
	imagen.setIcon(new ImageIcon("data/imagenes/titulo.jpg"));
	add(imagen, BorderLayout.NORTH);
	
	JPanel panelAuxiliar = new JPanel();
	panelAuxiliar.setLayout(new BorderLayout());
	add(panelAuxiliar, BorderLayout.CENTER);
	panelAuxiliar.setBorder(new TitledBorder ("informacion"));
	
	
	panel1 = new PanelInformacion(this);
	panelAuxiliar.add(panel1, BorderLayout.CENTER);


	panel2 = new PanelNavegacion(this);
	panelAuxiliar.add(panel2, BorderLayout.SOUTH);


	panel3 = new PanelOpciones(this);
	add(panel3, BorderLayout.SOUTH);





setVisible(true);	

 
try 
{
	mundo = new LigaBolos();
	mundo.darSiguienteJugador();
	panel1.actualizar(mundo.darPrimerJugador());
}
catch ( Exception e)
{
	JOptionPane.showMessageDialog(this, e.getMessage(), "inicializa  mundo", JOptionPane.ERROR_MESSAGE);
	dispose ();
}



}	


//metodos

public void verPrimerJugador()
{
	Jugador encontrado;
	try
	{
		encontrado = mundo.darPrimerJugador();
		panel1.actualizar(encontrado);
		
	}
	catch (Exception e)
	{
		JOptionPane.showMessageDialog(this, e.getMessage(), "Deplazarse al primer jugador", JOptionPane.INFORMATION_MESSAGE);
	}
	}

public void avanzar()
{
	Jugador encontrado;
	
	try
	{
		encontrado= mundo.darSiguienteJugador();
		panel1.actualizar(encontrado);
	}
	catch (Exception e)
	{
		JOptionPane.showMessageDialog(this, e.getMessage(), "avanzar a siguiente", JOptionPane.INFORMATION_MESSAGE);
	}
	
	}

public void retroceder()
{
Jugador encontrado;
	
	try
	{
		encontrado= mundo.darAnteriorJugador();
		panel1.actualizar(encontrado);
	}
	catch (Exception e)
	{
		JOptionPane.showMessageDialog(this, e.getMessage(), "retroceder al anterior", JOptionPane.INFORMATION_MESSAGE);
	}
	}

public void verUltimoJugador()
{
	Jugador encontrado;
	try
	{
		encontrado = mundo.darUltimoJugador();
		panel1.actualizar(encontrado);
		
	}
	catch (Exception e)
	{
		JOptionPane.showMessageDialog(this, e.getMessage(), "Deplazarse al ultimo jugador", JOptionPane.INFORMATION_MESSAGE);
	}
	}

public void buscarPorNombre ()
{
	String ingreso = JOptionPane.showInputDialog("Nombre del jugador");
	
	if(ingreso != null && !ingreso.trim().isEmpty())
	{
		try
		{
		Jugador encontrado = mundo.buscarJugadorPorNombre(ingreso);
		panel1.actualizar(encontrado);		
		}
		catch (Exception  e)
	    {
			JOptionPane.showMessageDialog(this, e.getMessage(), "buscar por nombre", JOptionPane.ERROR_MESSAGE);
	    }	
		
	}
	else {
		JOptionPane.showMessageDialog(this, "debe ingresar el nombre de el jugador", "buscar por nombre", JOptionPane.ERROR_MESSAGE);
	}
	
	
	}

public void buscarMejorPromedio ()
{
	Jugador encontrado = mundo.darJugadorMejorPromedio();
	
	panel1.actualizar(encontrado);
	
	
	}

public void opcion1()
{
String encontrado = mundo.metodo1();

JOptionPane.showMessageDialog(this, encontrado, "opcion1", JOptionPane.INFORMATION_MESSAGE);

}

public void opcion2()
{
	String encontrado = mundo.metodo2();

	JOptionPane.showMessageDialog(this, encontrado, "opcion2", JOptionPane.INFORMATION_MESSAGE);

	}










	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{
			IntefazLigaBolos  interfaz = new IntefazLigaBolos();
			interfaz.setVisible (true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		

	}

}
