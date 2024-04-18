package com.ibanfr.button;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Named
@ViewScoped
public class CommandButtonView implements Serializable {


    public void sleep() throws InterruptedException {
        System.out.println("sleep called");
        TimeUnit.SECONDS.sleep(5);
    }

}
