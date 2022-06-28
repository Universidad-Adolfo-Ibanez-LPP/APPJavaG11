package com.uai.app.ui;

import com.uai.app.files.GlobalVals;
import com.uai.app.ui.utils.UAIJFrame;
import com.uai.app.ui.utils.UIBuilder;
import com.uai.app.files.FileManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainMenuUI extends UAIJFrame {

    private JPanel mainPanel;
    private JButton mostrarDatosButton;
    private JButton buscarButton;
    private JButton eliminarButton;
    private JButton EditarButton;
    private JButton AgregarButton;
    private JButton Salir;
    private JButton EliminarSSP;
    private JButton agregarSecciónSedePisoButton;


    public MainMenuUI(String title) {
        super(title);
        this.setMainPanel(mainPanel);
        setLocationRelativeTo(null); //para que se cree en el centro de la pantalla

        mostrarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIBuilder.buildUI(MostrarDatosUI.class);
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {UIBuilder.buildUI(buscador.class);}
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {UIBuilder.buildUI(BorrarLibroUI.class);
            }
        });


        EditarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIBuilder.buildUI(EditarUI.class);

            }
        });

        AgregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIBuilder.buildUI((AgregarUI.class));
            }
        });

        Salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame= new JFrame("EXIT");

                FileManager fileupdated = GlobalVals.getFilename();
                fileupdated.saveData();  // una vez que el usuario presiona el botón para salir de la biblioteca, automáticamente se salva la nueva información en el archivo original

                if( JOptionPane.showConfirmDialog(frame, "¿Seguro de que quieres salir?", "EXIT",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION ){
                    System.exit(0);
                    // tengo que trarae de llegar con f (info actualizada) acá
                    // para eso vamos a llamar a una clase que tenga esa info
                    //GlobalVals fupdated = new GlobalVals();


                }
            }
        });
        EliminarSSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {UIBuilder.buildUI(EliminarSSPUI.class);}
        });


        agregarSecciónSedePisoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {UIBuilder.buildUI(AgregarSSP.class);
            }
        });

        this.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {
                JFrame frame= new JFrame("EXIT");

                FileManager fileupdated = GlobalVals.getFilename();
                fileupdated.saveData();  // una vez que el usuario presiona el botón para salir de la biblioteca, automáticamente se salva la nueva información en el archivo original

                if( JOptionPane.showConfirmDialog(frame, "¿Seguro de que quieres salir?", "EXIT",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION ){
                    System.exit(0);
                    // tengo que trarae de llegar con f (info actualizada) acá
                    // para eso vamos a llamar a una clase que tenga esa info
                    //GlobalVals fupdated = new GlobalVals();

            }}

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }

        });
    }
}
