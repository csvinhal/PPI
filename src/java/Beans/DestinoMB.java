package Beans;

import Controller.DestinoEJB;
import Model.Destino;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "destinoMB")
@ViewScoped
public class DestinoMB implements Serializable {
    
    @EJB
    DestinoEJB destinoEJB;
    private Destino destino;
    
    public DestinoMB() {
        destino = new Destino();
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }
    
    public void salvar(){
        if(destino.getIdDestino() == null){
            try{
                destinoEJB.salvar(destino);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Salvo com sucesso!"));
                destino = new Destino();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao salvar Destino!"));
            }
        }else{
            try{
                destinoEJB.salvar(destino);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Editado com sucesso!"));
                destino = new Destino();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao editar Destino!"));
            }
        }
    }
        
    public List<Destino> listarDestinos(){
        return destinoEJB.listarDestinos();
    }
    
    public Destino selecionaDestino(Destino destino){
        return this.destino = destino;
    }
    
    public void remover(Destino destino){
        try{
            destinoEJB.excluir(destino);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Destino excluído com sucesso!"));
        }catch(Exception e){
             e.printStackTrace();
             FacesContext fc = FacesContext.getCurrentInstance();
             fc.addMessage(null, new FacesMessage("Erro ao excluir Destino!"));
        }
    }
}
