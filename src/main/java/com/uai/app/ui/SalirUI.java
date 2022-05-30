package com.uai.app.ui;

import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalirUI extends UAIJFrame {
    private JPanel MainPanel;
    private JButton NOButton;
    private JButton SIButton;
    private JTextField Pregunta;


    public SalirUI(String title) {
        super(title);
        this.setMainPanel(MainPanel);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);

        SIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });

        NOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}