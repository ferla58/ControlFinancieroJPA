/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Categoria;

/**
 *
 * @author Fermín
 */
public class TestEliminarCategoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ControlFinancieroModelPU");
        EntityManager em = emf.createEntityManager();

        Categoria c = em.find(Categoria.class, 3);

        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
