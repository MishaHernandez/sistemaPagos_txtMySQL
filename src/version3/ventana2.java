/*
 * Esta es la clase de la ventana que edita la info del archivo de texto
 */

package version3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Mijail J. Hernandez
 */
public class ventana2 extends JDialog implements ActionListener{
    JTextArea area1;
    JButton boton1, boton2;
    JScrollPane scroll;
    //private Container contenedor;
    
    public ventana2(){
        configurarVentana();
        configurarComponentes();
    }
    
    private void configurarVentana() {
        this.setTitle("Editar contenido");
        this.setSize(500, 485);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setModal(true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    private void configurarComponentes() {
        //crear componentes
        area1=new JTextArea();
        scroll = new JScrollPane(area1); 
        boton1=new JButton();
        boton2=new JButton();
        //asignar etiquetas y contenidos
        area1.setText("Aqui va el contenido del archivo"); //asignar desde la clase operationFile
        area1.setEditable(true);
        boton1.setText("Guardar");
        boton2.setText("Cancelar");
        //posicion de los controles
        scroll.setBounds(20, 20, 455, 400);
        boton1.setBounds(125, 425, 100, 25);
        boton2.setBounds(250, 425, 100, 25);
        //añadir a la ventana
        this.add(scroll);
        this.add(boton1);
        this.add(boton2);
        //añadir eventos
        boton1.addActionListener(this);
        boton2.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //OperacionesFile opf=new OperacionesFile();
        //GUARDAR
        if(e.getSource()==boton1){
            //opf.abrir(texto2);
            
        }
        //CANCELAR
        if(e.getSource()==boton2){
            //opf.leer();
            dispose();
        }
        
    }

}
