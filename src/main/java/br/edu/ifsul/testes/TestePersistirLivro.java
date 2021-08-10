package br.edu.ifsul.testes;

import br.edu.ifsul.modelo04.Catalogo;
import br.edu.ifsul.modelo04.Formato;
import br.edu.ifsul.modelo04.Idioma;
import br.edu.ifsul.modelo04.Livro;
import br.edu.ifsul.modelo04.LivroBasico;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirLivro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-1-ModelPU");
        EntityManager em = emf.createEntityManager();

//        LivroBasico livb = em.find(LivroBasico.class, "1234567891235");
        Livro liv = new Livro();

        Catalogo cat = em.find(Catalogo.class, 7);
        liv.setFormato(em.find(Formato.class, 6));
        liv.setIdioma(em.find(Idioma.class, 5));

        liv.setISBN("2ISBN56789123");
        liv.setTitulo("TituloTeste2");
        liv.setResumo("ResumoTeste2");
        liv.setEditora("EditoraTeste2");
        // dataPublicacao

        liv.setCodigoBarras("223456789012"); // 12
        liv.setNumeroPaginas(200);
        liv.setAtivo(true);
        liv.setValor(223.50);
//        liv.setDataCadastro(Calendar.getInstance());

        cat.adicionarLivro(liv);

        em.getTransaction().begin();
        em.merge(cat);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
