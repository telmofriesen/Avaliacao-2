/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author a902918
 */
@Entity
@Table(name = "visita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visita.findAll", query = "SELECT v FROM Visita v"),
    @NamedQuery(name = "Visita.findByCodigo", query = "SELECT v FROM Visita v WHERE v.codigo = :codigo"),
    @NamedQuery(name = "Visita.findByDescricao", query = "SELECT v FROM Visita v WHERE v.descricao = :descricao"),
    @NamedQuery(name = "Visita.findByVagas", query = "SELECT v FROM Visita v WHERE v.vagas = :vagas")})
public class Visita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vagas")
    private int vagas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "visita1")
    private Collection<InscricaoVisita> inscricaoVisitaCollection;

    public Visita() {
    }

    public Visita(Integer codigo) {
        this.codigo = codigo;
    }

    public Visita(Integer codigo, String descricao, int vagas) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.vagas = vagas;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    @XmlTransient
    public Collection<InscricaoVisita> getInscricaoVisitaCollection() {
        return inscricaoVisitaCollection;
    }

    public void setInscricaoVisitaCollection(Collection<InscricaoVisita> inscricaoVisitaCollection) {
        this.inscricaoVisitaCollection = inscricaoVisitaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visita)) {
            return false;
        }
        Visita other = (Visita) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inscricao.persistence.entity.Visita[ codigo=" + codigo + " ]";
    }
    
}
