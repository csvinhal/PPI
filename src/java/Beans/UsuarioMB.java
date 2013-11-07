package Beans;

import Controller.UsuarioEJB;
import Model.Permissao;
import Model.Usuario;
import java.io.Serializable;
import java.util.List;
import javacrypt.Crypt;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="usuarioMB")
@ViewScoped
public class UsuarioMB implements Serializable{
    @EJB
    private UsuarioEJB usuEJB;
    private Usuario usuario;
    private Permissao permissao;
    
    
    
    Crypt c = new Crypt();
    
    public UsuarioMB() {
        usuario = new Usuario();
        permissao = new Permissao();       
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


    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }
    
    public void novo(){
        this.usuario = new Usuario();
        this.usuario.setAtivo(false);
        this.permissao = new Permissao();
    }
    
    public String cadastraUsuario(){
        novo();
        return "usuario";
    }
    
    public List<Usuario> findAllUsuario(){
        return usuEJB.findAllUsuario();
    }
    
    public List<Permissao> getListPermissoes(){
        return usuEJB.findAllPermissao();
    }
    
    public Permissao findPermissaoID(Long id){
        return usuEJB.findPermissaoPorId(id);
    }
           
    public void salvar(){
        String senha = usuario.getSenha();
        if(usuario.getIdUsuario() == null){
            try{
                usuario.setSenha(c.criptografa(senha));
                usuario.setAtivo(false);
                usuario.setPermissao(permissao);
                usuEJB.salvar(usuario);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Usuario salvo com sucesso!"));
                usuario = new Usuario();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao salvar usuário!"));
            }
       }else{
            try{
                usuario.setPermissao(permissao);
                usuEJB.salvar(usuario);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Usuario editado com sucesso!"));
                usuario = new Usuario();
                permissao = new Permissao();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao editar usuário!"));
            }
            
        }
    }
    
    public void remover(Usuario usuario){
        try{
            usuEJB.excluir(usuario);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Usuário excluido com sucesso!"));
        }catch(Exception e){
             e.printStackTrace();
             FacesContext fc = FacesContext.getCurrentInstance();
             fc.addMessage(null, new FacesMessage("Erro ao excluir Usuário!"));
        }
    }
}