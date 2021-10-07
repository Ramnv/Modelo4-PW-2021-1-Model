package br.edu.ifsul.testes;

import br.edu.ifsul.modelo04.Autor;
import br.edu.ifsul.modelo04.LivroBasico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirAutores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        LivroBasico u = em.find(LivroBasico.class, "1234567891235");
        Autor p1 = em.find(Autor.class, 9);
//        Autor p2 = em.find(Autor.class, 8);
        u.getAutores().add(p1);
//        u.getAutores().add(p2);
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
