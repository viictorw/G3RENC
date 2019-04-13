/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Reembolso;

/**
 *
 * @author viict
 */
public class ReembolsoDAO {

    private static ReembolsoDAO instance = new ReembolsoDAO();

    public static ReembolsoDAO getInstance() {
        return instance;

    }

    private ReembolsoDAO() {
    }

    public void salvar(Reembolso reembolso) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            if (reembolso.getId() != null) {
                em.merge(reembolso);
            } else {
                em.persist(reembolso);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }

    public void excluir(Reembolso reembolso) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(em.getReference(Reembolso.class, reembolso.getId()));
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }

    public Reembolso getReembolso(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Reembolso reembolso = null;

        try {
            tx.begin();
            reembolso = em.find(Reembolso.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return reembolso;
    }

    public List<Reembolso> getAllReembolsoes() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Reembolso> reembolsos = null;
        try {
            tx.begin();
            TypedQuery<Reembolso> query = em.createQuery("select reb From Reembolso reb", Reembolso.class);
            reembolsos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return reembolsos;
    }
}
