package bitmilhoes.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author ipoo
 * @version 1.0
 * @created 11-Nov-2010 01:11:27
 */
public class Movimento implements IMovimento,Serializable {

   
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
//        StringBuilder sb = new StringBuilder();
//        
//        sb.append(String.format("%-15s:","Data de Movimento:"));
//        sb.append(getDataMovimento());
//        sb.append("\n");
//        
//        sb.append(String.format("%-15s:","Descrição"));
//        sb.append(getDescricao());
//        sb.append("\n");
//        
//        sb.append(String.format("%-15s:","Valor"));
//        sb.append(getValor());
//        sb.append("\n");
//        
//        sb.append(String.format("%-15s:","Natureza"));
//        sb.append(getNatureza());
//        sb.append("\n");
        
        return "Movimento{" + "dataMovimento=" + dataMovimento + ", descricao=" + descricao + ", valor=" + valor + ", natureza=" + natureza + '}';
    }

    
}
