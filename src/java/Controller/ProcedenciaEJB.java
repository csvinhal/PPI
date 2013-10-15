package Controller;

import Model.Procedencia;
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
public class ProcedenciaEJB {

    @PersistenceContext(unitName="PPi0PU")
    private EntityManager em;
    
    public void salvar(Procedencia procedencia){
        em.merge(procedencia);
    }
    
    public List<Procedencia> listarProcedencias(){ 
        Query query = em.createQuery("SELECT p FROM Procedencia p");
        return query.getResultList();
    }
    
    public void excluir(Procedencia procedencia){
         procedencia = em.find(Procedencia.class, procedencia.getIdProcedencia());
         em.remove(procedencia);
    }

}
