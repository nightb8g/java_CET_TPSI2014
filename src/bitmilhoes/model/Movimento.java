package bitmilhoes.model;

import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * @author ipoo
 * @version 1.0
 * @created 11-Nov-2010 01:11:27
 */
public class Movimento implements IMovimento {

   
    private LocalDateTime dataMovimento;
    private String descricao;
    private float valor;
    private Natureza natureza;

    public Movimento(LocalDateTime dataMovimento, String descricao, float valor, Natureza natureza) {
    }

    @Override
    public LocalDateTime getDataMovimento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDescricao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Natureza getNatureza() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getValor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
