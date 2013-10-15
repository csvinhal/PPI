package Controller;

import Model.Substancia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class SubstanciaEJB {

   @PersistenceContext(unitName = "PPi0PU")
    private EntityManager em;

    public void salvar(Substancia substancia) {
        em.merge(substancia);
    }
    
    public List<Substancia> listarSubstancias(){
        Query query = em.createQuery("Select s From Substancia s");
        return query.getResultList();
    }
    
    public void excluir(Substancia substancia){
         substancia = em.find(Substancia.class, substancia.getIdSubstancia());
         em.remove(substancia);
    }
}
