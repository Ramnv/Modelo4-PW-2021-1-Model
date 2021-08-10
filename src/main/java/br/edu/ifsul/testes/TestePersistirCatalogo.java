package br.edu.ifsul.testes;

import br.edu.ifsul.modelo04.Catalogo;
import br.edu.ifsul.modelo04.Livraria;
import br.edu.ifsul.modelo04.Livro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirCatalogo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-1-ModelPU");
        EntityManager em = emf.createEntityManager();

        Livraria l = em.find(Livraria.class, 2);
        Catalogo i = new Catalogo();

        i.setNome("CatalagoTeste");
        i.setDescricao("Catalogo de livros digitais");
        l.adicionarCatalogo(i);

        em.getTransaction().begin();
        em.merge(l);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
