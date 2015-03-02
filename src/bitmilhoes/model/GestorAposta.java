package bitmilhoes.model;

import bitmilhoes.containers.ContainerList;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private List<Apostador> apostadores;//ArrayList
    
    public GestorAposta() {        
        
    }
    
    public List<Apostador> getApostador(int telefone, short pin){
        //recebe telefone + pin
//        apostadores.indexOf(pin);//verifica index do pin
//        apostadores.indexOf(telefone);//verifica o index do telefone
        
        if(apostadores.indexOf(telefone)==apostadores.indexOf(pin)){
            //devolve apostador
            
            apostadores.get(indexOfApostador(telefone));
        }
            List<Apostador> aux = new ArrayList<>();
        return aux;
    }
    
    public int indexOfApostador(int number){//recebe o index do apostador com o integer X
        return apostadores.indexOf(number);
    }
    
      public ContainerList<Apostador> getApostador(int telefone){
        //devolve apostador
        //recebe telefone
          ContainerList<Apostador> aux = new ContainerList<>();
          return aux;
    }
    
    @Override
    public boolean novoApostador(int telefone, short pin, String nome, LocalDate dataNascimento, float saldo) {
        //.existe apostador(telefone)
        //.não existe INSERE=TRUE
        //.existe ERRO=FALSE
        //"reconhece como novo apostador ou não"
        return false;
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
    public void apostaPersonalizada(int telefone, short pin, List<Integer> numeros, List<Integer> estrelas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Apostador> listarApostadoresNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Apostador> listarApostadoresDataNascimento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Apostador> listarApostadoresSaldo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aposta> listarPremiosUltimoSorteio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Movimento> listarMovimentosApostador(int telefone, short pin) {
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
    public Chave efectuarSorteio(List<Integer> nums, List<Integer> ests) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inicializaNrApostadores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Apostador> getApostadores() {
        //nova lista de todos os apostadores
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }

    
  
}
