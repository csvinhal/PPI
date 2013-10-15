package Converter;

import java.util.HashMap;
import java.util.Map;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "tipoDeMaterialConverter")
public class TipoDeMaterialConverter extends AbstractConverter {

    private static Map<Object, String> entities = new HashMap<Object, String>();

    public TipoDeMaterialConverter() {
        super(entities);
    }
}
