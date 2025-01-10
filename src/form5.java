import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class form5 extends JFrame {
    public JPanel mainPanel5;
    private JTextField textField1;  // Para el nombre
    private JButton btnRegistrar;
    private JButton btnMenu;
    private JTextField textField2;  // Para la edad (este debe ser un JTextField que reciba números)

    public form5() {
        // Acción para el botón Menu
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnMenu);
                frame.dispose();  // Cierra la ventana actual
            }
        });

        // Acción para el botón Registrar
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });
    }

    // Método para registrar el usuario en la base de datos
    private void registrarUsuario() {
        // Obtener los datos del formulario
        String nombre = textField1.getText();
        String edadTexto = textField2.getText();

        // Validar que los campos no estén vacíos
        if (nombre.isEmpty() || edadTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que la edad sea un número
        int edad;
        try {
            edad = Integer.parseInt(edadTexto);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese una edad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar que la edad esté entre 18 y 40 años
        if (edad < 18 || edad > 40) {
            JOptionPane.showMessageDialog(this, "La edad debe estar entre 18 y 40 años.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Conexión a la base de datos
        String url = "jdbc:mysql://localhost:3307/concurso";
        String user = "root";
        String password = "123456";
        String query = "INSERT INTO inscripciones (Nombre, Edad) VALUES (?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            // Preparar la sentencia SQL
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setInt(2, edad);

            // Ejecutar la inserción
            int rowsAffected = statement.executeUpdate();

            // Verificar si la inserción fue exitosa
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Registro exitoso.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void iniciarRetiro() {
        JFrame frame = new JFrame("Registro");
        frame.setContentPane(new form5().mainPanel5);
        frame.setSize(800, 600);  // Establecer tamaño de la ventana
        frame.setPreferredSize(new Dimension(800, 600)); // Tamaño preferido
        frame.pack();
        frame.setVisible(true); // Mostrar ventana
        frame.setLocationRelativeTo(null); // Centrar la ventana
    }
}
