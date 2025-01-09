import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Main {
    public static void main(String[] args) throws SQLException {

        String url="jdbc:mysql://localhost:3306/concurso";
        String user="root";
        String password="123456";

        String query="SELECT *FROM usuarios";


        try (Connection cone=DriverManager.getConnection(url,user,password)){


            PreparedStatement statement= cone.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();

            System.out.println("CONECTADO");

            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String nombre=resultSet.getNString("Nombre");
                String apellido=resultSet.getNString("Apellido");
                String passwordusuario=resultSet.getNString("Pass");

                System.out.println(" id: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido + ", password: "+passwordusuario);


            }

        }
        catch (Exception e){
            Exception e1 = e;
            e1.printStackTrace();
        }



    }
}