package bitmilhoes.model;

import bitmilhoes.containers.ContainerList;
import java.time.LocalDate;
import java.util.List;

/**
 * Intermedeia a interface utilizada pelo utilizador e as classes com
 * responsabilidade pelas operaçoes de gestto dos apostadores, o registo de
 * apostas, sorteio e atribuicao de premios.
 * @author poo
 * @version 4.0
 * @updated 18-Jan-2015T17:13:36
 */
public class GestorAposta implements IGestorAposta {

    private Sorteio sorteio;
    private ContainerList<Apostador> apostadores;
    
    public GestorAposta() {        

    }

    @Override
    public boolean novoApostador(int telefone, short pin, String nome, LocalDate dataNascimento, float saldo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterarPin(int telefone, short pinActual, short pinNovo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validaApostador(int telefone, short pinActual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean creditarMontante(int telefone, short pin,String descricao, float montante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean levantarMontante(int telefone, short pin,String descricao, float montante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Apostador removerApostador(int telefone, short pin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apostaAleatoria(int telefone, short pin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apostaPersonalizada(int telefone, short pin, ContainerList<Integer> numeros, ContainerList<Integer> estrelas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ContainerList<Apostador> listarApostadoresNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ContainerList<Apostador> listarApostadoresDataNascimento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ContainerList<Apostador> listarApostadoresSaldo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ContainerList<Aposta> listarPremiosUltimoSorteio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ContainerList<Movimento> listarMovimentosApostador(int telefone, short pin) {
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
    public Chave efectuarSorteio(ContainerList<Integer> nums, ContainerList<Integer> ests) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inicializaNrApostadores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ContainerList<Apostador> getApostadores() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }

    
  
}
