/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Lab2-01
 */
public class Conexao {
   
        
   //return (Connection) DriverManager.getConnection("jdbc:mysql://localhost/cliente", "skrulm", "kaique");
    public static java.sql.Connection getConexao() throws SQLException{
    String url ="jdbc:mysql://localhost:3307/cliente";
    String usuario = "skrulm";
    String senha = "kaique";
    try
    {
   Class.forName("com.mysql.jdbc.Driver").newInstance();
   java.sql.Connection conexao = DriverManager.getConnection(url, usuario, senha);
    return conexao;
    }
    catch (Exception ex){
    return null;
}
    }
}
    

