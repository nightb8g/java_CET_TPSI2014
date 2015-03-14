package bitmilhoes.model;

import java.time.LocalDateTime;

/**
 * O registo de cada aposta custa 2 euros a debitar no saldo do apostador. Se o
 * apostador Não possuir saldo suficiente Não é permitido o registo.
 *
 * @author ipoo
 * @version 1.0
 * @updated 17-Nov-2010 14:07:26
 */
public class Aposta implements IAposta {

    /**
     * A data de registo devera ser adicionada automaticamente com a data/hora
     * de sistema. O formato de saida da data de registo devera ser o
     * exemplificado a seguir: 15/07/2010 16:40:22
     */
    private LocalDateTime dataRegisto;
    /**
     * Valor do pr�mio atibuido a esta aposta.
     */
    private float valorPremio = 0;
    private Apostador apostador;
    private Chave chave; // Chave com o prémio
    private Premio premioAtribuido;
    private Chave chaveAposta; // Chave com a Aposta


    public Aposta(Apostador apostador, Chave chave) {
        this.apostador = apostador;
        this.chaveAposta = chave;
        this.dataRegisto = java.time.LocalDateTime.now();
    }
    
    @Override
    public Premio getPremio() {
        return this.premioAtribuido;
    }

    @Override
    public Chave getChave() {
        return this.chaveAposta;
    }

    @Override
    public Apostador getApostador() {
        return this.apostador;
    }

    @Override
    public LocalDateTime getDataRegisto() {
        return this.dataRegisto;
    }

    @Override
    public String toString() {
        //return "Aposta{" + "dataRegisto=" + dataRegisto + ", valorPremio=" + valorPremio + ", apostador=" + apostador + ", chave=" + chave + ", premioAtribuido=" + premioAtribuido + ", chaveAposta=" + chaveAposta + '}';
        return "Aposta{" + "dataRegisto=" + dataRegisto + ", valorPremio=" + valorPremio + ", chave=" + chave + ", premioAtribuido=" + premioAtribuido + ", chaveAposta=" + chaveAposta + "}";
    }

}
