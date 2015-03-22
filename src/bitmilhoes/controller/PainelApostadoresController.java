/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmilhoes.controller;

import bitmilhoes.model.Apostador;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    
    @FXML
    private TableView<Apostador> tvApostadores;
    
    @FXML
    private TableColumn<Apostador, Integer> telefone;
    
    @FXML
    private TableColumn<Apostador, String> nome;
    
    @FXML
    private TableColumn<Apostador, LocalDate> dtNasc;
    
    @FXML
    private TableColumn<Apostador, Float> saldo;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
}
