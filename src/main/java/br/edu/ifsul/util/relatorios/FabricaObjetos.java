package br.edu.ifsul.util.relatorios;


import br.edu.ifsul.modelo04.Idioma;
import br.edu.ifsul.modelo04.Livro;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rvelasco
 */
public class FabricaObjetos {

    public static List<Idioma> carregaIdiomas() {
        List<Idioma> lista = new ArrayList<>();
        Idioma t = new Idioma();
        t.setId(1);
        t.setNome("Português");
        t.setSigla("PT");
        lista.add(t);
        return lista;
    }
    
    public static List<Livro> carregaLivros() {
        List<Livro> lista = new ArrayList<>();
        Livro l = new Livro();

        lista.add(l);
        return lista;
    }
}
