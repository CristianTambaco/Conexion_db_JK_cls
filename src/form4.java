import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class form4 extends JFrame {
    public JPanel mainPanel4;
    private JButton btnMenu;
    private JTextArea textArea1;

    public form4() {
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al metodo que obtiene y muestra los registros al presionar el botón
                mostrarRegistros();
            }
        });
    }

    // Método para mostrar los registros de la base de datos en el JTextArea
    private void mostrarRegistros() {
        String url = "jdbc:mysql://localhost:3307/concurso";
        String user = "root";
        String password = "123456";

        String query = "SELECT * FROM inscripciones"; // Suponiendo que los registros están en la tabla 'usuarios'
        StringBuilder sb = new StringBuilder(); // StringBuilder para acumular los resultados

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Recorrer los resultados y agregar la información
            while (resultSet.next()) {
                int cod = resultSet.getInt("Cod");
                String nombre = resultSet.getString("Nombre");
                String apellido = resultSet.getString("Apellido");
                String edad = resultSet.getString("Edad");
                String correo = resultSet.getString("Correo");

                sb.append("COD: ").append(cod).append("\n")
                        .append("Nombre: ").append(nombre).append("\n")
                        .append("Apellido: ").append(apellido).append("\n")
                        .append("Edad: ").append(edad).append("\n")
                        .append("Correo: ").append(correo).append("\n")

                        .append("----------------------------\n");
            }

            // Establecer el texto acumulado en el JTextArea
            textArea1.setText(sb.toString());

        } catch (SQLException e) {
            e.printStackTrace();
            textArea1.setText("Error al obtener los registros.");
        }
    }

    public void verSaldo() {
        JFrame frame = new JFrame("Ver datos");
        frame.setContentPane(new form4().mainPanel4);
        frame.setSize(800, 600); // Establecer tamaño de la ventana
        frame.setPreferredSize(new Dimension(800, 600)); // Tamaño preferido
        frame.pack();
        frame.setVisible(true); // Mostrar ventana
        frame.setLocationRelativeTo(null); // Centrar la ventana
    }
}
