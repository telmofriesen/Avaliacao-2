/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "inscricao_pagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InscricaoPagamento.findAll", query = "SELECT i FROM InscricaoPagamento i"),
    @NamedQuery(name = "InscricaoPagamento.findByNumeroDocumento", query = "SELECT i FROM InscricaoPagamento i WHERE i.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "InscricaoPagamento.findByDataHoraProcessamento", query = "SELECT i FROM InscricaoPagamento i WHERE i.dataHoraProcessamento = :dataHoraProcessamento"),
    @NamedQuery(name = "InscricaoPagamento.findByDataVencimento", query = "SELECT i FROM InscricaoPagamento i WHERE i.dataVencimento = :dataVencimento"),
    @NamedQuery(name = "InscricaoPagamento.findByValorDocumento", query = "SELECT i FROM InscricaoPagamento i WHERE i.valorDocumento = :valorDocumento"),
    @NamedQuery(name = "InscricaoPagamento.findByDataPagamento", query = "SELECT i FROM InscricaoPagamento i WHERE i.dataPagamento = :dataPagamento"),
    @NamedQuery(name = "InscricaoPagamento.findByValorPago", query = "SELECT i FROM InscricaoPagamento i WHERE i.valorPago = :valorPago"),
    @NamedQuery(name = "InscricaoPagamento.findByValorTarifa", query = "SELECT i FROM InscricaoPagamento i WHERE i.valorTarifa = :valorTarifa"),
    @NamedQuery(name = "InscricaoPagamento.findByBancoPagamento", query = "SELECT i FROM InscricaoPagamento i WHERE i.bancoPagamento = :bancoPagamento"),
    @NamedQuery(name = "InscricaoPagamento.findByDataRetorno", query = "SELECT i FROM InscricaoPagamento i WHERE i.dataRetorno = :dataRetorno"),
    @NamedQuery(name = "InscricaoPagamento.findByDataHoraConfirmacao", query = "SELECT i FROM InscricaoPagamento i WHERE i.dataHoraConfirmacao = :dataHoraConfirmacao")})
public class InscricaoPagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numero_documento")
    private Integer numeroDocumento;
    @Column(name = "data_hora_processamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraProcessamento;
    @Column(name = "data_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_documento")
    private double valorDocumento;
    @Column(name = "data_pagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_pago")
    private Double valorPago;
    @Column(name = "valor_tarifa")
    private Double valorTarifa;
    @Column(name = "banco_pagamento")
    private Integer bancoPagamento;
    @Column(name = "data_retorno")
    @Temporal(TemporalType.DATE)
    private Date dataRetorno;
    @Column(name = "data_hora_confirmacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraConfirmacao;
    @JoinColumn(name = "numero_inscricao", referencedColumnName = "numero")
    @ManyToOne(optional = false)
    private Inscricao numeroInscricao;

    public InscricaoPagamento() {
    }

    public InscricaoPagamento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public InscricaoPagamento(Integer numeroDocumento, double valorDocumento) {
        this.numeroDocumento = numeroDocumento;
        this.valorDocumento = valorDocumento;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getDataHoraProcessamento() {
        return dataHoraProcessamento;
    }

    public void setDataHoraProcessamento(Date dataHoraProcessamento) {
        this.dataHoraProcessamento = dataHoraProcessamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(double valorDocumento) {
        this.valorDocumento = valorDocumento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Double getValorTarifa() {
        return valorTarifa;
    }

    public void setValorTarifa(Double valorTarifa) {
        this.valorTarifa = valorTarifa;
    }

    public Integer getBancoPagamento() {
        return bancoPagamento;
    }

    public void setBancoPagamento(Integer bancoPagamento) {
        this.bancoPagamento = bancoPagamento;
    }

    public Date getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public Date getDataHoraConfirmacao() {
        return dataHoraConfirmacao;
    }

    public void setDataHoraConfirmacao(Date dataHoraConfirmacao) {
        this.dataHoraConfirmacao = dataHoraConfirmacao;
    }

    public Inscricao getNumeroInscricao() {
        return numeroInscricao;
    }

    public void setNumeroInscricao(Inscricao numeroInscricao) {
        this.numeroInscricao = numeroInscricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroDocumento != null ? numeroDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscricaoPagamento)) {
            return false;
        }
        InscricaoPagamento other = (InscricaoPagamento) object;
        if ((this.numeroDocumento == null && other.numeroDocumento != null) || (this.numeroDocumento != null && !this.numeroDocumento.equals(other.numeroDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inscricao.persistence.entity.InscricaoPagamento[ numeroDocumento=" + numeroDocumento + " ]";
    }
    
}
