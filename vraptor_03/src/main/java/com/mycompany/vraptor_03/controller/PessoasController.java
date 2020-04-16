package com.mycompany.vraptor_03.controller;


import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import com.mycompany.vraptor_03.model.dao.PessoaDao;
import com.mycompany.vraptor_03.model.entity.Pessoa;
import java.util.List;

@Controller
public class PessoasController {

    PessoaDao dao = new PessoaDao();
    public void teste(){}
    public void form() {

    }
    @Path("/delete/{id}")
    public void delete(int id, Result result) {
        dao.remove(id);

        result.redirectTo(this).lista();
    }
    @Path("/update/{id}")
    public void update(int id, Result result) {
        Pessoa pessoa = dao.pessoa(id);
        result.include(pessoa);
        result.of(this).form();

    }

    public List<Pessoa> lista() {
        return dao.pessoasLista();

    }

    public void salvar(Pessoa pessoa, Result result) {
        if (pessoa.getId() == 0) {
            dao.salvar(pessoa);
        } else {
            dao.update(pessoa);
        }

        result.redirectTo(this).lista();
    }

}
