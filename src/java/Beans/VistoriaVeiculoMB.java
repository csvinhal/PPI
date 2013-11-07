package Beans;

import Controller.VistoriaVeiculoEJB;
import Model.Veiculo;
import Model.VistoriaVeiculo;
import Util.RelatorioFactory;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="vistoriaVeiculoMB")
@SessionScoped
public class VistoriaVeiculoMB implements Serializable {

    @EJB
    VistoriaVeiculoEJB vistoriaVeiculoEJB;
    private VistoriaVeiculo vistoriaVeiculo;
    private Veiculo veiculo;
    private VistoriaVeiculo vistoriaSelecionada;
    private Long id;
    
    public VistoriaVeiculoMB() {
    vistoriaVeiculo = new VistoriaVeiculo();
    veiculo = new Veiculo();    
    }

    //GETS E SETS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    public VistoriaVeiculo getVistoriaVeiculo() {
        return vistoriaVeiculo;
    }

    public void setVistoriaVeiculo(VistoriaVeiculo vistoriaVeiculo) {
        this.vistoriaVeiculo = vistoriaVeiculo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public VistoriaVeiculo getVistoriaSelecionada() {
        return vistoriaSelecionada;
    }

    public void setVistoriaSelecionada(VistoriaVeiculo vistoriaSelecionada) {
        this.vistoriaSelecionada = vistoriaSelecionada;
    }
    
    
    //MÉTODOS
    public void salvar(){
        if(vistoriaVeiculo.getIdLaudo() == null){
            try{
                vistoriaVeiculo.setVeiculo(veiculo);
                vistoriaVeiculo = vistoriaVeiculoEJB.salvar(vistoriaVeiculo);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Salvo com sucesso!"));
                //vistoriaVeiculo = new VistoriaVeiculo();
                //veiculo = new Veiculo();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao salvar a vistoria do veiculo!"));
            }
        }else{
            try{
                vistoriaVeiculo.setVeiculo(veiculo);
                vistoriaVeiculoEJB.salvar(vistoriaVeiculo);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Editado com sucesso!"));
                vistoriaVeiculo = new VistoriaVeiculo();
                veiculo = new Veiculo();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao editar a vistoria do veiculo!"));
            }
        }
    }
    
    public List<VistoriaVeiculo> listarVistoriaVeiculos(){
        return vistoriaVeiculoEJB.listarVistoriaVeiculos();
    }
    
    public void selecionarVistoriaVeiculo(VistoriaVeiculo vistoriaVeiculo) {
        this.vistoriaVeiculo = vistoriaVeiculo;
    }
    
    public void remover(VistoriaVeiculo vistoriaVeiculo){
        try{
            vistoriaVeiculoEJB.excluir(vistoriaVeiculo);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Vistoria do veiculo excluída com sucesso!"));
        }catch(Exception e){
             e.printStackTrace();
             FacesContext fc = FacesContext.getCurrentInstance();
             fc.addMessage(null, new FacesMessage("Erro ao excluir vistoria do veiculo!"));
        }
    }
    
    public void geraRelatorioVistoriaVeiculo(VistoriaVeiculo veiculo) {
        RelatorioFactory relatorioFactory = new RelatorioFactory();
        relatorioFactory.geraRelatorioPreliminar(veiculo.getIdLaudo());
    }
}
