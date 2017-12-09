package org.phoenix.model;

import org.hibernate.annotations.Fetch;
import javax.persistence.*;
import java.util.Set;

/**
 * Created by Kemi on 2017/9/23.
 * Description:
 */
@Entity
@Table(name = "t_data_template")
public class DataTemplateBean {
    private Integer id;
    private String name;
    private String type;
    private String description;

    private Set<DataTemplateFieldBean> dataTemplateFieldBeans;
    @Id
    @GeneratedValue

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @OneToMany(mappedBy = "dataTemlateBean", targetEntity = DataTemplateBean.class, cascade = CascadeType.ALL)
    public Set<DataTemplateFieldBean> getDataTemplateFieldBeans() {
        return dataTemplateFieldBeans;
    }

    public void setDataTemplateFieldBeans(Set<DataTemplateFieldBean> dataTemplateFieldBeans) {
        this.dataTemplateFieldBeans = dataTemplateFieldBeans;
    }
}
