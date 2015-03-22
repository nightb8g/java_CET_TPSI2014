/*
 * Copyright (C) 2015 david
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package bitmilhoes.model.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author david
 */
public class FicheiroLeituraTexto extends Ficheiro {

    private BufferedReader bufferOut;

    public FicheiroLeituraTexto(File filename) {
        super(filename);
    }

    public String ler() {
        String out = null;
        try {
            out= this.bufferOut.readLine();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return out;
    }

    @Override
    public void abrir() {
        try {
            this.bufferOut = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void fechar() {
        try {
            this.bufferOut.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
