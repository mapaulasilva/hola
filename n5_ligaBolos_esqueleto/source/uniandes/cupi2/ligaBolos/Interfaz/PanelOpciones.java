package uniandes.cupi2.ligaBolos.Interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.sun.org.apache.bcel.internal.generic.IFEQ;

public class PanelOpciones extends JPanel implements ActionListener {
	//costantes
	public final static  String POR_NOMBRE = "buscar por nombre";
	
	public final static  String MEJOR_PROMEDIO = "buscar mejor promedio";
	
	public final static  String OPCION_1 = "opcion 1";
	
	public final static  String OPCION_2 = "opcion 2";
	
	
	//atributos 
	
		private JButton btnBuscarPorNombre;
		
		private JButton btnBuscarMejorPromedio;
		
		private JButton btnOpcion1;
		
		private JButton btnOpcion2;

		//asociacion con  la ventana principal de la interfaz
		private IntefazLigaBolos principal;


		
	//constructor
		
		public PanelOpciones (IntefazLigaBolos pPrincipal)
		{
			principal = pPrincipal;
			
			setLayout(new GridLayout (1,4));
			setBorder(new TitledBorder ("opciones"));
			
			btnBuscarPorNombre = new JButton("Buscar por nombre");
			add (btnBuscarPorNombre);
			btnBuscarPorNombre.setActionCommand(POR_NOMBRE);
			btnBuscarPorNombre.addActionListener(this);
			
			
			btnBuscarMejorPromedio= new JButton("<<");
			add (btnBuscarMejorPromedio);
			btnBuscarMejorPromedio.setActionCommand(MEJOR_PROMEDIO);
			btnBuscarMejorPromedio.addActionListener(this);
			
			btnOpcion1 = new JButton("opcion 1");
			add (btnOpcion1);
			btnOpcion1.setActionCommand(OPCION_1);
			btnOpcion1.addActionListener(this);
			
			btnOpcion2 = new JButton("opcion 2");
			add (btnOpcion2);
			btnOpcion2.setActionCommand(OPCION_2);
			btnOpcion2.addActionListener(this);
			
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String comando = e.getActionCommand();
			
			if (comando.equals (POR_NOMBRE))
			{
				principal.buscarPorNombre();
			}
			else if (comando.equals (MEJOR_PROMEDIO))
			{
				principal.buscarMejorPromedio();
			}
			else if (comando.equals(OPCION_1))
			{
				principal.opcion1();
			}
			else
			{
				principal.opcion2();
			}
			
			
			
			
		}

}
