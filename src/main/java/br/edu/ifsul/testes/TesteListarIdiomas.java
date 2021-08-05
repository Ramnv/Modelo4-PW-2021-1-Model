package br.edu.ifsul.testes;

import br.edu.ifsul.modelo04.Idioma;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteListarIdiomas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        List<Idioma> lista = em.createQuery("from Idioma order by nome").getResultList();
        for (Idioma e : lista) {
            System.out.println("ID: " + e.getId() + " Nome: " + e.getNome() + " Sigla: " + e.getSigla());
        }

        em.close();
        emf.close();

    }

}
