package converter;

import dao.DessertLoaderDAO;
import dto.Dessert;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

@FacesConverter(forClass=Dessert.class)
@Named("dessertConverter")
@RequestScoped
public class DessertConverter implements Converter {

    // We will use this DAO to convert the selected dessert from the browser into a dessert object
    @Inject
    DessertLoaderDAO dessertDao;

    // argument 1 is FacesContext object
    // argument 2 is the object that triggered the conversion request, that means the object that this converter is attached to
    // argument 3 is the submitted value
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        if(value != null){
            try{
                return dessertDao.findDessertByName(value);
            }catch (Exception ex){
                throw new ConverterException(new FacesMessage(ex.getMessage()));
            }
        }else{
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
        if(value != null && value instanceof Dessert){
            return ((Dessert)value).getDessertName();
        }else{
            return null;
        }
    }
}
