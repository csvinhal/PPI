package Converter;

import java.util.HashMap;
import java.util.Map;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "laudoConverter")
public class LaudoConverter extends AbstractConverter {
	
	private static Map<Object, String> entities = new HashMap<Object, String>();

	public LaudoConverter() {
		super(entities);
	}

}