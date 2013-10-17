package Controller;

import Model.ToxicologicoPreliminar;
import Util.Manager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class ToxicologicoPreliminarEJB extends Manager{

    public void salvar(ToxicologicoPreliminar toxicologico) {
        em.merge(toxicologico);
    }
    
    public List<ToxicologicoPreliminar> listarToxicologicoPreliminar(){
        Query query = em.createQuery("Select tp From ToxicologicoPreliminar tp");
        return query.getResultList();
    }
    
    public void excluir(ToxicologicoPreliminar toxicologico){
         toxicologico = em.find(ToxicologicoPreliminar.class, toxicologico.getIdLaudo());
         em.remove(toxicologico);
    } 
    
    public ToxicologicoPreliminar pesquisaPorIdLaudo(int idLaudo){
        Query query = em.createQuery("SELECT l FROM Laudo l WHERE l.idLaudo = :idLaudo")
                .setParameter("idLaudo", idLaudo);
        return (ToxicologicoPreliminar) query.getSingleResult();
    }

}
