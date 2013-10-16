package Controller;

import Model.TipoDeExame;
import Util.Manager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class TipoDeExameEJB extends Manager{

    public void salvar(TipoDeExame tipoDeExame){
        em.merge(tipoDeExame);
    }
    
    public List<TipoDeExame> listarTiposDeExames(){ 
        Query query = em.createQuery("SELECT t FROM TipoDeExame t");
        return query.getResultList();
    }
    
    public void excluir(TipoDeExame tipoDeExame){
         tipoDeExame = em.find(TipoDeExame.class, tipoDeExame.getIdTipoExame());
         em.remove(tipoDeExame);
    }
}
