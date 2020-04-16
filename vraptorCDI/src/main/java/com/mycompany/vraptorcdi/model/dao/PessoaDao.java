/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vraptorcdi.model.dao;

/**
 *
 * @author maeh
 */
import com.mycompany.vraptorcdi.model.Pessoa;
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
}