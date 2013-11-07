package Beans;

import Controller.ToxicologicoDefinitivoEJB;
import Model.Involucro;
import Util.RelatorioFactory;
import Model.ToxicologicoDefinitivo;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="toxicologicoDefinitivoMB")
@ViewScoped
public class ToxicologicoDefinitivoMB implements Serializable{

    @EJB
    ToxicologicoDefinitivoEJB toxiDefinitivoEJB;
    private ToxicologicoDefinitivo toxicologicoDefinitivo;
    private Involucro involucro;
    
    public ToxicologicoDefinitivoMB() {
        toxicologicoDefinitivo = new ToxicologicoDefinitivo();
        involucro = new Involucro();
    }
    
    //GETS E SETS
    public ToxicologicoDefinitivo getToxicologicoDefinitivo() {
        return toxicologicoDefinitivo;
    }

    public void setToxicologicoDefinitivo(ToxicologicoDefinitivo toxicologicoDefinitivo) {
        this.toxicologicoDefinitivo = toxicologicoDefinitivo;
    }

    public Involucro getInvolucro() {
        return involucro;
    }

    public void setInvolucro(Involucro involucro) {
        this.involucro = involucro;
    }
    
        
    //METODOS
    public void salvar(){
        if(toxicologicoDefinitivo.getIdLaudo() == null){
            try{
                toxicologicoDefinitivo.setInvolucro(involucro);
                toxiDefinitivoEJB.salvar(toxicologicoDefinitivo);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Toxicologico Preliminar salvo com sucesso!"));
                toxicologicoDefinitivo = new ToxicologicoDefinitivo();
                involucro = new Involucro();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao salvar Toxicologico Preliminar!"));
            }
        }else{
            try{
                toxicologicoDefinitivo.setInvolucro(involucro);
                toxiDefinitivoEJB.salvar(toxicologicoDefinitivo);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Toxicologico Preliminar editado com sucesso!"));
                toxicologicoDefinitivo = new ToxicologicoDefinitivo();
                involucro = new Involucro();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao editar Involucro!"));
            }
        }
    }
    
     public List<ToxicologicoDefinitivo> listarToxicologicosDefinitivos(){
        return toxiDefinitivoEJB.listarToxicologicoDefinitivo();
    }

    public ToxicologicoDefinitivo selecionaToxicologicoDefinitivo(ToxicologicoDefinitivo toxicologicoDefinitivo){
        return this.toxicologicoDefinitivo = toxicologicoDefinitivo;
    }
    
    public void Remover(ToxicologicoDefinitivo toxicologicoDefinitivo){
        try{
            toxiDefinitivoEJB.excluir(toxicologicoDefinitivo);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Toxicologico Preliminar excluído com sucesso!"));
        }catch(Exception e){
             e.printStackTrace();
             FacesContext fc = FacesContext.getCurrentInstance();
             fc.addMessage(null, new FacesMessage("Erro ao excluir Toxicologico Preliminar!"));
        }
    }
    
    public void geraRelatorioToxicologicoDefinitivo(ToxicologicoDefinitivo preliminar) {
        RelatorioFactory relatorioFactory = new RelatorioFactory();
        relatorioFactory.geraRelatorioPreliminar(preliminar.getIdLaudo());
    }
}
