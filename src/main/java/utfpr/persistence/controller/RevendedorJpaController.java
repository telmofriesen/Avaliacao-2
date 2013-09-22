/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

//import inscricao.persistence.entity.Idioma;
import inscricao.persistence.entity.Estado;
import inscricao.persistence.entity.Revendedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Wilson
 */
public class RevendedorJpaController extends JpaController {

    public RevendedorJpaController() {
    }

    public void persist(Revendedor r) {
        EntityManager em = null;        
        try {
            em = getEntityManager();
            
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
            
        } finally {
            if (em != null) em.close();
        }
    }
}
