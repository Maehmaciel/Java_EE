package com.mycompany.vraptor_02.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static void main(String[] args) {
        System.out.println(Conexao.criarConexao());
    }
    
    public static Connection criarConexao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/vraptor?useSSL=false";
            String usuario = "root";
            String senha = "";
            return DriverManager.getConnection(url, usuario, senha);
           
        } catch (ClassNotFoundException ex) {
            System.out.println("AKIE");
        } catch (SQLException ex) {
            System.out.println("AKIE2");
        }
        return null;
    }

    
}
