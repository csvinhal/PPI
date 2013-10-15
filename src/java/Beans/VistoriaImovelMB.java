package Beans;

import Controller.VistoriaImovelEJB;
import Model.Laudo;
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
    private Laudo laudo;
    
    public VistoriaImovelMB() {
    vistoriaImovel = new VistoriaImovel();
    laudo = new Laudo();
    }

    public VistoriaImovel getVistoriaImovel() {
        return vistoriaImovel;
    }

    public void setVistoriaImovel(VistoriaImovel vistoriaImovel) {
        this.vistoriaImovel = vistoriaImovel;
    }

    public Laudo getLaudo() {
        return laudo;
    }

    public void setLaudo(Laudo laudo) {
        this.laudo = laudo;
    }
    
    public void salvar(){
        if(vistoriaImovel.getIdImovel() == null){
            try{
                vistoriaImovel.setLaudo(laudo);
                vistoriaImovelEJB.salvar(vistoriaImovel);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Salvo com sucesso!"));
                vistoriaImovel = new VistoriaImovel();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao salvar a vistoria do veiculo!"));
            }
        }else{
            try{
                vistoriaImovel.setLaudo(laudo);
                vistoriaImovelEJB.salvar(vistoriaImovel);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Editado com sucesso!"));
                vistoriaImovel = new VistoriaImovel();
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
