package bitmilhoes.model;

import bitmilhoes.containers.ContainerList;
import bitmilhoes.containers.IContainerOperations;
import java.time.LocalDateTime;
import java.util.Iterator;
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
    public static final float PRECO_REGISTO_APOSTA = 2.0f;//nrRegisto * o preço por aposta vai dar o total angariado
    /**
     * Percentagem da receita a ser distribuida pelos pr�mios.
     */
    public static final float PERCENTAGEM_PARA_PREMIOS = 0.9f;//total angariado * 0.9 = dinheiro disponibilizado para premio
    /**
     * Constante com a tabela de pr�mios disponiveis em fun��o da quantidade de
     * numeros e estrelas acertadas.
     */
    public static final Premio[] PREMIOS = {
        new Premio(1, 5, 2, 0.5000f),
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
        new Premio(12, 2, 1, 0.0020f)
    };
    /**
     * Indica a data em que o sorteio foi realizado.
     */
    private LocalDateTime dataSorteio;
    /**
     * Numero de registos de apostas ate ao momento.
     */
    private int nrRegistos;// passei a static pois vai ser a variavel contador e como só conta o lance
    /**
     * Indica se o sorteio foi ou n�o realizado.
     */
    private boolean realizado;
    /**
     * Indica qual a combina��o de n�meros e estrelas correspondentes ao
     * primeiro pr�mio atribu�do.
     */
    private Premio primeiroPremio;
    /**
     * Cont�m as apostas realizadas para o presente sorteio.
     */
    private IContainerOperations<Aposta> lances;
    private Chave chaveVencedora;

    //este é o construts, logo inicializa obs atributos
    public Sorteio() {//Preenchi este
        lances = new ContainerList();//inicializa uma lista de lances
        dataSorteio = java.time.LocalDateTime.now();//capta a data atual quando chama o construtor
        realizado = false;//o sorteio é criado, mas ainda não inicializado
        //chaveVencedora = new Chave();//gera a chave aleatória, combinação para ganhar 1º prémio
        chaveVencedora = null;//A chave é gerada no sorteio
        nrRegistos = 0;
    }

    public void inicializaSorteio() {
        //verifica se foi realizado o sorteio
        iniciarCicloApostas();
    }

    @Override
    public boolean iniciarCicloApostas() {
        if (isRealizado()) {
            //lances.getElements().clear();
            lances = new ContainerList();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean validarChave(Chave chave) {
        //recebe chave
        //verifico se é igual à chaveVencedora
        return chave == chaveVencedora;
    }

    @Override
    public Chave efectuarSorteio(IContainerOperations<Integer> nums, IContainerOperations<Integer> ests) {
        if (isRealizado()) {
            return null;
        }
        realizado = true;
        chaveVencedora = new Chave(nums, ests);
        Iterator<Aposta> apostas = lances.getIterador();
        float total = PRECO_REGISTO_APOSTA * nrRegistos * PERCENTAGEM_PARA_PREMIOS;

        int[] ordinal = new int[PREMIOS.length + 1];
        while (apostas.hasNext()) {
            int numscount = 0, estrelascount = 0;
            Aposta aposta = apostas.next();
            aposta.setChave(chaveVencedora);
            //Contador de numeros acertadas
            for (Object num : aposta.getChave().getNumeros().getElements()) {
                if (chaveVencedora.getNumeros().getElements().contains(num)) {
                    numscount++;
                }
            }
            //Contador de estrelas acertadas
            for (Object num : aposta.getChave().getEstrelas().getElements()) {
                if (chaveVencedora.getEstrelas().getElements().contains(num)) {
                    estrelascount++;
                }
            }
            //Atribuição de Prémios
            for (Premio premio : PREMIOS) {
                if (premio.getNumero() == numscount && premio.getEstrela() == estrelascount) {
                    aposta.setPremioAtribuido(premio);
                    ordinal[premio.getOrdinal()]++;
                }
            }
        }
        //Atribuição de valor do Prémio
        apostas = lances.getIterador();
        while (apostas.hasNext()) {
            Aposta aposta = apostas.next();
            for (Premio premio : PREMIOS) {
                if (aposta.getPremio() != null && aposta.getPremio().equals(premio)) {
                    float val=(total * premio.getPercentagem()) / ordinal[premio.getOrdinal()];
                    aposta.setValorPremio(val);
                    aposta.getApostador().criarMovimento("Aposta ganha!", val, Natureza.CREDITO);
                }
            }
        }
        primeiroPremio = PREMIOS[0];
        return new Chave(nums, ests);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LocalDateTime getDataSorteio() {
        return dataSorteio;
    }

    @Override
    public List<Aposta> getLances() {
        ContainerList aux = new ContainerList();
        while (lances.getIterador().hasNext()) {
            aux.insert(lances.getIterador().next());
        }
        return aux.getElements();
    }

    @Override
    public void registaAposta(Aposta aposta) {
        lances.insert(aposta);
        nrRegistos = lances.size();
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

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(String.format("%-15s:","Data Sorteio"));
//        sb.append(getDataSorteio());
//        sb.append("/n");
//        
//        sb.append(String.format("%-15s:","Sorteio Realizado"));
//        sb.append(isRealizado());
//        sb.append("/n");
//        
//        sb.append(String.format("%-15s:","Primeiro Premio"));
//        sb.append(getPrimeiroPremio());
//        sb.append("/n");
//        
//        sb.append(String.format("%-15s:","Lances"));
//        sb.append(getLances());
//        sb.append("/n");
//
//        return sb.toString();//"Sorteio{" + "dataSorteio=" + dataSorteio + ", realizado=" + realizado + ", primeiroPremio=" + primeiroPremio + ", lances=" + lances + ", chaveVencedora=" + chaveVencedora + '}';
//    }      
    @Override
    public String toString() {
        return "Sorteio{" + "dataSorteio=" + dataSorteio + ", nrRegistos=" + nrRegistos + ", realizado=" + realizado + ", primeiroPremio=" + primeiroPremio + ", lances=" + lances + ", chaveVencedora=" + chaveVencedora + '}';
    }
}
