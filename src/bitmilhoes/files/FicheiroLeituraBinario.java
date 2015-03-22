/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmilhoes.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class FicheiroLeituraBinario<T> extends Ficheiro {

    private FileInputStream streamIn;
    private ObjectInputStream objectIn;

    public FicheiroLeituraBinario(File filename) {
        super(filename);
    }

    @Override
    public void abrir() {
        try {
            this.streamIn = new FileInputStream(filename);
            this.objectIn = new ObjectInputStream(streamIn);
        }
             catch (Exception ex) {
            Logger.getLogger(FicheiroLeituraBinario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void fechar() {
        try {
            this.objectIn.close();
            this.streamIn.close();
        } catch (Exception ex) {
            Logger.getLogger(FicheiroEscritaBinario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public T ler() {
        Object obj = null;
        try {
            obj = this.objectIn.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(FicheiroEscritaBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (T)obj;
    }
}
