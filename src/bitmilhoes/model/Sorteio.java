package bitmilhoes.model;

import java.time.LocalDateTime;
import java.util.List;



/**
 * @author ipoo
 * @version 1.0
 * @created 11-Nov-2010 01:11:27
 */
public class Sorteio implements ISorteio {

    /**
     * Pre�o de uma aposta.
     */
    public static final float PRECO_REGISTO_APOSTA = 2.0f;
    /**
     * Percentagem da receita a ser distribuida pelos pr�mios.
     */
    public static final float PERCENTAGEM_PARA_PREMIOS = 0.9f;
    /**
     * Constante com a tabela de pr�mios disponiveis em fun��o da quantidade de
     * numeros e estrelas acertadas.
     */
    public static final Premio[] PREMIOS = {new Premio(1, 5, 2, 0.5000f),
                                            new Premio(2, 5, 1, 0.2000f),
                                            new Premio(3, 5, 0, 0.0800f),
                                            new Premio(4, 4, 2, 0.0600f),
                                            new Premio(5, 4, 1, 0.0500f),
                                            new Premio(6, 4, 0, 0.0400f),
                                            new Premio(7, 3, 2, 0.0300f),
                                            new Premio(8, 3, 1, 0.0200f),
                                            new Premio(9, 2, 2, 0.0100f),
                                            new Premio(10, 3, 0, 0.0050f),
                                            new Premio(11, 1, 2, 0.0030f),
                                            new Premio(12, 2, 1, 0.0020f)};
    /**
     * Indica a data em que o sorteio foi realizado.
     */
    private LocalDateTime dataSorteio;
    /**
     * Numero de registos de apostas ate ao momento.
     */
    private int nrRegistos;
    /**
     * Indica se o sorteio foi ou n�o realizado.
     */
    private boolean realizado;
    /**
     * Indica qual a combina��o de n�meros e estrelas correspondentes ao primeiro
     * pr�mio atribu�do.
     */
    private Premio primeiroPremio;
    /**
     * Cont�m as apostas realizadas para o presente sorteio.
     */
    private List<Aposta> lances;
    private Chave chaveVencedora;


    public Sorteio(){
        inicializaSorteio();
    }

    public void inicializaSorteio(){                

    }

    @Override
    public boolean iniciarCicloApostas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarChave(Chave chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Chave efectuarSorteio(List<Integer> nums, List<Integer> ests) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LocalDateTime getDataSorteio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aposta> getLances() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registaAposta(Aposta aposta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNrRegistos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Premio getPrimeiroPremio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isRealizado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        


}
