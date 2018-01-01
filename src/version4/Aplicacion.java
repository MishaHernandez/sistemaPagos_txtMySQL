package version4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/*
 * Aqui va la configuracion de la ventana menu y sus controles
 */

/**
 *
 * @author Mijail J. Hernandez
 */
public class Aplicacion extends JFrame implements ActionListener{
    //componentes
    JLabel texto1, texto2;
    JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7;
    JTextArea area1;
    
    public static void main(String[] args) {
        Aplicacion menu = new Aplicacion();
        menu.setVisible(true);
        System.out.println("Historial de eventos:");
        System.out.println("=====================");
    }
    
    public Aplicacion(){
        configurarVentana();
        configurarComponentes();
    }
    
    private void configurarVentana(){
        this.setTitle("Operaciones");
        this.setSize(470, 320);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void crearComponentes(){
        texto1=new JLabel();
        texto2=new JLabel();
        area1=new JTextArea();
        boton1=new JButton();
        boton2=new JButton();
        boton3=new JButton();
        boton4=new JButton();
        boton5=new JButton();
        boton6=new JButton();
        boton7=new JButton();
    }
    
    private void configurarComponentes() {
        crearComponentes();
        //asignar etiquetas
        texto1.setText("Archivo: ");
        texto2.setText("...");
        boton1.setText("Abrir");
        boton2.setText("Leer");
        boton3.setText("Editar");
        boton4.setText("Eliminar");
        boton5.setText("Guardar");
        boton6.setText("Cancelar");
        boton7.setText("Salir");
        //posicion de los controles
        texto1.setBounds(20, 20, 50, 25);
        texto2.setBounds(80, 20, 250, 25);
        area1.setBounds(20, 60, 300, 215);
        area1.setEditable(false);
        boton1.setBounds(340, 20, 100, 25);
        boton2.setBounds(340, 80, 100, 25);
        boton3.setBounds(340, 110, 100, 25);
        boton4.setBounds(340, 140, 100, 25);
        boton5.setBounds(340, 170, 100, 25);
        boton5.setEnabled(false);
        boton6.setBounds(340, 200, 100, 25);
        boton6.setEnabled(false);
        boton7.setBounds(340, 230, 100, 25);
        //añadir a la ventana
        this.add(texto1);
        this.add(texto2);
        this.add(area1);
        this.add(boton1);
        this.add(boton2);
        this.add(boton3);
        this.add(boton4);
        this.add(boton5);
        this.add(boton6);
        this.add(boton7);
        //añadir evento
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);
        boton4.addActionListener(this);
        boton5.addActionListener(this);
        boton6.addActionListener(this);
        boton7.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        OperacionesFile of=new OperacionesFile();
        
        //ABRIR
        if(e.getSource()==boton1){
            of.abrir(texto2);
            //definir la ruta del folder!!
        }
        //LEER
        if(e.getSource()==boton2){
            try {
                of.leer(area1);
                
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        //EDITAR
        if(e.getSource()==boton3){
            area1.setEditable(true);
            boton2.setEnabled(false);
            boton3.setEnabled(false);
            boton4.setEnabled(false);
            boton5.setEnabled(true);
            boton6.setEnabled(true);
            try {
                of.editar(area1);
                
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        //ELIMINAR
        if(e.getSource()==boton4){
            of.eliminar();
        }
        //GUARDAR
        if(e.getSource()==boton5){
            area1.setEditable(false);
            boton2.setEnabled(true);
            boton3.setEnabled(true);
            boton4.setEnabled(true);
            boton5.setEnabled(false);
            boton6.setEnabled(false);
            try {
                of.guardar(area1);
                
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        //CANCELAR
        if(e.getSource()==boton6){
            area1.setEditable(false);
            boton2.setEnabled(true);
            boton3.setEnabled(true);
            boton4.setEnabled(true);
            boton5.setEnabled(false);
            boton6.setEnabled(false);
            of.cancelar();
        }
        //SALIR
        if(e.getSource()==boton7){
            of.salir();
        }
    }

}
