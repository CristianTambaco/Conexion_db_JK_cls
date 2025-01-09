

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form5 extends JFrame {
    public JPanel mainPanel5;
    private JTextField textField1;
    private JButton enterButton;
    private JButton btnMenu;








    public form5() {
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnMenu);
                frame.dispose();


            }
        });
    }


    public void iniciarRetiro() {


        JFrame frame = new JFrame("Retiro");
        frame.setContentPane(new form5().mainPanel5);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //que es lo que pasa cuando cierro el formulario
        frame.setSize(800,600);                     //seteo del tamaño
        frame.setPreferredSize(new Dimension(800,600));    //seteo del tamaño preferido
        frame.pack();
        frame.setVisible(true);   //para visualizar una nueva ventana
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla

    }



}
