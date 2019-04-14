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
import model.Disponibilidade;

/**
 *
 * @author iza
 */
public class DisponibilidadeDAO {
        private static DisponibilidadeDAO instance = new DisponibilidadeDAO();
    public static DisponibilidadeDAO getInstance() {
        return instance;

    }

    private DisponibilidadeDAO() {
    }

    public void salvar(Disponibilidade disponibilidade) {
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

    public void excluir(Disponibilidade disponibilidade) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(em.getReference(Disponibilidade.class, disponibilidade.getId()));
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

    public Disponibilidade getDisponibilidade(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Disponibilidade disponibilidade = null;

        try {
            tx.begin();
            disponibilidade = em.find(Disponibilidade.class, id);
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

    public List<Disponibilidade> getAllDisponibilidades() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Disponibilidade> disponibilidades = null;
        try {
            tx.begin();
            TypedQuery<Disponibilidade> query = em.createQuery("select c From Disponibilidade c", Disponibilidade.class);
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
