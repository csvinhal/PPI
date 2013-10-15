/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Crouch
 */
@Entity
@Table(name = "toxicologico_preliminar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ToxicologicoPreliminar.findAll", query = "SELECT t FROM ToxicologicoPreliminar t"),
    @NamedQuery(name = "ToxicologicoPreliminar.findByDataOcorrencia", query = "SELECT t FROM ToxicologicoPreliminar t WHERE t.dataOcorrencia = :dataOcorrencia"),
    @NamedQuery(name = "ToxicologicoPreliminar.findByObservacao", query = "SELECT t FROM ToxicologicoPreliminar t WHERE t.observacao = :observacao"),
    @NamedQuery(name = "ToxicologicoPreliminar.findByIdPreliminar", query = "SELECT t FROM ToxicologicoPreliminar t WHERE t.idPreliminar = :idPreliminar")})

public class ToxicologicoPreliminar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataOcorrencia;
    @Size(max = 255)
    private String observacao;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idPreliminar;
    @JoinColumn(name = "usuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "involucro", referencedColumnName = "idInvolucro")
    @ManyToOne(optional = false)
    private Involucro involucro;
    @JoinColumn(name = "idPreliminar", referencedColumnName = "idLaudo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Laudo laudo;

    public ToxicologicoPreliminar() {
    }

    public ToxicologicoPreliminar(Integer idPreliminar) {
        this.idPreliminar = idPreliminar;
    }

    public ToxicologicoPreliminar(Integer idPreliminar, Date dataOcorrencia) {
        this.idPreliminar = idPreliminar;
        this.dataOcorrencia = dataOcorrencia;
    }

    public Date getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(Date dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getIdPreliminar() {
        return idPreliminar;
    }

    public void setIdPreliminar(Integer idPreliminar) {
        this.idPreliminar = idPreliminar;
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

    public Laudo getLaudo() {
        return laudo;
    }

    public void setLaudo(Laudo laudo) {
        this.laudo = laudo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPreliminar != null ? idPreliminar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ToxicologicoPreliminar)) {
            return false;
        }
        ToxicologicoPreliminar other = (ToxicologicoPreliminar) object;
        if ((this.idPreliminar == null && other.idPreliminar != null) || (this.idPreliminar != null && !this.idPreliminar.equals(other.idPreliminar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.ToxicologicoPreliminar[ idPreliminar=" + idPreliminar + " ]";
    }
    
}
