package org.phoenix.enums;

/**
 * Created by Kemi on 2017/10/26.
 * Description:数据模板类型，成功or失败
 */
public enum DataTemplateFieldTestType {
    SUCCESS("SUCCESS"),
    FAIL("FAIL");

    private String name;
    DataTemplateFieldTestType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
