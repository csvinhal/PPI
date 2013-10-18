package Beans;

import Controller.GuiaPericialEJB;
import Model.GuiaPericial;
import Util.RelatorioFactory;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "guiaPericialMB")
public class GuiaPericialMB implements Serializable{

    @EJB
    GuiaPericialEJB guiaPericialEJB;
    private GuiaPericial guiaPericial;
    private GuiaPericial guiaSelecionada = new GuiaPericial();
    private List<GuiaPericial> listGuia;

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

    public void salvar(){
        if (guiaPericial.getIdGuia() == null) {
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

    public void geraRelatorioGuia(GuiaPericial guiaPericial) {
        RelatorioFactory relatorioFactory = new RelatorioFactory();
        relatorioFactory.geraRelatorioGuia(guiaPericial.getIdGuia());
    }
}
