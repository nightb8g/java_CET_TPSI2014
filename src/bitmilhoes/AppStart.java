/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmilhoes;

import bitmilhoes.model.GestorAposta;
import bitmilhoes.model.files.FicheiroEscritaBinario;
import bitmilhoes.model.files.FicheiroEscritaTexto;
import bitmilhoes.model.files.FicheiroLeituraBinario;
import bitmilhoes.model.files.FicheiroLeituraTexto;
import ficheiros.Pessoa;
import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import javafx.application.Application;
import javafx.application.Platform;

import javafx.stage.Stage;

/**
 *
 * @author Jose António
 */
public class AppStart extends Application {

    @Override
    public void start(Stage primaryStage) {
        GestorAposta ga = new GestorAposta();
        ga.novoApostador(212, (short) 1234, "OP", LocalDate.of(1980, Month.OCTOBER, 31), 30);
        ga.apostaAleatoria(212, (short) 1234);
        
        
        //escrever fcheiro
        FicheiroEscritaTexto fet = new FicheiroEscritaTexto(new File("Pessoas.txt"));

        fet.abrir();
        fet.escrever(ga.toString());
        fet.fechar();

        //ler ficheiro
        FicheiroLeituraTexto flt = new FicheiroLeituraTexto(new File("Pessoas.txt"));
        
        flt.abrir();
        do {
            String linha = flt.ler();
            if (linha == null) {
                break;
            }
            System.out.println(linha);
        } while (true);
        flt.fechar();
        
        
        //escrever objecto
        FicheiroEscritaBinario feb = new FicheiroEscritaBinario(new File("Pessoas.bin"));
       // System.out.println(ga);
        feb.abrir();
        feb.escrever(ga.getApostadores());
        feb.fechar();

        //ler objecto
        FicheiroLeituraBinario<GestorAposta> flb = new FicheiroLeituraBinario(new File("Pessoas.bin"));
        flb.abrir();
        do {
            GestorAposta linha = flb.ler();
            if (linha == null) {
                break;
            }
           System.out.println(linha);
        } while (true);
        flb.fechar();
        
       
        
        Platform.exit();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
