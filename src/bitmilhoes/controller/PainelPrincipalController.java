/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmilhoes.controller;

import bitmilhoes.AppStart;
import bitmilhoes.files.FicheiroEscritaBinario;
import bitmilhoes.files.FicheiroLeituraBinario;
import bitmilhoes.model.GestorAposta;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author night8ug
 */
public class PainelPrincipalController implements Initializable {

    private GestorAposta gestorAposta;//retira um gestoraposta

    private Stage primaryStarge; //Stage

    private BorderPane borderPane;//BorderPane
    @FXML
    private AnchorPane anchorpane;

    //depositoLevantamento
    @FXML
    private void handleDepositoLevantamento(ActionEvent event) {

        System.out.println(ClassLoader.getSystemResource("bitmilhoes/view/PainelApostadores.fxml"));
        
    }

    //apostaAleatoria
    @FXML
    private void handleApostaAleatoria(ActionEvent event) {
    }

    //apostaPersonalizada
    @FXML
    private void handleApostaPersonalizada(ActionEvent event) {
    }

    //iniciaCicloApostas
    @FXML
    private void handleIniciaCicloApostas(ActionEvent event) {
    }

    //sorteaChaveAposta
    @FXML
    public void handleSorteaChaveVencedora(ActionEvent event) {
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if(anchorpane.getChildren().get(0)instanceof BorderPane)
         borderPane=(BorderPane)anchorpane.getChildren().get(0);
    }
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStarge = primaryStage;
    }
    public BorderPane getBorderPane() {
        return borderPane;
    }
    public Stage getPrimaryStage() {
        return primaryStarge;
    }
    public GestorAposta getGestorAposta() {
        return gestorAposta;
    }
    public void setGestorAposta(GestorAposta gestorAposta) {
        this.gestorAposta = gestorAposta;
    }
    public void initdata(GestorAposta gestorAposta, Stage stage) {
        this.gestorAposta = gestorAposta;
        this.primaryStarge = stage;
    }
    @FXML
    private void handleSair(ActionEvent event) {
        Platform.exit();
    }
    @FXML
    private void handleImportar(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("BIN", "*.bin"));
        File file = fileChooser.showOpenDialog(primaryStarge);
        //ler objecto
        if (file == null) {
            return;
        }
        FicheiroLeituraBinario<GestorAposta> flb = new FicheiroLeituraBinario(file);
        flb.abrir();
        do {
            GestorAposta linha = flb.ler();
            if (linha == null) {
                break;
            }
            gestorAposta = linha;
        } while (true);
        flb.fechar();
    }
    @FXML
    private void handleExportar(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Resource File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("BIN", "*.bin"));
        File file = fileChooser.showSaveDialog(primaryStarge);
        //escrever objecto
        FicheiroEscritaBinario feb = new FicheiroEscritaBinario(file);
        if (file == null) {
            return;
        }
        feb.abrir();
        feb.escrever(gestorAposta);
        feb.fechar();
    }
    @FXML
    private void handleDadosApostadores(ActionEvent event) {
     FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("bitmilhoes/view/PainelApostadores.fxml"));
     getBorderPane();
        try {
            borderPane.setCenter(loader.load());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
     
    }

}
