package Controller;

import Model.Danos;
import Util.Manager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;


@Stateless
public class DanosEJB extends Manager{
    
    public void salvar(Danos danos){
        em.merge(danos);
    }
    
    public List<Danos> listarDanos(){
        Query query = em.createQuery("Select d From Danos d");
        return query.getResultList();
    }
    
    public List<Danos> listarDanosLaudo(Integer idLaudo){
        Query query = em.createQuery("Select d From Danos d WHERE d.laudo.idLaudo = :idLaudo")
                .setParameter("idLaudo", idLaudo);
        return query.getResultList();
    }
    
    public void excluir(Danos danos){
         danos = em.find(Danos.class, danos.getIdDanos());
         em.remove(danos);
    } 

}
