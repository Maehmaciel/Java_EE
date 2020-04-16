/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vraptorcdi_crud.model.dao;

/**
 *
 * @author maeh
 */
import com.mycompany.vraptorcdi_crud.model.Pessoa;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Dependent
public class PessoaDao {
    
 

    @Inject
    EntityManager manager;

    public List<Pessoa> pessoas() {
        Query query = manager.createQuery("from Pessoa");
        return query.getResultList();
    }
     public void excluir(long id) {
          Pessoa pessoa = manager.find(Pessoa.class, id);

  manager.getTransaction().begin();
  manager.remove(pessoa);
  manager.getTransaction().commit();
      
        
    }
     
         public void add(Pessoa pessoa) {
            manager.getTransaction().begin();  
            manager.persist(pessoa);       
  
manager.getTransaction().commit();  
          
         
         
    }
             public void update(Pessoa pessoa) {
                   manager.getTransaction().begin();
manager.merge(pessoa);
manager.getTransaction().commit();
        
    }
             
             public Pessoa buscarPessoa(long id) {
             Query query = manager.createQuery("SELECT p FROM Pessoa p where p.id =:id");
        query.setParameter("id", id);
        return (Pessoa) query.getSingleResult();
    }
}