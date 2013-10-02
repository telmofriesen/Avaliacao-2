/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.mngbeans;

import com.icesoft.faces.component.ext.HtmlDataTable;
import inscricao.persistence.entity.Inscricao;
import utfpr.persistence.controller.InscricaoJpaController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;
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
    
    private ListDataModel<Inscricao> inscricoesDataModel;
    private ArrayList<Inscricao> inscricoes;
    private String busca;
    
    public ConsultaBean() {
        
        InscricaoJpaController rjc = new InscricaoJpaController();
        inscricoes = new ArrayList(rjc.getInscricoes());
        inscricoesDataModel = new ListDataModel<>(inscricoes);
    }

    public ListDataModel<Inscricao> getInscricoesDataModel() {
        return inscricoesDataModel;
    }

    public void setInscricoesDataModel(ListDataModel<Inscricao> inscricoesDataModel) {
        this.inscricoesDataModel = inscricoesDataModel;
    }
    
    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }
    
    public void buscaTextChanged(ValueChangeEvent event) {
        String filtro = (String) event.getNewValue();
        
        InscricaoJpaController rjc = new InscricaoJpaController();
        inscricoes = new ArrayList(rjc.getInscricoes(filtro));
//        revendedoresDataModel = new ListDataModel<>(revendedores);
        
        inscricoesDataModel.setWrappedData(inscricoes);
    }
}
