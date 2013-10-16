package Beans;

import Controller.ToxicologicoPreliminarEJB;
import Util.RelatorioFactory;
import Model.Involucro;
import Model.Laudo;
import Model.ToxicologicoPreliminar;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="toxicologicoPreliminarMB")
@ViewScoped
public class ToxicologicoPreliminarMB implements Serializable{

    @EJB
    ToxicologicoPreliminarEJB toxiPreliminarEJB;
    private ToxicologicoPreliminar toxicologicoPreliminar;
    private Involucro involucro;
    private Laudo laudo;
    
    public ToxicologicoPreliminarMB() {
        toxicologicoPreliminar = new ToxicologicoPreliminar();
        involucro = new Involucro();
        laudo = new Laudo();
    }

    public ToxicologicoPreliminar getToxicologicoPreliminar() {
        return toxicologicoPreliminar;
    }

    public void setToxicologicoPreliminar(ToxicologicoPreliminar toxicologicoPreliminar) {
        this.toxicologicoPreliminar = toxicologicoPreliminar;
    }

    public Involucro getInvolucro() {
        return involucro;
    }

    public void setInvolucro(Involucro involucro) {
        this.involucro = involucro;
    }

    public Laudo getLaudo() {
        return laudo;
    }

    public void setLaudo(Laudo laudo) {
        this.laudo = laudo;
    }
        
        
    public void salvar(){
        if(toxicologicoPreliminar.getIdLaudo() == null){
            try{
                toxicologicoPreliminar.setLaudo(laudo);
                toxicologicoPreliminar.setInvolucro(involucro);
                toxiPreliminarEJB.salvar(toxicologicoPreliminar);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Toxicologico Preliminar salvo com sucesso!"));
                toxicologicoPreliminar = new ToxicologicoPreliminar();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao salvar Toxicologico Preliminar!"));
            }
        }else{
            try{
                toxicologicoPreliminar.setLaudo(laudo);
                toxicologicoPreliminar.setInvolucro(involucro);
                toxiPreliminarEJB.salvar(toxicologicoPreliminar);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Toxicologico Preliminar editado com sucesso!"));
                toxicologicoPreliminar = new ToxicologicoPreliminar();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao editar Involucro!"));
            }
        }
    }
    
     public List<ToxicologicoPreliminar> listarTiposInvolucros(){
        return toxiPreliminarEJB.listarToxicologicoPreliminar();
    }

    public ToxicologicoPreliminar selecionaToxicologicoPreliminar(ToxicologicoPreliminar toxicologicoPreliminar){
        return this.toxicologicoPreliminar = toxicologicoPreliminar;
    }
    
    public void Remover(ToxicologicoPreliminar toxicologicoPreliminar){
        try{
            toxiPreliminarEJB.excluir(toxicologicoPreliminar);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Toxicologico Preliminar excluído com sucesso!"));
        }catch(Exception e){
             e.printStackTrace();
             FacesContext fc = FacesContext.getCurrentInstance();
             fc.addMessage(null, new FacesMessage("Erro ao excluir Toxicologico Preliminar!"));
        }
    }
    
    public void geraRelatorioToxicologicoPreliminar(ToxicologicoPreliminar preliminar) {
        RelatorioFactory relatorioFactory = new RelatorioFactory();
        relatorioFactory.geraRelatorioPreliminar(toxicologicoPreliminar.getIdLaudo());
    }
}
