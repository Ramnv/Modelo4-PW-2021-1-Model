package br.edu.ifsul.testes;

import br.edu.ifsul.modelo04.Livraria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirLivraria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Livraria i = new Livraria();
        
        i.setNome("LivrariaTeste2");
        i.setSite("Livraria2.teste.com");
        
        
        em.getTransaction().begin();
        em.persist(i);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
