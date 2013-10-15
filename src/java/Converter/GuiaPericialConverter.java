package Converter;

import java.util.HashMap;
import java.util.Map;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "guiaConverter")
public class GuiaPericialConverter extends AbstractConverter {
	
	private static Map<Object, String> entities = new HashMap<Object, String>();

	public GuiaPericialConverter() {
		super(entities);
	}

}
