/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmilhoes.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        }catch (Exception ex) {
            Logger.getLogger(FicheiroEscritaBinario.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    @Override
    public void fechar() {
        try {
            this.objectOut.close();
            this.streamOut.close();
        } catch (IOException ex) {
            Logger.getLogger(FicheiroEscritaBinario.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }

    public void escrever(Object obj) {
        try {
            objectOut.writeObject(obj);
        }catch (IOException ex) {
            Logger.getLogger(FicheiroEscritaBinario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
