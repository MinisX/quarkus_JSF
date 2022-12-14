package page;

import bean.SampleViewScopedBean;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

@Named("welcomePageBean")
// This scope specifies that this backing bean class should be instantiated at the beginning of
// a JSF page request and then be destroyed right after the request is complete, that is, when the page has completely loaded.
@RequestScoped
public class WelcomePageBean {

    private String welcomeUserName;
    private String completedGreeting;
    @Inject
    SampleViewScopedBean viewBean;

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
        FacesMessage messageToQ = new FacesMessage(FacesMessage.SEVERITY_INFO, completedGreeting, "We're so happy to see you");
        // Send the message to index.xhtml inputTextBox
        FacesContext.getCurrentInstance().addMessage("inputTextBox", messageToQ);
    }

    // Here we use FlashScope to transmit a variable to another page
    public String navigateToFlashPage(){
        // Here we are transmitting the list of dogs from bean.SampleViewScopedBean
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("transmittedVariable", viewBean.getDogs().get(0));
        return "flashscope.xhtml?faces-redirect=true";
    }

    public void ajaxTriggered(){
        Logger.getAnonymousLogger().info("This is an ajax-triggered log statement");
    }

    public void alsoAjaxTriggered(AjaxBehaviorEvent abe){

    }

    public void isRefreshed(){
        // A Postback is an action taken by an interactive webpage, when the entire page and its contents are sent to the server for processing some
        // information and then, the server posts the same page back to the browser.
        // This method returns true or false
        FacesContext.getCurrentInstance().isPostback();

        // Here we check whether a validation error has occurred during rendering.
        FacesContext.getCurrentInstance().validationFailed();
    }
}
