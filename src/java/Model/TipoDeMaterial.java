/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "tipo_de_material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDeMaterial.findAll", query = "SELECT t FROM TipoDeMaterial t"),
    @NamedQuery(name = "TipoDeMaterial.findByIdTipoMaterial", query = "SELECT t FROM TipoDeMaterial t WHERE t.idTipoMaterial = :idTipoMaterial"),
    @NamedQuery(name = "TipoDeMaterial.findByDescricaoMaterial", query = "SELECT t FROM TipoDeMaterial t WHERE t.descricaoMaterial = :descricaoMaterial")})
public class TipoDeMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idTipoMaterial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String descricaoMaterial;
    @ManyToMany(mappedBy = "tipoDeMaterial")
    private List<GuiaPericial> guiaPericialList;

    public TipoDeMaterial() {
    }

    public TipoDeMaterial(Integer idTipoMaterial) {
        this.idTipoMaterial = idTipoMaterial;
    }

    public TipoDeMaterial(Integer idTipoMaterial, String descricaoMaterial) {
        this.idTipoMaterial = idTipoMaterial;
        this.descricaoMaterial = descricaoMaterial;
    }

    public Integer getIdTipoMaterial() {
        return idTipoMaterial;
    }

    public void setIdTipoMaterial(Integer idTipoMaterial) {
        this.idTipoMaterial = idTipoMaterial;
    }

    public String getDescricaoMaterial() {
        return descricaoMaterial;
    }

    public void setDescricaoMaterial(String descricaoMaterial) {
        this.descricaoMaterial = descricaoMaterial;
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
        hash += (idTipoMaterial != null ? idTipoMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDeMaterial)) {
            return false;
        }
        TipoDeMaterial other = (TipoDeMaterial) object;
        if ((this.idTipoMaterial == null && other.idTipoMaterial != null) || (this.idTipoMaterial != null && !this.idTipoMaterial.equals(other.idTipoMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TipoDeMaterial[ idTipoMaterial=" + idTipoMaterial + " ]";
    }
    
}
