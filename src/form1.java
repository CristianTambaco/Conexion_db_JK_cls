

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form1 extends JFrame {
    public JPanel mainPanel;
    private JTextField usuarioTextField;
    private JPasswordField contraseniaPasswordField;
    private JButton loginButton;
    private JLabel mensajeLabel;


    // Metodo para validar el login

    private void validarLogin() {

        //Obtener los valores ingresados
        String usuario = usuarioTextField.getText();
        char[] contrasenia = contraseniaPasswordField.getPassword();
        String contraseniaTexto = new String(contrasenia);

        // Validar usuario y contraseña
        if (usuario.equals("APELLIDO") && contraseniaTexto.equals("APELLIDO123")) {
            form2 fords = new form2();
            fords.iniciarTransaccion();

            mensajeLabel.setText("Acceso Correcto :)");

            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(loginButton);
            frame.dispose();


        } else {
            form7 fords = new form7();
            fords.iniciarUsuarioIncorrecto();

            mensajeLabel.setText("Acceso Incorrecto :(");

        }


    }


    public void iniciarLogin() {


        JFrame frame = new JFrame("Aplicación Pantalla de Login");
        frame.setContentPane(new form1().mainPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //que es lo que pasa cuando cierro el formulario
        frame.setSize(800,600);                     //seteo del tamaño
        frame.setPreferredSize(new Dimension(800,600));    //seteo del tamaño preferido
        frame.pack();
        frame.setVisible(true);   //para visualizar una nueva ventana

    }





    //Funcionalidad para el boton login

    public form1() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                validarLogin();

            }
        });
    }






}



