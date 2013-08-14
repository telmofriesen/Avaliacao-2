/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.convert;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Wilson
 */
@FacesConverter("CNPJConverter")
public class CNPJConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return string == null || string.trim().isEmpty() ? null : Long.valueOf(string.replace("-", "").replace("/", "").replace(".", ""));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Long cnpj = (Long) o;
        return String.format("%02d.%03d.%03d/%04d-%02d", cnpj / 100, cnpj % 100);
    }
    
}
