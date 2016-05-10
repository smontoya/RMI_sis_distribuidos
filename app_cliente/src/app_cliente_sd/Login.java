package app_cliente_sd;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Login extends JFrame{
    //---------------------------------------------------------------;
    //----------------------------DECLARACION------------------------;
    //---------------------------------------------------------------;
    static String strId;
    static String strNombre;
    static String strPasswd, strPasswordAUX, strFecha;

    private JLabel JLabel_usuario = new JLabel("Nombre de Usuario:  ");
    private JLabel JLabel_contrasenia = new JLabel("Contraseña:  ");
    private JLabel JLabel_sistema_nombre = new JLabel("SISTEMAS DISTRIBUIDOS");
    private java.awt.Font Font_sistema_nombre= new java.awt.Font("Arial", Font.BOLD, 18);
    private JLabel JLabel_sistema_fecha = new JLabel();
    private JLabel JLabel_sistema_nota1 = new JLabel("Esta aplicación es para uso exclusivo del laboratorio.");

    private JPasswordField JPasswordField_password = new JPasswordField(20);
    private JTextField JTextField_usuario = new JTextField(20);
    private JButton JButton_aceptar = new JButton("Acceder");

    //---------------------------------------------------------------;
    //----------------------------CONSTRUCTOR------------------------;
    //---------------------------------------------------------------;
	public Login(){
        //---------------------------------------------------------------;
        //----------------------------CONFIGURACION----------------------;
        //---------------------------------------------------------------;
        JLabel_sistema_nombre.setBounds(500, 100, 400, 20);
        JLabel_sistema_nombre.setFont(Font_sistema_nombre);
        JLabel_sistema_fecha.setBounds(540, 120, 400, 20);
        Date date = new Date();
        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        JLabel_sistema_fecha.setText("Datos al "+formatoFecha.format(date));
        JLabel_sistema_nota1.setBounds(450, 140, 800, 20);

        JLabel_usuario.setBounds(450, 220, 200, 20);
        JLabel_contrasenia.setBounds(450, 250, 200, 20);
        
        JTextField_usuario.setBounds(600, 220, 150, 20);
        JTextField_usuario.setToolTipText("Ingrese Nombre de Usuario (Username)");
        
        JPasswordField_password.setBounds(600, 250, 150, 20);
        JPasswordField_password.setEchoChar('*');
        JPasswordField_password.setToolTipText("Ingrese Contraseña");
        
        JButton_aceptar.setBounds(550, 300, 100, 30);
        JButton_aceptar.setActionCommand("objButton3");

        add(JLabel_sistema_nombre);
        add(JLabel_sistema_fecha);
        add(JLabel_sistema_nota1);
        add(JLabel_usuario);
        add(JLabel_contrasenia);
        add(JTextField_usuario);
        add(JPasswordField_password);
        add(JButton_aceptar);

        inicializador();
        
        JButton_aceptar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JTextField_usuario.setText(JTextField_usuario.getText().trim());
                JPasswordField_password.setText(JPasswordField_password.getText().trim());
                if(JTextField_usuario.getText().length()==0){
                    JTextField_usuario.requestFocus();
                    JOptionPane.showMessageDialog(null, "Debe ingresar el Nombre de Usuario", "Mensaje", JOptionPane.ERROR_MESSAGE);
                }else if(JPasswordField_password.getText().length()==0){
                    JPasswordField_password.requestFocus();
                    JOptionPane.showMessageDialog(null, "Debe ingresar la Contraseña", "Mensaje", JOptionPane.ERROR_MESSAGE);
                }else{
                    acceder(JTextField_usuario.getText(), JPasswordField_password.getText());
                }
            }
        });
    }

    //Inicializador de la Ventana
    private void inicializador(){
        //setSize(400, 300);
        setLayout(null);
        setTitle("Login");
        //setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.JTextField_usuario.requestFocus();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //Acceder
    private void acceder(String valueStrUsuario, String valueStrPassword){
        //Se obtiene el atributo 'id' que esta en el tag 'USUARIO'
        //strId = trabajador.getAttributeValue("id");
        //strNombre = trabajador.getAttributeValue("nombre");
        //strPasswd = trabajador.getAttributeValue("passwd");
        //strPasswordAUX = pasaraMD5(valueStrPassword);
        Boolean sw = new Boolean(false);
        //if((strId.compareTo(valueStrUsuario)==0) && (strPasswd.compareTo(strPasswordAUX)==0)){
            sw=true;
            new MDI();
            dispose();
        //}

        if(sw==false){
            JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos.", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

}

