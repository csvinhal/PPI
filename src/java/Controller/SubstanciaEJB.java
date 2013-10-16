package Controller;

import Model.Substancia;
import Util.Manager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class SubstanciaEJB extends Manager{

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
