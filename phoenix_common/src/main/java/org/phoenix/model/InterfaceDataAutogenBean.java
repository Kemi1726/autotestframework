package org.phoenix.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

/**
 * Created by Kemi on 2017/10/26.
 * Description:笛卡尔乘积数据参数表
 */
@Entity
@Table(name = "t_interface_data_autogen")
@BatchSize(size = 30)
public class InterfaceDataAutogenBean {
    private int id;
    private String dataName;
    private String dataContent;
    private String dataType;
    private String actualDataType;
    private InterfaceBatchDataAutogenBean interfaceBatchDataAutogenBean;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getDataContent() {
        return dataContent;
    }

    public void setDataContent(String dataContent) {
        this.dataContent = dataContent;
    }


    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getActualDataType() {
        return actualDataType;
    }

    public void setActualDataType(String actualDataType) {
        this.actualDataType = actualDataType;
    }
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="interfaceBatchdataAutogenId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public InterfaceBatchDataAutogenBean getInterfaceBatchDataAutogenBean() {
        return interfaceBatchDataAutogenBean;
    }

    public void setInterfaceBatchDataAutogenBean(InterfaceBatchDataAutogenBean interfaceBatchDataAutogenBean) {
        this.interfaceBatchDataAutogenBean = interfaceBatchDataAutogenBean;
    }
}
