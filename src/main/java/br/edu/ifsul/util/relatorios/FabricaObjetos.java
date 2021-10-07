package br.edu.ifsul.util.relatorios;

import br.edu.ifsul.modelo04.Autor;
import br.edu.ifsul.modelo04.Catalogo;
import br.edu.ifsul.modelo04.Formato;
import br.edu.ifsul.modelo04.Idioma;
import br.edu.ifsul.modelo04.Livraria;
import br.edu.ifsul.modelo04.Livro;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author rvelasco
 */
public class FabricaObjetos {

    // livraria
    // criar catalogos
    public static List<Livraria> carregaLivrarias() {
        List<Livraria> lista = new ArrayList<>();

        Livraria livraria = new Livraria();
        livraria.setId(1);
        livraria.setNome("Livraria Saraiva");
        livraria.setSite("Saraiva.com");

        Catalogo cat = new Catalogo();
        cat.setId(1);
        cat.setNome("Cat1");
        cat.setDescricao("descricaocat1");

        livraria.adicionarCatalogo(cat);

        lista.add(livraria);
        return lista;
    }

    // catalogos
    // criar livros
//    public static List<Catalogo> carregaCatalogos() {
//        List<Catalogo> lista = new ArrayList<>();
//        Catalogo form = new Catalogo();
//
//        Livro livro = new Livro();
//livro.set
//        
//        form.setId(Integer.SIZE);
//        form.setNome("EPUB");
//        form.setDescricao("versão digital");
//        lista.add(form);
//        return lista;
//    }
    public static List<Idioma> carregaIdiomas() {
        List<Idioma> lista = new ArrayList<>();
        Idioma t = new Idioma();
        t.setId(1);
        t.setNome("Português");
        t.setSigla("PT");
        lista.add(t);
        t.setId(2);
        t.setNome("Inglês");
        t.setSigla("EN");
        lista.add(t);
        t.setId(3);
        t.setNome("Espanhol");
        t.setSigla("ES");
        lista.add(t);
        return lista;
    }

    public static List<Formato> carregaFormatos() {
        List<Formato> lista = new ArrayList<>();
        Formato form = new Formato();
        form.setId(Integer.SIZE);
        form.setNome("EPUB");
        lista.add(form);
        return lista;
    }

    public static List<Livro> carregaLivros() {
        List<Livro> lista = new ArrayList<>();
        Livro l = new Livro();
        l.setISBN("abc1234567890");
        l.setTitulo("tituloWEB");
        l.setResumo("asdfjlçksafsadçjflasasdfjlçksafsadçjflas asdfjlçksafsadçjflas asdfjlçksafsadçjflas asdfjlçksafsadçjflas");
        l.setEditora("Editora Saraiva");
        l.setDataPublicacao(Calendar.getInstance());
        l.setCodigoBarras("123456789524");
        l.setNumeroPaginas(300);
        l.setAtivo(true);
        l.setDataCadastro(Calendar.getInstance());
        l.setValor(100.00);

        Autor aut = new Autor();
        aut.setNome("Stephen");
        aut.setBibliografia("Bio King");

        Idioma idi = new Idioma();
        idi.setNome("Inglês");
        idi.setSigla("EN");

        Formato form = new Formato();
        form.setNome("MOBI");

//        l.setAutores(aut);
        l.setIdioma(idi);
        l.setFormato(form);

        lista.add(l);
        return lista;
    }
}
