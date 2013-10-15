package Controller;

import Model.Autoridade;
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
public class AutoridadeEJB {
    @PersistenceContext(unitName = "PPi0PU")
    private EntityManager em;

    public void salvar(Autoridade autoridade) {
        em.merge(autoridade);
    }
    
    public List<Autoridade> listarAutoridades(){
        Query query = em.createNamedQuery("Autoridade.findAll");
//        Query query = em.createQuery("Select a From Autoridade a");
        return query.getResultList();
    }
    
    public void excluir(Autoridade autoridade){
         autoridade = em.find(Autoridade.class, autoridade.getIdAutoridade());
         em.remove(autoridade);
    } 

}
