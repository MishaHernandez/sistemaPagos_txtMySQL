package version2;

/*
 * Aqui van los codigos que permite la conexion con SQLite
 * Un metodo para abrir la conexion y otro para cerrarla
 */

/**
 * @author Mijail J. Hernandez
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector{
    Connection conexion;
    String ruta;

    public void conectar(){ //abrir la conexion
        try{
            ruta = "sistema"; //dentro del mismo proyecto
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/"+ruta,"root", "");
            
            if(conexion!=null){ //mensaje de conexion exitosa
                //JOptionPane.showMessageDialog(null, "Conectado");
                System.out.println("Conectado.");
            }
        }
        catch(SQLException e){
            System.err.println("No hay conexion: "+e);
        }
    }
    
    public void cerrar(){ //cerrar conexion con la bd
        try {
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Error de cierre"+e);
        }
    }
    
}
