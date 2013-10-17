package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Danos.findAll", query = "SELECT d FROM Danos d"),
    @NamedQuery(name = "Danos.findByIdDanos", query = "SELECT d FROM Danos d WHERE d.idDanos = :idDanos"),
    @NamedQuery(name = "Danos.findByDescricao", query = "SELECT d FROM Danos d WHERE d.descricao = :descricao")})
public class Danos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idDanos;
    @Size(max = 50)
    private String descricao;
    @Lob
    private byte[] imagem;
    @JoinColumn(name = "laudo", referencedColumnName = "idLaudo")
    @ManyToOne(optional = false)
    private Laudo laudo;

    public Danos() {
    }

    public Danos(Integer idDanos) {
        this.idDanos = idDanos;
    }

    public Integer getIdDanos() {
        return idDanos;
    }

    public void setIdDanos(Integer idDanos) {
        this.idDanos = idDanos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
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
        hash += (idDanos != null ? idDanos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Danos)) {
            return false;
        }
        Danos other = (Danos) object;
        if ((this.idDanos == null && other.idDanos != null) || (this.idDanos != null && !this.idDanos.equals(other.idDanos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Danos[ idDanos=" + idDanos + " ]";
    }
    
}
