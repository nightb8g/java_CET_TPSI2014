/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmilhoes;

import bitmilhoes.containers.ContainerSet;
import bitmilhoes.containers.IContainerOperations;
import bitmilhoes.model.Apostador;
import bitmilhoes.model.Chave;
import bitmilhoes.model.GestorAposta;
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
        ga.novoApostador(212, (short) 1234, "OP", java.time.LocalDate.now(), 30);
        ga.apostaAleatoria(212, (short) 1234);
        ga.apostaAleatoria(212, (short) 1234);
        ga.apostaAleatoria(212, (short) 1234);
       
        ga.efectuarSorteio();
        Apostador ap = ga.getApostador(212,(short) 1234);
        System.out.println(ap);
        Platform.exit();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
