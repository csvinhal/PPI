package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByAtivo", query = "SELECT u FROM Usuario u WHERE u.ativo = :ativo"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idUsuario;
    private Boolean ativo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    private String senha;
    @ManyToOne(optional=false)
    private Permissao permissao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<VistoriaVeiculo> vistoriaVeiculoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<VistoriaImovel> vistoriaImovelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<ToxicologicoPreliminar> toxicologicoPreliminarList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<GuiaPericial> guiaPericialList;
    @OneToMany(mappedBy = "responsavel")
    private List<GuiaPericial> guiaPericialList1;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String email, String nome, String senha) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }
    
    public Usuario(boolean ativo) {
        this.ativo = true;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    @XmlTransient
    public List<VistoriaVeiculo> getVistoriaVeiculoList() {
        return vistoriaVeiculoList;
    }

    public void setVistoriaVeiculoList(List<VistoriaVeiculo> vistoriaVeiculoList) {
        this.vistoriaVeiculoList = vistoriaVeiculoList;
    }

    @XmlTransient
    public List<VistoriaImovel> getVistoriaImovelList() {
        return vistoriaImovelList;
    }

    public void setVistoriaImovelList(List<VistoriaImovel> vistoriaImovelList) {
        this.vistoriaImovelList = vistoriaImovelList;
    }

    @XmlTransient
    public List<ToxicologicoPreliminar> getToxicologicoPreliminarList() {
        return toxicologicoPreliminarList;
    }

    public void setToxicologicoPreliminarList(List<ToxicologicoPreliminar> toxicologicoPreliminarList) {
        this.toxicologicoPreliminarList = toxicologicoPreliminarList;
    }

    @XmlTransient
    public List<GuiaPericial> getGuiaPericialList() {
        return guiaPericialList;
    }

    public void setGuiaPericialList(List<GuiaPericial> guiaPericialList) {
        this.guiaPericialList = guiaPericialList;
    }

    @XmlTransient
    public List<GuiaPericial> getGuiaPericialList1() {
        return guiaPericialList1;
    }

    public void setGuiaPericialList1(List<GuiaPericial> guiaPericialList1) {
        this.guiaPericialList1 = guiaPericialList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
