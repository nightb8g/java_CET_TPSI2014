/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmilhoes.controller;

import bitmilhoes.model.Aposta;
import bitmilhoes.model.Chave;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author night8ug
 */
public class PainelApostasController implements Initializable {
    
    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnReiniciar;

    @FXML
    private TextField textPin;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnAlterar;

    @FXML
    private TextField textTelefone;

    @FXML
    private Label labelName;

    @FXML
    private Button btnNovo;

    
    @FXML
    private TableView<Aposta> tvApostas;
    
    @FXML
    private TableColumn<Aposta, LocalDate> data;

    @FXML
    private TableColumn<Aposta, Integer> premio;

    @FXML
    private TableColumn<Aposta, Float> valor;

    @FXML
    private TableColumn<Aposta, Chave> chaveAposta;

    @FXML
    private TableColumn<Aposta, Chave> chavePremio;
    
    
    @FXML
    void handleNovoAposta(ActionEvent event) {

    }

    @FXML
    void handleAlterarAposta(ActionEvent event) {

    }

    @FXML
    void handleEliminarAposta(ActionEvent event) {

    }

    @FXML
    void handleConfirmarAposta(ActionEvent event) {

    }

    @FXML
    void handleReiniciarAposta(ActionEvent event) {

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
