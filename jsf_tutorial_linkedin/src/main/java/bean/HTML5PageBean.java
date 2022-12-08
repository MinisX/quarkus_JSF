package bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("html5Bean")
@RequestScoped
public class HTML5PageBean {

    private String dateIn;
    private String dateOut;

    public void transformDates(){
        setDateOut(getDateIn());
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }
}
