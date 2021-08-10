package br.edu.ifsul.testes;

import br.edu.ifsul.modelo04.Autor;
import br.edu.ifsul.modelo04.Idioma;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirAutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Autor i = new Autor();

        i.setNome("AutorTeste");
        i.setBibliografia("BLABLABLABLBAABLA");
        em.getTransaction().begin();
        em.persist(i);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
