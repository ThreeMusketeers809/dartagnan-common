/**
 * 
 */
package show;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import static util.FunctionsLibrary.*;
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


/**
 * @author mitchell
 *
 */

public class EmployeeRegistration extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private JFormattedTextField formattedTextFieldCedulaProfesor;
	private JTextField textFieldPrimerNombreProfesor;
	private JTextField textFieldSegundoNombreProfesor;
	private JTextField textFieldPrimerApellidoProfesor;
	private JTextField textFieldSegundoApellidoProfesor;
	private JTextField textFieldEmailProfesor;
	private JFormattedTextField formattedTextFieldTelefono1Profesor;
	private JFormattedTextField formattedTextFieldTelefono2Profesor;

	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnModificar;
	public JButton btnCancelar;
	public JButton btnSalir;
			
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeRegistration frame = new EmployeeRegistration();
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
	public EmployeeRegistration() throws ParseException {
		setTitle("Regristo de Empleados");
		setBounds(100, 100, 471, 422);
		quitarBotonEsquinaIzquierdaJInternalFrame(this);
			
			/*------------------------------------------------------------------------------------------------------------------------------
			 *Creacion del panel Agregar Estudiante que contiene el formulario para registro de estudiantes.
			------------------------------------------------------------------------------------------------------------------------------*/
			JPanel panelAddTeacher = new JPanel();
			panelAddTeacher.setLayout(null);
			getContentPane().add(panelAddTeacher, BorderLayout.CENTER);
			
				/*------------------------------------------------------------------------------------------------------------------------------
				 * Creacion de las etiquetas del formulario para registro de estudiantes.
				------------------------------------------------------------------------------------------------------------------------------*/
				JLabel lblCedula = new JLabel("Cedula");
				lblCedula.setBounds(22, 15, 111, 26);
				lblCedula.setFont(new Font("SansSerif", Font.PLAIN, 14));
				panelAddTeacher.add(lblCedula);
				
				JLabel lblPrimerNombre = new JLabel("Primer Nombre");
				lblPrimerNombre.setBounds(22, 50, 111, 26);
				lblPrimerNombre.setFont(new Font("SansSerif", Font.PLAIN, 14));
				panelAddTeacher.add(lblPrimerNombre);
				
				JLabel lblSegundoNombre = new JLabel("Segundo Nombre");
				lblSegundoNombre.setBounds(22, 85, 111, 26);
				lblSegundoNombre.setFont(new Font("SansSerif", Font.PLAIN, 14));
				panelAddTeacher.add(lblSegundoNombre);
				
				JLabel lblPrimerApellido = new JLabel("Primer Apellido");
				lblPrimerApellido.setBounds(22, 120, 111, 26);
				lblPrimerApellido.setFont(new Font("SansSerif", Font.PLAIN, 14));
				panelAddTeacher.add(lblPrimerApellido);
				
				JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
				lblSegundoApellido.setBounds(22, 155, 111, 26);
				lblSegundoApellido.setFont(new Font("SansSerif", Font.PLAIN, 14));	
				panelAddTeacher.add(lblSegundoApellido);
				
				JLabel lblEmail = new JLabel("Email");
				lblEmail.setBounds(22, 190, 111, 26);
				lblEmail.setFont(new Font("SansSerif", Font.PLAIN, 14));
				panelAddTeacher.add(lblEmail);
				
				JLabel lblTelefonos = new JLabel("Telefonos");
				lblTelefonos.setBounds(22, 225, 111, 26);
				lblTelefonos.setFont(new Font("SansSerif", Font.PLAIN, 14));
				panelAddTeacher.add(lblTelefonos);
				
				JLabel lblTanda = new JLabel("Tanda");
				lblTanda.setBounds(22, 260, 111, 26);
				lblTanda.setFont(new Font("SansSerif", Font.PLAIN, 14));
				panelAddTeacher.add(lblTanda);
				
				/*Final de las estiquetas del formulario para registro de estudiantes.
				------------------------------------------------------------------------------------------------------------------------------*/
							
				/*------------------------------------------------------------------------------------------------------------------------------
				 * Creacion de los jTextField y JFormattedTextField del formulario para registro de estudiantes.
				------------------------------------------------------------------------------------------------------------------------------*/
				formattedTextFieldCedulaProfesor = new JFormattedTextField(new MaskFormatter("###-#######-#"));
				formattedTextFieldCedulaProfesor.setFocusLostBehavior(JFormattedTextField.PERSIST);
				formattedTextFieldCedulaProfesor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				formattedTextFieldCedulaProfesor.setColumns(13);
				formattedTextFieldCedulaProfesor.setBounds(147, 15, 141, 28);
				panelAddTeacher.add(formattedTextFieldCedulaProfesor);
				
				textFieldPrimerNombreProfesor = new JTextField();
				textFieldPrimerNombreProfesor.setBounds(145, 50, 292, 28);
				textFieldPrimerNombreProfesor.setColumns(10);
				panelAddTeacher.add(textFieldPrimerNombreProfesor);
				
				textFieldSegundoNombreProfesor = new JTextField();
				textFieldSegundoNombreProfesor.setBounds(145, 85, 292, 28);
				textFieldSegundoNombreProfesor.setColumns(10);
				panelAddTeacher.add(textFieldSegundoNombreProfesor);
				
				textFieldPrimerApellidoProfesor = new JTextField();
				textFieldPrimerApellidoProfesor.setBounds(145, 120, 292, 28);
				textFieldPrimerApellidoProfesor.setColumns(10);
				panelAddTeacher.add(textFieldPrimerApellidoProfesor);
				
				textFieldSegundoApellidoProfesor = new JTextField();
				textFieldSegundoApellidoProfesor.setBounds(145, 155, 292, 28);
				textFieldSegundoApellidoProfesor.setColumns(10);
				panelAddTeacher.add(textFieldSegundoApellidoProfesor);
				
				textFieldEmailProfesor = new JTextField();
				textFieldEmailProfesor.setBounds(145, 190, 292, 28);
				textFieldEmailProfesor.setColumns(10);
				panelAddTeacher.add(textFieldEmailProfesor);
				
				formattedTextFieldTelefono1Profesor = new JFormattedTextField(new MaskFormatter("###-###-####"));
				formattedTextFieldTelefono1Profesor.setFocusLostBehavior(JFormattedTextField.PERSIST);
				formattedTextFieldTelefono1Profesor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				formattedTextFieldTelefono1Profesor.setColumns(12);
				formattedTextFieldTelefono1Profesor.setBounds(147, 225, 141, 28);
				panelAddTeacher.add(formattedTextFieldTelefono1Profesor);
				
				formattedTextFieldTelefono2Profesor = new JFormattedTextField(new MaskFormatter("###-###-####"));
				formattedTextFieldTelefono2Profesor.setFocusLostBehavior(JFormattedTextField.PERSIST);
				formattedTextFieldTelefono2Profesor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				formattedTextFieldTelefono2Profesor.setColumns(12);
				formattedTextFieldTelefono2Profesor.setBounds(293, 225, 141, 28);
				panelAddTeacher.add(formattedTextFieldTelefono2Profesor);
													
				/* Final de los jTextField y JFormattedTextField del formulario para registro de estudiantes.
				------------------------------------------------------------------------------------------------------------------------------*/
				
			/*------------------------------------------------------------------------------------------------------------------------------
			 *Creacion del panel que contiene los botones del formulario para registro de estudiantes.
			------------------------------------------------------------------------------------------------------------------------------*/
			JPanel panelBotones = new JPanel();
			panelBotones.setBounds(0, 343, 460, 48);
			panelAddTeacher.add(panelBotones);
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
		//-------------------------------------------------------------
	}
}
