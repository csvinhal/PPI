package Converter;

import java.util.HashMap;
import java.util.Map;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "destinoConverter")
public class DestinoConverter extends AbstractConverter {

    private static Map<Object, String> entities = new HashMap<Object, String>();

    public DestinoConverter() {
        super(entities);
    }
}
