package org.phoenix.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Kemi on 2017/10/26.
 * Description:笛卡尔乘积数据表
 */
@Entity
@Table(name = "t_interface_batchdata_autogen")
@BatchSize(size = 32)
public class InterfaceBatchDataAutogenBean {
    private int id;
    private String expectData;
    private String expectType;
    private String remark;
    private int interfaceMetadataId;
    private String bodyContent;
    private CaseBean caseBean;
    private List<InterfaceDataAutogenBean> interfaceDataAutogenBeanList;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpectData() {
        return expectData;
    }

    public void setExpectData(String expectData) {
        this.expectData = expectData;
    }

    public String getExpectType() {
        return expectType;
    }

    public void setExpectType(String expectType) {
        this.expectType = expectType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getInterfaceMetadataId() {
        return interfaceMetadataId;
    }

    public void setInterfaceMetadataId(int interfaceMetadataId) {
        this.interfaceMetadataId = interfaceMetadataId;
    }

    public String getBodyContent() {
        return bodyContent;
    }

    public void setBodyContent(String bodyContent) {
        this.bodyContent = bodyContent;
    }

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="caseId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public CaseBean getCaseBean() {
        return caseBean;
    }


    public void setCaseBean(CaseBean caseBean) {
        this.caseBean = caseBean;
    }

    @OneToMany(mappedBy = "interfaceBatchDataAutogenBean", targetEntity = InterfaceDataAutogenBean.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(FetchMode.SUBSELECT)
    public List<InterfaceDataAutogenBean> getInterfaceDataAutogenBeanList() {
        return interfaceDataAutogenBeanList;
    }


    public void setInterfaceDataAutogenBeanList(List<InterfaceDataAutogenBean> interfaceDataAutogenBeanList) {
        this.interfaceDataAutogenBeanList = interfaceDataAutogenBeanList;
    }
}
