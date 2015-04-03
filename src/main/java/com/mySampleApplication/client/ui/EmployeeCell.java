package com.mySampleApplication.client.ui;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiRenderer;
import com.mySampleApplication.client.model.Employee;

public class EmployeeCell extends AbstractCell<Employee> {


    interface MyUiRenderer extends UiRenderer {
        void render(SafeHtmlBuilder sb, Employee employee);
    }

    private static MyUiRenderer renderer = GWT.create(MyUiRenderer.class);


    @Override
    public void render(Context context, Employee value, SafeHtmlBuilder sb) {
        if (value == null) {
            return;
        }
        renderer.render(sb, value);
    }
}
