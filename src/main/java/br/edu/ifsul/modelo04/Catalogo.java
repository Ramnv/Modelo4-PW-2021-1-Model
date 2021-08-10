/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author rvelasco
 */
@Entity
@Table(name = "catalogo")
public class Catalogo implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_catalogo", sequenceName = "seq_catalogo_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_catalogo", strategy = GenerationType.SEQUENCE)
    Integer id;
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 30, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 30, nullable = false)
    String nome;
    @NotBlank(message = "O descricao deve ser informado")
    @Length(max = 30, message = "O descricao não pode ter mais que {max} caracteres")
    @Column(name = "descricao", length = 30, nullable = false)
    String descricao;
    @NotNull(message = "O livraria deve ser informada")
    @ManyToOne
    @JoinColumn(name = "livraria_id", referencedColumnName = "id", nullable = false)
    private Livraria livraria;
    @OneToMany(mappedBy = "catalogo", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Livro> livros = new ArrayList<>();

    public Catalogo() {
    }

    public void adicionarLivro(Livro obj) {
//        obj.setTime(this);
        this.livros.add(obj);
    }

    public void removerLivro(int index) {
        this.livros.remove(index);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Livraria getLivraria() {
        return livraria;
    }

    public void setLivraria(Livraria livraria) {
        this.livraria = livraria;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
