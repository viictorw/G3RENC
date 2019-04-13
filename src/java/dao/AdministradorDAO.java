/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Administrador;

/**
 *
 * @author viict
 */
public class AdministradorDAO {

    private static AdministradorDAO instance = new AdministradorDAO();

    public static AdministradorDAO getInstance() {
        return instance;

    }

    private AdministradorDAO() {
    }

    public void salvar(Administrador administrador) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            if (administrador.getId() != null) {
                em.merge(administrador);
            } else {
                em.persist(administrador);
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

    public void excluir(Administrador administrador) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Administrador.class, administrador.getId()));
            tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
    }
   

    public Administrador getAdministrador(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Administrador administrador = null;

        try {
            tx.begin();
            administrador = em.find(Administrador.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return administrador;
    }

    public List<Administrador> getAllAdministradores() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Administrador> administradores = null;
        try {
            tx.begin();
            TypedQuery<Administrador> query = em.createQuery("select a From Administrador a", Administrador.class);
            administradores = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return administradores;
    }
    
    public static Administrador logar(String email, String senha) throws ClassNotFoundException {
        Connection conexao = null;
        Administrador administrador = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM administrador WHERE email = ? AND senha = ?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, email);
            comando.setString(2, senha);
            ResultSet rs = comando.executeQuery();
            if (rs.first()) {
                administrador = new Administrador(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"));
            }

            comando.close();
            conexao.close();
        } catch (SQLException e) {
        } finally {
            fecharConexao(conexao, comando);
        }
        return administrador;
    }
     public static void fecharConexao(Connection conexao, Statement comando) {
        try {
            if (comando != null) {
                comando.close();
            }

            if (comando != null) {
                conexao.close();
            }

        } catch (SQLException e) {

        }
    }
}
