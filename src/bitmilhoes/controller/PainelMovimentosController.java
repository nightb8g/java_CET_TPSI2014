/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmilhoes.controller;

import bitmilhoes.model.Apostador;
import bitmilhoes.model.GestorAposta;
import bitmilhoes.model.Movimento;
import bitmilhoes.model.Natureza;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author night8ug
 */
public class PainelMovimentosController implements Initializable {

    private GestorAposta gestorAposta;//gestoraposta

    private Stage primaryStarge; //Stage

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

    void handleAlterarMovimento(ActionEvent event) {

    }

    @FXML
    void handleEliminarMovimento(ActionEvent event) {

    }

    @FXML
    void handleConfirmarMovimento(ActionEvent event) {
        if(textTelefone.getText().isEmpty() || textPin.getText().isEmpty()) return;
        int telefone= Integer.parseInt(textTelefone.getText());
        short pin= Short.parseShort(textPin.getText());
        if(!gestorAposta.validaApostador(telefone,pin)) return;
        List<Movimento> mv;
        Apostador ap;
           ap=gestorAposta.getApostador(telefone, pin);
           textSaldo.setText(String.valueOf(ap.getSaldo()));
           labelNome.setText(String.valueOf(ap.getNome()));
            mv =ap.getMovimentos();
       valor.setCellValueFactory(new PropertyValueFactory<>("valor"));
       btnNovo.setDisable(false);
        btnEliminar.setDisable(false);
        btnConfirmar.setDisable(true);
    }

    @FXML
    void handleReiniciarMovimento(ActionEvent event) {

    }

    public void initdata(GestorAposta gestorAposta, Stage stage) {
        this.gestorAposta = gestorAposta;
        this.primaryStarge = stage;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnNovo.setDisable(true);
        btnEliminar.setDisable(true);
    }

}
