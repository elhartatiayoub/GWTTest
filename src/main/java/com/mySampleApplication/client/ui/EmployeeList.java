package com.mySampleApplication.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.mySampleApplication.client.model.Employee;
import com.mySampleApplication.client.model.MyDataProvider;

import java.util.List;

/**
 * Created by Iob on 02/04/2015.
 */
public class EmployeeList extends Composite {
    interface EmpListUiBinder extends UiBinder<Widget, EmployeeList> {
    }

    private static EmpListUiBinder ourUiBinder = GWT.create(EmpListUiBinder.class);

    public EmployeeList() {
        initWidget(ourUiBinder.createAndBindUi(this));
        setData();
    }
    @UiFactory
    CellList<Employee> initList(){
        EmployeeCell employeeCell = new EmployeeCell();
        CellList<Employee> list = new CellList<Employee>(employeeCell);
        return list;
    }


    @UiField
    CellList<Employee> cellTable;

    @UiField
    SimplePager pager;

    public void setData() {

//        ListDataProvider<Employee> listDataProvider = new ListDataProvider<Employee>();
//        listDataProvider.addDataDisplay(cellTable);
//        listDataProvider.setList(emps);
        MyDataProvider listDataProvider = new MyDataProvider();
        listDataProvider.addDataDisplay(cellTable);
        pager.setDisplay(cellTable);
    }
}