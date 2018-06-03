package beans;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import util.MyUtil;

@Named(value = "appBean")
@ApplicationScoped
public class appBean {

    public appBean() {
    }

    

    public String getBaseUrl() {
        return MyUtil.baseurl();
    }

    

    public String getBasepath() {
        return MyUtil.basepath();
    }
}
