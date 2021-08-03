/*
terminar autores
 */
package br.edu.ifsul.modelo04;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author rvelasco
 */
@Entity
@Table(name = "livrobasico")
public class LivroBasico {

    @Id
    @NotBlank(message = "O isbn de livro deve ser informado")
    @Length(max = 30, message = "O isbn de livro não pode ter mais que {max} caracteres")
    @Column(name = "isbn", length = 30, nullable = false)
    private String ISBN;
    @NotBlank(message = "O titulo deve ser informado")
    @Length(max = 30, message = "O titulo não pode ter mais que {max} caracteres")
    @Column(name = "titulo", length = 30, nullable = false)
    private String titulo;
    @NotBlank(message = "O resumo deve ser informado")
    @Length(max = 30, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "resumo", length = 30, nullable = false)
    private String resumo;
    @NotBlank(message = "O editora deve ser informado")
    @Length(max = 30, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "editora", length = 30, nullable = false)
    private String editora;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de fundação deve ser informada")
    @Column(name = "data_publicacao", nullable = false)
    private Calendar dataPublicacao;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "autores",
            joinColumns
            = @JoinColumn(name = "nome_usuario", referencedColumnName = "nome_usuario", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "autor", referencedColumnName = "nome", nullable = false))
    private Set<Autor> autores = new HashSet<>();

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Calendar getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Calendar dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.titulo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LivroBasico other = (LivroBasico) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return true;
    }

}
