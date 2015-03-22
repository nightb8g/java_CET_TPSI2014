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
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public void fechar() {
        try {
            this.objectIn.close();
            this.streamIn.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public T ler() {
        Object obj = null;
        try {
            obj = this.objectIn.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            
        }
        return (T)obj;
    }
}
