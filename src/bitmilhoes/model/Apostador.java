package bitmilhoes.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Conta do apostador cujo saldo pode ser utilizado para pagar o registo de
 * apostas. O valor dos premios são creditados nesta conta.
 *
 * @author ipoo
 * @version 1.0
 * @updated 17-Nov-2010 12:54:02
 */
public class Apostador implements IApostador {

    /**
     * O numero de telefone identifica univocamente um apostador. Não pode haver
     * numeros de telefone repetidos, pelo que devera sempre ser validardo este
     * facto no registo de novos apostadores.
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
     * A data de nascimento devera aparecer no formato dd-mm-aaaa (e.g.
     * 03-02-2008).
     */
    private LocalDate dataNascimento;
    /**
     * Deve ser inserida automaticamente sempre que o saldo for actualizado.
     */
    private LocalDateTime dataSaldo;
    /**
     * Os valores monetarios devem ser sempre apresentados com duas casas
     * decimais, e o simbolo do euro(e.g. 99,99 €)
     */
    private float saldo;

    private List<Movimento> movimentos;
    private List<Aposta> apostas;

    // NOVO
    public Apostador() {
    }

    // ALTERADO
    public Apostador(int telefone, short pin, String nome, LocalDate dataNascimento, float saldo) {
        this.telefone = telefone;
        this.pin = pin;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.saldo = saldo;
        this.dataSaldo = LocalDateTime.now();
        this.apostas = new ArrayList<>();
        this.movimentos=new ArrayList<>();

    }
    public void criarMovimento(String descricao, float valor, Natureza natureza){
        movimentos.add(new Movimento(LocalDateTime.now(), descricao, valor, natureza));
    }
    @Override
    public boolean creditar(float valor) {
        if (valor > 0) {
            this.saldo = saldo + valor;
            dataSaldo = LocalDateTime.now();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean debitar(float valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo = saldo - valor;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean alterarPin(short pinNovo, short pinActual) {
        if ((pin >= 0000 && pin <= 9999) && (Short.compare(pinActual, this.pin) == 0)) {
            this.pin = pinNovo;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Aposta criarAposta(Chave chave) {
        //cria a apostas
        Aposta aux = new Aposta(this, chave);
        apostas.add(aux);
        //cria o movimento
        movimentos.add(new Movimento(java.time.LocalDateTime.now(), "Nova aposta", 2, Natureza.DEBITO));
        return aux;
    }

    @Override
    public List<Aposta> getApostas() {
        return apostas;
    }

    @Override
    public List<Movimento> getMovimentos() {
        return movimentos;
    }

    @Override
    public LocalDateTime getDataSaldo() {
        return dataSaldo;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getNrApostas() {
        if (!this.apostas.isEmpty()) {
            return this.apostas.size();
        } else {
            return 0;
        }
    }

    @Override
    public int getNrMovimentos() {
        return this.movimentos.size();
    }

    @Override
    public short getPin() {
        return pin;
    }

    @Override
    public float getSaldo() {
        return saldo;
    }

    @Override
    public int getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Apostador{" + "telefone=" + telefone + ", nome=" + nome + ", pin=" + pin + ", dataNascimento=" + dataNascimento + ", dataSaldo=" + dataSaldo + ", saldo=" + saldo + ", movimentos=" + movimentos + ", apostas=" + apostas + '}';
    }

}
