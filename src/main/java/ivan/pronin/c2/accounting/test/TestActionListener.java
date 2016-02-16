package ivan.pronin.c2.accounting.test;

import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.ListenerFor;

/**
 * Created by Администратор on 14.02.2016.
 */
@Component("testActionListener")
public class TestActionListener implements ActionListener {
    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        System.out.println("processAction: " + event.getComponent().getAttributes());
    }
}
