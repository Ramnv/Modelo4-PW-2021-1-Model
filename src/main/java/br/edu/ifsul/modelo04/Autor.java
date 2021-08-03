/*
ok, 
 */
package br.edu.ifsul.modelo04;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author rvelasco
 */
@Entity
@Table(name = "autor")
public class Autor implements Serializable {

    @Id
    private Integer id;
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 30, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 30, nullable = false)
    private String nome;
    @NotBlank(message = "O bibliografia deve ser informado")
    @Column(name = "bibliografia", nullable = false)
    private String bibliografia;
    
    

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

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nome);
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
        final Autor other = (Autor) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

}
