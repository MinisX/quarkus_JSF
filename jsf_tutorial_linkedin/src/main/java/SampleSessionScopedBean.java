import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("sampleSessionBean")
// the sample session bean will be tied to an HTTP session, that is, the user's browser session.
// This means that every user of this web application will get their own personal instance of the SampleSessionScopedBean.
@SessionScoped
// SessionScoped should implement Serializable interface. Serializable means that instances of the class can be
// turned into a byte-stream (for example, to be saved to a file) and then converted back into classes again.
public class SampleSessionScopedBean implements Serializable {
}
