/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmilhoes;

import bitmilhoes.containers.ContainerList;
import bitmilhoes.containers.ContainerSet;
import bitmilhoes.containers.IContainerOperations;
import bitmilhoes.model.Apostador;
import bitmilhoes.model.Chave;
import bitmilhoes.model.GestorAposta;
import bitmilhoes.model.IGestorAposta;
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
        
        IContainerOperations<Integer> nums=new ContainerSet<>();
        IContainerOperations<Integer> ests=new ContainerSet<>();
        nums.insert(3);
        nums.insert(6);
        nums.insert(9);
        nums.insert(12);
        nums.insert(15);
        ests.insert(3);
        ests.insert(6);
        Chave c=new Chave(nums,ests);
        
        ga.apostaPersonalizada(212, (short) 1234, c.getNumeros(),c.getEstrelas());
        ga.apostaPersonalizada(212, (short) 1234, c.getNumeros(),c.getEstrelas());
        
        ga.efectuarSorteio(c.getNumeros(),c.getEstrelas());
        Apostador ap = ga.getApostador(212,(short) 1234);
        System.out.println(ga.getApostador(212,(short) 1234).getApostas().get(1));
        Platform.exit();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
