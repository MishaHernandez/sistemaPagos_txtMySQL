package version2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * Aqui va la configuracion de la ventana menu
 */

/**
 *
 * @author Mijail J. Hernandez
 */
public class Aplicacion extends JFrame implements ActionListener{
    //componentes
    private JLabel texto1, texto2;
    private JButton boton1, boton2, boton3, boton4, boton5;
    
    public static void main(String[] args) {
        Aplicacion ventana = new Aplicacion();
        ventana.setVisible(true);
    }
    
    public Aplicacion(){
        configurarVentana();
        configurarComponentes();
    }
    
    private void configurarVentana(){
        this.setTitle("Operaciones");
        this.setSize(310, 220);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void crearComponentes(){
        texto1=new JLabel();
        texto2=new JLabel();
        boton1=new JButton();
        boton2=new JButton();
        boton3=new JButton();
        boton4=new JButton();
        boton5=new JButton();
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
        boton5.setText("Salir");
        
        //posicion de los controles
        texto1.setBounds(50, 25, 50, 25);
        texto2.setBounds(120, 25, 100, 25);
        boton1.setBounds(50, 75, 100, 25);
        boton2.setBounds(170, 75, 100, 25);
        boton3.setBounds(50, 115, 100, 25);
        boton4.setBounds(170, 115, 100, 25);
        boton5.setBounds(110, 150, 100, 25);
        
        //añadir a la ventana
        this.add(texto1);
        this.add(texto2);
        this.add(boton1);
        this.add(boton2);
        this.add(boton3);
        this.add(boton4);
        this.add(boton5);
        
        //añadir evento
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);
        boton4.addActionListener(this);
        boton5.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        OperacionesFile opf=new OperacionesFile();
        //ABRIR
        if(e.getSource()==boton1){
            opf.abrir(texto2);
        }
        //LEER
        if(e.getSource()==boton2){
            try {
                opf.leer();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        //EDITAR
        if(e.getSource()==boton3){
            opf.editar();
        }
        //ELIMINAR
        if(e.getSource()==boton4){
            opf.eliminar();
        }
        //SALIR
        if(e.getSource()==boton5){
            opf.salir();
        }
    }

}
