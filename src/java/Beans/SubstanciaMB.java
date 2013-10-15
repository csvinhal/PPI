package Beans;

import Controller.SubstanciaEJB;
import Model.Substancia;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="substanciaMB")
@ViewScoped
public class SubstanciaMB implements Serializable {
    
    @EJB
    SubstanciaEJB substanciaEJB;
    private Substancia substancia;
    
    public SubstanciaMB() {
    substancia = new Substancia();
    }

    public Substancia getSubstancia() {
        return substancia;
    }

    public void setSubstancia(Substancia substancia) {
        this.substancia = substancia;
    }
    
    
    public void salvar(){
        if(substancia.getIdSubstancia() == null){
            try{
                substanciaEJB.salvar(substancia);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Salvo com sucesso!"));
                substancia = new Substancia();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao salvar Substancia!"));
            }
        }else{
            try{
                substanciaEJB.salvar(substancia);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Editado com sucesso!"));
                substancia = new Substancia();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao editar Substancia!"));
            }
        }
    }
    
    public List<Substancia> listarSubstancias(){
        return substanciaEJB.listarSubstancias();
    }
    
    public void selecionarSubstancia(Substancia substancia) {
        this.substancia = substancia;
    }
    
    public void remover(Substancia substancia){
        try{
            substanciaEJB.excluir(substancia);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Substancia excluída com sucesso!"));
        }catch(Exception e){
             e.printStackTrace();
             FacesContext fc = FacesContext.getCurrentInstance();
             fc.addMessage(null, new FacesMessage("Erro ao excluir Substancia!"));
        }
    }

}
