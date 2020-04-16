/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vraptorcdi_crud.controller;

/**
 *
 * @author maeh
 */

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import com.mycompany.vraptorcdi_crud.model.Pessoa;
import com.mycompany.vraptorcdi_crud.model.dao.PessoaDao;
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
    
    public void form() {

    }
    @Path("/delete/{id}")
    public void delete(long id, Result result) {
        dao.excluir(id);

        result.redirectTo(this).lista();
    }
    @Path("/update/{id}")
    public void update(long id, Result result) {
        Pessoa pessoa = dao.buscarPessoa(id);
        result.include(pessoa);
        result.of(this).form();

    }

  

    public void salvar(Pessoa pessoa, Result result) {
        if (pessoa.getId() == null) {
            dao.add(pessoa);
        } else {
            dao.update(pessoa);
        }

        result.redirectTo(this).lista();
    }

   
 
 


}