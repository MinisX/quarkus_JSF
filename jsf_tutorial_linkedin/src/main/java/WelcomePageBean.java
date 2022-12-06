import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("welcomePageBean")
// This scope specifies that this backing bean class should be instantiated at the beginning of
// a JSF page request and then be destroyed right after the request is complete, that is, when the page has completely loaded.
@RequestScoped
public class WelcomePageBean {

    private String welcomeUserName;
    private String completedGreeting;

    public String getWelcomeUserName() {
        return welcomeUserName;
    }

    public void setWelcomeUserName(String welcomeUserName) {
        this.welcomeUserName = welcomeUserName;
    }

    public String getCompletedGreeting() {
        return completedGreeting;
    }

    public void setCompletedGreeting(String completedGreeting) {
        this.completedGreeting = completedGreeting;
    }

    public void sayHello(){
        completedGreeting = "Hello, " + this.welcomeUserName;
    }

    // Here we use FlashScope to transmit a variable to another page
    public String navigateToFlashPage(){
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("transmittedVariable", welcomeUserName + " sent this");
        return "flashscope.xhtml";
    }
}
