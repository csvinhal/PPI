package Controller;

import Model.GuiaPericial;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Crouch
 */
@Stateless
public class GuiaPericialEJB {

   @PersistenceContext(unitName = "PPi0PU")
    private EntityManager em;

    public void salvar(GuiaPericial guiaPericial) {
        guiaPericial.setDataEntrada(new Date());
        em.merge(guiaPericial);
    }
    
    public List<GuiaPericial> listarGuias(){
        Query query = em.createQuery("Select g From GuiaPericial g");
        return query.getResultList();
    }
    
    public void excluir(GuiaPericial guiaPericial){
         guiaPericial = em.find(GuiaPericial.class, guiaPericial.getIdGuia());
         em.remove(guiaPericial);
    }
    
    public GuiaPericial verificarNumeroGuia(String numeroGuia){
        Query query = em.createQuery("SELECT g FROM GuiaPericial g WHERE g.numeroGuia = :numeroGuia")
                .setParameter("numeroGuia", numeroGuia);
        return (GuiaPericial) query.getSingleResult();
    }
    
    public GuiaPericial pesquisaIdGuia(int idGuia){
        Query query = em.createQuery("SELECT g FROM GuiaPericial g WHERE g.idGuia = :idGuia")
                .setParameter("idGuia", idGuia);
        return (GuiaPericial) query.getSingleResult();
        
    }
}
