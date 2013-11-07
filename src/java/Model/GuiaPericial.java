package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "guia_pericial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GuiaPericial.findAll", query = "SELECT g FROM GuiaPericial g"),
    @NamedQuery(name = "GuiaPericial.findByIdGuia", query = "SELECT g FROM GuiaPericial g WHERE g.idGuia = :idGuia"),
    @NamedQuery(name = "GuiaPericial.findByDataEntrada", query = "SELECT g FROM GuiaPericial g WHERE g.dataEntrada = :dataEntrada"),
    @NamedQuery(name = "GuiaPericial.findByEnvolvido", query = "SELECT g FROM GuiaPericial g WHERE g.envolvido = :envolvido"),
    @NamedQuery(name = "GuiaPericial.findByLocalExame", query = "SELECT g FROM GuiaPericial g WHERE g.localExame = :localExame"),
    @NamedQuery(name = "GuiaPericial.findByNumeroGuia", query = "SELECT g FROM GuiaPericial g WHERE g.numeroGuia = :numeroGuia"),
    @NamedQuery(name = "GuiaPericial.findByObservacao", query = "SELECT g FROM GuiaPericial g WHERE g.observacao = :observacao"),
    @NamedQuery(name = "GuiaPericial.findByReferencia", query = "SELECT g FROM GuiaPericial g WHERE g.referencia = :referencia"),
    @NamedQuery(name = "GuiaPericial.findByStatus", query = "SELECT g FROM GuiaPericial g WHERE g.status = :status"),
    @NamedQuery(name = "GuiaPericial.findByVitima", query = "SELECT g FROM GuiaPericial g WHERE g.vitima = :vitima")})

public class GuiaPericial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idGuia;
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String envolvido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    private String localExame;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(unique=true)
    private String numeroGuia;
    @Size(max = 255)
    private String observacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String referencia;
    @Basic(optional = false)
    @NotNull
    private boolean status;
    @Size(max = 100)
    private String vitima;
    @JoinTable(name = "guiamaterial", joinColumns = {
        @JoinColumn(name = "guia_id", referencedColumnName = "idGuia")}, inverseJoinColumns = {
        @JoinColumn(name = "tipoMaterial_id", referencedColumnName = "idTipoMaterial")})
    @ManyToMany
    private List<TipoDeMaterial> tipoDeMaterial;
    @OneToMany(mappedBy = "guia")
    private List<Laudo> laudoList;
    @JoinColumn(name = "usuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "tipoExame", referencedColumnName = "idTipoExame")
    @ManyToOne(optional = false)
    private TipoDeExame tipoExame;
    @JoinColumn(name = "responsavel", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario responsavel;
    @JoinColumn(name = "procedencia", referencedColumnName = "idProcedencia")
    @ManyToOne(optional = false)
    private Procedencia procedencia;
    @JoinColumn(name = "destino", referencedColumnName = "idDestino")
    @ManyToOne(optional = false)
    private Destino destino;
    @JoinColumn(name = "autoridade", referencedColumnName = "idAutoridade")
    @ManyToOne(optional = false)
    private Autoridade autoridade;

    public GuiaPericial() {
    }

    public GuiaPericial(Integer idGuia) {
        this.idGuia = idGuia;
    }

    public GuiaPericial(Integer idGuia, String envolvido, String localExame, String numeroGuia, String referencia) {
        this.idGuia = idGuia;
        this.envolvido = envolvido;
        this.localExame = localExame;
        this.numeroGuia = numeroGuia;
        this.referencia = referencia;
    }

    public Integer getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(Integer idGuia) {
        this.idGuia = idGuia;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getEnvolvido() {
        return envolvido;
    }

    public void setEnvolvido(String envolvido) {
        this.envolvido = envolvido;
    }

    public String getLocalExame() {
        return localExame;
    }

    public void setLocalExame(String localExame) {
        this.localExame = localExame;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public String getVitima() {
        return vitima;
    }

    public void setVitima(String vitima) {
        this.vitima = vitima;
    }

    @XmlTransient
    public List<TipoDeMaterial> getTipoDeMaterial() {
        return tipoDeMaterial;
    }

    public void setTipoDeMaterial(List<TipoDeMaterial> tipoDeMaterial) {
        this.tipoDeMaterial = tipoDeMaterial;
    }

    @XmlTransient
    public List<Laudo> getLaudoList() {
        return laudoList;
    }

    public void setLaudoList(List<Laudo> laudoList) {
        this.laudoList = laudoList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoDeExame getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(TipoDeExame tipoExame) {
        this.tipoExame = tipoExame;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public Procedencia getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(Procedencia procedencia) {
        this.procedencia = procedencia;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Autoridade getAutoridade() {
        return autoridade;
    }

    public void setAutoridade(Autoridade autoridade) {
        this.autoridade = autoridade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGuia != null ? idGuia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuiaPericial)) {
            return false;
        }
        GuiaPericial other = (GuiaPericial) object;
        if ((this.idGuia == null && other.idGuia != null) || (this.idGuia != null && !this.idGuia.equals(other.idGuia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.GuiaPericial[ idGuia=" + idGuia + " ]";
    }
    
}
