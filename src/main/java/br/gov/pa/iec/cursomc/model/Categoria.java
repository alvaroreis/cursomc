/**
 *
 */
package br.gov.pa.iec.cursomc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author alvarobarros
 *
 */

@Entity
public class Categoria implements Serializable {

    private static final long serialVersionUID = 6471684689262445696L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToMany(mappedBy ="categorias")
    private final List<Produto> produtos = new ArrayList<>();

    public Categoria() {

    }

    public Categoria(final Integer id, final String nome) {

        super();
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {

        return this.id;
    }

    public void setId(final Integer id) {

        this.id = id;
    }

    public String getNome() {

        return this.nome;
    }

    public void setNome(final String nome) {

        this.nome = nome;
    }

    public List<Produto> getProdutos() {

        return this.produtos;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        if (this.id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
