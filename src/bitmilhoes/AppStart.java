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
import bitmilhoes.model.Apostador;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
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
        testesConsola(gestoraposta);
        //testesFX(gestoraposta);
      
    }

    private void testesConsola(GestorAposta ga) {
        
        ga.novoApostador(212, (short) 1234, "OP", LocalDate.of(1980, Month.OCTOBER, 31), 30);
        ga.apostaAleatoria(212, (short) 1234);
        ga.apostaAleatoria(212, (short) 1234);
        ga.apostaAleatoria(212, (short) 1234);
        ga.novoApostador(1234, (short) 1234, "AP", LocalDate.of(1990, Month.OCTOBER, 31), 10);
        ga.apostaAleatoria(1234, (short) 1234);
        ga.apostaAleatoria(1234, (short) 1234);
        ga.apostaAleatoria(1234, (short) 1234);
        ga.apostaAleatoria(1234, (short) 1234);
        ga.apostaAleatoria(1234, (short) 1234);
        
        ga.efectuarSorteio();
        System.out.println(ga);
       ga.efectuarSorteio();
       
        System.out.println(ga);
        System.out.println(ga.iniciarCicloApostas());
       
     
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
        //teste
        return stage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
