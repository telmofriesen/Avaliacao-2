/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.mngbeans;

import inscricao.persistence.entity.Candidato;
import inscricao.persistence.entity.Idioma;
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
public class InscricoesBean extends PageBean {
    
    private static HashMap<Long, Candidato> inscricoes = new HashMap<> ();
    
    public boolean adicionarInscricao(Candidato c){
        if (!inscricoes.containsKey(c.getCpf())) {
            inscricoes.put(c.getCpf(), c);
            return true;
        }
        return false;
    }
    
    public boolean atualizarInscricao(Candidato c){
        if (inscricoes.containsKey(c.getCpf())) {
            inscricoes.put(c.getCpf(), c);
            return true;
        }
        return false;
    }
    
    public boolean excluirInscricao(Candidato c){
        if (inscricoes.containsKey(c.getCpf())) {
            inscricoes.remove(c.getCpf());
            return true;
        }
        return false;
    }
    
    public Candidato getInscricao(Long cpf) {
        return inscricoes.get(cpf);
    }
    
    public ArrayList<Candidato> getInscricoes() {
        return new ArrayList<>(inscricoes.values());
    }
}
