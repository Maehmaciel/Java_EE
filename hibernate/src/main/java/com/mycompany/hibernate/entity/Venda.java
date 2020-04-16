/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author maeh
 */
@Entity
@Table(name = "tb_venda")
public class Venda implements Serializable{
    
    @Id
    @GeneratedValue
    private int codigo;
    private Date data;
    
    @OneToMany
    @JoinColumn(name = "id_venda")
    private List<ItemVenda> itens;

    public Venda(Date data) {
        this.data = data;
        this.itens = new ArrayList();
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
    
    public void setItem(ItemVenda item) {
        this.itens.add(item);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    

    
    public double total() {
        double total=0;
        
        for(ItemVenda i : this.itens)
            total+=i.total();
        
        return total;
    }
}
