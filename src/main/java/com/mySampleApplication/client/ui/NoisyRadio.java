package com.mySampleApplication.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;

public class NoisyRadio extends Composite {

    @UiTemplate("NoisyRadio.ui.xml")
    interface MyUiBinder extends UiBinder<Widget, NoisyRadio> {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);


    @UiField
    Label text;


    public NoisyRadio() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    ClickHandler clickHandler = new ClickHandler() {
        @Override
        public void onClick(ClickEvent event) {
            Window.alert(((RadioButton) event.getSource()).getText()+" is broadCastion");
        }
    };

    @UiFactory
    public RadioButton zFactory(){
        RadioButton r = new RadioButton("grp");
        r.addClickHandler(clickHandler);
        return r;
    }


}