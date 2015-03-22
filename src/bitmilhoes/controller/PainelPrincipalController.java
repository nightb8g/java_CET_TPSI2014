/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmilhoes.controller;

import bitmilhoes.model.GestorAposta;
import bitmilhoes.model.files.FicheiroEscritaBinario;
import bitmilhoes.model.files.FicheiroLeituraBinario;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author night8ug
 */
public class PainelPrincipalController implements Initializable {

    private GestorAposta gestorAposta;
    private Stage stage;
    @FXML
    private BorderPane bp;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public void initdata(GestorAposta gestorAposta, Stage stage)
    {
      this.gestorAposta=gestorAposta;
      this.stage=stage;
    }
    public void setGestorAposta(GestorAposta gestorAposta) {
        this.gestorAposta = gestorAposta;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    private void handleSairAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void handleImportar(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        
         fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("BIN", "*.bin"));
        File file = fileChooser.showOpenDialog(stage);
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
        File file = fileChooser.showSaveDialog(stage);
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewApostadores.fxml"));
        loader.getController();
        Stage stage2 = new Stage(StageStyle.DECORATED);
        try {
           stage2.setScene(new Scene((AnchorPane) loader.load()));
        } catch (IOException ex) {
            Logger.getLogger(PainelPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
            stage2.initOwner(stage.getOwner());
            stage2.initModality(Modality.WINDOW_MODAL);
        stage2.show();
    }

}
