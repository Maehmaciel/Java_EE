/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vraptorcdi.controller;

/**
 *
 * @author maeh
 */

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import com.mycompany.vraptorcdi.model.Pessoa;
import com.mycompany.vraptorcdi.model.dao.PessoaDao;
import java.util.List;
import javax.inject.Inject;


@Controller
public class PessoasController{

    @Inject
    PessoaDao dao;
    @Inject
    Result result;

    public List<Pessoa> lista(){
        return dao.pessoas();
    }
    
   
 
 


}