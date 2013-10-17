package Controller;

import Model.VistoriaVeiculo;
import Util.Manager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class VistoriaVeiculoEJB extends Manager{

    public void salvar(VistoriaVeiculo vistoriaVeiculo) {
        em.merge(vistoriaVeiculo);
    }
    
    public List<VistoriaVeiculo> listarVistoriaVeiculos(){
        Query query = em.createQuery("Select vv From VistoriaVeiculo vv");
        return query.getResultList();
    }
    
    public void excluir(VistoriaVeiculo vistoriaVeiculo){
         vistoriaVeiculo = em.find(VistoriaVeiculo.class, vistoriaVeiculo.getIdLaudo());
         em.remove(vistoriaVeiculo);
    } 
    
    public VistoriaVeiculo pesquisaPorIdLaudo(int idLaudo){
        Query query = em.createQuery("SELECT l FROM Laudo l WHERE l.idLaudo = :idLaudo")
                .setParameter("idLaudo", idLaudo);
        return (VistoriaVeiculo) query.getSingleResult();
    }

}
