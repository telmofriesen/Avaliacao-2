package inscricao.faces.mngbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import utfpr.faces.support.PageBean;

/**
 *
 * @author Wilson
 */
@ManagedBean
@RequestScoped
public class LoginBean extends PageBean {
    
    private String nome = "";
    private String senha = "";
    private boolean failed = false;

    /** Creates a new instance of CadastroBean */
    public LoginBean() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }
    
    public boolean isFailed() {
        return failed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }
    
    public String loginAction(){
        failed = !(senha.equals("123") && nome.equals("telmo"));
        if (!failed) 
            return "inscricao";
        else
            return "login";
    }
}
