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
    @NamedQuery(name = "Autoridade.findAll", query = "SELECT a FROM Autoridade a"),
    @NamedQuery(name = "Autoridade.findByIdAutoridade", query = "SELECT a FROM Autoridade a WHERE a.idAutoridade = :idAutoridade"),
    @NamedQuery(name = "Autoridade.findByEmail", query = "SELECT a FROM Autoridade a WHERE a.email = :email"),
    @NamedQuery(name = "Autoridade.findByMasp", query = "SELECT a FROM Autoridade a WHERE a.masp = :masp"),
    @NamedQuery(name = "Autoridade.findByNome", query = "SELECT a FROM Autoridade a WHERE a.nome = :nome")})
public class Autoridade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idAutoridade;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    private String masp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autoridade")
    private List<GuiaPericial> guiaPericialList;

    public Autoridade() {
    }

    public Autoridade(Integer idAutoridade) {
        this.idAutoridade = idAutoridade;
    }

    public Autoridade(Integer idAutoridade, String email, String masp, String nome) {
        this.idAutoridade = idAutoridade;
        this.email = email;
        this.masp = masp;
        this.nome = nome;
    }

    public Integer getIdAutoridade() {
        return idAutoridade;
    }

    public void setIdAutoridade(Integer idAutoridade) {
        this.idAutoridade = idAutoridade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        hash += (idAutoridade != null ? idAutoridade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autoridade)) {
            return false;
        }
        Autoridade other = (Autoridade) object;
        if ((this.idAutoridade == null && other.idAutoridade != null) || (this.idAutoridade != null && !this.idAutoridade.equals(other.idAutoridade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Autoridade[ idAutoridade=" + idAutoridade + " ]";
    }
    
}
