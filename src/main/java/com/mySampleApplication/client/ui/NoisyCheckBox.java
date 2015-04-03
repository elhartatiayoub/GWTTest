package com.mySampleApplication.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class NoisyCheckBox extends Composite {

    @UiTemplate("NoisyCheckBox.ui.xml")
    interface MyUiBinder extends UiBinder<Widget, NoisyCheckBox> {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);


    @UiField
    Label text;

    @UiField
    CheckBox check1;

    @UiField
    CheckBox check2;

    public NoisyCheckBox() {
        initWidget(uiBinder.createAndBindUi(this));
        check2.setValue(false);
    }

    @UiHandler("check1")
     void handleClick1(ClickEvent e) {
        Window.alert("That is " + (check1.getValue() ? "" : "not ") + "checked");
    }

    @UiHandler("check2")
    void handleClick2(ClickEvent e) {
        if(check2.getValue()){
            Window.alert("not this, ... that!!");
            check2.setValue(false);
        }
    }


}