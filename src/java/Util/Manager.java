
package Util;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Manager implements Serializable {
   
    
    @PersistenceContext(unitName = "PPi0PU")
    public EntityManager em;  

}
