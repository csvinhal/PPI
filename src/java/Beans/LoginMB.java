package Beans;

import Controller.UsuarioEJB;
import Model.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name="loginMB")
@SessionScoped
public class LoginMB implements Serializable{
    
    @EJB
    public UsuarioEJB usuEJB;
    public Usuario usuario;
    
     public Usuario getUserLogado() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext external = context.getExternalContext();
        String login = external.getRemoteUser();

        if (usuario == null || !login.equals(usuario.getEmail())) {
            if (login != null) {
                usuario = usuEJB.findUsuarioPorLogin(login);                
            }
        }
        return usuario;
    }   
}
