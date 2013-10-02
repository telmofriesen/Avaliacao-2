/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

import inscricao.persistence.entity.Inscricao;
import inscricao.persistence.entity.InscricaoMinicurso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

/**
 *
 * @author Wilson
 */
public class InscricaoJpaController extends JpaController {

    public InscricaoJpaController() {
    }

    public void persist(Inscricao i) {
        EntityManager em = null;        
        try {
            em = getEntityManager();
            
            em.getTransaction().begin();
            em.persist(i);
            em.getTransaction().commit();
            
        } finally {
            if (em != null) em.close();
        }
    }
    
    public List<Inscricao> getInscricoes() {
        EntityManager em = null;        
        try {
            em = getEntityManager();
        
             // API criterios
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Inscricao> cq = cb.createQuery(Inscricao.class);
            Root<Inscricao> rt = cq.from(Inscricao.class);
            TypedQuery<Inscricao> q = em.createQuery(cq);
            List<Inscricao> inscricoes = q.getResultList();

            return inscricoes;
        } finally {
            if (em != null) em.close();
        }
    }
    
    public List<Inscricao> getInscricoes(String filtro) {
        EntityManager em = null;        
        try {
            em = getEntityManager();
        
            // API criterios
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Inscricao> cq = cb.createQuery(Inscricao.class);
            Root<Inscricao> rt = cq.from(Inscricao.class);
//            cq.where(cb.like(rt.get(Inscricao_.nome), "%"+filtro+"%"));
            TypedQuery<Inscricao> q = em.createQuery(cq);
            List<Inscricao> inscricoes = q.getResultList();

            return inscricoes;
        } finally {
            if (em != null) em.close();
        }
    }
    
    public Inscricao getInscricoes(Integer numero) {
        EntityManager em = null;        
        try {
            em = getEntityManager();
        
            // API criterios
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Inscricao> cq = cb.createQuery(Inscricao.class);
            Root<Inscricao> rt = cq.from(Inscricao.class);
//            cq.where(cb.equal(rt.get(Inscricao_.numero), numero));
            TypedQuery<Inscricao> q = em.createQuery(cq);
            Inscricao inscricao = q.getSingleResult();

            return inscricao;
        } finally {
            if (em != null) em.close();
        }
    }
    
    public Inscricao getInscricoes(long cpf) {
        EntityManager em = null;        
        try {
            em = getEntityManager();
        
            // API criterios
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Inscricao> cq = cb.createQuery(Inscricao.class);
            Root<Inscricao> rt = cq.from(Inscricao.class);
//            cq.where(cb.equal(rt.get(Inscricao_.cpf), cpf));
            TypedQuery<Inscricao> q = em.createQuery(cq);
            Inscricao inscricao = q.getSingleResult();

            return inscricao;
        } finally {
            if (em != null) em.close();
        }
    }
    
    public List<InscricaoMinicurso> getInscricoesMinicurso(Inscricao inscricao) {
        EntityManager em = null;        
        try {
            em = getEntityManager();
        
             // API criterios
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<InscricaoMinicurso> cq = cb.createQuery(InscricaoMinicurso.class);
            Root<InscricaoMinicurso> rt = cq.from(InscricaoMinicurso.class);
//            Join<InscricaoMinicurso, Inscricao> join = rt.join(InscricaoMinicurso_.numero_inscricao); // Default is inner
//            cq.select(InscricaoMinicurso.class).distinct(true);
            TypedQuery<InscricaoMinicurso> q = em.createQuery(cq);
            List<InscricaoMinicurso> inscricoes_minicurso = q.getResultList();

            return inscricoes_minicurso;
        } finally {
            if (em != null) em.close();
        }
    }
    
    public boolean exists(Long cnpj) {
//        EntityManager em = null;        
//        try {
//            em = getEntityManager();
//        
//            // JPQL
//            TypedQuery<Revendedor> q = em.createQuery("SELECT r FROM Revendedor r WHERE r.cnpj = :cnpj", Revendedor.class);
//            q.setParameter("cnpj", cnpj);
//            return q.getResultList().size() > 0;
//
//        } finally {
//            if (em != null) em.close();
//        }
        return false;
    }
}
