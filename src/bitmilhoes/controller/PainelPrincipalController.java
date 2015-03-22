/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmilhoes.controller;

import bitmilhoes.AppStart;
import bitmilhoes.model.GestorAposta;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author night8ug
 */
public class PainelPrincipalController implements Initializable {
    
    private GestorAposta gestorAposta;//retira um gestoraposta
    
    @FXML
    
    private Stage primaryStarge; //Stage
    
    @FXML
    private BorderPane borderPane;//BorderPane
    
    //importar
    public void handleImportar(ActionEvent event){
    }
    
    //guardar
    public void handleGuardar(ActionEvent event){
    }
    
    //sair
    public void handleSair(ActionEvent event){
        Platform.exit();
    }
    
    //dadosApostadores
    public void handleDadosApostadores(ActionEvent event){
        //try catch -> verificar erros
        try{
            //criar um node com correspondente painel
            Node node = getPainelApostadores();
            //colocar para a posição do borderpane
        }catch(Exception e){ System.out.println(e.getMessage());}
    }
    
    //depositoLevantamento
    public void handleDepositoLevantamento(ActionEvent event){
    }
    
    //apostaAleatoria
    public void handleApostaAleatoria(ActionEvent event){
    }
    
    //apostaPersonalizada
    public void handleApostaPersonalizada(ActionEvent event){
    }
    
    //iniciaCicloApostas
    public void handleIniciaCicloApostas(ActionEvent event){
    }
    
    //sorteaChaveAposta
    public void handleSorteaChaveVencedora(ActionEvent event){
    }
    
//    @FXML
//    private 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setPrimaryStage(Stage primaryStage){
        this.primaryStarge = primaryStage;
    }
    
    public BorderPane getBorderPane(){
        return borderPane;
    }
    
    public Stage getPrimaryStage(){
        return primaryStarge;
    }
    
    public GestorAposta getGestorAposta(){
        return gestorAposta;
    }
    
    private Node getPainelApostadores(){
        FXMLLoader loader = new FXMLLoader(AppStart.class.getResource("view/PainelApostadores.fxml"));
        loader.setController(new PainelApostadoresController(this));//ainda por implementar
        AnchorPane anchorPane = null;
        anchorPane = (AnchorPane) loader.load();
        return anchorPane;
    }
    
//    private Node getPainelMovimentos(){
//    FXMLLoader loader = new FXMLLoader(AppStart.class.getResource("view/PainelMovimentos.fxml"));
//        loader.setController(new PainelApostadoresController(this));
//        AnchorPane anchorPane = null;
//        anchorPane = (AnchorPane) loader.load();
//        return anchorPane;
//    }
    
//    private Node getPainelAlterarPin(){
//        FXMLLoader loader = new FXMLLoader(AppStart.class.getResource("view/PainelAlterarPin.fxml"));
//        loader.setController(new PainelApostadoresController(this));
//        AnchorPane anchorPane = null;
//        anchorPane = (AnchorPane) loader.load();
//        return anchorPane;
//    }
    
//    private Node getPainelApostas(){
//        FXMLLoader loader = new FXMLLoader(AppStart.class.getResource("view/PainelApostas.fxml"));
//        loader.setController(new PainelApostadoresController(this));
//        AnchorPane anchorPane = null;
//        anchorPane = (AnchorPane) loader.load();
//        return anchorPane;
//    }
    
}
