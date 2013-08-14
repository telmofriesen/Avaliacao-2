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

/**
 *
 * @author telmo
 */
@ManagedBean
@SessionScoped
public class CadastroBean extends PageBean {
    
    private Revendedor revendedor = new Revendedor(); // inicialmente ingles
    private boolean cnpjInvalido = false;

    public CadastroBean(){
        revendedor.setEstado(getEstados().get(1));
        revendedor.setRegiaoDeAtuacao(getRegioes().get(1));
        revendedor.setEstadoDeAtuacao(getRegioes().get(1).getEstados().get(1));
    }
    
    public boolean isCnpjInvalido() {
        return cnpjInvalido;
    }

    public void setCnpjInvalido(boolean cnpjInvalido) {
        this.cnpjInvalido = cnpjInvalido;
    }

    public Revendedor getRevendedor() {
        return revendedor;
    }

    public void setRevendedor(Revendedor revendedor) {
        this.revendedor = revendedor;
    }
    
    public List<Estado> getEstados() {
        ArrayList<Estado> estados = new ArrayList<>();
        
        estados.add(new Estado(1, "Parana"));
        estados.add(new Estado(2, "Santa Catarina"));
        estados.add(new Estado(3, "Rio Grande do Sul"));
        estados.add(new Estado(4, "Sao Paulo"));
        estados.add(new Estado(5, "Rio de Janeiro"));
        
        return new ArrayList<> (estados);
    }
    
    public List<Regiao> getRegioes() {
        ArrayList<Regiao> regioes = new ArrayList<>();
        
        ArrayList<Estado> asul = new ArrayList<>();
        
        asul.add(new Estado(1, "Parana"));
        asul.add(new Estado(2, "Santa Catarina"));
        asul.add(new Estado(3, "Rio Grande do Sul"));
        
        ArrayList<Estado> asudeste = new ArrayList<>();
        
        asudeste.add(new Estado(4, "Sao Paulo"));
        asudeste.add(new Estado(5, "Rio de Janeiro"));
        
        Regiao sul = new Regiao(1, "Sul");
        sul.setEstados(asul);
        Regiao sudeste = new Regiao(2, "Sudeste");
        sudeste.setEstados(asudeste);
        
        regioes.add(sul);
        regioes.add(sudeste);
        
        return new ArrayList<> (regioes);
    }
    
    public List<Estado> getRegiaoEstados() {
        return revendedor.getRegiaoDeAtuacao().getEstados();
    }
    
    public void atualizarEstados(ValueChangeEvent event) {
 
        //String selectedText = event.getNewValue().toString();
        revendedor.setEstadoDeAtuacao(revendedor.getRegiaoDeAtuacao().getEstados().get(0));
    }
    
    public String cadastroAction() {

        CadastrosBean cadastrosBean = (CadastrosBean)getBean("cadastrosBean");
        
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
            cnpjInvalido = true;
            return "cadastro";
        }
    }

}