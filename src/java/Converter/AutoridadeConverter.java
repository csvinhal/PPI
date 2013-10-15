package Converter;

import java.util.HashMap;
import java.util.Map;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "autoridadeConverter")
public class AutoridadeConverter extends AbstractConverter {

    private static Map<Object, String> entities = new HashMap<Object, String>();

    public AutoridadeConverter() {
        super(entities);
    }
}
