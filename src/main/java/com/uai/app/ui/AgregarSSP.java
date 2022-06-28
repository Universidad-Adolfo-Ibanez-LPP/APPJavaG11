package com.uai.app.ui;

import com.uai.app.dominio.Libro;
import com.uai.app.exceptions.NotMainPanelLoadedException;
import com.uai.app.logic.DataManager;
import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import java.util.HashSet;

public class AgregarSSP extends UAIJFrame {
    private JPanel MainPanel;
    private JTextField Respuesta;
    private JTextField textField2;
    private int n;

    public AgregarSSP(String title) {
        super(title);
        setLocationRelativeTo(null); //para que se cree en el centro de la pantalla
        this.setMainPanel(MainPanel);
        this.setSize(800, 800);
        String agregar;


        //Hashset con las secciones
        HashSet<String> secciones = new HashSet<>();
        HashSet<String> sedes = new HashSet<>();
        HashSet<Integer> pisos = new HashSet<>();
        HashSet<Libro> data = DataManager.getInstance().getData();


        n = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número de lo que deseas agregas: " + " " + "1.Sede 2.Sección 3.Piso"));

        switch (n) {

            case 1:
                for (Libro i : data) {
                    sedes.add(i.getSede());
                }
                JOptionPane.showMessageDialog(null, "\"actualmente tienes: \"" + sedes);
                agregar = JOptionPane.showInputDialog("Ingresa la sede que deseas agregar");
                sedes.add(agregar);
                textField2.setText(String.valueOf(sedes));
                break;

            case 2:
                for (Libro i : data) {
                    secciones.add(i.getEstante_Seccion());
                }
                JOptionPane.showMessageDialog(null, "\"actualmente tienes: \"" + secciones);
                agregar = JOptionPane.showInputDialog("Ingresa la sección que deseas agregar");
                secciones.add(agregar);
                textField2.setText(String.valueOf(secciones));
                break;

            case 3:
                for (Libro i : data) {
                    pisos.add(i.getPiso());
                }
                JOptionPane.showMessageDialog(null, "\"actualmente tienes: \"" + pisos);
                agregar = JOptionPane.showInputDialog("Ingresa el piso que deseas agregar");
                pisos.add(Integer.valueOf(agregar));
                textField2.setText(String.valueOf(pisos));
                break;
        }

    }
    @Override
    public void showUI() throws NotMainPanelLoadedException {
        super.showUI();
        setSize(800,800);
    }
}
