package Controller;

import Model.VistoriaVeiculo;
import Util.Manager;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;

@Stateless
public class VistoriaVeiculoEJB extends Manager{

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public VistoriaVeiculo salvar(VistoriaVeiculo vistoriaVeiculo) {
        return em.merge(vistoriaVeiculo);
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
