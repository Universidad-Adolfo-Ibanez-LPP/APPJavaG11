package com.uai.app.ui;

import com.uai.app.dominio.Libro;
import com.uai.app.exceptions.NotMainPanelLoadedException;
import com.uai.app.logic.DataManager;
import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import java.util.HashSet;
import java.util.Objects;

public class EliminarSSPUI extends UAIJFrame {
    private JPanel MainPanel;
    private JLabel respuesta;

    public EliminarSSPUI(String title) {
        super(title);
        this.setMainPanel(MainPanel);
        this.setSize(800, 800);
        setLocationRelativeTo(null); //para que se cree en el centro de la pantalla

        //obtengo los libros en una matriz
        HashSet<Libro> data = DataManager.getInstance().getData();
        String Titulon;
        HashSet<Libro> l1 = new HashSet<>();
        HashSet<String> secciones = new HashSet<>();
        HashSet<String> sedes = new HashSet<>();
        HashSet<Integer> pisos = new HashSet<>();
        boolean resp= false;

        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número de lo que deseas eliminar:" +
                " 1.Sede 2.Sección 3.Piso\n"));
        JOptionPane.showMessageDialog(null, "Para poder eliminar tu elección se borraran los libros asociados a esta.");

        switch(n) {
            case 1:
                for (Libro i : data) {
                    sedes.add(i.getSede());
                }
                JOptionPane.showMessageDialog(null, "\"actualmente tienes: \"" + sedes);
                Titulon = JOptionPane.showInputDialog("Ingresa la sede que quieres eliminar: ");
                for (Libro p:data) {
                    String sede = p.getSede();
                    if (Objects.equals(Titulon, sede)) {
                        l1.add(p);
                        resp=true;
                    }
                }
                DataManager.getInstance().removerLibro(l1);
                if (resp){
                    respuesta.setText("Sede eliminada correctamente");
                }else{
                    respuesta.setText("No se pudo eliminar la sede");
                }
                break;


            case 2:
                for (Libro i : data) {
                    secciones.add(i.getEstante_Seccion());
                }
                JOptionPane.showMessageDialog(null, "\"actualmente tienes: \"" + secciones);
                Titulon = JOptionPane.showInputDialog("Ingresa la sección que quieres eliminar: ");
                for (Libro p:data) {
                    String seccion = p.getEstante_Seccion();
                    if (Objects.equals(Titulon, seccion)) {
                        l1.add(p);
                        resp=true;
                    }
                }
                if (resp){
                    respuesta.setText("Sección eliminada correctamente");
                }else{
                    respuesta.setText("No se pudo eliminar la sección");
                }
                DataManager.getInstance().removerLibro(l1);
                break;


            case 3:
                for (Libro i : data) {
                    pisos.add(i.getPiso());
                }
                JOptionPane.showMessageDialog(null, "\"actualmente tienes: \"" + pisos);
                Titulon = JOptionPane.showInputDialog("Ingresa el piso que quieres eliminar: ");
                int Titulo = Integer.parseInt(Titulon);
                for (Libro p:data) {
                    int seccion =p.getPiso();
                    if (Titulo== seccion) {
                        l1.add(p);
                        resp=true;
                    }
                }
                if (resp){
                    respuesta.setText("Piso eliminado correctamente");
                }else{
                    respuesta.setText("No se pudo eliminar el piso");
                }
                DataManager.getInstance().removerLibro(l1);
                break;
        }
    }
    @Override
    public void showUI() throws NotMainPanelLoadedException {
        super.showUI();
        setSize(200,200);
    }
}
