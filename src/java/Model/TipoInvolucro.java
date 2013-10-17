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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "tipo_involucro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoInvolucro.findAll", query = "SELECT t FROM TipoInvolucro t"),
    @NamedQuery(name = "TipoInvolucro.findByIdTipoInvolucro", query = "SELECT t FROM TipoInvolucro t WHERE t.idTipoInvolucro = :idTipoInvolucro"),
    @NamedQuery(name = "TipoInvolucro.findByDescricao", query = "SELECT t FROM TipoInvolucro t WHERE t.descricao = :descricao")})
public class TipoInvolucro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idTipoInvolucro;
    @Size(max = 30)
    private String descricao;
    @OneToMany( mappedBy = "tipoInvolucro")
    private List<Involucro> involucroList;

    public TipoInvolucro() {
    }

    public TipoInvolucro(Integer idTipoInvolucro) {
        this.idTipoInvolucro = idTipoInvolucro;
    }

    public Integer getIdTipoInvolucro() {
        return idTipoInvolucro;
    }

    public void setIdTipoInvolucro(Integer idTipoInvolucro) {
        this.idTipoInvolucro = idTipoInvolucro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Involucro> getInvolucroList() {
        return involucroList;
    }

    public void setInvolucroList(List<Involucro> involucroList) {
        this.involucroList = involucroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoInvolucro != null ? idTipoInvolucro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoInvolucro)) {
            return false;
        }
        TipoInvolucro other = (TipoInvolucro) object;
        if ((this.idTipoInvolucro == null && other.idTipoInvolucro != null) || (this.idTipoInvolucro != null && !this.idTipoInvolucro.equals(other.idTipoInvolucro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TipoInvolucro[ idTipoInvolucro=" + idTipoInvolucro + " ]";
    }
    
}
