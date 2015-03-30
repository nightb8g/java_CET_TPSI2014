/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmilhoes.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author night8ug
 */
public class PainelApostadoresNovoController implements Initializable {
    @FXML
    private TextField textNome;
    @FXML
    private TextField textTelefone;
    @FXML
    private TextField textDataNascDia;
    @FXML
    private TextField textDataNascMes;
    @FXML
    private TextField textDataNascAno;
    @FXML
    private Button btnOk;
    @FXML
    private Button btnCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleOk(ActionEvent event) {
    }

    @FXML
    private void handleCancel(ActionEvent event) {
    }
    
}
