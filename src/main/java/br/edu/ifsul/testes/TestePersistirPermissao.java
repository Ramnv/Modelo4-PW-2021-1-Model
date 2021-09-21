package br.edu.ifsul.testes;

import br.edu.ifsul.modelo04.Permissao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirPermissao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Permissao admin = new Permissao();
        admin.setNome("ADMINISTRADOR");
        admin.setDescricao("Permissão com poderes irrestritos");
        Permissao user = new Permissao();
        user.setNome("USUARIO");
        user.setDescricao("Permissão comum");
        em.getTransaction().begin();
        em.persist(admin);
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
