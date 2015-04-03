package com.mySampleApplication.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class Example extends Composite  {

    @UiTemplate("Example.ui.xml")
    interface MyUiBinder extends UiBinder<Widget, Example> {}
    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);



    @UiField
   Label message;

   @UiField
   Button btn;

    public Example(){
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("btn")
    void handleClick(ClickEvent e) {
        if(message.getText().equals("you did it!!")){
            message.setText("click this =>");
            btn.setText("click me");
        }else
            if (message.getText().equals("click this =>")) {
                Window.alert("you cliked the button");
                message.setText("you did it!!");
                btn.setText("clear");
            }

    }

}