package br.edu.ifsul.testes;

import br.edu.ifsul.modelo04.Formato;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirFormato {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Formato i = new Formato();

        i.setNome("FormatoTeste");
        i.setNome("MOBI");
        em.getTransaction().begin();
        em.persist(i);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
