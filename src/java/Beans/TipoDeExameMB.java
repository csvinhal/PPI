package Beans;

import Controller.TipoDeExameEJB;
import Model.TipoDeExame;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="tipoDeExameMB")
@ViewScoped
public class TipoDeExameMB implements Serializable {

    @EJB
    TipoDeExameEJB tipoDeExameEJB;
    private TipoDeExame tipoDeExame;
    
    public TipoDeExameMB() {
        tipoDeExame = new TipoDeExame();
    }

    public TipoDeExame getTipoDeExame() {
        return tipoDeExame;
    }

    public void setTipoDeExame(TipoDeExame tipoDeExame) {
        this.tipoDeExame = tipoDeExame;
    }
        
    public void salvar(){
        if(tipoDeExame.getIdTipoExame() == null){
            try{
                tipoDeExameEJB.salvar(tipoDeExame);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Salvo com sucesso!"));
                tipoDeExame = new TipoDeExame();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao salvar Tipo de Exame!"));
            }
        }else{
            try{
                tipoDeExameEJB.salvar(tipoDeExame);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Editado com sucesso!"));
                tipoDeExame = new TipoDeExame();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao editar Tipo de Exame!"));
            }
        }
    }
    
     public List<TipoDeExame> listarTiposDeExames(){
        return tipoDeExameEJB.listarTiposDeExames();
    }

    public TipoDeExame selecionaTipoDeExame(TipoDeExame tipoDeExame){
        return this.tipoDeExame = tipoDeExame;
    }
    
    public void remover(TipoDeExame tipoDeExame){
        try{
            tipoDeExameEJB.excluir(tipoDeExame);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Tipo de Exame excluído com sucesso!"));
        }catch(Exception e){
             e.printStackTrace();
             FacesContext fc = FacesContext.getCurrentInstance();
             fc.addMessage(null, new FacesMessage("Erro ao excluir Tipo de Exame!"));
        }
    }
    
}
