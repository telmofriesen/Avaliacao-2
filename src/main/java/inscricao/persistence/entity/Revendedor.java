/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.persistence.entity;

/**
 *
 * @author telmo
 */
public class Revendedor {
    private Long cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String endereco;
    private String cidade;
    
    private Estado estado;
    
    private Regiao regiaoDeAtuacao;
    private Estado estadoDeAtuacao;

    public Estado getEstadoDeAtuacao() {
        return estadoDeAtuacao;
    }

    public void setEstadoDeAtuacao(Estado estadoDeAtuacao) {
        this.estadoDeAtuacao = estadoDeAtuacao;
    }

    public Regiao getRegiaoDeAtuacao() {
        return regiaoDeAtuacao;
    }

    public void setRegiaoDeAtuacao(Regiao regiaoDeAtuacao) {
        this.regiaoDeAtuacao = regiaoDeAtuacao;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nome_fantasia) {
        this.nomeFantasia = nome_fantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razao_social) {
        this.razaoSocial = razao_social;
    }
}
