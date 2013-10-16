package Controller;

import Model.TipoDeMaterial;
import Util.Manager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class TipoDeMaterialEJB extends Manager{
    
    public void salvar(TipoDeMaterial tipoDeMaterial){
        em.merge(tipoDeMaterial);
    }
    
    public List<TipoDeMaterial> listarTiposDeMateriais(){ 
        Query query = em.createQuery("SELECT t FROM TipoDeMaterial t");
        return query.getResultList();
    }
    
    public void excluir(TipoDeMaterial tipoDeMaterial){
         tipoDeMaterial = em.find(TipoDeMaterial.class, tipoDeMaterial.getIdTipoMaterial());
         em.remove(tipoDeMaterial);
    }
}

