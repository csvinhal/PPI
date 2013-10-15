/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Crouch
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Destino.findAll", query = "SELECT d FROM Destino d"),
    @NamedQuery(name = "Destino.findByIdDestino", query = "SELECT d FROM Destino d WHERE d.idDestino = :idDestino"),
    @NamedQuery(name = "Destino.findByNomeDestino", query = "SELECT d FROM Destino d WHERE d.nomeDestino = :nomeDestino")})
public class Destino implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idDestino;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String nomeDestino;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destino")
    private List<GuiaPericial> guiaPericialList;

    public Destino() {
    }

    public Destino(Integer idDestino) {
        this.idDestino = idDestino;
    }

    public Destino(Integer idDestino, String nomeDestino) {
        this.idDestino = idDestino;
        this.nomeDestino = nomeDestino;
    }

    public Integer getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(Integer idDestino) {
        this.idDestino = idDestino;
    }

    public String getNomeDestino() {
        return nomeDestino;
    }

    public void setNomeDestino(String nomeDestino) {
        this.nomeDestino = nomeDestino;
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
        hash += (idDestino != null ? idDestino.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destino)) {
            return false;
        }
        Destino other = (Destino) object;
        if ((this.idDestino == null && other.idDestino != null) || (this.idDestino != null && !this.idDestino.equals(other.idDestino))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Destino[ idDestino=" + idDestino + " ]";
    }
    
}
