package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procedencia.findAll", query = "SELECT p FROM Procedencia p"),
    @NamedQuery(name = "Procedencia.findByIdProcedencia", query = "SELECT p FROM Procedencia p WHERE p.idProcedencia = :idProcedencia"),
    @NamedQuery(name = "Procedencia.findByDescricao", query = "SELECT p FROM Procedencia p WHERE p.descricao = :descricao")})
public class Procedencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idProcedencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String descricao;
    @OneToMany(mappedBy = "procedencia")
    private List<GuiaPericial> guiaPericialList;

    public Procedencia() {
    }

    public Procedencia(Integer idProcedencia) {
        this.idProcedencia = idProcedencia;
    }

    public Procedencia(Integer idProcedencia, String descricao) {
        this.idProcedencia = idProcedencia;
        this.descricao = descricao;
    }

    public Integer getIdProcedencia() {
        return idProcedencia;
    }

    public void setIdProcedencia(Integer idProcedencia) {
        this.idProcedencia = idProcedencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<GuiaPericial> getGuiaPericialList() {
        return guiaPericialList;
    }

    public void setGuiaPericialList(List<GuiaPericial> guiaPericialList) {
        this.guiaPericialList = guiaPericialList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcedencia != null ? idProcedencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procedencia)) {
            return false;
        }
        Procedencia other = (Procedencia) object;
        if ((this.idProcedencia == null && other.idProcedencia != null) || (this.idProcedencia != null && !this.idProcedencia.equals(other.idProcedencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Procedencia[ idProcedencia=" + idProcedencia + " ]";
    }
    
}
