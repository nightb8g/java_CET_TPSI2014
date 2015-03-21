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
import java.time.LocalDate;
import java.time.LocalDateTime;
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
         ga.novoApostador(123, (short) 1234, "AP",LocalDate.of(1990, Month.MARCH, 3), 30);
        ga.apostaAleatoria(212, (short) 1234);
        ga.apostaAleatoria(212, (short) 1234);
        ga.apostaAleatoria(212, (short) 1234);
       
        ga.efectuarSorteio();
        
        System.out.println(ga.getApostadores());
        System.out.println("nome "+ga.listarApostadoresNome());
        System.out.println("data nascimento "+ ga.listarApostadoresDataNascimento());
        System.out.println("saldo "+ga.listarApostadoresSaldo());
        Platform.exit();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
