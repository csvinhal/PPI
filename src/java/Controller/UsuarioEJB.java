package Controller;

import Model.Permissao;
import Model.Usuario;
import Util.Manager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class UsuarioEJB extends Manager{

    public void salvar(Usuario usuario){
        em.merge(usuario);
    }
    
    
    public void excluir(Usuario usuario){
         usuario = em.find(Usuario.class, usuario.getIdUsuario());
         em.remove(usuario);
    }

    public Usuario findUsuarioPorEmail(String email) {
        Query query = em.createQuery("SELECT  u FROM Usuario u where u.email=:email");
        query.setParameter("email", email);
        Usuario usuario = (Usuario) query.getResultList().get(0);
        return usuario;
    } 
    
    
    public List<Usuario> findAllUsuario() {
        Query query = em.createQuery("SELECT u FROM Usuario u");
        return query.getResultList();
    }
    
    public Permissao findPermissaoPorId(String id) {
        Query query = em.createQuery("SELECT  p FROM Permissao p where p.id =:id");
        Long idPermissao = Long.parseLong(id);
        query.setParameter("id", idPermissao);
        Permissao pap = (Permissao) query.getResultList().get(0);
        return pap;
    }

    public List<Permissao> findAllPermissao() {
        Query query = em.createQuery("SELECT u FROM Permissao u");
        return query.getResultList();
    }

}
