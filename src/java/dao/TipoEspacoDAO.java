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
import model.Cliente;
import model.TipoEspaco;

/**
 *
 * @author Luis
 */
public class TipoEspacoDAO {
       private static TipoEspacoDAO instance = new TipoEspacoDAO();
    public static TipoEspacoDAO getInstance() {
        return instance;

    }

    private TipoEspacoDAO() {
    }

    public void salvar(TipoEspaco tipoEspaco) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            if (tipoEspaco.getId() != null) {
                em.merge(tipoEspaco);
            } else {
                em.persist(tipoEspaco);
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

    public void excluir(TipoEspaco tipoEspaco) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(em.getReference(TipoEspaco.class, tipoEspaco.getId()));
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

    public TipoEspaco getTipoEspaco(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        TipoEspaco tipoEspaco = null;

        try {
            tx.begin();
            tipoEspaco = em.find(TipoEspaco.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return tipoEspaco;
    }

    public List<TipoEspaco> getAllTipoEspacos() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<TipoEspaco> tipoEspacos = null;
        try {
            tx.begin();
            TypedQuery<TipoEspaco> query = em.createQuery("select c From TipoEspaco c", TipoEspaco.class);
            tipoEspacos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return tipoEspacos;
    }

}
