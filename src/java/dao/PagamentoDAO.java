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
import model.Pagamento;

/**
 *
 * @author viict
 */
public class PagamentoDAO {

    private static PagamentoDAO instance = new PagamentoDAO();

    public static PagamentoDAO getInstance() {
        return instance;

    }

    private PagamentoDAO() {
    }

    public void salvar(Pagamento pagamento) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            if (pagamento.getId() != null) {
                em.merge(pagamento);
            } else {
                em.persist(pagamento);
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

    public void excluir(Pagamento pagamento) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(em.getReference(Pagamento.class, pagamento.getId()));
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

    public Pagamento getPagamento(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Pagamento pagamento = null;

        try {
            tx.begin();
            pagamento = em.find(Pagamento.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return pagamento;
    }

    public List<Pagamento> getAllPagamentoes() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Pagamento> pagamentos = null;
        try {
            tx.begin();
            TypedQuery<Pagamento> query = em.createQuery("select p From Pagamento p", Pagamento.class);
            pagamentos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return pagamentos;
    }
}
