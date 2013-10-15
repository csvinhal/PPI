/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Crouch
 */
@Entity
@Table(name = "vistoria_imovel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VistoriaImovel.findAll", query = "SELECT v FROM VistoriaImovel v"),
    @NamedQuery(name = "VistoriaImovel.findByDataExame", query = "SELECT v FROM VistoriaImovel v WHERE v.dataExame = :dataExame"),
    @NamedQuery(name = "VistoriaImovel.findByDataFato", query = "SELECT v FROM VistoriaImovel v WHERE v.dataFato = :dataFato"),
    @NamedQuery(name = "VistoriaImovel.findByEsclarecimento1", query = "SELECT v FROM VistoriaImovel v WHERE v.esclarecimento1 = :esclarecimento1"),
    @NamedQuery(name = "VistoriaImovel.findByEsclarecimento2", query = "SELECT v FROM VistoriaImovel v WHERE v.esclarecimento2 = :esclarecimento2"),
    @NamedQuery(name = "VistoriaImovel.findByEsclarecimento3", query = "SELECT v FROM VistoriaImovel v WHERE v.esclarecimento3 = :esclarecimento3"),
    @NamedQuery(name = "VistoriaImovel.findByNatureza", query = "SELECT v FROM VistoriaImovel v WHERE v.natureza = :natureza"),
    @NamedQuery(name = "VistoriaImovel.findByProvas", query = "SELECT v FROM VistoriaImovel v WHERE v.provas = :provas"),
    @NamedQuery(name = "VistoriaImovel.findByVistoriaDescricao1", query = "SELECT v FROM VistoriaImovel v WHERE v.vistoriaDescricao1 = :vistoriaDescricao1"),
    @NamedQuery(name = "VistoriaImovel.findByVistoriaDescricao2", query = "SELECT v FROM VistoriaImovel v WHERE v.vistoriaDescricao2 = :vistoriaDescricao2"),
    @NamedQuery(name = "VistoriaImovel.findByVistoriaDescricao3", query = "SELECT v FROM VistoriaImovel v WHERE v.vistoriaDescricao3 = :vistoriaDescricao3"),
    @NamedQuery(name = "VistoriaImovel.findByIdImovel", query = "SELECT v FROM VistoriaImovel v WHERE v.idImovel = :idImovel")})
public class VistoriaImovel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataExame;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataFato;
    @Size(max = 255)
    private String esclarecimento1;
    @Size(max = 255)
    private String esclarecimento2;
    @Size(max = 255)
    private String esclarecimento3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String natureza;
    @Size(max = 255)
    private String provas;
    @Size(max = 255)
    private String vistoriaDescricao1;
    @Size(max = 255)
    private String vistoriaDescricao2;
    @Size(max = 255)
    private String vistoriaDescricao3;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idImovel;
    @JoinColumn(name = "usuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "localImovel", referencedColumnName = "idLocal")
    @ManyToOne(optional = false)
    private LocalImovel localImovel;
    @JoinColumn(name = "idImovel", referencedColumnName = "idLaudo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Laudo laudo;

    public VistoriaImovel() {
    }

    public VistoriaImovel(Integer idImovel) {
        this.idImovel = idImovel;
    }

    public VistoriaImovel(Integer idImovel, Date dataExame, Date dataFato, String natureza) {
        this.idImovel = idImovel;
        this.dataExame = dataExame;
        this.dataFato = dataFato;
        this.natureza = natureza;
    }

    public Date getDataExame() {
        return dataExame;
    }

    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }

    public Date getDataFato() {
        return dataFato;
    }

    public void setDataFato(Date dataFato) {
        this.dataFato = dataFato;
    }

    public String getEsclarecimento1() {
        return esclarecimento1;
    }

    public void setEsclarecimento1(String esclarecimento1) {
        this.esclarecimento1 = esclarecimento1;
    }

    public String getEsclarecimento2() {
        return esclarecimento2;
    }

    public void setEsclarecimento2(String esclarecimento2) {
        this.esclarecimento2 = esclarecimento2;
    }

    public String getEsclarecimento3() {
        return esclarecimento3;
    }

    public void setEsclarecimento3(String esclarecimento3) {
        this.esclarecimento3 = esclarecimento3;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public String getProvas() {
        return provas;
    }

    public void setProvas(String provas) {
        this.provas = provas;
    }

    public String getVistoriaDescricao1() {
        return vistoriaDescricao1;
    }

    public void setVistoriaDescricao1(String vistoriaDescricao1) {
        this.vistoriaDescricao1 = vistoriaDescricao1;
    }

    public String getVistoriaDescricao2() {
        return vistoriaDescricao2;
    }

    public void setVistoriaDescricao2(String vistoriaDescricao2) {
        this.vistoriaDescricao2 = vistoriaDescricao2;
    }

    public String getVistoriaDescricao3() {
        return vistoriaDescricao3;
    }

    public void setVistoriaDescricao3(String vistoriaDescricao3) {
        this.vistoriaDescricao3 = vistoriaDescricao3;
    }

    public Integer getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(Integer idImovel) {
        this.idImovel = idImovel;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalImovel getLocalImovel() {
        return localImovel;
    }

    public void setLocalImovel(LocalImovel localImovel) {
        this.localImovel = localImovel;
    }

    public Laudo getLaudo() {
        return laudo;
    }

    public void setLaudo(Laudo laudo) {
        this.laudo = laudo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImovel != null ? idImovel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VistoriaImovel)) {
            return false;
        }
        VistoriaImovel other = (VistoriaImovel) object;
        if ((this.idImovel == null && other.idImovel != null) || (this.idImovel != null && !this.idImovel.equals(other.idImovel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.VistoriaImovel[ idImovel=" + idImovel + " ]";
    }
    
}
