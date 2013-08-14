/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.mngbeans;

import inscricao.persistence.entity.Candidato;
import inscricao.persistence.entity.Idioma;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import utfpr.faces.support.PageBean;


/**
 *
 * @author telmo
 */
@ManagedBean
@RequestScoped
public class ConsultaBean extends PageBean {
    
    private Long cpf;
    private boolean cpfInvalido = false;

    public boolean isCpfInvalido() {
        return cpfInvalido;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
    
    public String consultaAction() {
        InscricoesBean inscricoesBean = (InscricoesBean)getBean("inscricoesBean");
        
        Candidato c = inscricoesBean.getInscricao(cpf);
        if (c != null) {
            InscricaoBean inscricaoBean = (InscricaoBean)getBean("inscricaoBean");
            
            inscricaoBean.setCandidato(c);
            return inscricaoBean.editarInscricao();
        } else {
            cpfInvalido = true;
            return "consulta";
        }
    }
}
