package Beans;

import Controller.ProcedenciaEJB;
import Model.Procedencia;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="procedenciaMB")
@ViewScoped
public class ProcedenciaMB implements Serializable {

    @EJB
    ProcedenciaEJB procedenciaEJB;
    private Procedencia procedencia;
    
    public ProcedenciaMB() {
        procedencia = new Procedencia();
    }

    public Procedencia getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(Procedencia procedencia) {
        this.procedencia = procedencia;
    }
        
    public void salvar(){
        if(procedencia.getIdProcedencia() == null){
            try{
                procedenciaEJB.salvar(procedencia);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Procedencia salva com sucesso!"));
                procedencia = new Procedencia();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao salvar Procedencia!"));
            }
        }else{
            try{
                procedenciaEJB.salvar(procedencia);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Procedencia editada com sucesso!"));
                procedencia = new Procedencia();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao editar Procedencia!"));
            }
        }
    }
    
     public List<Procedencia> listarProcedencias(){
        return procedenciaEJB.listarProcedencias();
    }

    public Procedencia selecionaProcedencia(Procedencia procedencia){
        return this.procedencia = procedencia;
    }
    
    public void remover(Procedencia procedencia){
        try{
            procedenciaEJB.excluir(procedencia);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Procedencia excluída com sucesso!"));
        }catch(Exception e){
             e.printStackTrace();
             FacesContext fc = FacesContext.getCurrentInstance();
             fc.addMessage(null, new FacesMessage("Erro ao excluir Procedencia"));
        }
    }
}
