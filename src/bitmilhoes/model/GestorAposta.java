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
    public boolean creditarMontante(int telefone, short pin, String descricao, float montante) {//A mexer Aqui!!!
        //aceder o cerditar do apostador
        if(validaApostador(telefone, pin)){
            descricao = "Creditar";//descreve o motivo
            //aceder ao apostador e getCreditar(montante)
            Apostador apostador = apostadores.getElement(new Apostador(telefone, (short) pin));//cria um novo apostador
            return apostador.creditar(montante);//depende da verificação do método creditar();
        }
        return false;
    }

    @Override //descricao -> motivo de levantamento
    public boolean levantarMontante(int telefone, short pin, String descricao, float montante) {//A mexer Aqui!!!
        if(validaApostador(telefone, pin)){//existe
            descricao = "Levantamento";
            Apostador apostador = apostadores.getElement(new Apostador(telefone, (short)pin));
            return apostador.debitar(montante);//depende da verificação do método debitar()
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
        return iniciarCicloApostas();
    }

    @Override
    public Chave efectuarSorteio() {//chave aleatória
        
//        apostadores.getElements().contains(this)
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    //public Chave efectuarSorteio(ContainerSet<Integer> nums, ContainerSet<Integer> ests) {//chave personalizada, chama a efetuarSorteio() de cima
    public Chave efectuarSorteio(ContainerSet<Integer> nums, ContainerSet<Integer> ests) {//chave personalizada, chama a efetuarSorteio() de cima
        
//        if(nums !=null && ests != null){
//        apostadores.getElements().contains(nums);//tem os numeros
//        apostadores.getElements().contains(ests);//tem as estrelas
//        } //este é no da sorteio
        //List<Sorteio> sorteio = new Sorteio();
        //sorteio.
        //return Sorteio.efectuarSorteio(List<Integer> nums, List<Integer> ests);
//        return Chave.doGerar(nums, maxiterar, nelem);
        
        //verificar se o sorteio foi realizado
//        if(!sorteio.isRealizado()){//true? Então foi realizado
//            //se realizado
//            sorteio.efectuarSorteio(nums, ests);
//        }
        
        //atribui chave?
//        return 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inicializaNrApostadores() {//'apaga' os apostadores
        //total de apostadores
        //iterador para aqui e remove enquanto há next
        
        //apostadores.remove();
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
}
