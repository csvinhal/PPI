package Converter;

import java.util.HashMap;
import java.util.Map;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="numeroConverter")
public class NumeroConverter extends AbstractConverter {

	private static Map<Object, String> entities = new HashMap<Object, String>();

    public NumeroConverter() {
        super(entities);
    }
}
