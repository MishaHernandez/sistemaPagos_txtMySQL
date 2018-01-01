/*
 * Aqui van los metodos que operan directamente el archivo de texto
 */

package version4;

import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * @author Mijail J. Hernandez
 */
public class OperacionesFile {
    OperacionesSQL opsql;
    
    public OperacionesFile(){
        opsql = new OperacionesSQL();
    }
    
    public void abrir(JLabel texto2){
        JFileChooser fc=new JFileChooser();
        fc.setCurrentDirectory(new File("archivo.txt")); //apertura en directorio actual
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt"); //filtro extension
        fc.setFileFilter(filtro);
        
        Component contentPane = null;
        int seleccion=fc.showOpenDialog(contentPane);
        
        if(seleccion==JFileChooser.APPROVE_OPTION){
            File fichero=fc.getSelectedFile();
            texto2.setText(fichero.getName()); //asignar el nombre del archivo a la etiqueta
            
            System.out.println("* Archivo seleccionado"); //mensaje test!
        }
    }
    
    public void leer(JTextArea area1) throws IOException {
        FileReader fr = null;
        BufferedReader br;
        ArrayList<String> arraytxt = new ArrayList<>();
        String [] datos;
        String linea, texto="";
        String separadores = "[\\ \\;]";
        
        //comunicar con clases
        
        try {
            fr = new FileReader("archivo.txt"); //abrir archivo
            br = new BufferedReader(fr);
            
            System.out.println("* Leyendo archivo."); //mensaje test!!
            
            while((linea=br.readLine())!=null){
                //capturando lineas -> JTextArea
                texto+=linea+"\n";
                //capturando lineas y separando en palabras -> SQL
                datos = linea.split(separadores);
                String dato1 = datos[0];
                String dato2 = datos[1];
                String dato3 = datos[2];
                String dato4 = datos[3];
                String dato5 = datos[4];
                String dato6 = datos[5];
                //añadir palabras al arraylist -> SQL
                arraytxt.add(0,dato1);
                arraytxt.add(1,dato2);
                arraytxt.add(2,dato3);
                arraytxt.add(3,dato4);
                arraytxt.add(4,dato5);
                arraytxt.add(5,dato6);
                //enviar arraylist de datos -> SQL
                opsql.insertar(arraytxt);
            }
            System.out.println("* Cargando base de datos"); //mensaje test!!
            //pasar contenido a JTextArea
            area1.setText(texto);
            
        } catch (FileNotFoundException ex) {
            System.out.println("* Error de lectura: "+ex);
            
        } finally {
            try {
                if( null != fr )
                    fr.close(); //cerrar archivo
            } catch (IOException e1) {
                System.out.println(e1);
            }
        }
    }
    
    public void editar(JTextArea area1) throws IOException {
        FileReader fr = null;
        BufferedReader br;
        String linea, texto="";
        
        try {
            fr = new FileReader("archivo.txt"); //abrir archivo
            br = new BufferedReader(fr);
            
            System.out.println("* Editando archivo."); //mensaje test!!
            while((linea=br.readLine())!=null){
                //capturando lineas -> JTextArea
                texto+=linea+"\n";
            }
            //pasar contenido a JTextArea
            area1.setText(texto);
            
        } catch (FileNotFoundException ex) {
            System.out.println("* Error de edicion: "+ex);
            
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
        File fichero = new File("archivo.txt"); //abrir archivo
        
        if(fichero.delete()){
            System.out.println("* Borrando archivo"); //mensaje test
        }else{
            System.out.println("* El archivo no puede ser borrado");
        }
    }
    
    public void salir() {
        System.out.println("* Programa finalizado"); //mensaje test
        System.exit(0);
    }
    
    public void guardar(JTextArea area1) throws IOException {
        FileWriter fw;
        BufferedWriter bw;
        String [] texto;
        int i;
        
        try {
            fw=new FileWriter("archivo.txt"); //abrir archivo
            bw=new BufferedWriter(fw);
            //capturando texto del JtextArea
            texto = area1.getText().split("\n");
            
            for(i=0;i<texto.length;i++){
                //escribiendo texto capturado -> .txt
                bw.write(String.valueOf(texto [i]));
                bw.newLine(); //salto de linea
                opsql.actualizar(); //llamar sentencia sql
            }
            System.out.println("* Guardando cambios"); //mensaje test!!
            System.out.println("* Actualizando base de datos"); //mensaje test!!
            
            bw.close(); //cerrar archivo
            
        } catch (IOException e) {
            System.out.println(e);
        }
        
    }
    
    public void cancelar() {
        System.out.println("* Edicion cancelada"); //mensaje test!!
    }
    
}