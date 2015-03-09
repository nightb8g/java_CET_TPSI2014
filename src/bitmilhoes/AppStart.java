/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmilhoes;

import bitmilhoes.model.Apostador;
import bitmilhoes.model.Chave;
import bitmilhoes.model.GestorAposta;
import bitmilhoes.model.IGestorAposta;
import bitmilhoes.model.Movimento;
import bitmilhoes.model.Natureza;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
        IGestorAposta ga = new GestorAposta();
        ga.novoApostador(212, (short) 1234, "OP", java.time.LocalDate.now(), 30);
        ga.apostaAleatoria(212, (short) 1234);
        ga.creditarMontante(212, (short)1234,"Movimento de Teste", 10);

        Platform.exit();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
