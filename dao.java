/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.Conexao;
import cliente.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lab2-01
 */
public class dao {

    private Connection Conexao;
    public void cadastrarCliente(Cliente obj) {
        try
        {
            
            String cmdsql = "insert into cliente(nome,email,telefone)values(?,?,?)";
            
            PreparedStatement stmt = Conexao.prepareStatement(cmdsql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getTelefone());
            
            stmt.execute();
            
            stmt.close();
        
        }
     catch (SQLException e)
    {
    throw new RuntimeException(e);
            }
    }

    public void update(Cliente c){
        Conexao con = new Conexao();
        PreparedStatement stmt = null;
        try
        {
            stmt = con.prepareStatement("UPDATE cliente SET nome=?, email=?, telefone=? WHERE id =?");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getTelefone());
            stmt.setInt(4,c.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
            }
        catch (SQLException ex)
        {
        JOptionPane.showMessageDialog(null,"ERRO AO ATUALIZAR"+ ex);
        }
        finally {ConnectionFactory.closeConnection(con,stmt);}
    }
    public void delete(Cliente c){
        Conexao con = Conexao();
        PreparedStatement stmt = null;
        try
        {
            stmt = con.prepareStatement("DELETE FROM cliente WHERE ID=?");
            stmt.setInt(1, c.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro ao excluir" +ex);
        }
        finally 
        {
        ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
    
    public void create(Cliente c)
    {
    Conexao con = Conexao();
    preparedStatement stmt = null;
    try
    {
    stmt = con.prepareStatement("INSERT INTO cliente (nome,email,telefone) VALUES (?,?,?)");
    stmt.setString(1, c.getNome());
    stmt.setString(2, c.getEmail());
    stmt.setString(3, c.getTelefone());
    stmt.executeUpdate();
    JOptionPane.showMessageDialog(null,"Salvo com sucesso");
    }
    catch (SQLException ex)
    {
    JOptionPane.showMessageDialog(null,"Erro ao salvar" +ex);
    }
    finally
    {
    ConnectionFactory.closeConnection(con, stmt);
    }
    }
}

