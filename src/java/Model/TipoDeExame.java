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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Crouch
 */
@Entity
@Table(name = "tipo_de_exame")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDeExame.findAll", query = "SELECT t FROM TipoDeExame t"),
    @NamedQuery(name = "TipoDeExame.findByIdTipoExame", query = "SELECT t FROM TipoDeExame t WHERE t.idTipoExame = :idTipoExame"),
    @NamedQuery(name = "TipoDeExame.findByDescricaoExame", query = "SELECT t FROM TipoDeExame t WHERE t.descricaoExame = :descricaoExame")})
public class TipoDeExame implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idTipoExame;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String descricaoExame;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoExame")
    private List<GuiaPericial> guiaPericialList;

    public TipoDeExame() {
    }

    public TipoDeExame(Integer idTipoExame) {
        this.idTipoExame = idTipoExame;
    }

    public TipoDeExame(Integer idTipoExame, String descricaoExame) {
        this.idTipoExame = idTipoExame;
        this.descricaoExame = descricaoExame;
    }

    public Integer getIdTipoExame() {
        return idTipoExame;
    }

    public void setIdTipoExame(Integer idTipoExame) {
        this.idTipoExame = idTipoExame;
    }

    public String getDescricaoExame() {
        return descricaoExame;
    }

    public void setDescricaoExame(String descricaoExame) {
        this.descricaoExame = descricaoExame;
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
        hash += (idTipoExame != null ? idTipoExame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDeExame)) {
            return false;
        }
        TipoDeExame other = (TipoDeExame) object;
        if ((this.idTipoExame == null && other.idTipoExame != null) || (this.idTipoExame != null && !this.idTipoExame.equals(other.idTipoExame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TipoDeExame[ idTipoExame=" + idTipoExame + " ]";
    }
    
}
