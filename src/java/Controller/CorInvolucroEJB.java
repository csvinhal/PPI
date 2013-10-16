package Controller;

import Model.Cor;
import Util.Manager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;


@Stateless
public class CorInvolucroEJB extends Manager{
    
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
