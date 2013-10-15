package Converter;

import java.util.HashMap;
import java.util.Map;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="usuarioConverter")
public class UsuarioConverter extends AbstractConverter {
	
	private static Map<Object, String> entities = new HashMap<Object, String>();

    public UsuarioConverter() {
        super(entities);
    }

}
