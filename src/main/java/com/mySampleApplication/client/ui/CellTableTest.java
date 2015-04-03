package com.mySampleApplication.client.ui;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.mySampleApplication.client.model.Employee;

import java.util.List;

/**
 * Created by Iob on 02/04/2015.
 */
public class CellTableTest extends Composite {
    interface CellTableTestUiBinder extends UiBinder<Widget, CellTableTest> {
    }

    private static CellTableTestUiBinder ourUiBinder = GWT.create(CellTableTestUiBinder.class);

    public CellTableTest(List<Employee> list) {
        initWidget(ourUiBinder.createAndBindUi(this));
        setData(list);
    }

    @UiField
    CellTable<Employee> cellTable;

    @UiField
    SimplePager pager;

    public void setData(List<Employee> emps) {

        TextColumn<Employee> cinCol = new TextColumn<Employee>() {
            @Override
            public String getValue(Employee object) {
                return object.getCin();
            }
        };

        TextColumn<Employee> nomCol = new TextColumn<Employee>() {
            @Override
            public String getValue(Employee object) {
                return object.getPrenom();
            }
        };

        TextColumn<Employee> prenomCol = new TextColumn<Employee>() {
            @Override
            public String getValue(Employee object) {
                return object.getPrenom();
            }
        };

        NumberFormat format = NumberFormat.getCurrencyFormat("EUR");
        Column<Employee, Number> salaireCol = new Column<Employee,Number>(new NumberCell(format)) {
            @Override
            public Number getValue(Employee object) {
                return object.getSalire();
            }
        };

        Column<Employee, String> dateNaissCol = new Column<Employee, String>(new TextCell()) {
            @Override
            public String getValue(Employee Employee) {
                String dayNr = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_LONG).format(Employee.getDateNaiss());
                return dayNr;
            }
        };

        cellTable.addColumn(cinCol,"CIN");
        cellTable.addColumn(nomCol,"Nom");
        cellTable.addColumn(prenomCol,"Prenom");
        cellTable.addColumn(salaireCol,"Salaire");
        cellTable.addColumn(dateNaissCol,"DAte de naissance");

        ListDataProvider<Employee> listDataProvider = new ListDataProvider<Employee>();
        listDataProvider.addDataDisplay(cellTable);
        listDataProvider.setList(emps);
//        MyDataProvider listDataProvider = new MyDataProvider();
//        listDataProvider.addDataDisplay(cellTable);
        pager.setDisplay(cellTable);
    }
}