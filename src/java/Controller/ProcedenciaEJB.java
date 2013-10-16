package Controller;

import Model.Procedencia;
import Util.Manager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class ProcedenciaEJB extends Manager{

    
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
