package bitmilhoes.model;

import bitmilhoes.containers.ContainerList;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.util.List;
import javafx.collections.ObservableList;



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
    private static int nrRegistos;// passei a static pois vai ser a variavel contador e como não conta  o sorteio, então não é inicializada
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
    private ContainerList lances;
    private Chave chaveVencedora;


    public Sorteio(){//Preenchi este
        lances = new ContainerList();//inicializa uma lista de lances
        dataSorteio = java.time.LocalDateTime.now();//capta a data quando chama o construtor para a dataSorteio
    }

    public void inicializaSorteio(){                
        //verifica a chave premio
        //verifica lances
        //compara premio e lances
        //atribui premios?
    }

    @Override
    public boolean iniciarCicloApostas() {//o construtor Sorteio inicializa os atributos... porque não o chamar?
       lances = new ContainerList();
       return true;
    }

    @Override
    public boolean validarChave(Chave chave) {
        
        //recebe chave
        //faço uma cópia da lista de chaves
        //Premio[] PREMIOS = {new Premio(1, 5, 2, 0.5000f),..
        //verifca os pémios
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Chave efectuarSorteio(ContainerList<Integer> nums, ContainerList<Integer> ests) {
        //para efetuar sorteio necessito da chave prémio gerada
        //não é assim
        //return Chave.doGerar(null, nrRegistos, nrRegistos);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LocalDateTime getDataSorteio() {
        return dataSorteio;
    }

    @Override
    public ContainerList<Aposta> getLances() {
        ContainerList aux=new ContainerList();
        while(lances.getIterador().hasNext())
            aux.insert(lances.getIterador().next());
       return aux;
    }

    @Override
    public void registaAposta(Aposta aposta) {//adicionei: nrRegistos++
        //quando registo uma aposta tenho de adicionar +1 ao número de registos
        nrRegistos++;// como é [static] não necessito de set, pois só necessito de alterar na class
        lances.insert(aposta);
    }

    @Override
    public int getNrRegistos() {
        return nrRegistos;
    }

    @Override
    public Premio getPrimeiroPremio() {
        return primeiroPremio;
    }

    @Override
    public boolean isRealizado() {
        return realizado;
    }
        


}
