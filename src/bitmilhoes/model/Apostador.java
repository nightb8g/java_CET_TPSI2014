package bitmilhoes.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


/**
 * Conta do apostador cujo saldo pode ser utilizado para pagar o registo de
 * apostas. O valor dos premios são creditados nesta conta.
 * @author ipoo
 * @version 1.0
 * @updated 17-Nov-2010 12:54:02
 */
public class Apostador implements IApostador{

    /**
     * O numero de telefone identifica univocamente um apostador. Não pode haver
     * numeros de telefone repetidos, pelo que devera sempre ser validardo este facto
     * no registo de novos apostadores.
     */
    private int telefone;
    /**
     * Nome completo do apostador.
     */
    private String nome;
    /**
     * O PIN do apostador deve ter exactamente 4 digitos. O PIN Não devera ser
     * mostrado em qualquer detalhe/listagem de apostadores.
     */
    private short pin;
    /**
     * A data de nascimento devera aparecer no formato dd-mm-aaaa (e.g. 03-02-2008).
     */
    private LocalDate dataNascimento;
    /**
     * Deve ser inserida automaticamente sempre que o saldo for actualizado.
     */
    private LocalDateTime dataSaldo;
    /**
     * Os valores monetarios devem ser sempre apresentados com duas casas decimais, 
     * e o simbolo do euro(e.g. 99,99 €)
     */
    private float saldo;
    
    private List<Movimento> movimentos;
    private List<Aposta> apostas;

    // NOVO
    public Apostador() {
    }

    // ALTERADO
    public Apostador(int telefone, short pin, String nome, LocalDate dataNascimento, float saldo) {
  
    }

    @Override
    public boolean creditar(float valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean debitar(float valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterarPin(short pinNovo, short pinActual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aposta criarAposta(Chave chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aposta> getApostas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Movimento> getMovimentos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LocalDateTime getDataSaldo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNrApostas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNrMovimentos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public short getPin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getSaldo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTelefone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
