/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Converter;

import java.util.HashMap;
import java.util.Map;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "usuarioConverter")

public class UsuarioConverter extends AbstractConverter{
    
    private static Map<Object, String> entities = new HashMap<Object, String>();

    public UsuarioConverter() {
        super(entities);
    }
}
