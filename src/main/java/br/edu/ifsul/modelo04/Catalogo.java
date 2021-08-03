/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo04;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author rvelasco
 */
public class Catalogo {

    @Id
    @SequenceGenerator(name = "seq_id", sequenceName = "seq_catalogo_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_id", strategy = GenerationType.SEQUENCE)
    Integer id;
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 30, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 30, nullable = false)
    String nome;
    @NotBlank(message = "O descricao deve ser informado")
    @Length(max = 30, message = "O descricao não pode ter mais que {max} caracteres")
    @Column(name = "descricao", length = 30, nullable = false)
    String descricao;
    @NotNull(message = "O livraria deve ser informado")
    @ManyToOne
    @JoinColumn(name = "livraria_id", referencedColumnName = "id", nullable = false)
    private Livraria livraria;
    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Livro> livros = new ArrayList<>();
}
