package com.mycompany.vraptor_02.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import com.mycompany.vraptor_02.model.dao.PessoaDao;
import com.mycompany.vraptor_02.model.entity.Pessoa;
import java.util.List;

@Controller
public class PessoasController {

    PessoaDao dao = new PessoaDao();

    public void form() {

    }
    @Path("/delete/{id}")
    public void delete(int id, Result result) {
        dao.excluir(id);

        result.redirectTo(this).lista();
    }
    @Path("/update/{id}")
    public void update(int id, Result result) {
        Pessoa pessoa = dao.buscarPessoa(id);
        result.include(pessoa);
        result.of(this).form();

    }

    public List<Pessoa> lista() {
        return dao.listar();

    }

    public void salvar(Pessoa pessoa, Result result) {
        if (pessoa.getId() == 0) {
            dao.add(pessoa);
        } else {
            dao.update(pessoa);
        }

        result.redirectTo(this).lista();
    }

}
