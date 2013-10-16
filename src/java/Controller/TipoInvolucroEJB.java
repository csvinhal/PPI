package Controller;

import Model.TipoInvolucro;
import Util.Manager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class TipoInvolucroEJB extends Manager{
    
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
