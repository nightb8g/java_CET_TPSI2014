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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author david
 */
public class FicheiroEscritaTexto extends Ficheiro {

    private BufferedWriter bufferIn;

    public FicheiroEscritaTexto(File filename) {
        super(filename);
    }

    @Override
    public void abrir() {
        try {
            this.bufferIn = new BufferedWriter(new FileWriter(filename));
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void fechar() {
        try {
            this.bufferIn.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void escrever(String linha) {
        try {
            this.bufferIn.write(linha);
            this.bufferIn.newLine();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }

}
