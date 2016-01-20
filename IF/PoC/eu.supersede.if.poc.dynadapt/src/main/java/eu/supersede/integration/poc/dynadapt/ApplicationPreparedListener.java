package eu.supersede.integration.poc.dynadapt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationPreparedListener implements ApplicationListener<ApplicationPreparedEvent>{
	private static final Logger log = LoggerFactory.getLogger(ApplicationPreparedListener.class);
	private DashboardImpl dashboard;
	@Autowired
    public void setDashboardTest(DashboardImpl dashboard) {
        this.dashboard = dashboard;
    }
	
    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
    	log.info("Dashboard ready");
    	dashboard.run();
    }
}
