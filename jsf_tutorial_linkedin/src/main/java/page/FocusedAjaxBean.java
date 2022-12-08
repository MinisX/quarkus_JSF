package page;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named("ajaxBean")
public class FocusedAjaxBean implements Serializable {
    private String theInputValue;

    public String getTheInputValue() {
        return theInputValue;
    }

    public void setTheInputValue(String theInputValue) {
        this.theInputValue = theInputValue;
    }
}
