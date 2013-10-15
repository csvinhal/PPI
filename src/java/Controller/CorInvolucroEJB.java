package Controller;

import Model.Cor;
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
public class CorInvolucroEJB {

    @PersistenceContext(unitName="PPi0PU")
    private EntityManager em;
    
    public void salvar(Cor corInvolucro){
        em.merge(corInvolucro);
    }
    
    public List<Cor> listarCores(){ 
        Query query = em.createQuery("SELECT c FROM Cor c");
        return query.getResultList();
    }
    
    public void excluir(Cor corInvolucro){
         corInvolucro = em.find(Cor.class, corInvolucro.getIdCor());
         em.remove(corInvolucro);
    }

}
