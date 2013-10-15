package Converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.convert.FacesConverter;

@FacesConverter(value="substanciaConverter")
public class SubstanciaConverter extends AbstractConverter {
	
	private static Map<Object, String> entities = new HashMap<Object, String>();

    public SubstanciaConverter() {
        super(entities);
    }

}
