package com.uai.app.ui;

import com.uai.app.dominio.Libro;
import com.uai.app.exceptions.NotMainPanelLoadedException;
import com.uai.app.logic.DataManager;
import com.uai.app.ui.utils.UAIJFrame;
import org.apache.tools.ant.Main;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.util.HashSet;

public class AgregarUI extends UAIJFrame {

    private JPanel MainPanel;
    private JLabel Respuesta;
    String titulo,autor,estante_seccion,edificio,sede;
    int anio,estante_numero,piso;

    public AgregarUI(String title){
        super(title);
        this.setMainPanel(MainPanel);
        this.setSize(800,800);
        setLocationRelativeTo(null); //para que se cree en el centro de la pantalla

        titulo= JOptionPane.showInputDialog("Ingresa el nombre del libro:");
        autor= JOptionPane.showInputDialog("Ingresa el autor del libro;");
        anio= Integer.parseInt(JOptionPane.showInputDialog("Ingresa el año del libro:"));
        estante_numero= Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero del estante donde quieres guardar el libro: "));
        estante_seccion= JOptionPane.showInputDialog("Ingresa la seccion en la que deseas guardar el libro:");
        piso= Integer.parseInt(JOptionPane.showInputDialog("Ingresa el piso en el que quieres guardar el libro"));
        edificio= JOptionPane.showInputDialog("Ingresa el edificio donde quieres guardar el libro:");
        sede= JOptionPane.showInputDialog("Ingresa la sede donde deseas guardar el libro:");



        //titulo,autor,anio,estante_numero,estante_seccion,piso,edificio,sede


        Libro l= new Libro();
        l.setTitulo(titulo);
        l.setAutor(autor);
        l.setAnio(anio);
        l.setEstante_numero(estante_numero);
        l.setEstante_seccion(estante_seccion);
        l.setPiso(piso);
        l.setEdifico(edificio);
        l.setSede(sede);

        DataManager.getInstance().agregarLibro(l);
        Respuesta.setText("Libro agregado correctamente");
    }
    @Override
    public void showUI() throws NotMainPanelLoadedException {
        super.showUI();
        setSize(200,200);
    }
}
