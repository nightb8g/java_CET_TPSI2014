package bitmilhoes.model;

import bitmilhoes.containers.ContainerSet;
import bitmilhoes.containers.IContainerOperations;
import java.time.LocalDate;
import java.util.List;

/**
 * Intermedeia a interface utilizada pelo utilizador e as classes com
 * responsabilidade pelas operaçoes de gestto dos apostadores, o registo de
 * apostas, sorteio e atribuicao de premios.
 *
 * @author poo
 * @version 4.0
 * @updated 18-Jan-2015T17:13:36
 */
public class GestorAposta implements IGestorAposta {

    private Sorteio sorteio;
    private IContainerOperations<Apostador> apostadores;

    public GestorAposta() {//cria uma LISTA com todos APOSTADORES(MOVIMENTOS e APOSTAS)
        apostadores = new ContainerSet();
    }
    
    
    @Override
    public boolean novoApostador(int telefone, short pin, String nome, LocalDate dataNascimento, float saldo) {
        //INSERE APOSTADOR
        return apostadores.insert(new Apostador(telefone, pin, nome, dataNascimento, saldo));
    }

    @Override
    public boolean alterarPin(int telefone, short pinActual, short pinNovo) {
        //Procura apostador pelo PIN e TELEFONE
        if (!validaApostador(telefone, pinActual)){
            return false;
        }
        
        Apostador apostador = apostadores.getElement(new Apostador(telefone));
        if (apostador == null){
            return false;
        }
        
        //ALTERA PIN se APOSTADOR existe
        return apostador.alterarPin(pinNovo, pinActual);
    }

    @Override
    public boolean validaApostador(int telefone, short pinActual) {//Aqui
        //verificar se o utilizador existe (telefone)
        
        Apostador apostador = apostadores.getElement(new Apostador(telefone));
        if (apostador==null)
            return false;
        
        return (apostador.getPin() == pinActual);
    }

    @Override
    public boolean creditarMontante(int telefone, short pin, String descricao, float montante) {//A mexer Aqui!!!
        //VALIDA APOSTADOR
        if(validaApostador(telefone, pin)){
            //descreve o motivo
            Apostador apostador = apostadores.getElement(new Apostador(telefone));
            apostador.criarMovimento(descricao, montante, Natureza.CREDITO);
            return true;
        }
        return false;
    }

    @Override //descricao -> motivo de levantamento
    public boolean levantarMontante(int telefone, short pin, String descricao, float montante) {//A mexer Aqui!!!
        //VALIDA APOSTADOR
        if(validaApostador(telefone, pin)){
            //descreve o motivo
            Apostador apostador = apostadores.getElement(new Apostador(telefone));
            apostador.criarMovimento(descricao, montante, Natureza.DEBITO);
            return true;
        }
        
        return false;
    }

    @Override
    public Apostador removerApostador(int telefone, short pin) {
        Apostador apostador = null;
        if (!validaApostador(telefone, pin))
            return apostador;
        
        return apostadores.remove(apostador);
    }

    @Override
    public void apostaAleatoria(int telefone, short pin) {
            getApostador(telefone, pin).criarAposta(new Chave());
    }

    @Override
    public void apostaPersonalizada(int telefone, short pin, IContainerOperations<Integer> numeros, IContainerOperations<Integer> estrelas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IContainerOperations<Apostador> listarApostadoresNome() {
//        apostadores.getElements().
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IContainerOperations<Apostador> listarApostadoresDataNascimento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IContainerOperations<Apostador> listarApostadoresSaldo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IContainerOperations<Aposta> listarPremiosUltimoSorteio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IContainerOperations<Movimento> listarMovimentosApostador(int telefone, short pin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean iniciarCicloApostas() {
        return (sorteio.iniciarCicloApostas());
    }

    @Override
    public Chave efectuarSorteio() {
        sorteio=new Sorteio();
        Chave chave=new Chave();
        sorteio.efectuarSorteio(chave.getNumeros(), chave.getEstrelas());
        return chave;
    }

        @Override
    public Chave efectuarSorteio(IContainerOperations<Integer> nums, IContainerOperations<Integer> ests) {
        sorteio.efectuarSorteio(nums, ests);
        return new Chave(nums, ests);
    }

    @Override
    public void inicializaNrApostadores() {//'apaga' os apostadores
        if(!apostadores.isEmpty()){
        apostadores.getElements().clear();
        }        
    }

    public List<Apostador> getApostadores() {
        return apostadores.getElements();
    }
    
    public Apostador getApostador(Apostador apostador){
        return apostadores.getElement(apostador);
    }
    public Apostador getApostador(int telefone, short pin){
        return apostadores.getElement(new Apostador(telefone, pin));
    }

    @Override
    public String toString() {
        return "GestorAposta{" + "sorteio=" + sorteio + ", apostadores=" + apostadores + '}';
    }
    
}