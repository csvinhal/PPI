package Beans;

import Controller.AutoridadeEJB;
import Model.Autoridade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.DuplicateKeyException;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "autoridadeMB")
@ViewScoped
public class AutoridadeMB implements Serializable{
    @EJB
    AutoridadeEJB autEJB;
    private Autoridade autoridade;
    
    public AutoridadeMB() {
    autoridade = new Autoridade();
    }

    public Autoridade getAutoridade() {
        return autoridade;
    }

    public void setAutoridade(Autoridade autoridade) {
        this.autoridade = autoridade;
    }
    
    
    public void salvar(){
        if(autoridade.getIdAutoridade() == null){
            try{
                autEJB.salvar(autoridade);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Salvo com sucesso!"));
                autoridade = new Autoridade(); 
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao salvar Autoridade!"));
            }
        }else{
            try{
                autEJB.salvar(autoridade);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Editado com sucesso!"));
                autoridade = new Autoridade();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao editar Autoridade!"));
            }
        }
    }
    
    public List<Autoridade> listarAutoridades(){
        return autEJB.listarAutoridades();
    }
    
    public void selecionarAutoridade(Autoridade autoridade) {
        this.autoridade = autoridade;
    }
    
    public void Remover(Autoridade autoridade){
        try{
            autEJB.excluir(autoridade);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Autoridade excluída com sucesso!"));
        }catch(Exception e){
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Erro ao excluir Autoridade!"));
        }
    }
    
}
