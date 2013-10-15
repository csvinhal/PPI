package Controller;

import Model.TipoInvolucro;
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
public class TipoInvolucroEJB {
    @PersistenceContext(unitName="PPi0PU")
    private EntityManager em;
    
    public void salvar(TipoInvolucro tipoInvolucro){
        em.merge(tipoInvolucro);
    }
    
    public List<TipoInvolucro> listarTiposinvolucros(){ 
        Query query = em.createQuery("SELECT t FROM TipoInvolucro t");
        return query.getResultList();
    }
    
    public void excluir(TipoInvolucro tipoInvolucro){
         tipoInvolucro = em.find(TipoInvolucro.class, tipoInvolucro.getIdTipoInvolucro());
         em.remove(tipoInvolucro);
    }
}
