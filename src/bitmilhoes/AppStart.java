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

//        Apostador p1 = new Apostador(212, (short) 1234, "OP1", java.time.LocalDate.now(), 30);
//        
//        List<Integer> numeros = new ArrayList<>();
//        
//        numeros.add(1);
//        numeros.add(5);
//        List<Integer> estrelas = new ArrayList<>();
//
//        estrelas.add(2);
//        estrelas.add(5);
//        p1.criarAposta(new Chave(numeros, estrelas));
        Apostador p1 = new Apostador(212, (short) 1234, "OP1", java.time.LocalDate.now(), 30);
        adicionarAposta(p1);
        adicionarMovimento(p1);
        //listarApostador(p1);
        System.out.println("*NEW*");
        IGestorAposta ga = new GestorAposta();

        
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
