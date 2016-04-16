package uniandes.cupi2.ligaBolos.Interfaz;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelNavegacion extends JPanel implements ActionListener {
	
	
	//constantes 
	
	public final static  String AVANZAR = "avanzar";
	
	public final static  String RETROCEDER = "retroceder";
	
	public final static  String PRIMER_JUGADOR = "ver primero";
	
	public final static  String ULTIMO_JUGADOR = "ver ultimojuador";
	
	
	//atributos 
	
	private JButton btnVerPrimerJugador;
	
	private JButton btnRetroceder;
	
	private JButton btnAvanzar;
	
	private JButton btnVerUltimoJugador;

	//asociacion con  la ventana principal de la interfaz
	private IntefazLigaBolos principal;


	
//constructor
	
	public PanelNavegacion (IntefazLigaBolos pPrincipal)
	{
		
		principal = pPrincipal;
		setLayout(new GridLayout (1,4));
		setBorder(new TitledBorder ("navegacion"));
		
		
		btnVerPrimerJugador = new JButton("ver primer jugador");
		add (btnVerPrimerJugador);
		btnVerPrimerJugador.setActionCommand(PRIMER_JUGADOR);
		btnVerPrimerJugador.addActionListener(this);
		
		btnRetroceder = new JButton("<<");
		add (btnRetroceder);
		btnRetroceder.setActionCommand(RETROCEDER);
		btnRetroceder.addActionListener(this);
		
		
		btnAvanzar = new JButton(">>");
		add (btnAvanzar);
		btnAvanzar.setActionCommand(AVANZAR);
		btnAvanzar.addActionListener(this);
		
		
		
		btnVerUltimoJugador = new JButton("ver ultimo jugador");
		add (btnVerUltimoJugador);
		btnVerUltimoJugador.setActionCommand(ULTIMO_JUGADOR);
		btnVerUltimoJugador.addActionListener(this);
		
	}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	
	String comando = e.getActionCommand();
	
	if (comando.equals (AVANZAR))
	{
		principal.avanzar();
	}
	else if (comando.equals (RETROCEDER))
	{
		principal.retroceder();
	}
	else if (comando.equals(PRIMER_JUGADOR))
	{
		principal.verPrimerJugador();
	}
	else
	{
		principal.verUltimoJugador();
	}
	
	
}
	

}
