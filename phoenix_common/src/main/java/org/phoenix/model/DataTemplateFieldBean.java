package org.phoenix.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

/*
 * Created by Kemi on 2017/9/23.
 * Description:
 */
@Entity
@Table(name = "t_data_template_field")
public class DataTemplateFieldBean {
    private Integer id;
    private String dataContent;
    private String dataName;
    private String testType;//测试类型SUCCESS，成功失败FAIL

    private DataTemplateBean dataTemplateBean;
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataContent() {
        return dataContent;
    }

    public void setDataContent(String dataContent) {
        this.dataContent = dataContent;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dataTemp;ateId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public DataTemplateBean getDataTemplateBean() {
        return dataTemplateBean;
    }

    public void setDataTemplateBean(DataTemplateBean dataTemplateBean) {
        this.dataTemplateBean = dataTemplateBean;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }
}
