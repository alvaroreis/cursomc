package br.gov.pa.iec.cursomc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 4729248887820835701L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Integer id;

    private final String nome;

    private final Double preco;

    @ManyToMany
    /* Cria tabela que ira fazer o "meio de campo" no relacionamento de muitos para muitos */
    @JoinTable(name = "PRODUTO_CATEGORIA", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private final List<Categoria> categorias = new ArrayList<>();

    /* Construtor com parametros */
    public Produto(final Integer id, final String nome, final Double preco) {

        super();
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getId() {

        return this.id;
    }

    public String getNome() {

        return this.nome;
    }

    public Double getPreco() {

        return this.preco;
    }

    public List<Categoria> getCategorias() {

        return this.categorias;
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
        final Produto other = (Produto) obj;
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
