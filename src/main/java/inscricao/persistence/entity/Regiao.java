/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.persistence.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author telmo
 */
public class Regiao {
    
    private static ArrayList<Regiao> regioes = null;
    
    public static ArrayList<Regiao> getRegioes(){
        if (regioes == null) {
            Regiao sul = new Regiao(1, "Sul");
            ArrayList<Estado> asul = new ArrayList<>();
            asul.add(new Estado(1, "Parana", sul));
            asul.add(new Estado(2, "Santa Catarina", sul));
            asul.add(new Estado(3, "Rio Grande do Sul", sul));
            sul.setEstados(asul);
            
            Regiao sudeste = new Regiao(2, "Sudeste");
            ArrayList<Estado> asudeste = new ArrayList<>();
            asudeste.add(new Estado(4, "Sao Paulo", sudeste));
            asudeste.add(new Estado(5, "Rio de Janeiro", sudeste));
            sudeste.setEstados(asudeste);

            regioes = new ArrayList<>();
            regioes.add(sul);
            regioes.add(sudeste);
        }
        return regioes;
    }
   
    private Integer codigo = 0;
    private String descricao = "";
    private List<Estado> estados = new ArrayList<>();

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
