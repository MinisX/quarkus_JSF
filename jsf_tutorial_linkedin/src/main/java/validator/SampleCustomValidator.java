package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Pattern;

@FacesValidator("selectValidator")
public class
SampleCustomValidator implements Validator {

    // the validate method is what's called by the JSF runtime to request processing.
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        boolean foundSelect = Pattern.compile(Pattern.quote("select"), Pattern.CASE_INSENSITIVE).matcher(value.toString()).find();

        if(foundSelect){
            throw new ValidatorException(new FacesMessage("Validation error: we the found the word: SELECT"));
        }
    }
}
