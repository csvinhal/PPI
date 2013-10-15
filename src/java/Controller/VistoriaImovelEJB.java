package Controller;

import Model.VistoriaImovel;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class VistoriaImovelEJB {

    @PersistenceContext(unitName = "PPi0PU")
    private EntityManager em;

    public void salvar(VistoriaImovel vistoriaImovel) {
        em.merge(vistoriaImovel);
    }
    
    public List<VistoriaImovel> listarVistoriaImovels(){
        Query query = em.createQuery("Select vi From VistoriaImovel vi");
        return query.getResultList();
    }
    
    public void excluir(VistoriaImovel vistoriaImovel){
         vistoriaImovel = em.find(VistoriaImovel.class, vistoriaImovel.getIdImovel());
         em.remove(vistoriaImovel);
    } 
}
