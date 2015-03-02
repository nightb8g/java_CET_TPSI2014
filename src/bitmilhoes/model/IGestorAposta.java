package bitmilhoes.model;

import java.time.LocalDate;
import java.util.List;

/**
 * @author JASP
 * @version 4.0
 * @created 18-Jan-2015 16:26:00
 */
public interface IGestorAposta {

    
	
    /**
     * Com base nos dados do novo apostador (com validaçao de todos os campos que
     * possuam restriçoes), este é adicionado à base de dados.
     *
     * @param telefone
     * @param pin
     * @param nome
     * @param dataNascimento
     * @param saldo   
     */
    public boolean novoApostador(int telefone, short pin, String nome, LocalDate dataNascimento, float saldo);

    /**
     * Com base no numero de telefone e PIN do apostador, verifica a correcçao dos
     * dados e procede à actualizaçao do novo PIN.
     *
     * @param telefone
     * @param pinActual
     * @param pinNovo    pinNovo
     */
    public boolean alterarPin(int telefone, short pinActual, short pinNovo);

    /**
     * Com base no numero de telefone e PIN do apostador, valida a sua exist�ncia.
     *
     * @param telefone
     * @param pinActual    pinActual
     */
    public boolean validaApostador(int telefone, short pinActual);

    /**
     * Valida o apostador e carrega o montante (valor positivo) a cr�dito na conta do
     * apostador.
     *
     * @param telefone
     * @param pin
     * @param montante    montante
     */
    public boolean creditarMontante(int telefone, short pin, float montante);

    /**
     * Valida o apostador e retira o montante (valor negativo) da conta do apostador.
     *
     * @param telefone
     * @param pin
     * @param montante    montante
     */
    public boolean levantarMontante(int telefone, short pin, float montante);

    /**
     * Remove o apostador da BD. É assumido que o saldo remanescente � entregue ao
     * apostador.
     *
     * @param telefone
     * @param pin    pin
     */
    public Apostador removerApostador(int telefone, short pin);

    /**
     * devera ser gerada a chave vencedora e atribuidos os premios aos apostadores
     * consoante a Tabela de premios. Não podem ser sorteadas duas chaves consecutivas
     * sem iniciar um novo ciclo de apostas entre ambas. são permitidas no maximo o
     * registo de 10 apostas por apostador num dado concurso. devera certificar-se que
     * é mostrado um erro quando se tentar registar a decima primeira aposta.
     *
     * @param telefone
     * @param pin    pin
     */
    public void apostaAleatoria(int telefone, short pin);

    /**
     * devera ser gerada a chave vencedora e atribuidos os premios aos apostadores
     * consoante a Tabela de premios. Não podem ser sorteadas duas chaves consecutivas
     * sem iniciar um novo ciclo de apostas entre ambas. A chave é introduzida
     * manualmente. Isto é para efeitos de depuraçao de resultados e atribuiçoes de
     * premios. são permitidas no maximo o registo de 10 apostas por apostador num
     * dado concurso. devera certificar-se que é mostrado um erro quando se tentar
     * registar a decima primeira aposta.
     *
     * @param telefone
     * @param pin
     * @param numeros
     * @param estrelas    estrelas
     */
    public void apostaPersonalizada(int telefone, short pin, List<Integer> numeros, List<Integer> estrelas);

    /**
     * Lista os apostadores por nome (ordem alfabetica)
     *
     * @return List<Apostador> retorna uma lista com os apostadores ordenados 
     */
    public List<Apostador> listarApostadoresNome();

    /**
     * Lista os apostadores por data de nascimento 
     *
     * @return List<Apostador> retorna uma lista com os apostadores ordenados 
     */
    public List<Apostador> listarApostadoresDataNascimento();

    /**
     * Lista os apostadores pelo seu saldo
     *
     * @return List<Apostador> retorna uma lista com os apostadores ordenados
     */
    public List<Apostador> listarApostadoresSaldo();

    /**
     * Listar os premios atribuidos no ultimo sorteio, juntamente com as chaves
     * premiadas e apostadores associados.
	 *
	 * @return List<Apostador> retorna uma lista com os apostadores ordenados
     */
    public List<Aposta> listarPremiosUltimoSorteio();

    /**
     * Lista os movimentos de um apostador por ordem crescente de data e decrescente
     * de valor
     *
     * @param telefone
     * @param pin    pin
	 *
	 * @return List<Apostador> retorna uma lista com os apostadores ordenados
     */
    public List<Movimento> listarMovimentosApostador(int telefone, short pin);

    /**
     * Reinicia o registo de apostas, eliminando todas as apostas registadas dos
     * apostadores. Só pode sortir efeito se tiver ocorrido um sorteio.
     */
    public boolean iniciarCicloApostas();

    public Chave efectuarSorteio();

    public Chave efectuarSorteio(List<Integer> nums, List<Integer> ests);

    public void inicializaNrApostadores();
}
