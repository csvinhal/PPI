package Controller;

import Model.TipoDeMaterial;
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
public class TipoDeMaterialEJB {
    
    @PersistenceContext(unitName="PPi0PU")
    private EntityManager em;
    
    public void salvar(TipoDeMaterial tipoDeMaterial){
        em.merge(tipoDeMaterial);
    }
    
    public List<TipoDeMaterial> listarTiposDeMateriais(){ 
        Query query = em.createQuery("SELECT t FROM TipoDeMaterial t");
        return query.getResultList();
    }
    
    public void excluir(TipoDeMaterial tipoDeMaterial){
         tipoDeMaterial = em.find(TipoDeMaterial.class, tipoDeMaterial.getIdTipoMaterial());
         em.remove(tipoDeMaterial);
    }
}

