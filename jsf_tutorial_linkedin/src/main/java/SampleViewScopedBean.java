import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("sampleViewBean")
//  For a given view scope bean that is backing a JSF page,
//  as long as the user doesn't navigate away from the current page, the same bean will be alive and in use for that page.
@ViewScoped
public class SampleViewScopedBean implements Serializable {
}
