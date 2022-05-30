package com.uai.app;

import com.uai.app.dominio.Libro;
import com.uai.app.dominio.enums.Tittles;
import com.uai.app.exceptions.CSVNotFoundException;
import com.uai.app.files.FileManager;
import com.uai.app.files.GlobalVals;
import com.uai.app.logic.DataManager;
import com.uai.app.logic.SearchManager;
import com.uai.app.ui.utils.UIBuilder;
import com.uai.app.ui.MainMenuUI;

import javax.swing.*;
import java.io.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws IOException {
        System.out.println("Bienvenido");
        String fileName = args[0];

        try {

            //instancio el file manager
            final FileManager f = new FileManager(fileName);
            GlobalVals globalFile = new GlobalVals(f);  // guardamos el objeto FileManager como variable global

            //instancio y seteo la data
            DataManager.getInstance().setData(f.getData());

            //aca ya puedo llamar al menu
            UIBuilder.buildMainUI(MainMenuUI.class);


        } catch (CSVNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Terminado");

    }
}
