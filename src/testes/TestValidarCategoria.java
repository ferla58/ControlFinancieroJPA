/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import modelo.Categoria;

/**
 *
 * @author Fermín
 */
public class TestValidarCategoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ControlFinancieroModelPU");
        EntityManager em = emf.createEntityManager();

        Categoria c = new Categoria();
        c.setId(3);
        c.setDescripcion("Ladera");
        c.setTipo("MENSAJE QUE DA POR EL CULO AL INTENTAR PASAR UN DATO CON MAS CARACTERES DE LOS QUE SON PARA VALIDAR");

        em.getTransaction().begin();
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Categoria>> errores = validador.validate(c);
        if (errores.size() > 0) {
            for (ConstraintViolation<Categoria> error : errores) {
                System.out.print("Error: " + error.getMessage());
            }
        } else {
            em.persist(c);
        }
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
