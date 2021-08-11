package br.edu.ifsul.testes;

import br.edu.ifsul.modelo04.Livro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteListarLivros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        List<Livro> lista = em.createQuery("from Livro order by titulo").getResultList();
        for (Livro e : lista) {
            System.out.println("ISBN: " + e.getISBN() + " CodBarras: " + e.getCodigoBarras() + " Titulo: " + e.getTitulo());
        }

        em.close();
        emf.close();

    }

}
