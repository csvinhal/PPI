package Beans;

import Controller.ToxicologicoDefinitivoEJB;
import Controller.UsuarioEJB;
import Model.GuiaPericial;
import Model.Involucro;
import Util.RelatorioFactory;
import Model.ToxicologicoDefinitivo;
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

@ManagedBean(name="toxicologicoDefinitivoMB")
@ViewScoped
public class ToxicologicoDefinitivoMB implements Serializable{

    @EJB
    ToxicologicoDefinitivoEJB toxiDefinitivoEJB;
    private ToxicologicoDefinitivo toxicologicoDefinitivo;
    private GuiaPericial guia;
    private Involucro involucro;
    private ToxicologicoPreliminar toxicologicoPreliminar;
    private Usuario usuario;
    @EJB
    public UsuarioEJB usuEJB;
    
    public ToxicologicoDefinitivoMB() {
        toxicologicoDefinitivo = new ToxicologicoDefinitivo();
        involucro = new Involucro();
    }
    
    //GETS E SETS
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = getUserLogado();
    }
    
    public GuiaPericial getGuia() {
        return guia;
    }

    public void setGuia(GuiaPericial guia) {
        this.guia = guia;
    }
    public ToxicologicoPreliminar getToxicologicoPreliminar() {
        return toxicologicoPreliminar;
    }

    public void setToxicologicoPreliminar(ToxicologicoPreliminar toxicologicoPreliminar) {
        this.toxicologicoPreliminar = toxicologicoPreliminar;
    }
    
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
        if(toxicologicoDefinitivo.getIdDefinitivo()== null){
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
                fc.addMessage(null, new FacesMessage("Erro ao salvar Toxicologico Definitivo!"));
            }
        }else{
            try{
                toxicologicoDefinitivo.setInvolucro(involucro);
                toxiDefinitivoEJB.salvar(toxicologicoDefinitivo);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Toxicologico Definitivo editado com sucesso!"));
                toxicologicoDefinitivo = new ToxicologicoDefinitivo();
                involucro = new Involucro();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao editar Involucro!"));
            }
        }
    }
    
    public ToxicologicoPreliminar selecionaToxicologicoPreliminar(ToxicologicoPreliminar toxicologicoPreliminar){
        toxicologicoDefinitivo.setGuia(toxicologicoPreliminar.getGuia());
        toxicologicoDefinitivo.setInvolucro(toxicologicoPreliminar.getInvolucro());
        involucro = toxicologicoDefinitivo.getInvolucro();
        guia = toxicologicoDefinitivo.getGuia();
        return this.toxicologicoPreliminar = toxicologicoPreliminar;
    }
    
     public List<ToxicologicoDefinitivo> listarToxicologicosDefinitivos(){
        return toxiDefinitivoEJB.listarToxicologicoDefinitivo();
    }

    public ToxicologicoDefinitivo selecionaToxicologicoDefinitivo(ToxicologicoDefinitivo toxicologicoDefinitivo){
        return this.toxicologicoDefinitivo = toxicologicoDefinitivo;
    }
    
    public void remover(ToxicologicoDefinitivo toxicologicoDefinitivo){
        try{
            toxiDefinitivoEJB.excluir(toxicologicoDefinitivo);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Toxicologico Definitivo excluído com sucesso!"));
        }catch(Exception e){
             e.printStackTrace();
             FacesContext fc = FacesContext.getCurrentInstance();
             fc.addMessage(null, new FacesMessage("Erro ao excluir Toxicologico Preliminar!"));
        }
    }
    
    public void geraRelatorioToxicologicoDefinitivo(ToxicologicoDefinitivo preliminar) {
        RelatorioFactory relatorioFactory = new RelatorioFactory();
        relatorioFactory.geraRelatorioPreliminar(preliminar.getIdDefinitivo());
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
