package Controller;

import Model.Destino;
import Util.Manager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class DestinoEJB extends Manager{

    
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
