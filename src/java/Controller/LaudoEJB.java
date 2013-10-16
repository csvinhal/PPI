package Controller;

import Model.GuiaPericial;
import Model.Laudo;
import Util.Manager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class LaudoEJB extends Manager{
    
    public List<Laudo> listarLaudos(){
        Query query = em.createQuery("Select l From Laudo l");
        return query.getResultList();
    }
    
    public List<Laudo> listarPorGuias(GuiaPericial guia){
        Query query = em.createQuery("Select l From Laudo l where l.guia :guia");
        return query.getResultList();
    }
}
