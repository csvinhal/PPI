package Controller;

import Model.GuiaPericial;
import Model.Laudo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class LaudoEJB {
    @PersistenceContext(unitName = "PPi0PU")
    private EntityManager em;

    
    public List<Laudo> listarLaudos(){
        Query query = em.createQuery("Select l From Laudo l");
        return query.getResultList();
    }
    
    public List<Laudo> listarPorGuias(GuiaPericial guia){
        Query query = em.createQuery("Select l From Laudo l where l.guia :guia");
        return query.getResultList();
    }
}
