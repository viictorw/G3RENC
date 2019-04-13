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
import model.Disponibilidadee;

/**
 *
 * @author iza
 */
public class DisponibilidadeeDAO {
        private static DisponibilidadeeDAO instance = new DisponibilidadeeDAO();
    public static DisponibilidadeeDAO getInstance() {
        return instance;

    }

    private DisponibilidadeeDAO() {
    }

    public void salvar(Disponibilidadee disponibilidade) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            if (disponibilidade.getId() != null) {
                em.merge(disponibilidade);
            } else {
                em.persist(disponibilidade);
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

    public void excluir(Disponibilidadee disponibilidade) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(em.getReference(Disponibilidadee.class, disponibilidade.getId()));
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

    public Disponibilidadee getDisponibilidade(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Disponibilidadee disponibilidade = null;

        try {
            tx.begin();
            disponibilidade = em.find(Disponibilidadee.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return disponibilidade;
    }

    public List<Disponibilidadee> getAllDisponibilidades() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Disponibilidadee> disponibilidades = null;
        try {
            tx.begin();
            TypedQuery<Disponibilidadee> query = em.createQuery("select c From Disponibilidade c", Disponibilidadee.class);
            disponibilidades = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return disponibilidades;
    }
}
