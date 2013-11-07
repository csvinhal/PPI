package Beans;

import Controller.ToxicologicoPreliminarEJB;
import Controller.UsuarioEJB;
import Model.Involucro;
import Util.RelatorioFactory;
import Model.ToxicologicoPreliminar;
import Model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name="toxicologicoPreliminarMB")
@ViewScoped
public class ToxicologicoPreliminarMB implements Serializable{

    @EJB
    ToxicologicoPreliminarEJB toxiPreliminarEJB;
    private ToxicologicoPreliminar toxicologicoPreliminar;
    private Involucro involucro;
    private Usuario usuario;
    @EJB
    public UsuarioEJB usuEJB;
    
    public ToxicologicoPreliminarMB() {
        toxicologicoPreliminar = new ToxicologicoPreliminar();
        involucro = new Involucro();
        usuario = new Usuario();
    }
    
    //GETS E SETS
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = getUserLogado();
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
    
        
    //METODOS
    public void salvar(){
        if(toxicologicoPreliminar.getIdLaudo() == null){
            try{
                toxicologicoPreliminar.setInvolucro(involucro);
                toxicologicoPreliminar.setUsuario(usuario);
                toxiPreliminarEJB.salvar(toxicologicoPreliminar);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Toxicologico Preliminar salvo com sucesso!"));
                toxicologicoPreliminar = new ToxicologicoPreliminar();
                involucro = new Involucro();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao salvar Toxicologico Preliminar!"));
            }
        }else{
            try{
                toxicologicoPreliminar.setInvolucro(involucro);
                toxicologicoPreliminar.setUsuario(usuario);
                toxiPreliminarEJB.salvar(toxicologicoPreliminar);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Toxicologico Preliminar editado com sucesso!"));
                toxicologicoPreliminar = new ToxicologicoPreliminar();
                involucro = new Involucro();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao editar Involucro!"));
            }
        }
    }
    
     public List<ToxicologicoPreliminar> listarToxicologicosPremilinares(){
        return toxiPreliminarEJB.listarToxicologicoPreliminar();
    }

    public ToxicologicoPreliminar selecionaToxicologicoPreliminar(ToxicologicoPreliminar toxicologicoPreliminar){
        return this.toxicologicoPreliminar = toxicologicoPreliminar;
    }
    
    public void remover(ToxicologicoPreliminar toxicologicoPreliminar){
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
        relatorioFactory.geraRelatorioPreliminar(preliminar.getIdLaudo());
    }
    
    public Usuario getUserLogado() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext external = context.getExternalContext();
        String login = external.getRemoteUser();

        if (usuario == null || !login.equals(usuario.getEmail())) {
            if (login != null) {
                usuario = usuEJB.findUsuarioPorLogin(login);                
            }
        }
        return usuario;
    }
}
