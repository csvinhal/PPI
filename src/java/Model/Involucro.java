
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Involucro.findAll", query = "SELECT i FROM Involucro i"),
    @NamedQuery(name = "Involucro.findByIdInvolucro", query = "SELECT i FROM Involucro i WHERE i.idInvolucro = :idInvolucro"),
    @NamedQuery(name = "Involucro.findByPeso", query = "SELECT i FROM Involucro i WHERE i.peso = :peso"),
    @NamedQuery(name = "Involucro.findByQuantidade", query = "SELECT i FROM Involucro i WHERE i.quantidade = :quantidade")})
public class Involucro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idInvolucro;
    @Basic(optional = false)
    @NotNull
    private double peso;
    @Basic(optional = false)
    @NotNull
    private double quantidade;
    @JoinColumn(name = "tipoInvolucro", referencedColumnName = "idTipoInvolucro")
    @ManyToOne(optional = false)
    private TipoInvolucro tipoInvolucro;
    @JoinColumn(name = "substancia", referencedColumnName = "idSubstancia")
    @ManyToOne(optional = false)
    private Substancia substancia;
    @JoinColumn(name = "cor", referencedColumnName = "idCor")
    @ManyToOne(optional = false)
    private Cor cor;
    @OneToMany(mappedBy = "involucro")
    private List<ToxicologicoPreliminar> toxicologicoPreliminarList;

    public Involucro() {
    }

    public Involucro(Integer idInvolucro) {
        this.idInvolucro = idInvolucro;
    }

    public Involucro(Integer idInvolucro, double peso, double quantidade) {
        this.idInvolucro = idInvolucro;
        this.peso = peso;
        this.quantidade = quantidade;
    }

    public Integer getIdInvolucro() {
        return idInvolucro;
    }

    public void setIdInvolucro(Integer idInvolucro) {
        this.idInvolucro = idInvolucro;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public TipoInvolucro getTipoInvolucro() {
        return tipoInvolucro;
    }

    public void setTipoInvolucro(TipoInvolucro tipoInvolucro) {
        this.tipoInvolucro = tipoInvolucro;
    }

    public Substancia getSubstancia() {
        return substancia;
    }

    public void setSubstancia(Substancia substancia) {
        this.substancia = substancia;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    @XmlTransient
    public List<ToxicologicoPreliminar> getToxicologicoPreliminarList() {
        return toxicologicoPreliminarList;
    }

    public void setToxicologicoPreliminarList(List<ToxicologicoPreliminar> toxicologicoPreliminarList) {
        this.toxicologicoPreliminarList = toxicologicoPreliminarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInvolucro != null ? idInvolucro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Involucro)) {
            return false;
        }
        Involucro other = (Involucro) object;
        if ((this.idInvolucro == null && other.idInvolucro != null) || (this.idInvolucro != null && !this.idInvolucro.equals(other.idInvolucro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Involucro[ idInvolucro=" + idInvolucro + " ]";
    }
    
}
