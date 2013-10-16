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

public class ToxicologicoPreliminar extends Laudo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataOcorrencia;
    @Size(max = 255)
    private String observacao;
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

    public ToxicologicoPreliminar(Integer idPreliminar, Date dataOcorrencia) {
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
}
