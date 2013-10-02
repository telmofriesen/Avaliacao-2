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
@Table(name = "inscricao_visita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InscricaoVisita.findAll", query = "SELECT i FROM InscricaoVisita i"),
    @NamedQuery(name = "InscricaoVisita.findByNumeroInscricao", query = "SELECT i FROM InscricaoVisita i WHERE i.inscricaoVisitaPK.numeroInscricao = :numeroInscricao"),
    @NamedQuery(name = "InscricaoVisita.findByVisita", query = "SELECT i FROM InscricaoVisita i WHERE i.inscricaoVisitaPK.visita = :visita"),
    @NamedQuery(name = "InscricaoVisita.findByDataHora", query = "SELECT i FROM InscricaoVisita i WHERE i.dataHora = :dataHora"),
    @NamedQuery(name = "InscricaoVisita.findBySituacao", query = "SELECT i FROM InscricaoVisita i WHERE i.situacao = :situacao")})
public class InscricaoVisita implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InscricaoVisitaPK inscricaoVisitaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "situacao")
    private int situacao;
    @JoinColumn(name = "visita", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Visita visita1;
    @JoinColumn(name = "numero_inscricao", referencedColumnName = "numero", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Inscricao inscricao;

    public InscricaoVisita() {
    }

    public InscricaoVisita(InscricaoVisitaPK inscricaoVisitaPK) {
        this.inscricaoVisitaPK = inscricaoVisitaPK;
    }

    public InscricaoVisita(InscricaoVisitaPK inscricaoVisitaPK, Date dataHora, int situacao) {
        this.inscricaoVisitaPK = inscricaoVisitaPK;
        this.dataHora = dataHora;
        this.situacao = situacao;
    }

    public InscricaoVisita(int numeroInscricao, int visita) {
        this.inscricaoVisitaPK = new InscricaoVisitaPK(numeroInscricao, visita);
    }

    public InscricaoVisitaPK getInscricaoVisitaPK() {
        return inscricaoVisitaPK;
    }

    public void setInscricaoVisitaPK(InscricaoVisitaPK inscricaoVisitaPK) {
        this.inscricaoVisitaPK = inscricaoVisitaPK;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public Visita getVisita1() {
        return visita1;
    }

    public void setVisita1(Visita visita1) {
        this.visita1 = visita1;
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
        hash += (inscricaoVisitaPK != null ? inscricaoVisitaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscricaoVisita)) {
            return false;
        }
        InscricaoVisita other = (InscricaoVisita) object;
        if ((this.inscricaoVisitaPK == null && other.inscricaoVisitaPK != null) || (this.inscricaoVisitaPK != null && !this.inscricaoVisitaPK.equals(other.inscricaoVisitaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inscricao.persistence.entity.InscricaoVisita[ inscricaoVisitaPK=" + inscricaoVisitaPK + " ]";
    }
    
}
