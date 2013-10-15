package Converter;

import java.util.HashMap;
import java.util.Map;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "tipoDeExameConverter")
public class TipoDeExameConverter extends AbstractConverter {

    private static Map<Object, String> entities = new HashMap<Object, String>();

    public TipoDeExameConverter() {
        super(entities);
    }
}