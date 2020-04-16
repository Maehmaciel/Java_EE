/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate.dao;

import com.mycompany.hibernate.entity.ItemVenda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JpaUtil;

/**
 *
 * @author maeh
 */
public class ItemVendaDao {
        EntityManager em = JpaUtil.getEntityManager();

    public void salvar(ItemVenda itemVenda){
        //inicia a transação
        em.getTransaction().begin();
        em.persist(itemVenda);
        em.getTransaction().commit();
    }

    public ItemVenda produto(int id){
        return em.find(ItemVenda.class, id);
    }

    public List<ItemVenda> Produtos(){
        Query query = em.createQuery("from tb_itemVenda");
        return query.getResultList();
    }

    public void remove(ItemVenda itemVenda){
        em.getTransaction().begin();
        ItemVenda v = em.find(ItemVenda.class, itemVenda.getCodigo());
        em.remove(v);
        em.getTransaction().commit();
    }

    public void update(ItemVenda itemVenda){
        em.getTransaction().begin();
        em.merge(itemVenda);
        em.getTransaction().commit();
    }
}
