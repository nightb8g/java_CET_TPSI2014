package bitmilhoes.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ipoo
 * @version 1.0
 * @created 11-Nov-2010 01:11:27
 */
public interface ISorteio {

    /**
     * Reinicia o registo de apostas. S� pode sortir efeito se tiver ocorrido um
     * sorteio.
     */
    public boolean iniciarCicloApostas();

    /**
     *
     * @param chave    chave
     */
    public boolean validarChave(Chave chave);
    // Recebendo os números e estrelas correspondentes à chave
    // efectua o calculo e atribuição de prémios pelas apostas

    public Chave efectuarSorteio(List<Integer> nums, List<Integer> ests);
    // Devolve a data de sorteio

    public LocalDateTime getDataSorteio();
    // Devolve os lances de apostas existentes

    public List<Aposta> getLances();
    // Regista uma aposta no array de lances

    public void registaAposta(Aposta aposta);
    // Devolve o número de apostas efectuadas

    public int getNrRegistos();
    // Devolve o primeiro premio do sorteio

    public Premio getPrimeiroPremio();
    // Devolve true se o sorteio já se tiver efectuado

    public boolean isRealizado();
}
