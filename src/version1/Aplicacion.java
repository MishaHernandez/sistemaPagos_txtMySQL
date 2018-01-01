package version1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Sistema de pagos utilizando datos de texto plano y MySQl.
 * version 1: utilizacion de comandos; abrir, leer, editar, eliminar, salir
 */

/**
 * @author John
 */
public class Aplicacion {
    
    public static void main(String[] args) throws IOException {
        Aplicacion ap=new Aplicacion();
        String ruta = "archivo.txt";
        
        ap.abrir(ruta);
        ap.leer(ruta); //mostrar()
        ap.editar(ruta);
        //ap.eliminar(ruta);
        //ap.salir();
    }
    
    private void abrir(String ruta) {
        File archivo = new File (ruta); //apertura del fichero
        
        if(archivo.exists())
            System.out.println("* Abriendo archivo."); //mensaje test
        else 
            System.out.println("Archivo no existe"); //mensaje test
    }
    
    private void leer(String ruta) throws IOException {
        FileReader fr = null;
        BufferedReader br;
        ArrayList<String> arraytxt = new ArrayList<>();
        String [] datos;
        String linea;
        String separadores = "[\\ \\;]";
        
        //comunicar con clase operaciones
        Operaciones op = new Operaciones();
        
        try {
            fr = new FileReader(ruta);
            br = new BufferedReader(fr);
            
            System.out.println("* Leyendo archivo."); //mensaje test
            while((linea=br.readLine())!=null){
                //leyendo linea por linea
                System.out.println("-"+linea);
                //separando datos
                datos = linea.split(separadores);
                String dato1 = datos[0];
                String dato2 = datos[1];
                String dato3 = datos[2];
                String dato4 = datos[3];
                String dato5 = datos[4];
                String dato6 = datos[5];
                //añadir datos al arraylist
                arraytxt.add(0,dato1);
                arraytxt.add(1,dato2);
                arraytxt.add(2,dato3);
                arraytxt.add(3,dato4);
                arraytxt.add(4,dato5);
                arraytxt.add(5,dato6);
                
                op.insertar(arraytxt); //pasar arraylist de datos
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error de lectura: "+ex);
            
        } finally {
            try {
                if( null != fr )
                    fr.close();
            } catch (IOException e1) {
                System.out.println(e1);
            }
        }
    }
    
    private void editar(String ruta) {
        //edita el texto desde consola
        //guarda el texto en memoria (array)
        //sobreescribe archivo
    }
    
    private void eliminar(String ruta) {
        File fichero = new File(ruta);
        
        if(fichero.delete()){
            System.out.println("* Borrando archivo"); //mensaje test
        }else{
            System.out.println("El archivo no puede ser borrado");
        }
    }
    
    private void salir() {
        System.exit(0);
    }
    
}
