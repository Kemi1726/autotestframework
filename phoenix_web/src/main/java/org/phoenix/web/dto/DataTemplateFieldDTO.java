package org.phoenix.web.dto;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Kemi on 2017/9/23.
 * Description:
 */
public class DataTemplateFieldDTO {

    private int id;
    private int dataTemplateId;
    private String dataContent;
    private String testType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDataTemplateId() {
        return dataTemplateId;
    }

    public void setDataTemplateId(int dataTemplateId) {
        this.dataTemplateId = dataTemplateId;
    }

    @NotBlank(message = "名称不能为空")
    public String getDataContent() {
        return dataContent;
    }

    public void setDataContent(String dataContent) {
        this.dataContent = dataContent;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }
}
