/**
 * 
 */
package show;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import static util.FunctionsLibrary.*;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EmptyBorder;

/**
 * @author mitchell
 *
 */

public class StudentRegistration extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFormattedTextField formattedTextFieldCedulaEstudiante;
	private JComboBox<String> comboBoxPeriodoEstudiante;
	private JTextField textFieldPrimerNombreEstudiante;
	private JTextField textFieldSegundoNombreEstudiante;
	private JTextField textFieldPrimerApellidoEstudiante;
	private JTextField textFieldSegundoApellidoEstudiante;
	private JTextField textFieldEmailEstudiante;
	private JFormattedTextField formattedTextFieldTelefono1Estudiante;
	private JFormattedTextField formattedTextFieldTelefono2Estudiante;
	private JComboBox<String> comboBoxTandaEstudiante;
		
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnSalir;
	public JButton btnModificar;
	public JButton btnCancelar;
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRegistration frame = new StudentRegistration();
					frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public StudentRegistration() throws ParseException {
		setTitle("Regristo de Estudiantes");
		setBounds(100, 100, 471, 422);
		quitarBotonEsquinaIzquierdaJInternalFrame(this);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		//----------------------------------------------------------------------------------------------------------------------------------
		
			/*------------------------------------------------------------------------------------------------------------------------------
			 *Creacion del panel Agregar Estudiante que contiene el formulario para registro de estudiantes.
			------------------------------------------------------------------------------------------------------------------------------*/
			JPanel panelAddStudent = new JPanel();
			panelAddStudent.setBorder(new EmptyBorder(0, 0, 0, 0));
			tabbedPane.addTab("Agregar Estudiante", null, panelAddStudent, null);
			panelAddStudent.setLayout(null);
		
				/*------------------------------------------------------------------------------------------------------------------------------ 
				 * Creacion de las etiquetas del formulario para registro de estudiantes.
				------------------------------------------------------------------------------------------------------------------------------*/
				JLabel lblCedula = new JLabel("Cedula");
				lblCedula.setBounds(22, 15, 111, 26);
				lblCedula.setFont(new Font("SansSerif", Font.PLAIN, 14));
				panelAddStudent.add(lblCedula);
				
				JLabel lblPeriodo = new JLabel("Periodo");
				lblPeriodo.setFont(new Font("SansSerif", Font.PLAIN, 14));
				lblPeriodo.setBounds(272, 15, 49, 26);
				panelAddStudent.add(lblPeriodo);
				
				JLabel lblPrimerNombre = new JLabel("Primer Nombre");
				lblPrimerNombre.setBounds(22, 50, 111, 26);
				lblPrimerNombre.setFont(new Font("SansSerif", Font.PLAIN, 14));
				panelAddStudent.add(lblPrimerNombre);
				
				JLabel lblSegundoNombre = new JLabel("Segundo Nombre");
				lblSegundoNombre.setBounds(22, 85, 111, 26);
				lblSegundoNombre.setFont(new Font("SansSerif", Font.PLAIN, 14));
				panelAddStudent.add(lblSegundoNombre);
				
				JLabel lblPrimerApellido = new JLabel("Primer Apellido");
				lblPrimerApellido.setBounds(22, 120, 111, 26);
				lblPrimerApellido.setFont(new Font("SansSerif", Font.PLAIN, 14));
				panelAddStudent.add(lblPrimerApellido);
				
				JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
				lblSegundoApellido.setBounds(22, 155, 111, 26);
				lblSegundoApellido.setFont(new Font("SansSerif", Font.PLAIN, 14));	
				panelAddStudent.add(lblSegundoApellido);
				
				JLabel lblEmail = new JLabel("Email");
				lblEmail.setBounds(22, 190, 111, 26);
				lblEmail.setFont(new Font("SansSerif", Font.PLAIN, 14));
				panelAddStudent.add(lblEmail);
				
				JLabel lblTelefonos = new JLabel("Telefonos");
				lblTelefonos.setBounds(22, 225, 111, 26);
				lblTelefonos.setFont(new Font("SansSerif", Font.PLAIN, 14));
				panelAddStudent.add(lblTelefonos);
				
				JLabel lblTanda = new JLabel("Tanda");
				lblTanda.setBounds(22, 260, 111, 26);
				lblTanda.setFont(new Font("SansSerif", Font.PLAIN, 14));
				panelAddStudent.add(lblTanda);
				
				/*Final de las estiquetas del formulario para registro de estudiantes.
				------------------------------------------------------------------------------------------------------------------------------*/
				
				/*------------------------------------------------------------------------------------------------------------------------------ 
				 * Creacion de los jTextField y JFormattedTextField del formulario para registro de estudiantes.
				------------------------------------------------------------------------------------------------------------------------------*/
				formattedTextFieldCedulaEstudiante = new JFormattedTextField(new MaskFormatter("###-#######-#"));
				formattedTextFieldCedulaEstudiante.setFocusLostBehavior(JFormattedTextField.PERSIST);
				formattedTextFieldCedulaEstudiante.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				formattedTextFieldCedulaEstudiante.setColumns(13);
				formattedTextFieldCedulaEstudiante.setBounds(147, 15, 120, 28);
				panelAddStudent.add(formattedTextFieldCedulaEstudiante);
				
				comboBoxPeriodoEstudiante = new JComboBox<String>();
				comboBoxPeriodoEstudiante.setBounds(324, 15, 113, 28);
				panelAddStudent.add(comboBoxPeriodoEstudiante);
				
				textFieldPrimerNombreEstudiante = new JTextField();
				textFieldPrimerNombreEstudiante.setBounds(145, 50, 292, 28);
				textFieldPrimerNombreEstudiante.setColumns(10);
				panelAddStudent.add(textFieldPrimerNombreEstudiante);
				
				textFieldSegundoNombreEstudiante = new JTextField();
				textFieldSegundoNombreEstudiante.setBounds(145, 85, 292, 28);
				textFieldSegundoNombreEstudiante.setColumns(10);
				panelAddStudent.add(textFieldSegundoNombreEstudiante);
				
				textFieldPrimerApellidoEstudiante = new JTextField();
				textFieldPrimerApellidoEstudiante.setBounds(145, 120, 292, 28);
				textFieldPrimerApellidoEstudiante.setColumns(10);
				panelAddStudent.add(textFieldPrimerApellidoEstudiante);
				
				textFieldSegundoApellidoEstudiante = new JTextField();
				textFieldSegundoApellidoEstudiante.setBounds(145, 155, 292, 28);
				textFieldSegundoApellidoEstudiante.setColumns(10);
				panelAddStudent.add(textFieldSegundoApellidoEstudiante);
				
				textFieldEmailEstudiante = new JTextField();
				textFieldEmailEstudiante.setBounds(145, 190, 292, 28);
				textFieldEmailEstudiante.setColumns(10);
				panelAddStudent.add(textFieldEmailEstudiante);
				
				formattedTextFieldTelefono1Estudiante = new JFormattedTextField(new MaskFormatter("###-###-####"));
				formattedTextFieldTelefono1Estudiante.setFocusLostBehavior(JFormattedTextField.PERSIST);
				formattedTextFieldTelefono1Estudiante.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				formattedTextFieldTelefono1Estudiante.setColumns(12);
				formattedTextFieldTelefono1Estudiante.setBounds(147, 225, 141, 28);
				panelAddStudent.add(formattedTextFieldTelefono1Estudiante);
				
				formattedTextFieldTelefono2Estudiante = new JFormattedTextField(new MaskFormatter("###-###-####"));
				formattedTextFieldTelefono2Estudiante.setFocusLostBehavior(JFormattedTextField.PERSIST);
				formattedTextFieldTelefono2Estudiante.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				formattedTextFieldTelefono2Estudiante.setColumns(12);
				formattedTextFieldTelefono2Estudiante.setBounds(293, 225, 141, 28);
				panelAddStudent.add(formattedTextFieldTelefono2Estudiante);
				
				comboBoxTandaEstudiante = new JComboBox<String>();
				comboBoxTandaEstudiante.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Ma\u00F1ana", "Tarde", "Noche"}));
				comboBoxTandaEstudiante.setBounds(145, 261, 145, 28);
				panelAddStudent.add(comboBoxTandaEstudiante);
				/* Final de los jTextField y JFormattedTextField del formulario para registro de estudiantes.
				------------------------------------------------------------------------------------------------------------------------------*/
				
			/*------------------------------------------------------------------------------------------------------------------------------
			 *Creacion del panel que contiene los botones del formulario para registro de estudiantes.
			------------------------------------------------------------------------------------------------------------------------------*/
			JPanel panelBotones = new JPanel();
			panelBotones.setBounds(0, 313, 460, 48);
			panelAddStudent.add(panelBotones);
			panelBotones.setLayout(null);
			/* Final del panel que contiene los botones del formulario para registro de estudiantes.
			------------------------------------------------------------------------------------------------------------------------------*/
		
				/*------------------------------------------------------------------------------------------------------------------------------ 
				 * Creacion de los Botones del formulario para registro de estudiantes.
				------------------------------------------------------------------------------------------------------------------------------*/
				btnNuevo = new JButton("Nuevo");
				btnNuevo.setBounds(0, 11, 85, 36);
				panelBotones.add(btnNuevo);
				
				btnGuardar = new JButton("Guardar");
				btnGuardar.setBounds(93, 11, 85, 36);
				panelBotones.add(btnGuardar);
				
				btnModificar = new JButton("Modificar");
				btnModificar.setBounds(186, 11, 85, 36);
				panelBotones.add(btnModificar);
				
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setBounds(279, 11, 85, 36);
				panelBotones.add(btnCancelar);
				
				btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						dispose();
					}
				});
				btnSalir.setBounds(374, 11, 85, 36);
				panelBotones.add(btnSalir);		
				
			/*------------------------------------------------------------------------------------------------------------------------------				
			 *Creacion del panel Agregar Estudiante que contiene el formulario para registro de estudiantes.
			------------------------------------------------------------------------------------------------------------------------------*/
			JPanel panelAgregarDesdeArchivo = new JPanel();
			tabbedPane.addTab("Agregar Desde Archivos", null, panelAgregarDesdeArchivo, null);
			panelAgregarDesdeArchivo.setLayout(null);
		//-------------------------------------------------------------
	}
}
