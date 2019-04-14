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
import model.Cartao;
import model.Irregularidade;

/**
 *
 * @author iza
 */
public class CartaoDAO {
     private static CartaoDAO instance = new CartaoDAO();
    public static CartaoDAO getInstance() {
        return instance;

    }

    private CartaoDAO() {
    }

    public void salvar(Cartao cartao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            if (cartao.getId() != null) {
                em.merge(cartao);
            } else {
                em.persist(cartao);
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
    
       public static void alterar(Irregularidade irregularidade) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "update irregularidade set autor=?,descricao=?,espaco_id=? where id=?";

            comando = conexao.prepareStatement(sql);

            comando.setString(1, irregularidade.getAutor());
            comando.setString(2, irregularidade.getDescricao());

            if (irregularidade.getIdEspaco() == null) {
                comando.setNull(3, Types.NULL);
            } else {
                comando.setLong(3, (long) irregularidade.getIdEspaco());
            }

            comando.setLong(4, irregularidade.getId());
            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            throw e;
        }
    }

    public void excluir(Cartao cartao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(em.getReference(Cartao.class, cartao.getId()));
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

    public Cartao getCartao(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Cartao cartao = null;

        try {
            tx.begin();
            cartao = em.find(Cartao.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return cartao;
    }

    public List<Cartao> getAllCartoess() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Cartao> cartoes = null;
        try {
            tx.begin();
            TypedQuery<Cartao> query = em.createQuery("select c From Cartao c", Cartao.class);
            cartoes = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return cartoes;
    }

}
