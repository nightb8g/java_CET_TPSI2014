package bitmilhoes.model;

import java.time.LocalDateTime;

/**
 * @author ipoo
 * @version 1.0
 * @created 11-Nov-2010 01:11:27
 */
public interface IMovimento {

    public LocalDateTime getDataMovimento();

    public String getDescricao();

    public Natureza getNatureza();

    public float getValor();
}
