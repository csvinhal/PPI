package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "toxicologicodefinitivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ToxicologicoDefinitivo.findAll", query = "SELECT t FROM ToxicologicoDefinitivo t"),
    @NamedQuery(name = "ToxicologicoDefinitivo.findByIdDefinitivo", query = "SELECT t FROM ToxicologicoDefinitivo t WHERE t.idDefinitivo = :idDefinitivo"),
    @NamedQuery(name = "ToxicologicoDefinitivo.findByLocalexame", query = "SELECT t FROM ToxicologicoDefinitivo t WHERE t.localexame = :localexame"),
    @NamedQuery(name = "ToxicologicoDefinitivo.findByReferencia", query = "SELECT t FROM ToxicologicoDefinitivo t WHERE t.referencia = :referencia"),
    @NamedQuery(name = "ToxicologicoDefinitivo.findByDataocorrencia", query = "SELECT t FROM ToxicologicoDefinitivo t WHERE t.dataocorrencia = :dataocorrencia"),
    @NamedQuery(name = "ToxicologicoDefinitivo.findByObservacao", query = "SELECT t FROM ToxicologicoDefinitivo t WHERE t.observacao = :observacao")})

public class ToxicologicoDefinitivo  implements  Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDefinitivo")
    private Integer idDefinitivo;
    @Size(max = 255)
    @Column(name = "localexame")
    private String localexame;
    @Size(max = 255)
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "dataocorrencia")
    @Temporal(TemporalType.DATE)
    private Date dataocorrencia;
    @Size(max = 255)
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "usuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "involucro", referencedColumnName = "idInvolucro")
    @ManyToOne(optional = false)
    private Involucro involucro;
    @JoinColumn(name = "laudo", referencedColumnName = "idLaudo")
    @ManyToOne(optional = false)
    private Laudo laudo;
    @JoinColumn(name = "guia", referencedColumnName = "idGuia")
    @ManyToOne(optional = false)
    private GuiaPericial guia;

    public ToxicologicoDefinitivo() {
    }

    public Laudo getLaudo() {
        return laudo;
    }

    public void setLaudo(Laudo laudo) {
        this.laudo = laudo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Involucro getInvolucro() {
        return involucro;
    }

    public void setInvolucro(Involucro involucro) {
        this.involucro = involucro;
    }   

    public ToxicologicoDefinitivo(Integer idDefinitivo) {
        this.idDefinitivo = idDefinitivo;
    }

    public Integer getIdDefinitivo() {
        return idDefinitivo;
    }

    public void setIdDefinitivo(Integer idDefinitivo) {
        this.idDefinitivo = idDefinitivo;
    }

    public String getLocalexame() {
        return localexame;
    }

    public void setLocalexame(String localexame) {
        this.localexame = localexame;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Date getDataocorrencia() {
        return dataocorrencia;
    }

    public void setDataocorrencia(Date dataocorrencia) {
        this.dataocorrencia = dataocorrencia;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public GuiaPericial getGuia() {
        return guia;
    }

    public void setGuia(GuiaPericial guia) {
        this.guia = guia;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDefinitivo != null ? idDefinitivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ToxicologicoDefinitivo)) {
            return false;
        }
        ToxicologicoDefinitivo other = (ToxicologicoDefinitivo) object;
        if ((this.idDefinitivo == null && other.idDefinitivo != null) || (this.idDefinitivo != null && !this.idDefinitivo.equals(other.idDefinitivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.ToxicologicoDefinitivo[ idDefinitivo=" + idDefinitivo + " ]";
    }
}
