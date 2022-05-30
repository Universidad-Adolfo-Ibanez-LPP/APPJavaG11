package com.uai.app.files;

public class GlobalVals {  // esta clase es para tener a mano el archivo actualizado (sobre el cual vamos a ingresar, sacar, etc. libros)
    static FileManager filename = null;

    public GlobalVals(FileManager filename) {
        GlobalVals.filename = filename;
    }

    public static FileManager getFilename() {
        return filename;
    }
}
