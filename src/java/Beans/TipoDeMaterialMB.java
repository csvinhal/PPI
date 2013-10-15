package Beans;

import Controller.TipoDeMaterialEJB;
import Model.TipoDeMaterial;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Crouch
 */
@ManagedBean(name="tipoDeMaterialMB")
@ViewScoped
public class TipoDeMaterialMB implements Serializable{

    @EJB
    TipoDeMaterialEJB tipoDeMaterialEJB;
    private TipoDeMaterial tipoDeMaterial;
    
    public TipoDeMaterialMB() {
        tipoDeMaterial = new TipoDeMaterial();
    }

    public TipoDeMaterial getTipoDeMaterial() {
        return tipoDeMaterial;
    }

    public void setTipoDeMaterial(TipoDeMaterial tipoDeMaterial) {
        this.tipoDeMaterial = tipoDeMaterial;
    }
        
    public void salvar(){
        if(tipoDeMaterial.getIdTipoMaterial() == null){
            try{
                tipoDeMaterialEJB.salvar(tipoDeMaterial);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Material salvo com sucesso!"));
                tipoDeMaterial = new TipoDeMaterial();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao salvar Material!"));
            }
        }else{
            try{
                tipoDeMaterialEJB.salvar(tipoDeMaterial);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Material editado com sucesso!"));
                tipoDeMaterial = new TipoDeMaterial();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao editar Material!"));
            }
        }
    }
    
     public List<TipoDeMaterial> listarTiposDeMateriais(){
        return tipoDeMaterialEJB.listarTiposDeMateriais();
    }

    public TipoDeMaterial selecionaTipoDeMaterial(TipoDeMaterial tipoDeMaterial){
        return this.tipoDeMaterial = tipoDeMaterial;
    }
    
    public void remover(TipoDeMaterial tipoDeMaterial){
        try{
            tipoDeMaterialEJB.excluir(tipoDeMaterial);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Material excluído com sucesso!"));
        }catch(Exception e){
             e.printStackTrace();
             FacesContext fc = FacesContext.getCurrentInstance();
             fc.addMessage(null, new FacesMessage("Erro ao excluir Material!"));
        }
    }
}
