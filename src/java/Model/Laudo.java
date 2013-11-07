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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Laudo.findAll", query = "SELECT l FROM Laudo l"),
    @NamedQuery(name = "Laudo.findByIdLaudo", query = "SELECT l FROM Laudo l WHERE l.idLaudo = :idLaudo"),
    @NamedQuery(name = "Laudo.findByLocalExame", query = "SELECT l FROM Laudo l WHERE l.localExame = :localExame"),
    @NamedQuery(name = "Laudo.findByReferencia", query = "SELECT l FROM Laudo l WHERE l.referencia = :referencia")})
public class Laudo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idLaudo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    private String localExame;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String referencia;
    @JoinColumn(name = "guia", referencedColumnName = "idGuia")
    @ManyToOne(optional = false)
    private GuiaPericial guia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "laudo")
    private List<Danos> danosList;
    @OneToMany(mappedBy = "laudo")
    private List<ToxicologicoDefinitivo> toxicologicoDefinitivos;

    public Laudo() {
    }

    public Laudo(Integer idLaudo) {
        this.idLaudo = idLaudo;
    }

    public Laudo(Integer idLaudo, String localExame, String referencia) {
        this.idLaudo = idLaudo;
        this.localExame = localExame;
        this.referencia = referencia;
    }

    public Integer getIdLaudo() {
        return idLaudo;
    }

    public void setIdLaudo(Integer idLaudo) {
        this.idLaudo = idLaudo;
    }

    public String getLocalExame() {
        return localExame;
    }

    public void setLocalExame(String localExame) {
        this.localExame = localExame;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
    public GuiaPericial getGuia() {
        return guia;
    }

    public void setGuia(GuiaPericial guia) {
        this.guia = guia;
    }


    @XmlTransient
    public List<Danos> getDanosList() {
        return danosList;
    }

    public void setDanosList(List<Danos> danosList) {
        this.danosList = danosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLaudo != null ? idLaudo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Laudo)) {
            return false;
        }
        Laudo other = (Laudo) object;
        if ((this.idLaudo == null && other.idLaudo != null) || (this.idLaudo != null && !this.idLaudo.equals(other.idLaudo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Laudo[ idLaudo=" + idLaudo + " ]";
    }
    
}
