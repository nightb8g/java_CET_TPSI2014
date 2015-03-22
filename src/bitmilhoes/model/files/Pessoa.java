/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheiros;

import java.io.Serializable;

/**
 *
 * @author david
 */
public class Pessoa implements Serializable{

    private long id;
    private String nome;
    private char genero;

    public Pessoa(long id, String nome, char genero) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
    }

    public char getGenero() {
        return genero;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append(",");
        sb.append("\"");
        sb.append(nome);
        sb.append("\"");
        sb.append(",");
        sb.append("\"");
        sb.append(genero);
        sb.append("\"");
        return sb.toString();
    }

}
