package Beans;

import Controller.CorInvolucroEJB;
import Model.Cor;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class CorInvolucroMB implements Serializable {

    @EJB
    CorInvolucroEJB corEJB;
    private Cor corInvolucro;
    
    public CorInvolucroMB() {
        corInvolucro = new Cor();
    }
        public Cor getCor() {
        return corInvolucro;
    }

    public void setCor(Cor corInvolucro) {
        this.corInvolucro = corInvolucro;
    }
        
    public void salvar(){
        if(corInvolucro.getIdCor() == null){
            try{
                corEJB.salvar(corInvolucro);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Cor salva com sucesso!"));
                corInvolucro = new Cor();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao salvar Cor do Involucro!"));
            }
        }else{
            try{
                corEJB.salvar(corInvolucro);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Cor editada com sucesso!"));
                corInvolucro = new Cor();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao editar Cor do Involucro!"));
            }
        }
    }
    
     public List<Cor> listarCores(){
        return corEJB.listarCores();
    }

    public Cor selecionaCor(Cor corInvolucro){
        return this.corInvolucro = corInvolucro;
    }
    
    public void remover(Cor corInvolucro){
        try{
            corEJB.excluir(corInvolucro);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Cor excluída com sucesso!"));
        }catch(Exception e){
             e.printStackTrace();
             FacesContext fc = FacesContext.getCurrentInstance();
             fc.addMessage(null, new FacesMessage("Erro ao excluir Cor!"));
        }
    }
}
