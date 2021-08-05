package br.edu.ifsul.testes;

import br.edu.ifsul.modelo04.Idioma;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteRemoverIdioma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-1-ModelPU");
            EntityManager em = emf.createEntityManager();
            Idioma e = em.find(Idioma.class, 1);
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
            em.close();
            emf.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getCause().getCause().getCause().getMessage());
        }

    }

}
