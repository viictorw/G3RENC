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
import model.Modalidade;

/**
 *
 * @author Luis
 */
public class ModalidadeDAO {
       private static ModalidadeDAO instance = new ModalidadeDAO();
    public static ModalidadeDAO getInstance() {
        return instance;

    }

    private ModalidadeDAO() {
    }

    public void salvar(Modalidade modalidade) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            if (modalidade.getId() != null) {
                em.merge(modalidade);
            } else {
                em.persist(modalidade);
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

    public void excluir(Modalidade modalidade) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(em.getReference(Modalidade.class, modalidade.getId()));
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

    public Modalidade getModalidade(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Modalidade modalidade = null;

        try {
            tx.begin();
            modalidade = em.find(Modalidade.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return modalidade;
    }

    public List<Modalidade> getAllModalidades() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Modalidade> modalidades = null;
        try {
            tx.begin();
            TypedQuery<Modalidade> query = em.createQuery("select c From Modalidade c", Modalidade.class);
            modalidades = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return modalidades;
    }
}
