package com.mySampleApplication.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;




public class ExampleKeyDown extends Composite {

    @UiTemplate("ExampleKeyDown.ui.xml")
    interface MyUiBinder extends UiBinder<Widget, ExampleKeyDown> {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
    @UiField
    TextBox input;

    @UiField
    Label text;



    public ExampleKeyDown() {
        //initWidget(button);
        initWidget(uiBinder.createAndBindUi(this));
        text.setText("type something..");
    }

    @UiHandler("input")
    void handleKey(KeyDownEvent e) {
        if(e.getNativeKeyCode() == KeyCodes.KEY_ENTER)
            Window.alert(input.getText());
        else{

            text.setText(input.getText().toUpperCase()+ ((char) e.getNativeKeyCode()));
        }

    }

}
