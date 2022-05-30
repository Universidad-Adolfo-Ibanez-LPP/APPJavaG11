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

public class EditarUI extends UAIJFrame {

    private JPanel MainPanel;
    private JTextArea Titulo;
    private JButton OKButton;

    public EditarUI(String title) {
        super(title);
        this.setMainPanel(MainPanel);
        this.setSize(800, 800);
        setLocationRelativeTo(null); //para que se cree en el centro de la pantalla

        //obtengo los libros en una matriz
        HashSet<Libro> data = DataManager.getInstance().getData();
        Libro p2 = new Libro();

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Titulon = Titulo.getText();
                String titulon,autorn,estante_seccionn, edificion, seden;
                int anion,estante_numeron, pison ,n = 0;

                for (Libro l : data) {
                    p2.setTitulo(l.getTitulo());

                    if (Objects.equals(Titulon, p2.getTitulo())) {
                        Titulo.setText("Libro encontrado");
                        n = Integer.parseInt(JOptionPane.showInputDialog("Ingresa lo que quieras editar:" +
                                " 1.titulo 2.autor 3.anio 4.estante_numero 5.estante_seccion 6.piso 7.edificio 8.sede\n"));
                        switch(n){
                            case 1:
                                Titulon= JOptionPane.showInputDialog("Ingresa el titulo");
                                l.setTitulo(Titulon);
                                JOptionPane.showMessageDialog(null,"Libro editado correctamente");
                                break;
                            case 2:
                                autorn= JOptionPane.showInputDialog("Ingresa el autor");
                                l.setAutor(autorn);
                                JOptionPane.showMessageDialog(null,"Libro editado correctamente");
                                break;
                            case 3:
                                anion= Integer.parseInt(JOptionPane.showInputDialog("Ingresa el anio"));
                                l.setAnio(anion);
                                JOptionPane.showMessageDialog(null,"Libro editado correctamente");
                                break;
                            case 4:
                                estante_numeron= Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero del estante"));
                                l.setEstante_numero(estante_numeron);
                                JOptionPane.showMessageDialog(null,"Libro editado correctamente");
                                break;
                            case 5:
                                estante_seccionn= JOptionPane.showInputDialog("Ingresa la seccion");
                                l.setEstante_seccion(estante_seccionn);
                                JOptionPane.showMessageDialog(null,"Libro editado correctamente");
                                break;
                            case 6:
                                pison= Integer.parseInt(JOptionPane.showInputDialog("Ingresa el piso"));
                                l.setPiso(pison);
                                JOptionPane.showMessageDialog(null,"Libro editado correctamente");
                                break;
                            case 7:
                                edificion= JOptionPane.showInputDialog("Ingresa el edifico");
                                l.setEdifico(edificion);
                                JOptionPane.showMessageDialog(null,"Libro editado correctamente");
                                break;
                            case 8:
                                seden= JOptionPane.showInputDialog("Ingresa la sede");
                                l.setSede(seden);
                                JOptionPane.showMessageDialog(null,"Libro editado correctamente");
                                break;
                        }

                    }

                }
            }
        });
    }
    @Override
    public void showUI() throws NotMainPanelLoadedException {
        super.showUI();
        setSize(300,150);
    }
}

