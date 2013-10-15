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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "vistoria_veiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VistoriaVeiculo.findAll", query = "SELECT v FROM VistoriaVeiculo v"),
    @NamedQuery(name = "VistoriaVeiculo.findByDataExame", query = "SELECT v FROM VistoriaVeiculo v WHERE v.dataExame = :dataExame"),
    @NamedQuery(name = "VistoriaVeiculo.findByIdVistoriaVeiculo", query = "SELECT v FROM VistoriaVeiculo v WHERE v.idVistoriaVeiculo = :idVistoriaVeiculo")})
public class VistoriaVeiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataExame;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idVistoriaVeiculo;
    @JoinColumn(name = "veiculo", referencedColumnName = "idVeiculo")
    @ManyToOne(optional = false)
    private Veiculo veiculo;
    @JoinColumn(name = "usuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "idVistoriaVeiculo", referencedColumnName = "idLaudo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Laudo laudo;

    public VistoriaVeiculo() {
    }

    public VistoriaVeiculo(Integer idVistoriaVeiculo) {
        this.idVistoriaVeiculo = idVistoriaVeiculo;
    }

    public VistoriaVeiculo(Integer idVistoriaVeiculo, Date dataExame) {
        this.idVistoriaVeiculo = idVistoriaVeiculo;
        this.dataExame = dataExame;
    }

    public Date getDataExame() {
        return dataExame;
    }

    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }

    public Integer getIdVistoriaVeiculo() {
        return idVistoriaVeiculo;
    }

    public void setIdVistoriaVeiculo(Integer idVistoriaVeiculo) {
        this.idVistoriaVeiculo = idVistoriaVeiculo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        hash += (idVistoriaVeiculo != null ? idVistoriaVeiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VistoriaVeiculo)) {
            return false;
        }
        VistoriaVeiculo other = (VistoriaVeiculo) object;
        if ((this.idVistoriaVeiculo == null && other.idVistoriaVeiculo != null) || (this.idVistoriaVeiculo != null && !this.idVistoriaVeiculo.equals(other.idVistoriaVeiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.VistoriaVeiculo[ idVistoriaVeiculo=" + idVistoriaVeiculo + " ]";
    }
    
}
