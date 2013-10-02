/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author a902918
 */
@Embeddable
public class InscricaoVisitaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_inscricao")
    private int numeroInscricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "visita")
    private int visita;

    public InscricaoVisitaPK() {
    }

    public InscricaoVisitaPK(int numeroInscricao, int visita) {
        this.numeroInscricao = numeroInscricao;
        this.visita = visita;
    }

    public int getNumeroInscricao() {
        return numeroInscricao;
    }

    public void setNumeroInscricao(int numeroInscricao) {
        this.numeroInscricao = numeroInscricao;
    }

    public int getVisita() {
        return visita;
    }

    public void setVisita(int visita) {
        this.visita = visita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numeroInscricao;
        hash += (int) visita;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscricaoVisitaPK)) {
            return false;
        }
        InscricaoVisitaPK other = (InscricaoVisitaPK) object;
        if (this.numeroInscricao != other.numeroInscricao) {
            return false;
        }
        if (this.visita != other.visita) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inscricao.persistence.entity.InscricaoVisitaPK[ numeroInscricao=" + numeroInscricao + ", visita=" + visita + " ]";
    }
    
}
