/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmilhoes.model.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author david
 */
public class FicheiroEscritaBinario extends Ficheiro {

    private FileOutputStream streamOut;
    private ObjectOutputStream objectOut;

    public FicheiroEscritaBinario(File filename) {
        super(filename);
    }

    @Override
    public void abrir() {
        try {
            this.streamOut = new FileOutputStream(filename);
            this.objectOut = new ObjectOutputStream(streamOut);
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void fechar() {
        try {
            this.objectOut.close();
            this.streamOut.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void escrever(Object obj) {
        try {
            objectOut.writeObject(obj);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }
}
