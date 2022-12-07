package bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("sampleViewBean")
//  For a given view scope bean that is backing a JSF page,
//  as long as the user doesn't navigate away from the current page, the same bean will be alive and in use for that page.
@ViewScoped
public class SampleViewScopedBean implements Serializable {

    List<String> dogs;

    public SampleViewScopedBean(){
    }

    // Annotating a method with at PostConstruct guarantees that the method will be run only once, immediately after the bean has been instantiated by the
    // JSF run time. This guarantees that your data initialization happens at a safe position only once during the lifetime of the bean.
    @PostConstruct
    public void initDogs(){
        dogs = new ArrayList<>();
        dogs.add("corgi");
        dogs.add("retriever");
    }

    //  The converse to the PostConstruct annotation is the PreDestroy annotation, which guarantees that a method so annotated, will be run just before the bean
    //  is destroyed, so we can carry out any clean-up tasks here.
    @PreDestroy
    public void cleanUp(){
        dogs = null;
    }

    // Here we are getting HTTP session
    public void getSession(){
        // Setting it to false means we don't create a session if one doesn't exist
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        // This destroys the current HTTP session. This will go nicely in logout method
        session.invalidate();
    }
    public List<String> getDogs() {
        return dogs;
    }

    public void setDogs(List<String> dogs) {
        this.dogs = dogs;
    }
}
