/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmilhoes;

import bitmilhoes.model.Apostador;
import bitmilhoes.model.Chave;
import bitmilhoes.model.GestorAposta;
import bitmilhoes.model.Natureza;
import java.time.LocalDate;
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
        GestorAposta ga=new GestorAposta();
        ga.novoApostador(212,  (short)1234, "OP1", java.time.LocalDate.now(), 30);
        //Apostador p1 = new Apostador(212,  (short)1234, "OP1", java.time.LocalDate.now(), 30);
        //ga.getApostadores()
//        adicionarAposta(p1);
//        adicionarMovimento(p1);
//        listarApostador(p1);
        Platform.exit();
    }
    private void listarApostador(Apostador apr){
        System.out.println(apr);
    }
    private void novaChave() {
        Chave c1 = new Chave();
        System.out.println(c1.toString());
    }
    private void adicionarAposta(Apostador apr){ 
       apr.criarAposta(new Chave());
    }
    private void adicionarMovimento(Apostador apr){
         apr.criarMovimento("Movimento de Teste", 12, Natureza.CREDITO);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
