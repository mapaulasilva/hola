package uniandes.cupi2.ligaBolos.Interfaz;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.ligaBolos.mundo.Jugador;
/**
 *  panel que representa la informacion del jugador
 * @author maria paula
 *
 */
public class PanelInformacion extends JPanel implements ActionListener {

//constantes 
	
	public final static String NUEVO_PUNTAJE = "agregar nuevo puntaje";
	
// atributos 
	

// atributo que representa la imagen
private JLabel lblImagen;

//atributo que representa el nombre de el equipo
private JTextField txtNombreEquipo;

//atributo que representa el nombre de el jugador
private JTextField txtNombreJugador;

//atributo que representa el numero de las partidas jugadas
private JTextField txtPartidasJugadas;

//atributo que representa el promedio de puntos
private JTextField txtPromedioPuntos;

//checkbox que indica si el jugadro es profesional
private JCheckBox chkProfesional;

//atributo que representa el boton para agregar un nuevo puntaje
private JButton btnAgregarNuevoPuntaje;

//asociacion con  la ventana principal de la interfaz
private IntefazLigaBolos principal;

private Jugador actual;

//contructor


public PanelInformacion (IntefazLigaBolos pPrincipal)
{
	principal = pPrincipal;
	
setLayout (new GridLayout (1,2));
lblImagen = new JLabel();
add (lblImagen);


JPanel panelAuxiliar = new JPanel();
add  (panelAuxiliar);
panelAuxiliar.setLayout(new GridLayout(7,2));

panelAuxiliar.add(new JLabel ("Nombre del equipo"));

txtNombreEquipo = new JTextField();
txtNombreEquipo.setEditable(false);
panelAuxiliar.add(txtNombreEquipo);

panelAuxiliar.add(new JLabel ("Nombre del jugador"));

txtNombreJugador = new JTextField();
txtNombreJugador.setEditable(false);
panelAuxiliar.add(txtNombreJugador);

panelAuxiliar.add(new JLabel ("Partidas Jugadas"));

txtPartidasJugadas = new JTextField();
txtPartidasJugadas.setEditable(false);
panelAuxiliar.add (txtPartidasJugadas);


panelAuxiliar.add(new JLabel("promedio de puntos"));

txtPromedioPuntos = new JTextField();
txtPromedioPuntos.setEditable(false);
panelAuxiliar.add(txtPromedioPuntos);

panelAuxiliar.add (new JLabel("es profesional?"));

chkProfesional = new JCheckBox();
panelAuxiliar.add(chkProfesional);


panelAuxiliar.add (new JLabel());

panelAuxiliar.add (new JLabel());

panelAuxiliar.add (new JLabel());


btnAgregarNuevoPuntaje = new JButton("agregar nuevo puntaje");
panelAuxiliar.add(btnAgregarNuevoPuntaje);
btnAgregarNuevoPuntaje.setActionCommand(NUEVO_PUNTAJE);
btnAgregarNuevoPuntaje.addActionListener(this);


}

	
	
//metodos

public void actualizar (Jugador pJugador)
{
	
lblImagen.setIcon (new ImageIcon (pJugador.darRutaImagen()));


txtNombreEquipo.setText(pJugador.darNombreEquipo());

txtNombreJugador.setText(pJugador.darNombreJugador());

txtPartidasJugadas.setText(""+ pJugador.darCantidadPartidasJugadas());

txtPromedioPuntos.setText(""+pJugador.darPromedioPuntos());

chkProfesional.setEnabled(pJugador.esProfesional());

actual= pJugador;

	
	}



@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
String comando = e.getActionCommand();
	
	if (comando.equals (NUEVO_PUNTAJE))
	{
		String puntaje = JOptionPane.showInputDialog(this, "punteja  a agregar", "agregar  nuevo puntaje", JOptionPane.NO_OPTION);
	if(puntaje!= null)
	{
		if(!puntaje.trim().isEmpty())
		{
		
			try
			{
				int valor = Integer.parseInt(puntaje);
				if(valor > 0)
				{
					actual.agregarNuevoPuntaje(valor);
					actualizar (actual);
				}
				
			}
			catch (Exception d)
			{
				JOptionPane.showMessageDialog(this, "debe ingresar un valor numerico", "agregar puntaje", JOptionPane.ERROR_MESSAGE); 
			}
			
		}
		else 
		{
			JOptionPane.showInputDialog(this, "debe ingresar el puntaje que desea aagregar al jugador que sea mayor que 0", "agregar nuevo puntje", JOptionPane.ERROR_MESSAGE);
		}
	}
	}
	
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
