package com.mycompany.vraptor_02.model.dao;
import com.mycompany.vraptor_02.model.entity.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Dependent;

@Dependent
public class PessoaDao {
    public boolean excluir(int id) {
        try {
            Connection con = Conexao.criarConexao();
            String sql = "delete from pessoa where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);   
            if(ps.executeUpdate()==1)
                return true;
            
        } catch (SQLException ex) {
            System.out.println("Errim");
        } 
        return false;
    }

    public boolean add(Pessoa pessoa) {
        try {
            Connection con = Conexao.criarConexao();
            String sql = "insert into pessoa (nome) values (?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pessoa.getNome());
            
            if(ps.executeUpdate()==1)
                return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRIM");
        } 
        return false;
    }
    public boolean update(Pessoa pessoa) {
        try {
            Connection con = Conexao.criarConexao();
            String sql = "update pessoa set nome=? where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pessoa.getNome());
            ps.setInt(2, pessoa.getId());
            
            if (ps.executeUpdate()==1)
                return true;
                    
        } catch (SQLException ex) {
            System.out.println("ERRIM");
        }
        return false;
    }

 public Pessoa buscarPessoa(int id) { 
     Pessoa p = new Pessoa();
     try {
     
           Connection con = Conexao.criarConexao();        
           String sql = "select * from pessoa where id = ?";
           PreparedStatement ps = con.prepareStatement(sql);
         
           ps.setInt(1, id);       

            ResultSet rs = ps.executeQuery();
           if (rs.first()) {

               p.setId(rs.getInt("id"));
               p.setNome(rs.getString("nome"));

              return p;
            }
     } catch (SQLException ex) {
          System.out.println("Errim");
       }
        return p;
    }

    public List<Pessoa> listar() {
        List<Pessoa> pessoas = new ArrayList();
        try {
            Connection con = Conexao.criarConexao();
            String sql = "select * from pessoa";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                pessoas.add(p);
            }
            return pessoas;
        } catch (SQLException ex) {
            System.out.println("ETA");
        }
        return pessoas;
    }
    
    
    
}
