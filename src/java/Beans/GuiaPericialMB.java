package Beans;

import Controller.GuiaPericialEJB;
import Util.RelatorioFactory;
import Model.Autoridade;
import Model.Destino;
import Model.GuiaPericial;
import Model.Procedencia;
import Model.TipoDeExame;
import Model.TipoDeMaterial;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Crouch
 */
@ManagedBean(name = "guiaPericialMB")
public class GuiaPericialMB implements Serializable{

    @EJB
    GuiaPericialEJB guiaPericialEJB;
    private GuiaPericial guiaPericial;
    private GuiaPericial guiaSelecionada = new GuiaPericial();
    private List<GuiaPericial> listGuia;
    private Autoridade autoridade;
    private Destino destino;
    private Procedencia procedencia;
    private List<TipoDeMaterial> tipoMaterial;
    private TipoDeExame tipoExame;

    public GuiaPericialMB() {
        guiaPericial = new GuiaPericial();
        }

    public GuiaPericial getGuiaSelecionada() {
        return guiaSelecionada;
    }

    public void setGuiaSelecionada(GuiaPericial guiaSelecionada) {
        this.guiaSelecionada = guiaSelecionada;
    }

    public GuiaPericial getGuiaPericial() {
        return guiaPericial;
    }

    public void setGuiaPericial(GuiaPericial guiaPericial) {
        this.guiaPericial = guiaPericial;
    }

    public Autoridade getAutoridade() {
        return autoridade;
    }

    public void setAutoridade(Autoridade autoridade) {
        this.autoridade = autoridade;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Procedencia getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(Procedencia procedencia) {
        this.procedencia = procedencia;
    }

    public TipoDeExame getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(TipoDeExame tipoExame) {
        this.tipoExame = tipoExame;
    }

    public List<TipoDeMaterial> getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(List<TipoDeMaterial> tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public void setListGuia(List<GuiaPericial> listGuia) {
        this.listGuia = listGuia;
    }

    public List<GuiaPericial> getListGuia() {
        listGuia = guiaPericialEJB.listarGuias();
        return listGuia;
    }

    public List<GuiaPericial> listarGuias() {
        return guiaPericialEJB.listarGuias();
    }

    public void selecionarGuiaPericial(GuiaPericial guiaPericial) {
        this.guiaPericial = guiaPericial;
    }

    public void salvar() {
        if (guiaPericial.getIdLaudo() == null) {
            try {
                guiaPericialEJB.salvar(guiaPericial);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Salvo com sucesso!"));
                guiaPericial = new GuiaPericial();
            } catch (Exception e) {
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao salvar Guia Pericial"));
            }
        } else {
            try {
                guiaPericialEJB.salvar(guiaPericial);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Editado com sucesso!"));
                guiaPericial = new GuiaPericial();
            } catch (Exception e) {
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao editar Guia Pericial"));
            }
        }
    }

    public void remover(GuiaPericial guiaPericial) {
        try {
            guiaPericialEJB.excluir(guiaPericial);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Guia Pericial excluída com sucesso!"));
        } catch (Exception e) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Erro ao excluir Guia Pericial"));
        }
    }

    public void geraRelatorioGuia(GuiaPericial guiaSelecionada) {
        RelatorioFactory relatorioFactory = new RelatorioFactory();
        relatorioFactory.geraRelatorioGuia(guiaSelecionada.getIdLaudo());
    }
}
