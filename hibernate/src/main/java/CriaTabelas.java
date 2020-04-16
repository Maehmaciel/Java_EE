
import com.mycompany.hibernate.dao.ItemVendaDao;
import com.mycompany.hibernate.dao.ProdutoDao;
import com.mycompany.hibernate.dao.VendaDao;
import com.mycompany.hibernate.entity.ItemVenda;
import com.mycompany.hibernate.entity.Produto;
import com.mycompany.hibernate.entity.Venda;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Persistence;

public class CriaTabelas {
    public static void main(String[] args) {
 
       Calendar date = Calendar.getInstance();
       
        System.out.println( date.getTime());
        Produto p = new Produto();
        p.setDescricao("Banana");
        p.setValor(2);
         Produto p2 = new Produto();
        p2.setDescricao("Maça");
        p2.setValor(2);
        ProdutoDao dao = new ProdutoDao();
        dao.salvar(p2);
        dao.salvar(p);
        
        
        ItemVendaDao dao2 = new ItemVendaDao();
        ItemVenda iv = new ItemVenda(2,p);
        ItemVenda iv2 = new ItemVenda(2,p2);
        dao2.salvar(iv);
        dao2.salvar(iv2);
        Venda v = new Venda(Calendar.getInstance().getTime());
        
        v.setItem(iv2);
        v.setItem(iv);
        VendaDao dao3 = new VendaDao();
        dao3.salvar(v);
        System.out.println(v.total());
        
    }
}