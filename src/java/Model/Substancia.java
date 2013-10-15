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
    @NamedQuery(name = "Substancia.findAll", query = "SELECT s FROM Substancia s"),
    @NamedQuery(name = "Substancia.findByIdSubstancia", query = "SELECT s FROM Substancia s WHERE s.idSubstancia = :idSubstancia"),
    @NamedQuery(name = "Substancia.findByDescricao", query = "SELECT s FROM Substancia s WHERE s.descricao = :descricao"),
    @NamedQuery(name = "Substancia.findByTipoSubstancia", query = "SELECT s FROM Substancia s WHERE s.tipoSubstancia = :tipoSubstancia")})
public class Substancia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idSubstancia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String tipoSubstancia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "substancia")
    private List<Involucro> involucroList;

    public Substancia() {
    }

    public Substancia(Integer idSubstancia) {
        this.idSubstancia = idSubstancia;
    }

    public Substancia(Integer idSubstancia, String descricao, String tipoSubstancia) {
        this.idSubstancia = idSubstancia;
        this.descricao = descricao;
        this.tipoSubstancia = tipoSubstancia;
    }

    public Integer getIdSubstancia() {
        return idSubstancia;
    }

    public void setIdSubstancia(Integer idSubstancia) {
        this.idSubstancia = idSubstancia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoSubstancia() {
        return tipoSubstancia;
    }

    public void setTipoSubstancia(String tipoSubstancia) {
        this.tipoSubstancia = tipoSubstancia;
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
        hash += (idSubstancia != null ? idSubstancia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Substancia)) {
            return false;
        }
        Substancia other = (Substancia) object;
        if ((this.idSubstancia == null && other.idSubstancia != null) || (this.idSubstancia != null && !this.idSubstancia.equals(other.idSubstancia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Substancia[ idSubstancia=" + idSubstancia + " ]";
    }
    
}
