/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo04;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author rvelasco
 */
@Entity
@Table(name = "idioma")
public class Idioma implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_idioma", sequenceName = "seq_idioma_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_idioma", strategy = GenerationType.SEQUENCE)
    Integer id;
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 30, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome_idioma", length = 30, nullable = false)
    String nome;
    @NotBlank(message = "O sigla deve ser informado")
    @Length(max = 30, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "sigla", length = 30, nullable = false)
    String sigla;

    public Idioma() {
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Idioma other = (Idioma) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
