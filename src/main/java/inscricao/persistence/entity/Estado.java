/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.persistence.entity;

/**
 *
 * @author telmo
 */
public class Estado {
    private Integer codigo;
    private String descricao;
    private Regiao regiao;

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
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
    
    public Estado() {
    }

    public Estado(Integer codigo) {
        this.codigo = codigo;
    }

    public Estado(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    public Estado(Integer codigo, String descricao, Regiao regiao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.regiao = regiao;
    }
}
