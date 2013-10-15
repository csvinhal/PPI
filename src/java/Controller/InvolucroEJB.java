package Controller;

import Model.Cor;
import Model.Involucro;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class InvolucroEJB {

    @PersistenceContext(unitName = "PPi0PU")
    private EntityManager em;

    public void salvar(Involucro involucro) {
        em.merge(involucro);
    }
    
    public List<Involucro> listarInvolucros(){
        Query query = em.createQuery("Select i From Involucro i");
        return query.getResultList();
    }
    
    public void excluir(Involucro involucro){
         involucro = em.find(Involucro.class, involucro.getIdInvolucro());
         em.remove(involucro);
    } 
    
    public List<Involucro> buscarInvolucroCor(Cor cor){
        Query query = em.createQuery("SELECT i FROM Involucro i WHERE i.cor = :cor")
                .setParameter("cor", cor);
        return query.getResultList();
        
    }
}
