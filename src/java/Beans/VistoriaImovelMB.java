package Beans;

import Controller.VistoriaImovelEJB;
import Model.LocalImovel;
import Model.VistoriaImovel;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="vistoriaImovelMB")
@ViewScoped
public class VistoriaImovelMB implements Serializable{

    @EJB
    VistoriaImovelEJB vistoriaImovelEJB;
    private VistoriaImovel vistoriaImovel;
    private LocalImovel localImovel;
    
    public VistoriaImovelMB() {
        vistoriaImovel = new VistoriaImovel();
        localImovel = new LocalImovel();
    }

    public VistoriaImovel getVistoriaImovel() {
        return vistoriaImovel;
    }

    public void setVistoriaImovel(VistoriaImovel vistoriaImovel) {
        this.vistoriaImovel = vistoriaImovel;
    }

    public LocalImovel getLocalImovel() {
        return localImovel;
    }

    public void setLocalImovel(LocalImovel localImovel) {
        this.localImovel = localImovel;
    }

    public void salvar(){
        if(vistoriaImovel.getIdLaudo() == null){
            try{
                vistoriaImovel.setLocalImovel(localImovel);
                vistoriaImovelEJB.salvar(vistoriaImovel);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Salvo com sucesso!"));
                vistoriaImovel = new VistoriaImovel();
                localImovel = new LocalImovel();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao salvar a vistoria do veiculo!"));
            }
        }else{
            try{
                vistoriaImovel.setLocalImovel(localImovel);
                vistoriaImovelEJB.salvar(vistoriaImovel);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Editado com sucesso!"));
                vistoriaImovel = new VistoriaImovel();
                localImovel = new LocalImovel();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao editar a vistoria do veiculo!"));
            }
        }
    }
    
    public List<VistoriaImovel> listarVistoriaImovels(){
        return vistoriaImovelEJB.listarVistoriaImovels();
    }
    
    public void selecionarVistoriaImovel(VistoriaImovel vistoriaImovel) {
        this.vistoriaImovel = vistoriaImovel;
    }
    
    public void remover(VistoriaImovel vistoriaImovel){
        try{
            vistoriaImovelEJB.excluir(vistoriaImovel);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Vistoria do veiculo excluída com sucesso!"));
        }catch(Exception e){
             e.printStackTrace();
             FacesContext fc = FacesContext.getCurrentInstance();
             fc.addMessage(null, new FacesMessage("Erro ao excluir vistoria do veiculo!"));
        }
    }
}
