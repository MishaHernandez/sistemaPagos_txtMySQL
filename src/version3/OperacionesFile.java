/*
 * Aqui van los metodos que operan directamente con el archivo de texto
 */

package version3;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Mijail J. Hernandez
 */
public class OperacionesFile {
    
    public void abrir(JLabel texto2){
        JFileChooser fc=new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
        fc.setFileFilter(filtro);
        Component contentPane = null;
            
        int seleccion=fc.showOpenDialog(contentPane);
            
        if(seleccion==JFileChooser.APPROVE_OPTION){
            File fichero=fc.getSelectedFile();
            texto2.setText(fichero.getAbsolutePath());
        }
    }
    
    public void leer() throws IOException {
        FileReader fr = null;
        BufferedReader br;
        ArrayList<String> arraytxt = new ArrayList<>();
        String [] datos;
        String linea, texto = null;
        String separadores = "[\\ \\;]";
        
        //comunicar con clases
        //OperacionesSQL opsql = new OperacionesSQL();
        ventana1 v1 = new ventana1();
        try {
            fr = new FileReader("archivo.txt");
            br = new BufferedReader(fr);
            
            System.out.println("* Leyendo archivo."); //mensaje test
            while((linea=br.readLine())!=null){
                //capturando lineas
                texto+=linea+"\n";
                //capturando lineas y separando en palabras
//                datos = linea.split(separadores);
//                String dato1 = datos[0];
//                String dato2 = datos[1];
//                String dato3 = datos[2];
//                String dato4 = datos[3];
//                String dato5 = datos[4];
//                String dato6 = datos[5];
//                //añadir palabras al arraylist
//                arraytxt.add(0,dato1);
//                arraytxt.add(1,dato2);
//                arraytxt.add(2,dato3);
//                arraytxt.add(3,dato4);
//                arraytxt.add(4,dato5);
//                arraytxt.add(5,dato6);
//                //pasar arraylist de datos
//                opsql.insertar(arraytxt);
            }
            
            System.out.println(texto);
            
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
    
    public void eliminar() {
        File fichero = new File("archivo.txt");
        
        if(fichero.delete()){
            System.out.println("* Borrando archivo"); //mensaje test
        }else{
            System.out.println("El archivo no puede ser borrado");
        }
    }
    
    public void editar() {
        //mostrar en jtextarea
    }

    public void salir() {
        System.exit(0);
    }
    
}
