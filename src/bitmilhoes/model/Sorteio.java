package bitmilhoes.model;

import bitmilhoes.containers.ContainerList;
import java.time.LocalDateTime;



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
    private static int nrRegistos;// passei a static pois vai ser a variavel contador e como só conta o lance
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

    //este é o construts, logo inicializa os atributos
    public Sorteio(){//Preenchi este
        lances = new ContainerList();//inicializa uma lista de lances
        dataSorteio = java.time.LocalDateTime.now();//capta a data quando chama o construtor para a dataSorteio
        realizado = false;//o sorteio é criado, mas ainda não inicializado
        chaveVencedora = new Chave();//gera uma chave aleatória
    }

    public void inicializaSorteio(){
        //não há perigo do atributo realizado ser nulo
        //verifica se foi realizado o sorteio
        if(realizado != true){//não foi realizado
            //iniciar sorteio
            //efectuarSorteio(lances, lances);//por verificar, não acabado
            //colocar realizado true
            realizado = true;
        }
    }

    @Override
    public boolean iniciarCicloApostas() {
       //lances = new ContainerList(); <- este é inicializado no construtor
        //verificar sorteio realizado, se true permite inicializar, se não não permite
       return (isRealizado());
    }

    @Override
    public boolean validarChave(Chave chave) {
        //recebe chave
        //verifico se é igual à chaveVencedora
        return chave.toString().contains(chaveVencedora.toString());
    }

    @Override
    public Chave efectuarSorteio(ContainerList<Integer> nums, ContainerList<Integer> ests) {
        
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
    public void registaAposta(Aposta aposta) {
        nrRegistos++;//por cada lance adiona +1 registo
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
        return getDataSorteio().isAfter(java.time.LocalDateTime.now());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-15s:","Data Sorteio"));
        sb.append(getDataSorteio());
        sb.append("/n");
        
        sb.append(String.format("%-15s:","Sorteio Realizado"));
        sb.append(isRealizado());
        sb.append("/n");
        
        sb.append(String.format("%-15s:","Primeiro Premio"));
        sb.append(getPrimeiroPremio());
        sb.append("/n");
        
        sb.append(String.format("%-15s:","Lances"));
        sb.append(getLances());
        sb.append("/n");

        return sb.toString();//"Sorteio{" + "dataSorteio=" + dataSorteio + ", realizado=" + realizado + ", primeiroPremio=" + primeiroPremio + ", lances=" + lances + ", chaveVencedora=" + chaveVencedora + '}';
    }
        


}
