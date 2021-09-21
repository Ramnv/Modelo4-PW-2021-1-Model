package br.edu.ifsul.testes;

import br.edu.ifsul.modelo04.Permissao;
import br.edu.ifsul.modelo04.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirPermissoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Usuario u = em.find(Usuario.class, "ramonvelasco");
        Permissao p1 = em.find(Permissao.class, "ADMINISTRADOR");
        Permissao p2 = em.find(Permissao.class, "USUARIO");
        u.getPermissoes().add(p1);
        u.getPermissoes().add(p2);
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
