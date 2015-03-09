package bitmilhoes.model;

import bitmilhoes.containers.ContainerSet;
import bitmilhoes.containers.IContainerOperations;
import java.util.Random;


/**
 * Não existem "m�ltiplas", pelo que cada chave ter� exactamente 5 numeros e 2
 * estrelas.
 * @author ipoo
 * @version 1.0
 * @created 11-Nov-2010 01:11:27
 */
public class Chave {
    private IContainerOperations numeros;
    private IContainerOperations estrelas;

    public Chave(){
        //Falta Gerar chave aleatoria
        numeros= new ContainerSet();
        estrelas= new ContainerSet();
        doGerar(numeros, 50, 5);
        doGerar(estrelas, 11, 2);
    }
  public static void doGerar(IContainerOperations nmros, int maxiterar, int nelem) {
        Random rand = new java.util.Random();
        int nm;
        do {
            nmros.insert(rand.nextInt(maxiterar)+1);
            //nmros.insert(rand.nextInt(maxiterar)+1); 
        } while (nmros.size() != nelem);
    }

    public Chave(IContainerOperations numeros, IContainerOperations estrelas) { 
        
        this.estrelas=estrelas;
        this.numeros=numeros;
    }

    @Override
    public String toString() {
        return "Chave{" + "numeros=" + numeros.getElements() + ", estrelas=" + estrelas.getElements() + '}';
    }

}
