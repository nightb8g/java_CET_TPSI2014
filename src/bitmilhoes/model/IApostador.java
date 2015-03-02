package bitmilhoes.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author poo
 * @version 4.0
 * @created 18-Jan-2015 17:25:27
 */
public interface IApostador {

    /**
     *
     * @param valor    valor
     */
    public boolean creditar(float valor);

    /**
     *
     * @param valor    valor
     */
    public boolean debitar(float valor);

    /**
     *
     * @param pinNovo
     * @param pinActual    pinActual
     */
    public boolean alterarPin(short pinNovo, short pinActual);

    /**
     *
     * @param chave    chave
     */
    public Aposta criarAposta(Chave chave);

    /**
     * Devolve as apostas efectuadas pelo apostador.
     */
    public List<Aposta> getApostas();

    /**
     * Devolve os movimentos efectuados na conta do apostador.
     */
    public List<Movimento> getMovimentos();

    public LocalDateTime getDataSaldo();

    public String getNome();

    public int getNrApostas();

    public int getNrMovimentos();

    public short getPin();

    public float getSaldo();

    public int getTelefone();
}
