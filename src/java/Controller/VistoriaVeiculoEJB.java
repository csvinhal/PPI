package Controller;

import Model.VistoriaVeiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class VistoriaVeiculoEJB {

    @PersistenceContext(unitName = "PPi0PU")
    private EntityManager em;

    public void salvar(VistoriaVeiculo vistoriaVeiculo) {
        em.merge(vistoriaVeiculo);
    }
    
    public List<VistoriaVeiculo> listarVistoriaVeiculos(){
        Query query = em.createQuery("Select vv From VistoriaVeiculo vv");
        return query.getResultList();
    }
    
    public void excluir(VistoriaVeiculo vistoriaVeiculo){
         vistoriaVeiculo = em.find(VistoriaVeiculo.class, vistoriaVeiculo.getIdVistoriaVeiculo());
         em.remove(vistoriaVeiculo);
    } 

}
