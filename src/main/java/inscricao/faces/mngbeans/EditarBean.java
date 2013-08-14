/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.mngbeans;

import com.icesoft.faces.component.commandsortheader.CommandSortHeader;
import inscricao.persistence.entity.Candidato;
import inscricao.persistence.entity.Idioma;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Collections;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import utfpr.faces.support.PageBean;

/**
 *
 * @author telmo
 */
@ManagedBean
@RequestScoped
public class EditarBean extends PageBean {

    public static final String SORT_COLUMN_NOME = "nome";
    public static final String SORT_COLUMN_CPF = "cpf";
    public static final String SORT_COLUMN_IDIOMA = "idioma";
    public static final String SORT_COLUMN_CIDADE = "cidade";
    public static final String SORT_COLUMN_ESTADO = "estado";
    public static final String COLUMN_EDITAR = "editar";
    public static final String COLUMN_EXCLUIR = "excluir";
    
    private String sortColumnNome = SORT_COLUMN_NOME;
    private String sortColumnCpf = SORT_COLUMN_CPF;
    private String sortColumnIdioma = SORT_COLUMN_IDIOMA;
    private String sortColumnCidade = SORT_COLUMN_CIDADE;
    private String sortColumnEstado = SORT_COLUMN_ESTADO;
    private String columnEditar = COLUMN_EDITAR;
    private String columnExcluir = COLUMN_EXCLUIR;
    
    private ListDataModel<Candidato> candidatosDataModel;
    private ArrayList<Candidato> inscricoes;
    private InscricoesBean inscricoesBean;
    
    public String getSortColumnNome() { return sortColumnNome; }
    public String getSortColumnCpf() { return sortColumnCpf; }
    public String getSortColumnIdioma() { return sortColumnIdioma; }
    public String getSortColumnCidade() { return sortColumnCidade; }
    public String getSortColumnEstado() { return sortColumnEstado; }
    public String getColumnEditar() { return columnEditar; }
    public String getColumnExcluir() { return columnExcluir; }

    private String columnName = SORT_COLUMN_NOME;
    private boolean ascending = true;
    public String getColumnName() { return columnName;}
    public boolean getAscending() {return ascending;}
    public void setColumnName(String columnName) {this.columnName = columnName;}
    public void setAscending(boolean ascending) { this.ascending = ascending; }
    
    public ListDataModel<Candidato> getCandidatosDataModel() {
        return candidatosDataModel;
    }

    public EditarBean() {
       inscricoesBean = (InscricoesBean)getBean("inscricoesBean");
       inscricoes = inscricoesBean.getInscricoes();
       sort(columnName, ascending, inscricoes);
       candidatosDataModel = new ListDataModel<>(inscricoes);
    }
        
    public void columnSort(ActionEvent event)
    {
        // Ensure we have valid items, a valid column to sort on, and a valid event to work with
//        if ((inscricoes != null) && (inscricoes.size() > 0) &&
//            (columnName != null) &&
//            (event != null) && (event.getComponent() != null)) {
            // Get the column name that was clicked to perform the sort
            String newColumnName = ((CommandSortHeader)event.getComponent()).getColumnName();
            boolean newAscending = true;
            
            // If the new column was the same as the old column, just toggle the ascending
            if (newColumnName.equals(columnName)) {
                newAscending = !ascending;
            }
        //    ascending = newAscending;
                
            // Perform the actual sort
            sort(newColumnName, newAscending, inscricoes);
            //candidatosDataModel = new ListDataModel<>(inscricoes);
//        }
    }
      
    public static void sort(String sortColumn, ArrayList<Candidato> inscricoes) {
        sort(sortColumn, true, inscricoes);
    }
    
    public static void sort(final String sortColumn, final boolean sortAscending, final ArrayList<Candidato> inscricoes) {
        // Build a comparator that uses compareTo of the proper column
        Comparator<Candidato> sortComparator = new Comparator<Candidato>() {
            public int compare(Candidato item1, Candidato item2) {
                if (SORT_COLUMN_NOME.equals(sortColumn)) {
                    return sortAscending ?
                            item1.getNome().compareTo(item2.getNome()) :
                            item2.getNome().compareTo(item1.getNome());
                } else if (SORT_COLUMN_CPF.equals(sortColumn)) {
                    return sortAscending ?
                            item1.getCpf().compareTo(item2.getCpf()) :
                            item2.getCpf().compareTo(item1.getCpf());
                } else if (SORT_COLUMN_IDIOMA.equals(sortColumn)) {
                    return sortAscending ?
                            item1.getIdioma().getDescricao().compareTo(item2.getIdioma().getDescricao()) :
                            item2.getIdioma().getDescricao().compareTo(item1.getIdioma().getDescricao());
                } else if (SORT_COLUMN_CIDADE.equals(sortColumn)) {
                    return sortAscending ?
                            item1.getCidade().compareTo(item2.getCidade()) :
                            item2.getCidade().compareTo(item1.getCidade());
                } else if (SORT_COLUMN_ESTADO.equals(sortColumn)) {
                    return sortAscending ?
                            item1.getEstado().compareTo(item2.getEstado()) :
                            item2.getEstado().compareTo(item1.getEstado());
                } else return 0;
            }
        };
    
        Collections.sort(inscricoes, sortComparator);
    }
    
    public String excluirAction() {
        Candidato c = candidatosDataModel.getRowData();
        inscricoesBean.excluirInscricao(c);
        inscricoes = inscricoesBean.getInscricoes();
        sort(columnName, ascending, inscricoes);
        candidatosDataModel = new ListDataModel<>(inscricoes);
        return "editar";
    }
    
    public String editarAction() {
        InscricaoBean inscricaoBean = (InscricaoBean) getBean("inscricaoBean");
        Candidato c = candidatosDataModel.getRowData();
        inscricaoBean.setCandidato(c);
        return inscricaoBean.editarInscricao();
    }
}
