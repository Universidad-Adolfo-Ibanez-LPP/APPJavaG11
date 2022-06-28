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

public class buscador extends UAIJFrame {
    private JPanel mainpanel;
    private JButton OKButton;
    private JLabel Noencontro;
    private JLabel Libroencontrado;
    private JTextField LibroABuscar;


    public buscador(String title) {
        super(title);
        this.setMainPanel(mainpanel);
        this.setSize(800, 800);
        setLocationRelativeTo(null); //para que se cree en el centro de la pantalla

        //obtengo las personas en una matriz
        HashSet<Libro> data = DataManager.getInstance().getData();
        Libro p2 = new Libro();
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Titulo = LibroABuscar.getText();
                int cont = 0;
                int pos;
                for (Libro l : data) {
                    p2.setTitulo(l.getTitulo());
                    p2.setAutor(l.getAutor());
                    p2.setAnio(l.getAnio());
                    p2.setEstante_numero(l.getEstante_Numero());
                    p2.setEstante_seccion(l.getEstante_Seccion());
                    p2.setPiso(l.getPiso());
                    p2.setEdifico(l.getEdificio());
                    p2.setSede(l.getSede());


                    if (Objects.equals(Titulo, p2.getTitulo())) {

                        Libroencontrado.setText("Título: " + p2.getTitulo() + "\nAutor: " + p2.getAutor()+ "\nAño: "
                                + p2.getAnio()+ "\nEstante: "+ p2.getEstante_Numero()+"\nSección: "+ p2.getEstante_Seccion()
                                +"\nPiso: "+p2.getPiso()+"\nEdificio:"+p2.getEdificio()+"\nSede: "+p2.getSede());
                        break;
                    } else {
                        Libroencontrado.setText("No existe el libro");
                    }


                }
            }
        });
    }
    @Override
    public void showUI() throws NotMainPanelLoadedException {
        super.showUI();
        setSize(1000,300);
    }
}


