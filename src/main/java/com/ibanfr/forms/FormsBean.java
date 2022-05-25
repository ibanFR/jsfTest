package com.ibanfr.forms;

import com.ibanfr.user.UserDetailsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.lang.String;

@Named
@ViewScoped
public class FormsBean  implements Serializable {


    private static final Logger logger = LoggerFactory.getLogger(FormsBean.class);


    /**
     * Text content for input on view <code>forms/index.xhtml</code>
     */
    private String textContent;


    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String submitFormAction(){

        logger.debug("submitFormAction, textContent={}", textContent);

        return "index";
    }

    /**
     * valueChangeListener method is invoked during the end of the PROCESS_VALIDATIONS phase. At that moment,
     * the submitted value is not been updated in the model yet. So you cannot get it by just accessing the bean
     * property which is bound to the input component's value. You need to get it by ValueChangeEvent#getNewValue().
     * The old value is by the way also available by ValueChangeEvent#getOldValue().
     *
     * @param event {@link ValueChangeEvent}
     */
    public void inputChangedListener(ValueChangeEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        // ...

        logger.debug("inputChangedListener, oldValue={}, newValue={}, this.textContent={}", oldValue, newValue, textContent);
    }

    /**
     * Can we use an ajax listener to call to save model?
     *
     *
     * @param event
     */
    public void ajaxListener(AjaxBehaviorEvent event){


        logger.debug("submitFormAction, textContent={}", textContent);

        FacesContext.getCurrentInstance().addMessage("", new FacesMessage("text updated to "+textContent));

    }

}
