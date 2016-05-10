package app_cliente_sd;
import java.util.List;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.*;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
//import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
//Librerias para trabajar con tablas
import javax.swing.JTable.*;
import javax.swing.JScrollPane.*;
import javax.swing.table.DefaultTableModel;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MDI extends JFrame{
    //---------------------------------------------------------------;
    //----------------------------DECLARACION------------------------;
    //---------------------------------------------------------------;
    public static int Puerto = 2014;                                 //NÃºmero del puerto que estÃ¡ alojado el servidor
    public static String IPServer = "localhost";                    //DirecciÃ³n IP del servidor, la cual podrÃ­a utilizarse por defecto el localhost
    public static String nombreReferenciaRemota = "Ejemplo-RMI"; // Nombre del objeto subido
    
    int indice=0;
    String strRUT, strSRC;

    private Cursor cursorWAIT_CURSOR = new Cursor(Cursor.WAIT_CURSOR);
    private Cursor cursorDEFAULT_CURSOR = new Cursor(Cursor.DEFAULT_CURSOR);
    
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu();
    private JMenuItem JMenuItem_Funcionario = new JMenuItem();
    private JMenuItem JMenuItem_Salir = new JMenuItem();

    private JLabel JLabel_titulo_empleado = new JLabel("EMPLEADOS");
    private java.awt.Font Font_titulo_empleado = new java.awt.Font("Arial", Font.BOLD, 16);

    private JLabel JLabel_username = new JLabel("Username:");
    private JLabel JLabel_rut = new JLabel("RUT:  ");
    private JLabel JLabel_nombre = new JLabel("Nombre de Usuario:");
    private JLabel JLabel_departamento = new JLabel("Departamento:");
    private JLabel JLabel_salario = new JLabel("Salario:");
    private JLabel JLabel_password = new JLabel("Password:");
    private JTextField JTextField_username = new JTextField(10);
    private JTextField JTextField_rut = new JTextField(10);
    private JTextField JTextField_digito = new JTextField(3);
    private JTextField JTextField_nombre = new JTextField(20);
    private JTextField JTextField_salario = new JTextField(10);
    private JPasswordField JPasswordField_password = new JPasswordField(20);
    String[] strDepartamentos = {"", "FINANZAS Y CONTABILIDAD", "GERENCIA", "RR.HH."};
    private JComboBox JComboBox_departamento = new JComboBox(strDepartamentos);
    private JButton JButton_grabar = new JButton("Grabar");
    private JButton JButton_cerrar = new JButton("Cerrar");
    private DefaultTableModel miTableDefaultTableModel = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private JTable JTable_resultado_busqueda = new JTable(miTableDefaultTableModel);
    private JScrollPane JScrollPane_resultado_busqueda = new JScrollPane(JTable_resultado_busqueda);

    //El JFrame creamos el formulario MDI.
    private JFrame JFrame_MDI = new JFrame("MDI - Sistema de Consulta de Respaldos");
    private JDesktopPane JDesktopPane_contenedor = new JDesktopPane();

    //Se construye el panel que ira dentro del JInternalFrame
    private JPanel JPanel_formulario_empleado = new JPanel();
    //private JPanel JPanel_resultado_busqueda = new JPanel();

    //Se construye el JInternalFrame
    private JInternalFrame JInternalFrame_formulario_empleado = new JInternalFrame("Formulario Empleados");
    //private JInternalFrame JInternalFrame_resultado_busqueda = new JInternalFrame("Resultados de la Búsqueda");

    //---------------------------------------------------------------;
    //----------------------------CONSTRUCTOR------------------------;
    //---------------------------------------------------------------;
	public MDI(){
        //---------------------------------------------------------------;
        //----------------------------CONFIGURACION----------------------;
        //---------------------------------------------------------------;
        JMenuItem_Funcionario.setText("Funcionario");
        JMenuItem_Salir.setText("Salir");
        fileMenu.setText("Archivo");
        fileMenu.addSeparator();
        fileMenu.add(JMenuItem_Funcionario);
        fileMenu.add(JMenuItem_Salir);
        menuBar.add(fileMenu);

		JFrame_MDI.getContentPane().add(JDesktopPane_contenedor);//Agregamos el JDesktopPane_dp dentro del JFrame_MDI
		JPanel_formulario_empleado.setLayout(null);

        JLabel_titulo_empleado.setBounds(150, 5, 200, 30);
        JLabel_titulo_empleado.setForeground(Color.BLUE);
        JLabel_titulo_empleado.setFont(Font_titulo_empleado);
        JPanel_formulario_empleado.add(JLabel_titulo_empleado);

        JLabel_username.setBounds(50, 50, 100, 20);
        JPanel_formulario_empleado.add(JLabel_username);

        JTextField_username.setBounds(150, 50, 100, 20);
        JPanel_formulario_empleado.add(JTextField_username);

        JLabel_rut.setBounds(50, 70, 100, 20);
        JPanel_formulario_empleado.add(JLabel_rut);

        JTextField_rut.setBounds(150, 70, 100, 20);
        JPanel_formulario_empleado.add(JTextField_rut);

        JTextField_digito.setBounds(250, 70, 20, 20);
        JPanel_formulario_empleado.add(JTextField_digito);

        JLabel_nombre.setBounds(50, 90, 100, 20);
        JPanel_formulario_empleado.add(JLabel_nombre);

        JTextField_nombre.setBounds(150, 90, 300, 20);
        JPanel_formulario_empleado.add(JTextField_nombre);
        
        JLabel_departamento.setBounds(50, 110, 100, 20);
        JPanel_formulario_empleado.add(JLabel_departamento);

        JComboBox_departamento.setBounds(150, 110, 200, 20);
        JPanel_formulario_empleado.add(JComboBox_departamento);

        JLabel_salario.setBounds(50, 130, 100, 20);
        JPanel_formulario_empleado.add(JLabel_salario);

        JTextField_salario.setBounds(150, 130, 100, 20);
        JPanel_formulario_empleado.add(JTextField_salario);

        JLabel_password.setBounds(50, 150, 100, 20);
        JPanel_formulario_empleado.add(JLabel_password);

        JPasswordField_password.setBounds(150, 150, 100, 20);
        JPasswordField_password.setEchoChar('*');
        JPasswordField_password.setToolTipText("Ingrese Contraseña");
        JPanel_formulario_empleado.add(JPasswordField_password);

        JButton_grabar.setBounds(310, 300, 100, 30);
        JPanel_formulario_empleado.add(JButton_grabar);
        JButton_cerrar.setBounds(420, 300, 100, 30);
        JPanel_formulario_empleado.add(JButton_cerrar);
        

		JInternalFrame_formulario_empleado.add(JPanel_formulario_empleado);
        JInternalFrame_formulario_empleado.pack();
        JInternalFrame_formulario_empleado.setBounds(0, 0, 550, 500);
		JInternalFrame_formulario_empleado.setResizable(false);
		JInternalFrame_formulario_empleado.setClosable(false);
        JInternalFrame_formulario_empleado.setVisible(true);

		//Se mete el internal en el JDesktopPane
		JDesktopPane_contenedor.add(JInternalFrame_formulario_empleado);

        JFrame_MDI.setJMenuBar(menuBar);

		//Se visualiza todo.
        JFrame_MDI.setExtendedState(JFrame.MAXIMIZED_BOTH);
		JFrame_MDI.setVisible(true);
		JFrame_MDI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //this.limpiarTableDefaultTableModel();
        this.JTextField_username.requestFocus();
        
        //---------------------------------------------------------------;
        //----------------------------EVENTOS----------------------------;
        //---------------------------------------------------------------;
        JButton_grabar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog (null, "Message", "Title", JOptionPane.INFORMATION_MESSAGE);
                //JOptionPane.showMessageDialog (null, "Message", "Title", JOptionPane.WARNING_MESSAGE);
                //JTextField_rut.setText(JTextField_rut.getText().trim());
                //JTextField_nro_siniestro.setText(JTextField_nro_siniestro.getText().trim());
                //JTextField_nombre.setText(JTextField_nombre.getText().trim());
                if(JTextField_username.getText().length()==0){
                    JTextField_username.requestFocus();
                    JOptionPane.showMessageDialog(null, "Debe ingresar el Username", "Mensaje", JOptionPane.ERROR_MESSAGE);
                }else if(JTextField_rut.getText().length()==0){
                    //JTextField_rut.setText(null);
                    JTextField_rut.requestFocus();
                    JOptionPane.showMessageDialog(null, "Debe ingresar el RUT", "Mensaje", JOptionPane.ERROR_MESSAGE);
                }else if(JTextField_digito.getText().length()==0){
                    JTextField_digito.requestFocus();
                    JOptionPane.showMessageDialog(null, "Debe ingresar el Digito verificador", "Mensaje", JOptionPane.ERROR_MESSAGE);
                }else if(JTextField_nombre.getText().length()==0){
                    JTextField_nombre.requestFocus();
                    JOptionPane.showMessageDialog(null, "Debe ingresar el Nombre", "Mensaje", JOptionPane.ERROR_MESSAGE);
                //}else if(JComboBox_departamento.getText().length()==0){
                    //JComboBox_departamento.requestFocus();
                    //JOptionPane.showMessageDialog(null, "Debe ingresar el Departamento", "Mensaje", JOptionPane.ERROR_MESSAGE);
                }else if(JTextField_salario.getText().length()==0){
                    JTextField_salario.requestFocus();
                    JOptionPane.showMessageDialog(null, "Debe ingresar el Salario", "Mensaje", JOptionPane.ERROR_MESSAGE);
                }else if(JPasswordField_password.getText().length()==0){
                    JPasswordField_password.requestFocus();
                    JOptionPane.showMessageDialog(null, "Debe ingresar la Password", "Mensaje", JOptionPane.ERROR_MESSAGE);
                }else{
                    grabarEmpleado();
                }

                //setCursorWAIT_CURSOR();

            }
        });

        JButton_cerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JInternalFrame_formulario_empleado.setVisible(false);
                setCursorDEFAULT_CURSOR();
            }
        });
        
        JMenuItem_Funcionario.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                JInternalFrame_formulario_empleado.setVisible(true);
            }
        });
        
        JMenuItem_Salir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                System.exit(0);
            }
        });
	}
    
    //---------------------------------------------------------------;
    //----------------------------METODOS----------------------------;
    //---------------------------------------------------------------;
    //Grabar Empleado
    private void grabarEmpleado(){

        
        Interface objetoRemoto; //Se crea un nuevo objeto llamado objetoRemoto
        ConexionCliente conexion = new ConexionCliente();//Se instancia el objeto que conecta con el servidor
        try {
            //Se conecta con el servidor
            if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaRemota)) {
                //Se obtiene la referencia al objeto remoto
                objetoRemoto = conexion.getServidor();
                //Llama a un método del objeto remoto, y se le ingresa un parámetro a éste método
                String username = JTextField_username.getText();
                String rut = JTextField_rut.getText();
                String digito = JTextField_digito.getText();
                String nombre = JTextField_nombre.getText();
                String departamento = "RR.HH";
                String salario = JTextField_salario.getText();
                String pass = JPasswordField_password.getText();
                boolean ingreso = objetoRemoto.ingresarUsuario(username, rut, digito, nombre, "RR.HH.", salario, pass);
                if (ingreso) {
                    System.out.println("¡Felicitaciones, ha sido agregado el usuario!");
                } else {
                    System.out.println("Lamentablemente no ha sido ingresado el usuario, pruebe con otro nombre...");
                }
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error...");
        }
    }
    //Activar cursor Reloj de arena
    private void setCursorWAIT_CURSOR(){
        JFrame_MDI.setCursor(cursorWAIT_CURSOR);
        JInternalFrame_formulario_empleado.setCursor(cursorWAIT_CURSOR);
        //JInternalFrame_resultado_busqueda.setCursor(cursorWAIT_CURSOR);
    }
    //Activar cursor x defecto
    private void setCursorDEFAULT_CURSOR(){
        JFrame_MDI.setCursor(cursorDEFAULT_CURSOR);
        JInternalFrame_formulario_empleado.setCursor(cursorDEFAULT_CURSOR);
        //JInternalFrame_resultado_busqueda.setCursor(cursorDEFAULT_CURSOR);
    }
}
