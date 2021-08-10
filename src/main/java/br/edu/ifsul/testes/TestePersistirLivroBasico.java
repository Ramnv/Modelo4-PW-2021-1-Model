package br.edu.ifsul.testes;

import br.edu.ifsul.modelo04.LivroBasico;
import java.util.Calendar;
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

        LivroBasico c = new LivroBasico();

        c.setISBN("1234567891235");
        c.setTitulo("tituloBasico");
        c.setResumo("ResumoBasico");
        c.setEditora("EditoraBasico");
//        c.setDataPublicacao(Calendar.getInstance());

        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
