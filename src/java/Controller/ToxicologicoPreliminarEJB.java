package Controller;

import Model.ToxicologicoPreliminar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ToxicologicoPreliminarEJB {

    @PersistenceContext(unitName = "PPi0PU")
    private EntityManager em;

    public void salvar(ToxicologicoPreliminar toxicologico) {
        em.merge(toxicologico);
    }
    
    public List<ToxicologicoPreliminar> listarToxicologicoPreliminar(){
        Query query = em.createQuery("Select tp From ToxicologicoPreliminar tp");
        return query.getResultList();
    }
    
    public void excluir(ToxicologicoPreliminar toxicologico){
         toxicologico = em.find(ToxicologicoPreliminar.class, toxicologico.getIdPreliminar());
         em.remove(toxicologico);
    } 

}
