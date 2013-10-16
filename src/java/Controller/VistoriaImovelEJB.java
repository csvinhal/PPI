package Controller;

import Model.VistoriaImovel;
import Util.Manager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class VistoriaImovelEJB extends Manager{

    public void salvar(VistoriaImovel vistoriaImovel) {
        em.merge(vistoriaImovel);
    }
    
    public List<VistoriaImovel> listarVistoriaImovels(){
        Query query = em.createQuery("Select vi From VistoriaImovel vi");
        return query.getResultList();
    }
    
    public void excluir(VistoriaImovel vistoriaImovel){
         vistoriaImovel = em.find(VistoriaImovel.class, vistoriaImovel.getIdLaudo());
         em.remove(vistoriaImovel);
    } 
}
