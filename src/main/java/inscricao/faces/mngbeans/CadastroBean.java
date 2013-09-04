package inscricao.faces.mngbeans;

import inscricao.persistence.entity.Estado;
import inscricao.persistence.entity.Regiao;
import inscricao.persistence.entity.Revendedor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import utfpr.faces.support.PageBean;
import utfpr.persistence.controller.IdiomaJpaController;
import utfpr.persistence.controller.JpaController;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import java.util.Iterator;
import javax.faces.component.UISelectItems;

/**
 *
 * @author telmo
 */
@ManagedBean
@SessionScoped
public class CadastroBean extends PageBean {

    public static final String PLEASE_SELECT = "Selecione...";
    public static final String TOPLEVEL_LOOKUP_VALUE = "9999999";
    
    private Revendedor revendedor = new Revendedor();
    private ArrayList<Regiao> regioes = Regiao.getRegioes();
    private transient HtmlSelectOneMenu menuRegiaoDeAtuacao;
    private transient HtmlSelectOneMenu menuEstadoDeAtuacao;

    public CadastroBean() {
    }

    public Revendedor getRevendedor() {
        return revendedor;
    }

    public void setRevendedor(Revendedor revendedor) {
        this.revendedor = revendedor;
    }

    public List<Regiao> getRegioes() {
        return regioes;
    }

    public List<Estado> getEstados() {

        ArrayList<Estado> todosEstados = new ArrayList<>();
        for (Regiao regiao : regioes) {
            List<Estado> estados = regiao.getEstados();
            for (Estado estado : estados) {
                todosEstados.add(estado);
            }
        }
        return todosEstados;
    }

    public List<Estado> getRegiaoEstados() {
        return revendedor.getRegiaoDeAtuacao().getEstados();
    }

    public HtmlSelectOneMenu getMenuRegiaoDeAtuacao() {
        if (menuRegiaoDeAtuacao == null) {
            menuRegiaoDeAtuacao = new HtmlSelectOneMenu();
            menuRegiaoDeAtuacao.setVisible(false);
            
            List<SelectItem> list = createSelectItemsRegioes(regioes);
            UISelectItems items = new UISelectItems();
            items.setValue(list);
            menuRegiaoDeAtuacao.getChildren().add(items);
        }
        
        return menuRegiaoDeAtuacao;
    }
    
    public HtmlSelectOneMenu getMenuEstadoDeAtuacao() {
        if (menuEstadoDeAtuacao == null) {
            menuEstadoDeAtuacao = new HtmlSelectOneMenu();
            menuEstadoDeAtuacao.setVisible(false);
        }
        return menuEstadoDeAtuacao;
    }

    public void setMenuRegiaoDeAtuacao(HtmlSelectOneMenu menu) {
        this.menuRegiaoDeAtuacao = menu;
    }

    public void setMenuEstadoDeAtuacao(HtmlSelectOneMenu menu) {
        this.menuEstadoDeAtuacao = menu;
    }

    public void menuRegiaoDeAtuacaoChanged(ValueChangeEvent event) {
        String id = (String) event.getNewValue();
        int iid = Integer.parseInt((String) event.getNewValue());

        resetRegiaoDeAtuacaoMenu(menuEstadoDeAtuacao, iid);
    }

    public void menuEstadoDeAtuacaoChanged(ValueChangeEvent event) {
        String id = (String) event.getNewValue();
        int iid = Integer.parseInt((String) event.getNewValue());

        revendedor.setEstadoDeAtuacao(null);
        for (Estado estado: revendedor.getRegiaoDeAtuacao().getEstados()) {
            if (estado.getCodigo() == iid) {
                revendedor.setEstadoDeAtuacao(estado);
            }
        }
    }
    
    private void resetRegiaoDeAtuacaoMenu(HtmlSelectOneMenu menu, int id) {
        menu.getChildren().clear();

        for (Regiao regiao : regioes) {
            if (regiao.getCodigo() == id) {
                revendedor.setRegiaoDeAtuacao(regiao);
            }
        }

        List<SelectItem> list = createSelectItemsEstados(revendedor.getRegiaoDeAtuacao().getEstados());
        UISelectItems items = new UISelectItems();
        items.setValue(list);
        menu.getChildren().add(items);
        menu.setVisible(true);
    }

    private List<SelectItem> createSelectItemsEstados(List<Estado> estados) {

        List<SelectItem> list = new ArrayList<>();
        // add the "please select" item item
        list.add(0, new SelectItem(TOPLEVEL_LOOKUP_VALUE, PLEASE_SELECT));
        for (Iterator<Estado> iter = estados.iterator(); iter.hasNext();) {
            Estado e = iter.next();
            String id = String.valueOf(e.getCodigo());
            String areaName = e.getDescricao();
            SelectItem si = new SelectItem(id, areaName);
            list.add(si);
        }
        return list;
    }

    private List<SelectItem> createSelectItemsRegioes(List<Regiao> regioes) {

        List<SelectItem> list = new ArrayList<>();
        // add the "please select" item item
        list.add(0, new SelectItem(TOPLEVEL_LOOKUP_VALUE, PLEASE_SELECT));
        for (Iterator<Regiao> iter = regioes.iterator(); iter.hasNext();) {
            Regiao e = iter.next();
            String id = String.valueOf(e.getCodigo());
            String areaName = e.getDescricao();
            SelectItem si = new SelectItem(id, areaName);
            list.add(si);
        }
        return list;
    }
    
    public String cadastroAction() {

        CadastrosBean cadastrosBean = (CadastrosBean) getBean("cadastrosBean");

//        if (editarInscricao) {
//            if (inscricoesBean.atualizarInscricao(candidato))
//                return "confirma";
//            else
//                return null;
//
//        } else {
        if (cadastrosBean.adicionarCadastro(revendedor)) {
            revendedor = new Revendedor();
            return "consulta";
        } else {
            return "cadastro";
        }
    }
}