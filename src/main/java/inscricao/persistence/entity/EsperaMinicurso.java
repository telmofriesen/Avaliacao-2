/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a902918
 */
@Entity
@Table(name = "espera_minicurso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EsperaMinicurso.findAll", query = "SELECT e FROM EsperaMinicurso e"),
    @NamedQuery(name = "EsperaMinicurso.findByNumeroInscricao", query = "SELECT e FROM EsperaMinicurso e WHERE e.esperaMinicursoPK.numeroInscricao = :numeroInscricao"),
    @NamedQuery(name = "EsperaMinicurso.findByMinicurso", query = "SELECT e FROM EsperaMinicurso e WHERE e.esperaMinicursoPK.minicurso = :minicurso"),
    @NamedQuery(name = "EsperaMinicurso.findByDataHora", query = "SELECT e FROM EsperaMinicurso e WHERE e.dataHora = :dataHora"),
    @NamedQuery(name = "EsperaMinicurso.findByConfirmado", query = "SELECT e FROM EsperaMinicurso e WHERE e.confirmado = :confirmado")})
public class EsperaMinicurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EsperaMinicursoPK esperaMinicursoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "confirmado")
    private boolean confirmado;
    @JoinColumn(name = "minicurso", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Minicurso minicurso1;
    @JoinColumn(name = "numero_inscricao", referencedColumnName = "numero", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Inscricao inscricao;

    public EsperaMinicurso() {
    }

    public EsperaMinicurso(EsperaMinicursoPK esperaMinicursoPK) {
        this.esperaMinicursoPK = esperaMinicursoPK;
    }

    public EsperaMinicurso(EsperaMinicursoPK esperaMinicursoPK, Date dataHora, boolean confirmado) {
        this.esperaMinicursoPK = esperaMinicursoPK;
        this.dataHora = dataHora;
        this.confirmado = confirmado;
    }

    public EsperaMinicurso(int numeroInscricao, int minicurso) {
        this.esperaMinicursoPK = new EsperaMinicursoPK(numeroInscricao, minicurso);
    }

    public EsperaMinicursoPK getEsperaMinicursoPK() {
        return esperaMinicursoPK;
    }

    public void setEsperaMinicursoPK(EsperaMinicursoPK esperaMinicursoPK) {
        this.esperaMinicursoPK = esperaMinicursoPK;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public boolean getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public Minicurso getMinicurso1() {
        return minicurso1;
    }

    public void setMinicurso1(Minicurso minicurso1) {
        this.minicurso1 = minicurso1;
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (esperaMinicursoPK != null ? esperaMinicursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EsperaMinicurso)) {
            return false;
        }
        EsperaMinicurso other = (EsperaMinicurso) object;
        if ((this.esperaMinicursoPK == null && other.esperaMinicursoPK != null) || (this.esperaMinicursoPK != null && !this.esperaMinicursoPK.equals(other.esperaMinicursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inscricao.persistence.entity.EsperaMinicurso[ esperaMinicursoPK=" + esperaMinicursoPK + " ]";
    }
    
}
