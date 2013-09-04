/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.mngbeans;

import inscricao.persistence.entity.Revendedor;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.model.SelectItem;
import utfpr.faces.support.PageBean;
/**
 *
 * @author telmo
 */
@ManagedBean
@ApplicationScoped
public class CadastrosBean extends PageBean {
    
    private static HashMap<Long, Revendedor> cadastros = new HashMap<> ();
    
    public boolean existeCadastro(Long cnpj){
        if (cadastros.containsKey(cnpj)) {
            return true;
        }
        return false;
    }
    
    public boolean adicionarCadastro(Revendedor r){
        if (!cadastros.containsKey(r.getCnpj())) {
            cadastros.put(r.getCnpj(), r);
            return true;
        }
        return false;
    }
    
    public boolean atualizarCadastro(Revendedor c){
        if (cadastros.containsKey(c.getCnpj())) {
            cadastros.put(c.getCnpj(), c);
            return true;
        }
        return false;
    }
    
    public boolean excluirCadastro(Revendedor c){
        if (cadastros.containsKey(c.getCnpj())) {
            cadastros.remove(c.getCnpj());
            return true;
        }
        return false;
    }
    
    public Revendedor getCadastro(Long cnpj) {
        return cadastros.get(cnpj);
    }
    
    public ArrayList<Revendedor> getCadastros() {
        return new ArrayList<>(cadastros.values());
    }
}
