package Controller;

import Model.TipoDeExame;
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
public class TipoDeExameEJB {
    
    @PersistenceContext(unitName="PPi0PU")
    private EntityManager em;
    
    public void salvar(TipoDeExame tipoDeExame){
        em.merge(tipoDeExame);
    }
    
    public List<TipoDeExame> listarTiposDeExames(){ 
        Query query = em.createQuery("SELECT t FROM TipoDeExame t");
        return query.getResultList();
    }
    
    public void excluir(TipoDeExame tipoDeExame){
         tipoDeExame = em.find(TipoDeExame.class, tipoDeExame.getIdTipoExame());
         em.remove(tipoDeExame);
    }
}
