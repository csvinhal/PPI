package Beans;

import Model.Usuario;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="usuarioMB")
@ViewScoped
public class UsuarioMB {
    private Usuario usuario;
    private String confirmaSenha;
    private String senhaCriptografada;
    
    public UsuarioMB() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        if (usuario == null){
            usuario = new Usuario();
        }
        return usuario;  
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }
    
    public void novo(){
        this.usuario = new Usuario();
    }
    
    public String cadastraUsuario(){
        novo();
        return "usuario";
    }
    
    public void salvar(){
       String senha = this.usuario.getSenha();
       
       if(!senha.equals(this.confirmaSenha)){
           FacesContext fc = FacesContext.getCurrentInstance();
           fc.addMessage(null, new FacesMessage("A senha confirmada não conrresponde a senha digitada"));
       }else{
            try{
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Usuario salvo com sucesso!"));
                usuario = new Usuario();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao salvar usuário!"));
            }
       }
    }
    
    
}
