package bean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named("sampleAppScopedBean")
// Only one instance of this backing bean will exist inside the entire application. So we can sort of think of it as a singleton.
//  It isn't tied to an HTTP session either. Every user of this application will be accessing the same instance of bean.SampleApplicationScopedBean.
@ApplicationScoped
public class SampleApplicationScopedBean {
}
