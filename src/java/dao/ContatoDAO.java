/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Contato;
import model.Irregularidade;

/**
 *
 * @author iza
 */
public class ContatoDAO extends GenericoDAO<Contato>{
     private static ContatoDAO instance = new ContatoDAO();
    public static ContatoDAO getInstance() {
        return instance;

    }

    private ContatoDAO() {
    }


    public List<Contato> getAllContatos() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Contato> contatos = null;
        try {
            tx.begin();
            TypedQuery<Contato> query = em.createQuery("select c From Contato c", Contato.class);
            contatos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return contatos;
    }

}
