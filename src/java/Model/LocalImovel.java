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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "local_imovel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocalImovel.findAll", query = "SELECT l FROM LocalImovel l"),
    @NamedQuery(name = "LocalImovel.findByIdLocal", query = "SELECT l FROM LocalImovel l WHERE l.idLocal = :idLocal"),
    @NamedQuery(name = "LocalImovel.findByAltura", query = "SELECT l FROM LocalImovel l WHERE l.altura = :altura"),
    @NamedQuery(name = "LocalImovel.findByClarificacao", query = "SELECT l FROM LocalImovel l WHERE l.clarificacao = :clarificacao"),
    @NamedQuery(name = "LocalImovel.findByComodos", query = "SELECT l FROM LocalImovel l WHERE l.comodos = :comodos"),
    @NamedQuery(name = "LocalImovel.findByEdificado", query = "SELECT l FROM LocalImovel l WHERE l.edificado = :edificado"),
    @NamedQuery(name = "LocalImovel.findByEstrutura1", query = "SELECT l FROM LocalImovel l WHERE l.estrutura1 = :estrutura1"),
    @NamedQuery(name = "LocalImovel.findByEstrutura2", query = "SELECT l FROM LocalImovel l WHERE l.estrutura2 = :estrutura2"),
    @NamedQuery(name = "LocalImovel.findByEstruturaJanela", query = "SELECT l FROM LocalImovel l WHERE l.estruturaJanela = :estruturaJanela"),
    @NamedQuery(name = "LocalImovel.findByInstalacoes", query = "SELECT l FROM LocalImovel l WHERE l.instalacoes = :instalacoes"),
    @NamedQuery(name = "LocalImovel.findByLadeado", query = "SELECT l FROM LocalImovel l WHERE l.ladeado = :ladeado"),
    @NamedQuery(name = "LocalImovel.findByMarca1", query = "SELECT l FROM LocalImovel l WHERE l.marca1 = :marca1"),
    @NamedQuery(name = "LocalImovel.findByMarca2", query = "SELECT l FROM LocalImovel l WHERE l.marca2 = :marca2"),
    @NamedQuery(name = "LocalImovel.findByMarca3", query = "SELECT l FROM LocalImovel l WHERE l.marca3 = :marca3"),
    @NamedQuery(name = "LocalImovel.findByMarca4", query = "SELECT l FROM LocalImovel l WHERE l.marca4 = :marca4"),
    @NamedQuery(name = "LocalImovel.findByMuros", query = "SELECT l FROM LocalImovel l WHERE l.muros = :muros"),
    @NamedQuery(name = "LocalImovel.findByParedes", query = "SELECT l FROM LocalImovel l WHERE l.paredes = :paredes"),
    @NamedQuery(name = "LocalImovel.findByPiso", query = "SELECT l FROM LocalImovel l WHERE l.piso = :piso"),
    @NamedQuery(name = "LocalImovel.findByTeto", query = "SELECT l FROM LocalImovel l WHERE l.teto = :teto"),
    @NamedQuery(name = "LocalImovel.findByTipoImovel", query = "SELECT l FROM LocalImovel l WHERE l.tipoImovel = :tipoImovel"),
    @NamedQuery(name = "LocalImovel.findByTrancamento1", query = "SELECT l FROM LocalImovel l WHERE l.trancamento1 = :trancamento1"),
    @NamedQuery(name = "LocalImovel.findByTrancamento2", query = "SELECT l FROM LocalImovel l WHERE l.trancamento2 = :trancamento2"),
    @NamedQuery(name = "LocalImovel.findByTrancamento3", query = "SELECT l FROM LocalImovel l WHERE l.trancamento3 = :trancamento3"),
    @NamedQuery(name = "LocalImovel.findByTrancamento4", query = "SELECT l FROM LocalImovel l WHERE l.trancamento4 = :trancamento4"),
    @NamedQuery(name = "LocalImovel.findByViasEdificacao1", query = "SELECT l FROM LocalImovel l WHERE l.viasEdificacao1 = :viasEdificacao1"),
    @NamedQuery(name = "LocalImovel.findByViasEdificacao2", query = "SELECT l FROM LocalImovel l WHERE l.viasEdificacao2 = :viasEdificacao2"),
    @NamedQuery(name = "LocalImovel.findByViasTerreno1", query = "SELECT l FROM LocalImovel l WHERE l.viasTerreno1 = :viasTerreno1"),
    @NamedQuery(name = "LocalImovel.findByViasTerreno2", query = "SELECT l FROM LocalImovel l WHERE l.viasTerreno2 = :viasTerreno2")})
public class LocalImovel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idLocal;
    @Basic(optional = false)
    @NotNull
    private double altura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String clarificacao;
    @Basic(optional = false)
    @NotNull
    private int comodos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String edificado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String estrutura1;
    @Size(max = 255)
    private String estrutura2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String estruturaJanela;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String instalacoes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String ladeado;
    @Size(max = 255)
    private String marca1;
    @Size(max = 255)
    private String marca2;
    @Size(max = 255)
    private String marca3;
    @Size(max = 255)
    private String marca4;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String muros;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String paredes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String piso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String teto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String tipoImovel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String trancamento1;
    @Size(max = 255)
    private String trancamento2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String trancamento3;
    @Size(max = 255)
    private String trancamento4;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String viasEdificacao1;
    @Size(max = 255)
    private String viasEdificacao2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String viasTerreno1;
    @Size(max = 255)
    private String viasTerreno2;
    @OneToMany(mappedBy = "localImovel")
    private List<VistoriaImovel> vistoriaImovelList;

    public LocalImovel() {
    }

    public LocalImovel(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public LocalImovel(Integer idLocal, double altura, String clarificacao, int comodos, String edificado, String estrutura1, String estruturaJanela, String instalacoes, String ladeado, String muros, String paredes, String piso, String teto, String tipoImovel, String trancamento1, String trancamento3, String viasEdificacao1, String viasTerreno1) {
        this.idLocal = idLocal;
        this.altura = altura;
        this.clarificacao = clarificacao;
        this.comodos = comodos;
        this.edificado = edificado;
        this.estrutura1 = estrutura1;
        this.estruturaJanela = estruturaJanela;
        this.instalacoes = instalacoes;
        this.ladeado = ladeado;
        this.muros = muros;
        this.paredes = paredes;
        this.piso = piso;
        this.teto = teto;
        this.tipoImovel = tipoImovel;
        this.trancamento1 = trancamento1;
        this.trancamento3 = trancamento3;
        this.viasEdificacao1 = viasEdificacao1;
        this.viasTerreno1 = viasTerreno1;
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getClarificacao() {
        return clarificacao;
    }

    public void setClarificacao(String clarificacao) {
        this.clarificacao = clarificacao;
    }

    public int getComodos() {
        return comodos;
    }

    public void setComodos(int comodos) {
        this.comodos = comodos;
    }

    public String getEdificado() {
        return edificado;
    }

    public void setEdificado(String edificado) {
        this.edificado = edificado;
    }

    public String getEstrutura1() {
        return estrutura1;
    }

    public void setEstrutura1(String estrutura1) {
        this.estrutura1 = estrutura1;
    }

    public String getEstrutura2() {
        return estrutura2;
    }

    public void setEstrutura2(String estrutura2) {
        this.estrutura2 = estrutura2;
    }

    public String getEstruturaJanela() {
        return estruturaJanela;
    }

    public void setEstruturaJanela(String estruturaJanela) {
        this.estruturaJanela = estruturaJanela;
    }

    public String getInstalacoes() {
        return instalacoes;
    }

    public void setInstalacoes(String instalacoes) {
        this.instalacoes = instalacoes;
    }

    public String getLadeado() {
        return ladeado;
    }

    public void setLadeado(String ladeado) {
        this.ladeado = ladeado;
    }

    public String getMarca1() {
        return marca1;
    }

    public void setMarca1(String marca1) {
        this.marca1 = marca1;
    }

    public String getMarca2() {
        return marca2;
    }

    public void setMarca2(String marca2) {
        this.marca2 = marca2;
    }

    public String getMarca3() {
        return marca3;
    }

    public void setMarca3(String marca3) {
        this.marca3 = marca3;
    }

    public String getMarca4() {
        return marca4;
    }

    public void setMarca4(String marca4) {
        this.marca4 = marca4;
    }

    public String getMuros() {
        return muros;
    }

    public void setMuros(String muros) {
        this.muros = muros;
    }

    public String getParedes() {
        return paredes;
    }

    public void setParedes(String paredes) {
        this.paredes = paredes;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getTeto() {
        return teto;
    }

    public void setTeto(String teto) {
        this.teto = teto;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public String getTrancamento1() {
        return trancamento1;
    }

    public void setTrancamento1(String trancamento1) {
        this.trancamento1 = trancamento1;
    }

    public String getTrancamento2() {
        return trancamento2;
    }

    public void setTrancamento2(String trancamento2) {
        this.trancamento2 = trancamento2;
    }

    public String getTrancamento3() {
        return trancamento3;
    }

    public void setTrancamento3(String trancamento3) {
        this.trancamento3 = trancamento3;
    }

    public String getTrancamento4() {
        return trancamento4;
    }

    public void setTrancamento4(String trancamento4) {
        this.trancamento4 = trancamento4;
    }

    public String getViasEdificacao1() {
        return viasEdificacao1;
    }

    public void setViasEdificacao1(String viasEdificacao1) {
        this.viasEdificacao1 = viasEdificacao1;
    }

    public String getViasEdificacao2() {
        return viasEdificacao2;
    }

    public void setViasEdificacao2(String viasEdificacao2) {
        this.viasEdificacao2 = viasEdificacao2;
    }

    public String getViasTerreno1() {
        return viasTerreno1;
    }

    public void setViasTerreno1(String viasTerreno1) {
        this.viasTerreno1 = viasTerreno1;
    }

    public String getViasTerreno2() {
        return viasTerreno2;
    }

    public void setViasTerreno2(String viasTerreno2) {
        this.viasTerreno2 = viasTerreno2;
    }

    @XmlTransient
    public List<VistoriaImovel> getVistoriaImovelList() {
        return vistoriaImovelList;
    }

    public void setVistoriaImovelList(List<VistoriaImovel> vistoriaImovelList) {
        this.vistoriaImovelList = vistoriaImovelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocal != null ? idLocal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalImovel)) {
            return false;
        }
        LocalImovel other = (LocalImovel) object;
        if ((this.idLocal == null && other.idLocal != null) || (this.idLocal != null && !this.idLocal.equals(other.idLocal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.LocalImovel[ idLocal=" + idLocal + " ]";
    }
    
}
