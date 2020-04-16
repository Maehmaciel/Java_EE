/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate.dao;

import util.JpaUtil;
import com.mycompany.hibernate.entity.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author maeh
 */
public class ProdutoDao {
    
    EntityManager em = JpaUtil.getEntityManager();

    public void salvar(Produto produto){
        //inicia a transação
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
    }

    public Produto produto(int id){
        return em.find(Produto.class, id);
    }

    public List<Produto> Produtos(){
        Query query = em.createQuery("from tb_produto");
        return query.getResultList();
    }

    public void remove(Produto produto){
        em.getTransaction().begin();
        Produto p = em.find(Produto.class, produto.getCodigo());
        em.remove(p);
        em.getTransaction().commit();
    }

    public void update(Produto produto){
        em.getTransaction().begin();
        em.merge(produto);
        em.getTransaction().commit();
    }


}
