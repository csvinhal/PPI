package Beans;

import Controller.InvolucroEJB;
import Model.Involucro;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="involucroMB")
@ViewScoped
public class InvolucroMB {

    @EJB
    InvolucroEJB involucroEJB;
    private Involucro involucro;
    
    public InvolucroMB() {
    involucro = new Involucro();
    }

    public Involucro getInvolucro() {
        return involucro;
    }

    public void setInvolucro(Involucro involucro) {
        this.involucro = involucro;
    }
    
    
    public void salvar(){
        if(involucro.getIdInvolucro() == null){
            try{
                involucroEJB.salvar(involucro);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Salvo com sucesso!"));
                involucro = new Involucro();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao salvar o involucro!"));
            }
        }else{
            try{
                involucroEJB.salvar(involucro);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Editado com sucesso!"));
                involucro = new Involucro();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao editar o Involucro!"));
            }
        }
    }
    
    public List<Involucro> listarInvolucros(){
        return involucroEJB.listarInvolucros();
    }
    
    public void selecionarInvolucro(Involucro involucro) {
        this.involucro = involucro;
    }
    
    public void remover(Involucro involucro){
        try{
            involucroEJB.excluir(involucro);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Vistoria do veiculo excluída com sucesso!"));
        }catch(Exception e){
             e.printStackTrace();
             FacesContext fc = FacesContext.getCurrentInstance();
             fc.addMessage(null, new FacesMessage("Erro ao excluir vistoria do veiculo!"));
        }
    }
}
