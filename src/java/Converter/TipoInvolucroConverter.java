package Converter;

import java.util.HashMap;
import java.util.Map;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="tipoInvolucroConverter")
public class TipoInvolucroConverter extends AbstractConverter {
	
	private static Map<Object, String> entities = new HashMap<Object, String>();

    public TipoInvolucroConverter() {
        super(entities);
    }

}
