package Converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.convert.FacesConverter;

@FacesConverter(value="corConverter")
public class CorConverter extends AbstractConverter {
	
	private static Map<Object, String> entities = new HashMap<Object, String>();

    public CorConverter() {
        super(entities);
    }

}
