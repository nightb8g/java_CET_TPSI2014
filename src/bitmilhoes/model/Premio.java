package bitmilhoes.model;

/**
 * @author ipoo
 * @version 1.0
 * @created 11-Nov-2010 01:11:27
 */
public class Premio {

    private int ordinal; // 1º Premio, 2º Premio, 3º Premio, ...,etc
    private int numero; // Numero de numeros certos
    private int estrela; // Numero de estrelas certas
    private float percentagem; // Percentagem atribuida

    public Premio(int ordinal,int numero,int estrela,float percentagem) {
       this.ordinal=ordinal;
       this.numero=numero;
       this.estrela=estrela;
       this.percentagem=percentagem;
    }

    public float getPercentagem() {
        return percentagem;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public int getEstrela() {
        return estrela;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Premio{" + "ordinal=" + ordinal + ", numero=" + numero + ", estrela=" + estrela + ", percentagem=" + percentagem + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.ordinal;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Premio other = (Premio) obj;
        if (this.ordinal != other.ordinal) {
            return false;
        }
        return true;
    }

    
}
