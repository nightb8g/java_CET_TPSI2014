/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmilhoes.controller;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author night8ug
 */
public class PainelPrincipalController implements Initializable {

    private GestorAposta gestorAposta;//retira um gestoraposta

    private Stage primaryStarge; //Stage

    private BorderPane borderPane;//BorderPane

    //sair
    @FXML
    public void handleSair(ActionEvent event) {
        Platform.exit();
    }

    //depositoLevantamento
    @FXML
    public void handleDepositoLevantamento(ActionEvent event) {
    }

    //apostaAleatoria
    @FXML
    public void handleApostaAleatoria(ActionEvent event) {
    }

    //apostaPersonalizada
    @FXML
    public void handleApostaPersonalizada(ActionEvent event) {
    }

    //iniciaCicloApostas
    @FXML
    public void handleIniciaCicloApostas(ActionEvent event) {
    }

    //sorteaChaveAposta
    @FXML
    public void handleSorteaChaveVencedora(ActionEvent event) {
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

    private void handleSairAction(ActionEvent event) {
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
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(gestorAposta.toString());
        alert.showAndWait();
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/PainelPrincipal.fxml"));
        loader.getController();
        Stage stage2 = new Stage(StageStyle.DECORATED);
        try {
            stage2.setScene(new Scene((AnchorPane) loader.load()));
        } catch (IOException ex) {
            Logger.getLogger(PainelPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage2.initOwner(primaryStarge.getOwner());
        stage2.initModality(Modality.WINDOW_MODAL);
        stage2.show();
    }

}
