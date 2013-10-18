package Converter;

import java.util.HashMap;
import java.util.Map;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "localImovelConverter")
public class LocalImovelConverter extends AbstractConverter{
    
    private static Map<Object, String> entities = new HashMap<Object, String>();

    public LocalImovelConverter(){
        super(entities);
    }
    
}
