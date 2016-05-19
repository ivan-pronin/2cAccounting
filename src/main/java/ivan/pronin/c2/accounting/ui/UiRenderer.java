package ivan.pronin.c2.accounting.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * Created by Администратор on 15.05.2016.
 */
@Component
public class UiRenderer {

    private static final Logger LOGGER = LogManager.getLogger(UiRenderer.class);
    private int activeTabIndex;

    public void onTabChange() {
        Map<String, String> paramMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int tabIndex = Integer.valueOf(paramMap.get("invoiceForm:invoiceTabView_activeIndex"));
        setActiveTabIndex(tabIndex);
        LOGGER.info("Active tab changed to : " + tabIndex);
    }

    public int getActiveTabIndex() {
        return activeTabIndex;
    }

    public void setActiveTabIndex(int activeTabIndex) {
        this.activeTabIndex = activeTabIndex;
    }

}
