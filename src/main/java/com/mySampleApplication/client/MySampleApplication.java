package com.mySampleApplication.client;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.mySampleApplication.client.model.*;
import com.mySampleApplication.client.ui.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MySampleApplication implements EntryPoint {


    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {

        DecoratedTabPanel tp = new DecoratedTabPanel();

//        TabPanel tp = new TabPanel();
        tp.add(phase12(), "Before Cell");
        tp.add(phase3(), "Cell, the begining..");
        tp.setWidth("100%");
        tp.selectTab(0);
        tp.setAnimationEnabled(true);
        RootPanel.get("gwtcontainer").add(tp);

//        RootPanel.get("slot0").add(box);
//        RootPanel.get("slot1").add(button);
//        GWT.log("hna???");
//        RootPanel.get("slot2").add(label);
//        RootPanel.get("slot4").add(flexTable);
    }

    public ComplexPanel phase12() {
        final Button button = new Button("Click me");
        final Button btnclose = new Button("clese me");
        final Label label = new Label();
//        final Example example = new Example();
//        final TextBox textBox = new TextBox();

        final MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
        oracle.add("Cat");
        oracle.add("Dog");
        oracle.add("Horse");
        oracle.add("Canary");

        final SuggestBox box = new SuggestBox(oracle);

        final FlexTable flexTable = new FlexTable();
        flexTable.setTitle("history");

        final PopupPanel popup = new PopupPanel();
        int left = (Window.getClientWidth()) / 3;
        int top = (Window.getClientHeight()) / 3;
        popup.setHeight("200");
        popup.setWidth("400");
        popup.setPopupPosition(left, top);
        popup.setAnimationEnabled(true);
        DockLayoutPanel dockLayoutPanel = new DockLayoutPanel(Style.Unit.EM);
        dockLayoutPanel.addSouth(btnclose, 2);
        dockLayoutPanel.add(new Label("other than aaa"));
        popup.add(dockLayoutPanel);
        popup.setAutoHideEnabled(true);


        btnclose.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                popup.hide();
            }
        });

        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (label.getText().equals("")) {
                    if (box.getText().equals("aaa")) {
                        popup.show();

                    }
                    int row = flexTable.getRowCount();
                    flexTable.setText(row, 0, box.getText());
                    MySampleApplicationService.App.getInstance().getMessage(box.getText(), new MyAsyncCallback(label));
                } else {
                    label.setText("");
                }
            }
        });

        // Assume that the host HTML has elements defined whose
        // IDs are "slot1", "slot2".  In a real app, you probably would not want
        // to hard-code IDs.  Instead, you could, for example, search for all
        // elements with a particular CSS class and replace them with widgets.
        //
//        DockLayoutPanel p = new DockLayoutPanel(Style.Unit.EM);
//        p.addNorth(new HTML("header"), 2);
//        p.addSouth(new HTML("footer"), 2);
//        p.addWest(new HTML("navigation"), 10);
//        p.add(new HTML("lakdlkqdnclkqc lqkcnlqkc lqksclqksc,l"));
//
//        RootPanel.get("slot0").add(p);


//        FlowPanel flowPanel = new FlowPanel();
//
//        // Add CheckBoxes to flow Panel
//        for(int i = 1;  i <= 10; i++){
//            CheckBox checkBox = new CheckBox("Item" + i);
//            flowPanel.add(checkBox);
//        }
//
//        DecoratorPanel decoratorPanel = new DecoratorPanel();
//        decoratorPanel.setWidth("500");
//        decoratorPanel.add(flowPanel);
//
//        // Add the widgets to the root panel.
//        RootPanel.get().add(decoratorPanel);

        VerticalPanel panel = new VerticalPanel();
        panel.setWidth("100%");
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        panel.setSpacing(10);
        panel.setBorderWidth(1);

        panel.add(box);
        panel.add(button);
        panel.add(label);
        panel.add(flexTable);
        panel.add(flexTable);
        Example example = new Example();
        ExampleKeyDown exampleKeyDown = new ExampleKeyDown();
//        RootLayoutPanel.get().add(example);
        panel.add(example);
        panel.add(exampleKeyDown);
//        SimpleLayoutPanel layoutPanel = new SimpleLayoutPanel();
//        layoutPanel.add(example);
//        panel.add(layoutPanel);
//        HelloButton helloButton = new HelloButton();
//        panel.add(helloButton);

        NoisyListBox listBox = new NoisyListBox();
        listBox.addElems("elem1", "elem2", "elem3");
        panel.add(listBox);

        NoisyCheckBox checkBox = new NoisyCheckBox();
        panel.add(checkBox);

        NoisyRadio radio = new NoisyRadio();
        panel.add(radio);


        Label lbl = new Label("This is just <b>text</b>.  It will not be interpreted "
                + "as <html>.");
        HTML html = new HTML(
                "This is <b>HTML</b>.  It will be interpreted as such if you specify "
                        + "the <span style='font-family:fixed'>asHTML</span> flag.", false);
        HorizontalPanel p = new HorizontalPanel();
        p.setSpacing(10);
        p.add(lbl);
        p.add(html);
        panel.add(p);

        HtmlHijack hijack = new HtmlHijack();
        panel.add(hijack);
        return panel;
    }

    public ComplexPanel phase3(){
          final List<String> DAYS = Arrays.asList("Sunday", "Monday",
                  "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");

        // Create a cell to render each value in the list.
        TextCell textCell = new TextCell();

        // Create a CellList that uses the cell.
        CellList<String> cellList = new CellList<String>(textCell);

        // Set the total row count. This isn't strictly necessary, but it affects
        // paging calculations, so its good habit to keep the row count up to date.
        cellList.setRowCount(DAYS.size(), true);

        // Push the data into the widget.
        cellList.setRowData(0, DAYS);
        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        verticalPanel.setBorderWidth(1);
        verticalPanel.setSpacing(10);
        verticalPanel.add(cellList);

        List<Employee> emps = new ArrayList<Employee>();
        for (int i = 1; i < 200; i++) {
            emps.add(new Employee(i));
        }
        CellTableTest cellTableTest = new CellTableTest(emps);
        verticalPanel.add(cellTableTest);

        EmployeeList empList = new EmployeeList();
        ScrollPanel scrollPanel = new ScrollPanel(empList);
        scrollPanel.setSize("100%","300px");

        verticalPanel.add(scrollPanel);
        return verticalPanel;
    }
    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
}
