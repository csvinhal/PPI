package Controller;

import Model.Destino;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Crouch
 */
@Stateless
public class DestinoEJB {
    @PersistenceContext(unitName="PPi0PU")
    private EntityManager em;
    
    public void salvar(Destino destino){
        em.merge(destino);
    }
    
    public List<Destino> listarDestinos(){ 
        Query query = em.createQuery("Select d From Destino d");
        return query.getResultList();
    }
    
    public void excluir(Destino destino){
         destino = em.find(Destino.class, destino.getIdDestino());
         em.remove(destino);
    }

}
