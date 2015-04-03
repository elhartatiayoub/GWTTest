package com.mySampleApplication.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.*;

public class HtmlHijack extends Composite {

    @UiTemplate("HtmlHijack.ui.xml")
    interface MyUiBinder extends UiBinder<Widget, HtmlHijack> {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);


    @UiField
    TextBox input;

    @UiField
    Button safe;

    @UiField
    Button unsafe;

    @UiField
    HTML output;

    public HtmlHijack() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("safe")
    public void onSafe(ClickEvent e){
        output.setHTML(SafeHtmlUtils.fromString(input.getText()));
    }
    @UiHandler("unsafe")
    public void onUnSafe(ClickEvent e){
        output.setHTML(input.getText());
    }


}