/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vraptor_03.model.dao;
import com.mycompany.vraptor_03.model.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JpaUtil;

public class PessoaDao{

    EntityManager em = JpaUtil.getEntityManager();
   
    public void salvar(Pessoa pessoa){
        //inicia a transação
        em.getTransaction().begin();
        em.persist(pessoa);
        em.getTransaction().commit();
    }

    public Pessoa pessoa(int id){
        return em.find(Pessoa.class, id);
    }

    public List<Pessoa> pessoasLista(){
        Query query = em.createQuery("from Pessoa");
        return query.getResultList();
    }

    public void remove(int id){
        Pessoa pessoa = this.pessoa(id);
        em.getTransaction().begin();
        Pessoa p = em.find(Pessoa.class, pessoa.getId());
        em.remove(p);
        em.getTransaction().commit();
    }

    public void update(Pessoa pessoa){
        em.getTransaction().begin();
        em.merge(pessoa);
        em.getTransaction().commit();
    }


}
