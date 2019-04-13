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
import model.Irregularidade;

/**
 *
 * @author Luis
 */
public class IrregularidadeDAO {
       private static IrregularidadeDAO instance = new IrregularidadeDAO();
    public static IrregularidadeDAO getInstance() {
        return instance;

    }

    private IrregularidadeDAO() {
    }

    public void salvar(Irregularidade irregularidade) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            if (irregularidade.getId() != null) {
                em.merge(irregularidade);
            } else {
                em.persist(irregularidade);
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

    public void excluir(Irregularidade irregularidade) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(em.getReference(Irregularidade.class, irregularidade.getId()));
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

    public Irregularidade getIrregularidade(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Irregularidade irregularidade = null;

        try {
            tx.begin();
            irregularidade = em.find(Irregularidade.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return irregularidade;
    }

    public List<Irregularidade> getAllIrregularidades() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Irregularidade> irregularidades = null;
        try {
            tx.begin();
            TypedQuery<Irregularidade> query = em.createQuery("select c From Irregularidade c", Irregularidade.class);
            irregularidades = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return irregularidades;
    }
}
