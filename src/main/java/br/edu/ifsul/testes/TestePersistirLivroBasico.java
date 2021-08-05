package br.edu.ifsul.testes;

import br.edu.ifsul.modelo04.LivroBasico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirLivroBasico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-1-ModelPU");
        EntityManager em = emf.createEntityManager();
//        LivroBasico c = new LivroBasico();
//        c.setNome("Passo Fundo");
//        c.setEstado(em.find(Estado.class, 1));
//        em.getTransaction().begin();
//        em.persist(c);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();

    }

}
