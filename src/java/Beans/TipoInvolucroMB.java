package Beans;

import Controller.TipoInvolucroEJB;
import Model.TipoInvolucro;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="tipoInvolucroMB")
@ViewScoped
public class TipoInvolucroMB implements Serializable {

    @EJB
    TipoInvolucroEJB tipoInvolucroEJB;
    private TipoInvolucro tipoInvolucro;
    
    public TipoInvolucroMB() {
        tipoInvolucro = new TipoInvolucro();
    }

    public TipoInvolucro getTipoInvolucro() {
        return tipoInvolucro;
    }

    public void setTipoInvolucro(TipoInvolucro tipoInvolucro) {
        this.tipoInvolucro = tipoInvolucro;
    }
        
    public void salvar(){
        if(tipoInvolucro.getIdTipoInvolucro() == null){
            try{
                tipoInvolucroEJB.salvar(tipoInvolucro);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Involucro salvo com sucesso!"));
                tipoInvolucro = new TipoInvolucro();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao salvar Involucro!"));
            }
        }else{
            try{
                tipoInvolucroEJB.salvar(tipoInvolucro);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Involucro editado com sucesso!"));
                tipoInvolucro = new TipoInvolucro();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao editar Involucro!"));
            }
        }
    }
    
     public List<TipoInvolucro> listarTiposInvolucros(){
        return tipoInvolucroEJB.listarTiposinvolucros();
    }

    public TipoInvolucro selecionaTipoInvolucro(TipoInvolucro tipoInvolucro){
        return this.tipoInvolucro = tipoInvolucro;
    }
    
    public void Remover(TipoInvolucro tipoInvolucro){
        try{
            tipoInvolucroEJB.excluir(tipoInvolucro);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Involucro excluído com sucesso!"));
        }catch(Exception e){
             e.printStackTrace();
             FacesContext fc = FacesContext.getCurrentInstance();
             fc.addMessage(null, new FacesMessage("Erro ao excluir Involucro!"));
        }
    }
}
