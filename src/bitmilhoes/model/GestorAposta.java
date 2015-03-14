package bitmilhoes.model;

import bitmilhoes.containers.ContainerList;
import bitmilhoes.containers.ContainerSet;
import bitmilhoes.containers.IContainerOperations;
import java.time.LocalDate;
import java.util.ArrayList;
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
    public GestorAposta() {
        this.sorteio=new Sorteio();
        this.apostadores=new ContainerSet<>();
    }
    
    
    @Override
    public boolean novoApostador(int telefone, short pin, String nome, LocalDate dataNascimento, float saldo) {
        return apostadores.insert(new Apostador(telefone, pin, nome, dataNascimento, saldo));
    }

    @Override
    public boolean alterarPin(int telefone, short pinActual, short pinNovo) {
        //verificar se o utilizador existe (telefone)
        //se existir ALTERAR pin
        //permite a INSERIR pin
        return false;
    }

    @Override
    public boolean validaApostador(int telefone, short pinActual) {
        //verificar se o utilizador existe (telefone)
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean creditarMontante(int telefone, short pin, String descricao, float montante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean levantarMontante(int telefone, short pin, String descricao, float montante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Apostador removerApostador(int telefone, short pin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apostaAleatoria(int telefone, short pin) {
            getApostador(telefone, pin).criarAposta(new Chave());
    }

    @Override
    public void apostaPersonalizada(int telefone, short pin, IContainerOperations<Integer> numeros, IContainerOperations<Integer> estrelas) {
        getApostador(telefone, pin).criarAposta(new Chave(numeros, estrelas));
    }

    @Override
    public IContainerOperations<Apostador> listarApostadoresNome() {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Chave efectuarSorteio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Chave efectuarSorteio(IContainerOperations<Integer> nums, IContainerOperations<Integer> ests) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inicializaNrApostadores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
