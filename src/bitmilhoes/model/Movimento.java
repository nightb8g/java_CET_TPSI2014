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
        this.dataMovimento=dataMovimento;
        this.descricao=descricao;
        this.valor=valor;
        this.natureza=natureza;
    }
    
    @Override
    public LocalDateTime getDataMovimento() {
        return dataMovimento;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public Natureza getNatureza() {
        return natureza;
    }

    @Override
    public float getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Movimento{" + "dataMovimento=" + dataMovimento + ", descricao=" + descricao + ", valor=" + valor + ", natureza=" + natureza + '}';
    }

    
}
