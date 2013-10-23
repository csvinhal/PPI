package Converter;

import java.util.HashMap;
import java.util.Map;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "permissaoConverter")
public class PermissaoConverter extends AbstractConverter{
    
    private static Map<Object, String> entities = new HashMap<Object, String>();

    public PermissaoConverter(){
        super(entities);
    }
}
