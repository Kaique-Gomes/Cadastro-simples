/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import JDBC.Conexao;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Lab2-01
 */
public class testa {
     public static void main(String args[]) throws SQLException{
    try (Connection conexao = new Conexao().getConexao()){
    if(conexao != null){
        System.out.println("Conexao efetuada com sucesso! ");   
    }
    else{  
        System.out.println("Houve um erro na conexao ");
    
    }}}
}
