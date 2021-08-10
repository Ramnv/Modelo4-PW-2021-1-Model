package br.edu.ifsul.testes;

import br.edu.ifsul.modelo04.Formato;
import br.edu.ifsul.modelo04.Idioma;
import br.edu.ifsul.modelo04.Livro;
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

        Idioma i = em.find(Idioma.class, 1);
        Formato f = em.find(Formato.class, 1);
        Livro liv = new Livro();

        liv.setISBN("ISBN567891235");
        liv.setTitulo("TituloTeste");
        liv.setResumo("ResumoTeste");
        liv.setEditora("EditoraTeste");
        liv.setDataPublicacao(Calendar.getInstance());

        liv.setCodigoBarras("123456");
        liv.setNumeroPaginas(900);
        liv.setAtivo(true);
        liv.setDataCadastro(Calendar.getInstance());
        liv.setValor(200.50);
        

        em.getTransaction().begin();
        em.persist(liv);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
