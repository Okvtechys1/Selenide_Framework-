package BaseClasses;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static data.SystemProperties.AFDALANALYTICS_URL;
import static org.assertj.core.api.Assertions.assertThat;

public class PtiAnalyticsBaseTest extends  BaseWebTest{


    private final List<Feature> features = new ArrayList<>();
    private String NCSAURL=null;

    protected PtiAnalyticsBaseTest() {
    }

    public PtiAnalyticsBaseTest add(Feature feature) {
        features.add(feature);
        return this;
    }

    public void trigger() {
        openPtiAnalytics();

        new FeatureExecutor(features).execute();
    }

    protected void openPtiAnalytics()
    {

//
//        if(AUTHENTICATION_REQUIRED.trim().equals("Yes") ){
//            NCSAURL  = "https://"+USERNAME+":"+PASSWORD+"@wwwncsa.ncsasports.org/";
//            System.err.println("Executing on URL-->" + NCSAURL);
//            open(NCSAURL);
//        }
//        else{
        assertThat(AFDALANALYTICS_URL).isNotNull();
        System.err.println("Executing on URL-->" + AFDALANALYTICS_URL);

        open(AFDALANALYTICS_URL);
    }


}
