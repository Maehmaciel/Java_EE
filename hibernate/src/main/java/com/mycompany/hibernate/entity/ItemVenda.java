/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author maeh
 */
@Entity
@Table(name = "tb_itemVenda")
public class ItemVenda implements Serializable{
    
    @Id
    @GeneratedValue
    private int codigo;
    private double qtd;
    
    @OneToOne
    @JoinColumn(name = "id_produto")
    Produto p;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
    
    public ItemVenda(double qtd, Produto p) {
        this.qtd = qtd;
        this.p = p;
    }
    
     public double total() {
        return this.p.getValor()*qtd;
    }
}
