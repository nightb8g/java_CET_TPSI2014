/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmilhoes;

import bitmilhoes.controller.PainelPrincipalController;
import bitmilhoes.model.GestorAposta;
import bitmilhoes.files.FicheiroEscritaBinario;
import bitmilhoes.files.FicheiroEscritaTexto;
import bitmilhoes.files.FicheiroLeituraBinario;
import bitmilhoes.files.FicheiroLeituraTexto;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Jose António
 */
public class AppStart extends Application {

    @Override
    public void start(Stage primaryStage) {
        GestorAposta gestoraposta = new GestorAposta();
        //testesConsola(gestoraposta);
        testesFX(gestoraposta);
      
    }

    private void testesConsola(GestorAposta ga) {
        
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

    private Stage testesFX(GestorAposta gestoraposta) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/PainelPrincipal.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        try {
            stage.setScene(new Scene((AnchorPane) loader.load()));
        } catch (IOException ex) {
            Logger.getLogger(AppStart.class.getName()).log(Level.SEVERE, null, ex);
        }
        PainelPrincipalController controller = loader.<PainelPrincipalController>getController();
        controller.initdata(gestoraposta,stage);
        stage.show();
        return stage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
