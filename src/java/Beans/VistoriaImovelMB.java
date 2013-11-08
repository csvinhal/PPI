package Beans;

import Controller.UsuarioEJB;
import Controller.VistoriaImovelEJB;
import Model.LocalImovel;
import Model.Usuario;
import Model.VistoriaImovel;
import Util.RelatorioFactory;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name="vistoriaImovelMB")
@ViewScoped
public class VistoriaImovelMB implements Serializable{

    @EJB
    VistoriaImovelEJB vistoriaImovelEJB;
    @EJB
    public UsuarioEJB usuEJB;
    private VistoriaImovel vistoriaImovel;
    private LocalImovel localImovel;
    private Usuario usuario;
    
    public VistoriaImovelMB() {
        vistoriaImovel = new VistoriaImovel();
        localImovel = new LocalImovel();
    }

    //GETS E SETS
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
    
    //METODOS
    public void salvar(){
        if(vistoriaImovel.getIdLaudo() == null){
            try{
                vistoriaImovel.setLocalImovel(localImovel);
                vistoriaImovel.setUsuario(usuario);
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
                vistoriaImovel.setUsuario(usuario);
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
    
    public void geraRelatorioVistoriaImovel(VistoriaImovel vistoriaImovel) {
        RelatorioFactory relatorioFactory = new RelatorioFactory();
        relatorioFactory.geraRelatorioVistoriaImovel(vistoriaImovel.getIdLaudo());
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
