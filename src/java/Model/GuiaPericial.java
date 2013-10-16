/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Crouch
 */
@Entity
@Table(name = "guia_pericial")
@XmlRootElement
public class GuiaPericial extends Laudo implements Serializable {
    private static final long serialVersionUID = 1L;
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
    private String numeroGuia;
    @Size(max = 255)
    private String observacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String referencia;
    private Integer status;
    @Size(max = 100)
    private String vitima;
    @JoinTable(name = "guiamaterial", joinColumns = {
        @JoinColumn(name = "laudo_id", referencedColumnName = "idLaudo")}, inverseJoinColumns = {
        @JoinColumn(name = "tipoMaterial_id", referencedColumnName = "idTipoMaterial")})
    @ManyToMany
    private List<TipoDeMaterial> tipoDeMaterial;
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

    public GuiaPericial(String envolvido, String localExame, String numeroGuia, String referencia) {
        this.envolvido = envolvido;
        this.localExame = localExame;
        this.numeroGuia = numeroGuia;
        this.referencia = referencia;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
}
