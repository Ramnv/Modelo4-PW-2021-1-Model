/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo04;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rvelasco
 */
@Entity
@Table(name = "livro")
public class Livro extends LivroBasico {

    @NotNull(message = "O codigo de barras deve ser informado")
    @Column(name = "codigo_barras", nullable = false, columnDefinition = "numeric(6)")
    String codigoBarras;
    @NotNull(message = "O numero de paginas deve ser informado")
    @Column(name = "numero_paginas", nullable = false, columnDefinition = "numeric(6)")
    Integer numeroPaginas;
    @NotNull(message = "O campo ativo deve ser informado")
    @Column(name = "ativo", nullable = false)
    Boolean ativo;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de cadastro deve ser informada")
    @Column(name = "data_cadastro", nullable = false)
    Calendar dataCadastro;
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", nullable = false, columnDefinition = "numeric(6,3)")
    Double valor;
    @NotNull(message = "O usuário deve ser informado")
    @ManyToOne
    @JoinColumn(name = "idioma", referencedColumnName = "nome_idioma", nullable = false)
    private Idioma idioma;
    @NotNull(message = "O formato deve ser informado")
    @ManyToOne
    @JoinColumn(name = "formato", referencedColumnName = "nome_formato", nullable = false)
    private Formato formato;
    @NotNull(message = "O catalogo deve ser informado")
    @ManyToOne
    @JoinColumn(name = "catalogo_id", referencedColumnName = "id", nullable = false)
    private Catalogo catalogo;

    public Livro() {
        this.dataCadastro = Calendar.getInstance();
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

}
