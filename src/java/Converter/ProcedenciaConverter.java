package Converter;

import java.util.HashMap;
import java.util.Map;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="procedenciaConverter")
public class ProcedenciaConverter extends AbstractConverter {

	private static Map<Object, String> entities = new HashMap<Object, String>();

    public ProcedenciaConverter() {
        super(entities);
    }

}
