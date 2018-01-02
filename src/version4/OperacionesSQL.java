package version4;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Aqui van los metodos que operan directamente con la base de datos (MySQL)
 * 
 */

/**
 * @author Mijail J. Hernandez
 */
public class OperacionesSQL {
    Conector con;
    
    public OperacionesSQL(){
        con = new Conector();
    }
    
    public void insertar(ArrayList arraytxt){
        PreparedStatement pst;
        
        //convertir datos del array
        int idestud = Integer.parseInt((String) arraytxt.get(0));
        String nombre = (String) arraytxt.get(1);
        String apellidop = (String) arraytxt.get(2);
        String apellidom = (String) arraytxt.get(3);
        int idpago = Integer.parseInt((String) arraytxt.get(4));
        int monto = Integer.parseInt((String) arraytxt.get(5));
        
        String sql="insert into reporte (idestud, nombre, apellidop, apellidom, idpago, monto) values (?,?,?,?,?,?)";
        
        con.conectar();
        
        try {
            pst = con.conexion.prepareStatement(sql);
            //asignar valores a insertar
            pst.setInt(1, idestud);
            pst.setString(2, nombre);
            pst.setString(3, apellidop);
            pst.setString(4, apellidom);
            pst.setInt(5, idpago);
            pst.setInt(6, monto);
            pst.execute(); //ejecutar consulta
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        con.cerrar();
    }
    
    public void actualizar(ArrayList arraytxt){
        PreparedStatement pst;
        
        //convertir datos del array
        int idestud = Integer.parseInt((String) arraytxt.get(0));
        String nombre = (String) arraytxt.get(1);
        String apellp = (String) arraytxt.get(2);
        String apellm = (String) arraytxt.get(3);
        int idpago = Integer.parseInt((String) arraytxt.get(4));
        int monto = Integer.parseInt((String) arraytxt.get(5));
        
        String sql="update reporte set nombre = '"+nombre+"', apellidop = '"+apellp+"', apellidom = '"+apellm+"', idpago = "+idpago+", monto = "+monto+" where idestud = "+idestud+"";
        
        con.conectar();
        
        try {
            pst = con.conexion.prepareStatement(sql);
            pst.executeUpdate(); //ejecutar consulta
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        con.cerrar();
    }
}