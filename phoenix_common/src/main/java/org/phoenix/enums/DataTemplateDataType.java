package org.phoenix.enums;

/**
 * Created by Kemi on 2017/10/26.
 * Description:数据模板类型
 */
public enum DataTemplateDataType {
    STRING("STRING"),
    INT("INT"),
    FLOAT("FLOAT"),
    JSON("JSON");

    private String name;
    DataTemplateDataType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
