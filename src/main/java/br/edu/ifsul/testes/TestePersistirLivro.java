package br.edu.ifsul.testes;

import br.edu.ifsul.modelo04.Catalogo;
import br.edu.ifsul.modelo04.Formato;
import br.edu.ifsul.modelo04.Idioma;
import br.edu.ifsul.modelo04.Livro;
import br.edu.ifsul.modelo04.LivroBasico;
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

//        LivroBasico livbasico = em.find(LivroBasico.class, "1234567891235");
        Catalogo cat = em.find(Catalogo.class, 10);
        Livro liv = new Livro();
        
        liv.setCatalogo(em.find(Catalogo.class, 10));
        liv.setFormato(em.find(Formato.class, 10));
        liv.setIdioma(em.find(Idioma.class, 12));
        
        liv.setISBN("1ISBN56789123");
        liv.setTitulo("TituloTeste1");
        liv.setResumo("ResumoTeste1");
        liv.setEditora("EditoraTeste1");
        // dataPublicacao

        liv.setCodigoBarras("223456789012"); // 12
        liv.setNumeroPaginas(100);
        liv.setAtivo(true);
        liv.setValor(323.50);
//        liv.setDataCadastro(Calendar.getInstance());

//        cat.adicionarLivro(liv);
        cat.adicionarLivro(liv);
        em.getTransaction().begin();
        em.merge(cat);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}
