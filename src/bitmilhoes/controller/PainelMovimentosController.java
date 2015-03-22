/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmilhoes.controller;

import bitmilhoes.model.Aposta;
import bitmilhoes.model.Movimento;
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
public class PainelMovimentosController implements Initializable {
    
    @FXML
    private Label labelNome;

    @FXML
    private Label textSaldo;
    
    @FXML
    private TextField textPin;
    
    @FXML
    private TextField textTelefone;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnNovo;
    
    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnReiniciar;

    @FXML
    private TableView<Movimento> tvMovimentos;
    
    @FXML
    private TableColumn<Movimento, LocalDate> data;

    @FXML
    private TableColumn<Movimento, Float> valor;

    @FXML
    private TableColumn<Movimento, String> descricao;


    @FXML
    private TableColumn<Movimento, String> natureza;



    @FXML
    void handleNovoMovimento(ActionEvent event) {

    }

    @FXML
    void handleAlterarMovimento(ActionEvent event) {

    }

    @FXML
    void handleEliminarMovimento(ActionEvent event) {

    }

    @FXML
    void handleConfirmarMovimento(ActionEvent event) {

    }

    @FXML
    void handleReiniciarMovimento(ActionEvent event) {

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
