package Controller;

import Model.ToxicologicoDefinitivo;
import Util.Manager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class ToxicologicoDefinitivoEJB extends Manager{

    public void salvar(ToxicologicoDefinitivo toxicologico) {
        em.merge(toxicologico);
    }
    
    public List<ToxicologicoDefinitivo> listarToxicologicoDefinitivo(){
        Query query = em.createQuery("Select td From ToxicologicoDefinitivo td");
        return query.getResultList();
    }
    
    public void excluir(ToxicologicoDefinitivo toxicologico){
         toxicologico = em.find(ToxicologicoDefinitivo.class, toxicologico.getIdLaudo());
         em.remove(toxicologico);
    } 
    
    public ToxicologicoDefinitivo pesquisaPorIdLaudo(int idLaudo){
        Query query = em.createQuery("SELECT l FROM Laudo l WHERE l.idLaudo = :idLaudo")
                .setParameter("idLaudo", idLaudo);
        return (ToxicologicoDefinitivo) query.getSingleResult();
    }

}
