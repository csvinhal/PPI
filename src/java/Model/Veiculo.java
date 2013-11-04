package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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

@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Veiculo.findAll", query = "SELECT v FROM Veiculo v"),
    @NamedQuery(name = "Veiculo.findByIdVeiculo", query = "SELECT v FROM Veiculo v WHERE v.idVeiculo = :idVeiculo"),
    @NamedQuery(name = "Veiculo.findByAno", query = "SELECT v FROM Veiculo v WHERE v.ano = :ano"),
    @NamedQuery(name = "Veiculo.findByChassis", query = "SELECT v FROM Veiculo v WHERE v.chassis = :chassis"),
    @NamedQuery(name = "Veiculo.findByCor", query = "SELECT v FROM Veiculo v WHERE v.cor = :cor"),
    @NamedQuery(name = "Veiculo.findByMarca", query = "SELECT v FROM Veiculo v WHERE v.marca = :marca"),
    @NamedQuery(name = "Veiculo.findByModelo", query = "SELECT v FROM Veiculo v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Veiculo.findByOdometro", query = "SELECT v FROM Veiculo v WHERE v.odometro = :odometro"),
    @NamedQuery(name = "Veiculo.findByPlaca", query = "SELECT v FROM Veiculo v WHERE v.placa = :placa"),
    @NamedQuery(name = "Veiculo.findByPneu", query = "SELECT v FROM Veiculo v WHERE v.pneu = :pneu")})
public class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idVeiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    private String ano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    private String chassis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String cor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    private String modelo;
    private Integer odometro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    private String placa;
    @Size(max = 100)
    private String pneu;
    @OneToMany(mappedBy = "veiculo")
    private List<VistoriaVeiculo> vistoriaVeiculoList;
    

    public Veiculo() {
    }

    public Veiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Veiculo(Integer idVeiculo, String ano, String chassis, String cor, String marca, String modelo, String placa) {
        this.idVeiculo = idVeiculo;
        this.ano = ano;
        this.chassis = chassis;
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
    }

    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getOdometro() {
        return odometro;
    }

    public void setOdometro(Integer odometro) {
        this.odometro = odometro;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPneu() {
        return pneu;
    }

    public void setPneu(String pneu) {
        this.pneu = pneu;
    }

    @XmlTransient
    public List<VistoriaVeiculo> getVistoriaVeiculoList() {
        return vistoriaVeiculoList;
    }

    public void setVistoriaVeiculoList(List<VistoriaVeiculo> vistoriaVeiculoList) {
        this.vistoriaVeiculoList = vistoriaVeiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVeiculo != null ? idVeiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veiculo)) {
            return false;
        }
        Veiculo other = (Veiculo) object;
        if ((this.idVeiculo == null && other.idVeiculo != null) || (this.idVeiculo != null && !this.idVeiculo.equals(other.idVeiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Veiculo[ idVeiculo=" + idVeiculo + " ]";
    }
    
}
