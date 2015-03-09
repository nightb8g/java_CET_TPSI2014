package bitmilhoes.model;

import bitmilhoes.containers.ContainerList;
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

    public GestorAposta() {
        apostadores = new ContainerSet();
    }
    
    
    @Override
    public boolean novoApostador(int telefone, short pin, String nome, LocalDate dataNascimento, float saldo) {
        return apostadores.insert(new Apostador(telefone, pin, nome, dataNascimento, saldo));//funciona
    }

    @Override
    public boolean alterarPin(int telefone, short pinActual, short pinNovo) {//Aqui
        if (!validaApostador(telefone, pinActual))
            return false;
        
        Apostador apostador = apostadores.getElement(new Apostador(telefone));
        if (apostador == null)
            return false;
        
        
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
    public boolean creditarMontante(int telefone, short pin, String descricao, float montante) {
        //descrição?
        //não existe este apostador
//        (!validaApostador(telefone, (short)pin)? return false :
//                                                 apostadores.;
        //aceder o cerditar do apostador
        return false;
    }

    @Override
    public boolean levantarMontante(int telefone, short pin, String descricao, float montante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void apostaPersonalizada(int telefone, short pin, ContainerSet<Integer> numeros, ContainerSet<Integer> estrelas) {
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
    public Chave efectuarSorteio(ContainerSet<Integer> nums, ContainerSet<Integer> ests) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inicializaNrApostadores() {
        
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
}
