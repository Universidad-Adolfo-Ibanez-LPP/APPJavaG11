package com.uai.app.logic;

import com.uai.app.dominio.Libro;
import com.uai.app.dominio.Libro;
import com.uai.app.dominio.enums.Tittles;
import com.uai.app.exceptions.DataNotLoadedException;
import com.uai.app.ui.utils.*;
import org.apache.commons.text.CaseUtils;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/*
*
* Dado que solo necesitare una instancia de esta clase
* la convierto en SIngleton https://refactoring.guru/design-patterns/singleton
*
 */

public class DataManager {

    private HashSet<Libro> data;

    private static DataManager instance;

    //todos los singletons
    // tienen constructores privados

    public static DataManager getInstance(){
        if (instance == null){
            instance = new DataManager();
            SearchManager.getInstance();
        }
        return instance;
    }


    public HashSet<Libro> getData() {
        return data;
    }
    public void setData(HashSet<Libro> data) {
        this.data = data;
    }
    public void agregarLibro(Libro l){
        this.data.add(l);
    }
    public void removerLibro(Libro l){
        this.data.remove(l);
    }
    public void removerLibro(Collection<Libro> libros){
        this.data.removeAll(libros);
    }

}
