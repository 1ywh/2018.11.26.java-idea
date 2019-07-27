package com.ywh.bean;

import java.util.*;

/**
 * Author:ywh
 * Date:2019/07/26
 */
public class Bean1 {
    private int intValue;
    private String strValue;
    private Map mapValue;
    private Set setValue;
    private List listValue;
    private  String[] arrayValue;

    //
    private Date dateValue;

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String getStrValue() {
        return strValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    public Map getMapValue() {
        return mapValue;
    }

    public void setMapValue(Map mapValue) {
        this.mapValue = mapValue;
    }

    public Set getSetValue() {
        return setValue;
    }

    public void setSetValue(Set setValue) {
        this.setValue = setValue;
    }

    public List getListValue() {
        return listValue;
    }

    public void setListValue(List listValue) {
        this.listValue = listValue;
    }

    public String[] getArrayValue() {
        return arrayValue;
    }

    public void setArrayValue(String[] arrayValue) {
        this.arrayValue = arrayValue;
    }

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    @Override
    public String toString() {
        return "Bean1{" +
                "intValue=" + intValue +
                ", strValue='" + strValue + '\'' +
                ", mapValue=" + mapValue +
                ", setValue=" + setValue +
                ", listValue=" + listValue +
                ", arrayValue=" + Arrays.toString(arrayValue) +
                ", dateValue=" + dateValue +
                '}';
    }

    public Bean1(){

    }
}
