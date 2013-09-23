/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.mngbeans;

import inscricao.persistence.entity.Revendedor;
import utfpr.persistence.controller.RevendedorJpaController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;
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
    private ListDataModel<Revendedor> revendedoresDataModel;
    private ArrayList<Revendedor> revendedores;
    private CadastrosBean cadastrosBean;
    
    public ConsultaBean() {
        
        RevendedorJpaController rjc = new RevendedorJpaController();
        revendedores = new ArrayList(rjc.getRevendedores());
        revendedoresDataModel = new ListDataModel<>(revendedores);
    }
    
    public ListDataModel<Revendedor> getRevendedoresDataModel() {
        return revendedoresDataModel;
    }

    public void setRevendedoresDataModel(ListDataModel<Revendedor> revendedoresDataModel) {
        this.revendedoresDataModel = revendedoresDataModel;
    }
    
    public boolean isCpfInvalido() {
        return cpfInvalido;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
    

//    public String consultaAction() {
//        CadastrosBean inscricoesBean = (CadastrosBean)getBean("inscricoesBean");
//        
//        Revendedor c = inscricoesBean.getInscricao(cpf);
//        if (c != null) {
//            InscricaoBean inscricaoBean = (InscricaoBean)getBean("inscricaoBean");
//            
//            inscricaoBean.setCandidato(c);
//            return inscricaoBean.editarInscricao();
//        } else {
//            cpfInvalido = true;
//            return "consulta";
//        }
//    }
}
