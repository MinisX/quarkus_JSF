import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("welcomePageBean")
// An object which is defined as @RequestScoped is created once for every request and is shared by all the bean that inject it throughout a request.
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
}
