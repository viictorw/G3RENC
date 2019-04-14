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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Cliente;

/**
 *
 * @author viict
 */
public class ClienteDAO {

    private static ClienteDAO instance = new ClienteDAO();
    public static ClienteDAO getInstance() {
        return instance;

    }

    private ClienteDAO() {
    }

    public void salvar(Cliente cliente) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            if (cliente.getId() != null) {
                em.merge(cliente);
            } else {
                em.persist(cliente);
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

    public void excluir(Cliente cliente) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(em.getReference(Cliente.class, cliente.getId()));
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

    public Cliente getCliente(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Cliente cliente = null;

        try {
            tx.begin();
            cliente = em.find(Cliente.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return cliente;
    }

    public List<Cliente> getAllClientes() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Cliente> clientes = null;
        try {
            tx.begin();
            TypedQuery<Cliente> query = em.createQuery("select c From Cliente c", Cliente.class);
            clientes = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return clientes;
    }
    
      public static Cliente logar(String email, String senha) throws ClassNotFoundException {
        Connection conexao = null;
        Cliente cliente = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM cliente WHERE email = ? AND senha = ?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, email);
            comando.setString(2, senha);
            ResultSet rs = comando.executeQuery();
            if (rs.first()) {
                cliente = new Cliente(
                        rs.getString("nome"),
                        rs.getString("sobrenome"),
                        rs.getString("data_nascimento"),
                        rs.getString("email"),
                        rs.getString("cpf"),
                        rs.getString("senha"));
            }

            comando.close();
            conexao.close();
        } catch (SQLException e) {
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return cliente;
    }
    public static void alterar(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "update cliente set  nome = ?, sobrenome = ?, cpf = ?, data_nascimento = ?, email = ?, senha=?"
                    + "where id = ?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getSobrenome());
            comando.setString(3, cliente.getCpf());
            comando.setString(4, cliente.getDataNascimento());
            comando.setString(5, cliente.getEmail());
             comando.setString(6, cliente.getSenha());

            comando.setLong(7, cliente.getId());
            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            throw e;
        }
    }
}
