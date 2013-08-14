/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.persistence.entity;

import java.util.List;

/**
 *
 * @author telmo
 */
public class Regiao {
    private Integer codigo;
    private String descricao;
    
    private List<Estado> estados;

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
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
    
    public Regiao() {
    }

    public Regiao(Integer codigo) {
        this.codigo = codigo;
    }

    public Regiao(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}
