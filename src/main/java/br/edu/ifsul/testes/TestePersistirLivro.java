package br.edu.ifsul.testes;

import br.edu.ifsul.modelo04.Catalogo;
import br.edu.ifsul.modelo04.Formato;
import br.edu.ifsul.modelo04.Idioma;
import br.edu.ifsul.modelo04.Livro;
import br.edu.ifsul.modelo04.LivroBasico;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirLivro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-1-ModelPU");
        EntityManager em = emf.createEntityManager();

//        LivroBasico livb = em.find(LivroBasico.class, "1234567891235");
//        Catalogo cat = new Catalogo();
        Livro liv = new Livro();

        liv.setFormato(em.find(Formato.class, 6));
        liv.setIdioma(em.find(Idioma.class, 5));

        liv.setISBN("ISBN567891235");
        liv.setTitulo("TituloTeste");
        liv.setResumo("ResumoTeste");
        liv.setEditora("EditoraTeste");
        // dataPublicacao

        liv.setCodigoBarras("123456");
        liv.setNumeroPaginas(900);
        liv.setAtivo(true);
        liv.setValor(200.50);
//        liv.setDataCadastro(Calendar.getInstance());

        em.getTransaction().begin();
        em.persist(liv);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
