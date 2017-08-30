/**
 * 
 */
package show;

import java.awt.EventQueue;
import static util.FunctionsLibrary.*;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author mitchell
 *
 */
public class ExchangeOfInformation extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> comboBoxPeriodo;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExchangeOfInformation frame = new ExchangeOfInformation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExchangeOfInformation() {
		setTitle("Intercambio De Informacion");
		setBounds(100, 100, 780, 480);
		quitarBotonEsquinaIzquierdaJInternalFrame(this);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 768, 449);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblPeriodo.setBounds(48, 15, 65, 26);
		panel.add(lblPeriodo);
		
		JLabel lblProfesor = new JLabel("Profesor");
		lblProfesor.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblProfesor.setBounds(281, 15, 65, 26);
		panel.add(lblProfesor);
		
		comboBoxPeriodo = new JComboBox<String>();
		comboBoxPeriodo.setBounds(111, 15, 144, 26);
		panel.add(comboBoxPeriodo);
		
		JComboBox<String> comboBoxProfesor = new JComboBox<String>();
		comboBoxProfesor.setBounds(347, 15, 252, 26);
		panel.add(comboBoxProfesor);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setBounds(611, 14, 33, 30);
		panel.add(btnBuscar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon("C:\\Users\\djmit\\Desktop\\Delete-80_icon-icons.com_57340.png"));
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		btnSalir.setBounds(656, 14, 33, 30);
		panel.add(btnSalir);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 64, 756, 379);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("SansSerif", Font.PLAIN, 14));
		menuBar.setBounds(0, 0, 758, 23);
		panel_1.add(menuBar);
		
		JMenu mnNuevo = new JMenu("Nuevo");
		mnNuevo.setFont(new Font("SansSerif", Font.PLAIN, 13));
		menuBar.add(mnNuevo);
		
		JMenuItem mntmNuevoGrupo = new JMenuItem("Nuevo Grupo");
		mntmNuevoGrupo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		mnNuevo.add(mntmNuevoGrupo);
		
		JMenu mnAcciones = new JMenu("Acciones");
		mnAcciones.setFont(new Font("SansSerif", Font.PLAIN, 13));
		menuBar.add(mnAcciones);
		
		JMenuItem mntmEliminarGrupo = new JMenuItem("Eliminar Grupo");
		mntmEliminarGrupo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		mnAcciones.add(mntmEliminarGrupo);
		
		JMenuItem mntmAsignarEstudiantes = new JMenuItem("Asignar Estudiantes");
		mntmAsignarEstudiantes.setFont(new Font("SansSerif", Font.PLAIN, 12));
		mnAcciones.add(mntmAsignarEstudiantes);
		
		JMenuItem mntmImprimir = new JMenuItem("Imprimir Listado de Estudiantes");
		mntmImprimir.setFont(new Font("SansSerif", Font.PLAIN, 12));
		mnAcciones.add(mntmImprimir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(-2, 20, 760, 360);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Grupo", "C\u00F3digo", "Nivel", "Profesor"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(0).setMinWidth(120);
		table.getColumnModel().getColumn(0).setMaxWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setMinWidth(120);
		table.getColumnModel().getColumn(1).setMaxWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(135);
		table.getColumnModel().getColumn(2).setMinWidth(135);
		table.getColumnModel().getColumn(2).setMaxWidth(135);
		table.getColumnModel().getColumn(3).setPreferredWidth(400);
		table.getColumnModel().getColumn(3).setMinWidth(400);
		scrollPane.setViewportView(table);
	}
}
