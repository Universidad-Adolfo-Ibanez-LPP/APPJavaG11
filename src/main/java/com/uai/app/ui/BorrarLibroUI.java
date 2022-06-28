package com.uai.app.ui;

import com.uai.app.dominio.Libro;
import com.uai.app.exceptions.NotMainPanelLoadedException;
import com.uai.app.logic.DataManager;
import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Objects;

public class BorrarLibroUI extends UAIJFrame {

    private JPanel MainPanel;
    private JButton button1;
    private JTextField textField1;
    private JLabel respuesta;
    String titulo;
    int condicional;



    public BorrarLibroUI(String title) {
        super(title);
        this.setMainPanel(MainPanel);
        this.setSize(800, 800);
        setLocationRelativeTo(null); //para que se cree en el centro de la pantalla

        //obtengo las personas en una matriz
        HashSet<Libro> data = DataManager.getInstance().getData();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String libroBuscado = textField1.getText();

                for (Libro p:data){
                    titulo= p.getTitulo();
                    if(Objects.equals(titulo, libroBuscado)){
                        DataManager.getInstance().removerLibro(p);
                        condicional=1;
                        break;
                    }else{
                        condicional=0;
                    }
                }   //verifica si está el libro

                if(condicional==1){
                    respuesta.setText("Eliminado correctamente");
                }if(condicional==0){
                    respuesta.setText("No se pudo eliminar");
                }   //te hace la respuesta dependiendo de si está o no el libro

            }
        });

    }
    @Override
    public void showUI() throws NotMainPanelLoadedException {
        super.showUI();
        setSize(300,150);
    }}





