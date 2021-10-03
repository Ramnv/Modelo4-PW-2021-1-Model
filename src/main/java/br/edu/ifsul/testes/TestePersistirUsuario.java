
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo04.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Usuario u = new Usuario();
        u.setNomeUsuario("user");
        u.setSenha("123456");
        u.setAtivo(true);
        u.setEmail("ramon.velasco@ifsul.edu.br");        
        u.setNome("Ramon Velasco");        
        em.getTransaction().begin();
        em.persist(u);        
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
        
    }

}
