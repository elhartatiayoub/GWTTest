package com.mySampleApplication.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

public class NoisyListBox extends Composite  {

    @UiTemplate("NoisyListBox.ui.xml")
    interface MyUiBinder extends UiBinder<Widget, NoisyListBox> {}
    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);



    @UiField
   Label text;

   @UiField
   ListBox list;

    public NoisyListBox(){
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("list")
    void handleClick(ChangeEvent e) {
        Window.alert(list.getSelectedItemText());
    }

    public void addElem(String elem){
        list.addItem(elem);
    }

    public void addElems(String... elems){
        for (String elem:elems)
            list.addItem(elem);
    }

}