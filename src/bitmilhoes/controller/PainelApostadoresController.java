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

/**
 * FXML Controller class
 *
 * @author night8ug
 */
public class PainelApostadoresController implements Initializable {
    
    
    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnNovo;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnAlterar.setDisable(true);
        btnEliminar.setDisable(true);
        
    }    

    @FXML
    private void handlesNovoApostador(ActionEvent event) {
        
    }
    
    
    
}
