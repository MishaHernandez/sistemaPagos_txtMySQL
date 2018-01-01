/*
 * Esta es la clase de la ventana que muestra la info del archivo de texto
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
public final class ventana1 extends JDialog implements ActionListener{
    JTextArea area1;
    JButton boton1;
    JScrollPane scroll;
    
    public ventana1(){
        configurarVentana();
        configurarComponentes();
    }
    
    public void configurarVentana() {
        this.setTitle("nombre del archivo");
        this.setSize(500, 485);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setModal(true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
    
    public void configurarComponentes() {
        //crear componentes
        area1=new JTextArea();
        scroll = new JScrollPane(area1);
        boton1=new JButton();
        //asignar etiquetas y contenidos
        area1.setText("hola");
        area1.setEditable(false);
        boton1.setText("Aceptar");
        //posicionar
        scroll.setBounds(20, 20, 455, 400);
        boton1.setBounds(200, 425, 100, 25);
        //añadir a la ventana
        this.add(scroll);
        this.add(boton1);
        //añadir eventos
        boton1.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //opf.aceptar();
        dispose();
    }
    
}
