/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmilhoes.controller;

import bitmilhoes.model.Apostador;
import bitmilhoes.model.GestorAposta;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    
    private GestorAposta gestorAposta;

    @FXML
    private TableView<Apostador> tvApostadores;
    @FXML
    private TableColumn<Apostador, Integer> tcTelefone;
    @FXML
    private TableColumn<Apostador, String> tcNome;
    @FXML
    private TableColumn<Apostador, LocalDate> tcDataNasc;
    @FXML
    private TableColumn<Apostador, Float> tcSaldo;
    
    public void initdata(GestorAposta gestorAposta) {
        this.gestorAposta = gestorAposta;
       ObservableList<Apostador> apostadores=FXCollections.observableArrayList(gestorAposta.getApostadores());
        preencherTabelaApostadores(apostadores);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnAlterar.setDisable(true);
        btnEliminar.setDisable(true);
    }    
    private void preencherTabelaApostadores(ObservableList apostadores) {
       tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
       tcTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
       tcDataNasc.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
       tcSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));
       tvApostadores.setItems(apostadores);
    }

    @FXML
    private void handlesNovoApostador(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("bitmilhoes/view/PainelApostadoresNovo.fxml"));
         Stage stage = new Stage();
         try {
             stage.setScene(new Scene((AnchorPane) loader.load()));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    stage.setTitle("Novo Apostador");
    stage.initModality(Modality.WINDOW_MODAL);
    stage.initOwner(((Node)event.getSource()).getScene().getWindow());

          stage.show();  
    }
    
}
