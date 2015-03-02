package bitmilhoes.model;

import java.time.LocalDateTime;

/**
 * @author ipoo
 * @version 1.0
 * @created 11-Nov-2010 01:11:27
 */
public interface IAposta {

    public Premio getPremio();

    public Chave getChave();

    public Apostador getApostador();

    public LocalDateTime getDataRegisto();
}
