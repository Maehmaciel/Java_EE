/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate.dao;

import com.mycompany.hibernate.entity.Venda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JpaUtil;

/**
 *
 * @author maeh
 */
public class VendaDao {
    EntityManager em = JpaUtil.getEntityManager();

    public void salvar(Venda venda){
        //inicia a transação
        em.getTransaction().begin();
        em.persist(venda);
        em.getTransaction().commit();
    }

    public Venda produto(int id){
        return em.find(Venda.class, id);
    }

    public List<Venda> Produtos(){
        Query query = em.createQuery("from tb_venda");
        return query.getResultList();
    }

    public void remove(Venda venda){
        em.getTransaction().begin();
        Venda v = em.find(Venda.class, venda.getCodigo());
        em.remove(v);
        em.getTransaction().commit();
    }

    public void update(Venda venda){
        em.getTransaction().begin();
        em.merge(venda);
        em.getTransaction().commit();
    }
}
